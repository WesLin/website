package com.metaedu.server.website.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.metaedu.server.business.complex.ComplexMaterialInform;
import com.metaedu.server.business.data.hessian.DataFactory;
import com.metaedu.server.business.material.Material;
import com.metaedu.server.filefoxlib.data.FeedbackResult;
import com.metaedu.server.filefoxlib.util.FilefoxUpload;
import com.metaedu.server.log.LogPak;
import com.metaedu.server.utils.text.HashUtils;
import com.metaedu.server.utils.text.StringAndByteUtils;
import com.metaedu.server.website.web.common.AddressConfig;

/** 课堂辅助功能 Controller
 * @author Sam
 * @version Pre_1.0
 * @since 2015.05.14
 */
@Controller
@RequestMapping(value="/complex")
public class ComplexController {

	/** 日志类 */
	private static LogPak log = new LogPak(ComplexController.class);
	
	/** Filefox ID 与资源 */
	public static ConcurrentHashMap<String, Material> filefoxIdMaterialMap = new ConcurrentHashMap<String, Material>();
	
	/** Filefox ID 与 Complex 映射表 */
	public static ConcurrentHashMap<String, String> filefoxIdComplexMap = new ConcurrentHashMap<String, String>();
	
	
	/** 对所有客户端的接收消息接口 */
	@RequestMapping(value="/uploadfile")
	public ModelAndView uploadFile(@RequestParam("complexId") String refComplexId, @RequestParam("userId") String refUserId, HttpServletRequest request) {
		ModelAndView curRtn = new ModelAndView("result");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) { // 如果是文件上传请求
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile multipartFile = multipartRequest.getFile("file");
			String originalFileName = StringAndByteUtils.stringISOToUTF(multipartFile.getOriginalFilename()); // 上传的文件名
			String fileSuffix = StringAndByteUtils.getFileSuffix(originalFileName); // 文件后缀
			String fileId = HashUtils.getUuidCompact(); // 生成 UUID 的文件 ID
			String renewFileName = fileId + "." + fileSuffix; // 根据 ID 与后缀生成新的文件名
			Calendar curCalendar = Calendar.getInstance(); // 生成一个日期计算实例
			String curYear = String.valueOf(curCalendar.get(Calendar.YEAR)); // 获取年份
			String curMonth = (curCalendar.get(Calendar.MONTH) + 1) >= 10 ? String.valueOf(curCalendar.get(Calendar.MONTH) + 1) : "0" + String.valueOf(curCalendar.get(Calendar.MONTH) + 1); // 获取月份
			String curDay = curCalendar.get(Calendar.DATE) >= 10 ? String.valueOf(curCalendar.get(Calendar.DATE)) : "0" + String.valueOf(curCalendar.get(Calendar.DATE)); // 获取天
			String renewRelativePath = "/" + curYear + "/" + curMonth + "/" + curDay + "/" + renewFileName; // 文件保存相对路径
			String renewAbsolutePath = (String)AddressConfig.getContext().getBean("FileTempFoloder") + renewRelativePath; // 文件保存绝对路径
			File renewFile = new File(renewAbsolutePath); // 生成文件操作类
			File parentFile = renewFile.getParentFile(); // 获取文件上级类
			if (parentFile != null && !parentFile.exists()) {
				parentFile.mkdirs(); // 创建目录
			}
			try {
				renewFile.createNewFile(); // 创建本地文件
				multipartFile.transferTo(renewFile); // 写入数据
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 创建并保存资料
			Material curMat = new Material();
			curMat.setId(HashUtils.getUuidCompact()); // 设置主键
			curMat.setUserId(refUserId); // 设置用户
			curMat.setName(originalFileName); // 原始文件名
			curMat.setSuffix(fileSuffix); // 文件后缀
			curMat.setSize(multipartFile.getSize());
			
//			FilefoxUpload.setUrl("http://10.1.15.100");
//			String tmpBack = FilefoxUpload.uploadFileToServer(renewFile, "http://10.1.15.50/complex/filefoxcallback.htm", renewFileName, true);
			FilefoxUpload.setUrl((String)AddressConfig.getContext().getBean("FilefoxRequestAddress"));
			String tmpBack = FilefoxUpload.uploadFileToServer(renewFile, (String)AddressConfig.getContext().getBean("FilefoxCallbackAddress"), renewFileName, true);
			log.debug("uploadFile", "Filefox 返回：" + tmpBack);
			Gson curGson = new Gson();
			ServerCheckHashResp curResp = curGson.fromJson(tmpBack, ServerCheckHashResp.class);
			if (curResp.getTransStatus() == 1) { // 如果是转换完成
				curMat.setUsingType(curResp.getType()); // 设置文件类型
				curMat.setFilefoxId(curResp.getId()); // 设置 Filefox ID
				curMat.setPage(curResp.getPage()); // 设置页数
				curMat.setDetail(curResp.getDetail()); // 设置明细
				// 发送 REMOTING 到 COMPLEX
				for (int i=0; i<curMat.getPage(); i++) {
					ComplexMaterialInform curInform = new ComplexMaterialInform();
					if (curResp.getType() == 3) { // 如果是多媒体类型
						curInform.setIsDocument(false);
					} else { // 如果是文档或者多媒体类型
						curInform.setIsDocument(true);
					}
					curInform.setId(curMat.getId());
					curInform.setFilefoxId(curMat.getFilefoxId());
					curInform.setName(curMat.getName());
					curInform.setSuffix(curMat.getSuffix());
					curInform.setComplexId(refComplexId);
					curInform.setPath(curResp.getPath());
					log.debug("uploadFile", "Path:" + curInform.getPath());
					curInform.setPage((i+1));
					curInform.setDetail(curMat.getDetail());
					DataFactory.getComplexExternalData().pushMaterialInform(curInform);
					log.debug("uploadFile", "传输到课堂资料 " + curMat.getName() + " " + refComplexId + " 第 " + (i+1) + " 页");
					// TODO : 文件信息保存
				}
			} else if (curResp.getTransStatus() == 2) { // 如果是开始转换
				curMat.setFilefoxId(curResp.getId()); // 设置 Filefox ID
				filefoxIdMaterialMap.put(curResp.getId(), curMat);
				filefoxIdComplexMap.put(curResp.getId(), refComplexId);
			}
		}
		return curRtn;
	}
	
	/** 对所有客户端的接收消息接口 */
	@RequestMapping(value="/filefoxcallback")
	public ModelAndView filefoxFeedback(@RequestParam("data") String refParams, HttpServletRequest request) {
		ModelAndView curRtn = new ModelAndView("result");
		FeedbackResult curResult = FilefoxUpload.getFeedbackResult(refParams.substring(6));
		// "id":"942a66f69a0c4b268e6763335e07bbc7","type":2,"transStatus":3,"detail":"","curCount":1,"totalCount":4,"path":""
		log.debug("filefoxFeedback", refParams);
		if (filefoxIdMaterialMap.containsKey(curResult.getId())) {
			Material curMat = filefoxIdMaterialMap.get(curResult.getId());
			curMat.setUsingType(curResult.getType());
			curMat.setPage(curResult.getTotalCount());
			if (curMat.getDetail().equals("")) { // 如果尚未设置 Detail，进行设置
				curMat.setDetail(curResult.getDetail());
			}
			if (curResult.getTransStatus() != 1) { // 如果不是传输结束信令
				ComplexMaterialInform curInform = new ComplexMaterialInform();
				if (curResult.getType() == 3) { // 如果是多媒体类型
					curInform.setIsDocument(false);
				} else { // 如果是文档或者多媒体类型
					curInform.setIsDocument(true);
				}
				curInform.setId(curMat.getId());
				curInform.setFilefoxId(curMat.getFilefoxId());
				curInform.setName(curMat.getName());
				curInform.setSuffix(curMat.getSuffix());
				curInform.setComplexId(filefoxIdComplexMap.get(curResult.getId()));
				curInform.setPath(curResult.getPath());
				curInform.setPage(curResult.getCurCount());
				curInform.setDetail(curMat.getDetail());
				DataFactory.getComplexExternalData().pushMaterialInform(curInform);
				log.debug("filefoxFeedback", "传输到课堂资料 " + curMat.getName() + " " + filefoxIdComplexMap.get(curResult.getId()) + " 第 " + curResult.getCurCount() + " 页");
			} else log.debug("filefoxFeedback", "传输到课堂资料 " + curMat.getName() + " " + filefoxIdComplexMap.get(curResult.getId()) + " 已全部转换完毕");
		}
		return curRtn;
	}
	
	
	
	
}
