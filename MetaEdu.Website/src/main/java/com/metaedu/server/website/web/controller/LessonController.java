package com.metaedu.server.website.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.metaedu.server.business.complex.Record;
import com.metaedu.server.business.data.hessian.DataFactory;
import com.metaedu.server.business.education.Course;
import com.metaedu.server.business.education.Lesson;
import com.metaedu.server.business.education.Subject;
import com.metaedu.server.business.institution.Institution;
import com.metaedu.server.business.metaweb.CourseSummary;
import com.metaedu.server.business.metaweb.DetailsListBaseModel;
import com.metaedu.server.business.metaweb.LessonSummary;
import com.metaedu.server.business.metaweb.LessonSummaryListModel;
import com.metaedu.server.business.metaweb.UserSummary;
import com.metaedu.server.business.user.CharacterType;
import com.metaedu.server.business.user.User;
import com.metaedu.server.log.LogPak;
import com.metaedu.server.website.web.common.AddressConfig;
import com.metaedu.server.website.web.form.LessonInfo;

/**
 * 课堂相关页面 Controller
 * 
 * @author Sam
 * @version Pre_1.0
 * @since 2015.05.12
 */
@Controller
// 此处不使用前置路径映射，避免静态资源无法加载
public class LessonController {

	/** 日志类 */
	private static LogPak log = new LogPak(LessonController.class);

	/** 测试课堂页面 */
	@RequestMapping(value = "/lesson/test")
	public ModelAndView lessonTest(@RequestParam("account") String refAccount, HttpServletRequest request,
			HttpSession session) {
		ModelAndView curRtn = new ModelAndView("/lesson/live");
		String curLessonId = "0860571100000010-1508161621320579"; // 8.17 并发测试课程
		Lesson curLesson = DataFactory.getLessonData().getValidLessonById(curLessonId);
		// Institution curIns =
		// DataFactory.getInstitutionData().getInstitutionById("0860571100000010");
		// // 四中
		UserSummary curUS = DataFactory.getMetaWebData().getUserSummary("0860571100000010", refAccount);
		if (curLesson != null && curUS != null) {
			// UserSummary curUserSummary =
			// (UserSummary)session.getAttribute("summary");
			curRtn.addObject("user", curUS); // 添加用户摘要
			curRtn.addObject("lessonId", curLessonId); // 添加课时编号
			curRtn.addObject("lessonName", curLesson.getName()); // 添加课程名称
			curRtn.addObject("messageServer", (String) AddressConfig.getContext().getBean("MessageServer")); // 信令服务地址
			curRtn.addObject("streamServer", (String) AddressConfig.getContext().getBean("StreamServer")); // 流媒体服务地址
			curRtn.addObject("fileUploadAddress", (String) AddressConfig.getContext().getBean("FileUploadAddress")); // 上传服务地址
			curRtn.addObject("fileDownloadAddress", (String) AddressConfig.getContext().getBean("FileDownloadAddress")); // 下载服务地址
		} else {
			curRtn = new ModelAndView("result");
			curRtn.addObject("result", "无效的用户账号");
		}
		return curRtn;
	}

	/** 直播课堂页面 */
	@RequestMapping(value = "/lesson/live/{lessonId}")
	public ModelAndView lessonLive(@PathVariable("lessonId") String refLessonId, HttpServletRequest request,
			HttpSession session) {
		ModelAndView curRtn = new ModelAndView("/lesson/live");
		Lesson curLesson = DataFactory.getLessonData().getValidLessonById(refLessonId);
		if (curLesson != null) {
			UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
			curRtn.addObject("user", curUserSummary); // 添加用户摘要
			curRtn.addObject("lessonId", refLessonId); // 添加课时编号
			curRtn.addObject("lessonName", curLesson.getName()); // 添加课程名称
			curRtn.addObject("messageServer", (String) AddressConfig.getContext().getBean("MessageServer")); // 信令服务地址
			curRtn.addObject("streamServer", (String) AddressConfig.getContext().getBean("StreamServer")); // 流媒体服务地址
			curRtn.addObject("fileUploadAddress", (String) AddressConfig.getContext().getBean("FileUploadAddress")); // 上传服务地址
			curRtn.addObject("fileDownloadAddress", (String) AddressConfig.getContext().getBean("FileDownloadAddress")); // 下载服务地址
		}
		return curRtn;
	}

	/** 录播课堂页面 */
	@RequestMapping(value = "/lesson/record/{lessonId}")
	public ModelAndView lessonRecord(@PathVariable("lessonId") String refLessonId, HttpServletRequest request,
			HttpSession session) {
		ModelAndView curRtn = new ModelAndView("/lesson/record");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		curRtn.addObject("summary", curUserSummary); // 添加用户摘要
		curRtn.addObject("lessonId", refLessonId); // 添加课时编号
		return curRtn;
	}

	/** 录像数据页面 */
	@RequestMapping(value = "/lesson/record-data/{lessonId}")
	public ModelAndView lessonRecordData(@PathVariable("lessonId") String refLessonId, HttpServletRequest request,
			HttpSession session) {
		log.debug("lessonRecordData", "请求课程编号为 " + refLessonId);
		ModelAndView curRtn = new ModelAndView("/result");
		Record curRecord = DataFactory.getLessonData().getLessonRecordById(refLessonId);
		curRtn.addObject("result", curRecord.getContent());
		return curRtn;
	}

	/**
	 * 添加课时
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/lesson/add")
	public ModelAndView add(HttpServletRequest request, HttpSession session) {
		ModelAndView curRtn = new ModelAndView("/lesson/add");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		// 仅教师和管理员有权限添加课时
		curRtn.addObject("summary", curUserSummary); // 添加用户摘要
		List<CourseSummary> curCourseSummaries = DataFactory.getMetaWebData()
				.getCourseSummaries(curUserSummary.getInstitutionId(), null, 0, true, true, true); // 获取所有开启中的课程信息
		curRtn.addObject("courseSummaries", curCourseSummaries); // 添加所有课程信息摘要
		return curRtn;
	}

	/**
	 * 添加课时保存
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/lesson/add-ope")
	public ModelAndView addOpe(LessonInfo refInfo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		if (curUserSummary.getCharacterType() != CharacterType.ADMIN
				&& curUserSummary.getCharacterType() != CharacterType.TEACHER)
			response.sendRedirect("/#noright"); // 专向至登陆页
		ModelAndView curRtn = new ModelAndView("/result");
		Lesson curLesson = new Lesson(true, curUserSummary.getInstitutionId()); // 构造新的课程对象
		curLesson.setCourseId(refInfo.getCourseId()); // 设置课程编号
		curLesson.setTeacherId(refInfo.getTeacherId()); // 设置教师编号
		curLesson.setName(refInfo.getName()); // 设置课时名称
		curLesson.setBeginTime(refInfo.getBeginTime()); // 设置上课时间
		curLesson.setOverTime(refInfo.getOverTime()); // 设置下课时间
		curLesson.setRecordNeed(refInfo.getRecordNeed()); // 设置是否需要录像
		curLesson.setIsValid(true);
		curLesson.setCreateTime(new Date());
		curLesson.setUpdateTime(new Date());
		DataFactory.getLessonData().createLesson(curLesson); // 保存当前课程
		curRtn.addObject("result", true);
		return curRtn;
	}

	/**
	 * 编辑课时
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/lesson/edit")
	public ModelAndView edit(@RequestParam("lessonId") String refLessonId, @RequestParam("from") String refFromUri,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		ModelAndView curRtn = new ModelAndView("/lesson/edit");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		// 仅教师和管理员有权限添加课时
		if (curUserSummary.getCharacterType() != CharacterType.ADMIN
				&& curUserSummary.getCharacterType() != CharacterType.TEACHER)
			response.sendRedirect("/#noright"); // 专向至登陆页
		curRtn.addObject("summary", curUserSummary); // 添加用户摘要
		curRtn.addObject("from", refFromUri); // 添加来源地址
		// 取课程实体并验证有效性
		Lesson curLesson = DataFactory.getLessonData().getValidLessonById(refLessonId);
		if (curLesson != null && curLesson.getIsValid()) { // 如果是有效课时
			curRtn.addObject("lesson", curLesson); // 添加相关课程
			// 课时编辑时，不能修改所属课程，故只取对应课程信息
			List<CourseSummary> curCourseSummaries = DataFactory.getMetaWebData().getCourseSummaries(
					curUserSummary.getInstitutionId(), curLesson.getCourseId(), 0, true, true, true); // 获取课时对应的课程信息
			if (curCourseSummaries.size() == 1) {
				// curRtn.addObject("courseSummary", curCourseSummaries.get(0));
				// // 添加有关课程信息摘要
				curRtn.addObject("courseSummaries", curCourseSummaries); // 添加有关课程信息摘要
			} else {
				log.debug("edit", "课时 " + refLessonId + " 对应的课程数据异常");
				response.sendRedirect("/#illegal"); // 专向至登陆页
			}
		} else
			response.sendRedirect("/#illegal"); // 专向至登陆页
		return curRtn;
	}

	/**
	 * 编辑课时保存
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/lesson/edit-ope")
	public ModelAndView editOpe(LessonInfo refInfo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		if (curUserSummary.getCharacterType() != CharacterType.ADMIN
				&& curUserSummary.getCharacterType() != CharacterType.TEACHER)
			response.sendRedirect("/#noright"); // 专向至登陆页
		ModelAndView curRtn = new ModelAndView("/result");
		Lesson curLesson = DataFactory.getLessonData().getValidLessonById(refInfo.getId()); // 获取课程实体
		if (curLesson != null) {
			curLesson.setCourseId(refInfo.getCourseId()); // 设置课程编号
			curLesson.setTeacherId(refInfo.getTeacherId()); // 设置教师编号
			curLesson.setName(refInfo.getName()); // 设置课时名称
			curLesson.setBeginTime(refInfo.getBeginTime()); // 设置上课时间
			curLesson.setOverTime(refInfo.getOverTime()); // 设置下课时间
			curLesson.setRecordNeed(refInfo.getRecordNeed()); // 设置是否需要录像
			DataFactory.getLessonData().updateLesson(curLesson); // 保存当前课程
			curRtn.addObject("result", true);
		} else {
			log.debug("editOpe", "未找到主键 " + refInfo.getId() + " 的课程实体");
			curRtn.addObject("result", false);
		}
		return curRtn;
	}

	/**
	 * 课时删除
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/lesson/del-ope")
	public ModelAndView delOpe(@RequestParam("id") String refLessonId, HttpServletRequest request,
			HttpSession session) {
		ModelAndView curRtn = new ModelAndView("/result");
		DataFactory.getLessonData().removeLesson(refLessonId);
		curRtn.addObject("result", true);
		return curRtn;
	}

	/**
	 * AJAX分页获取课时列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/lesson/ajax-lesson-list")
	public ModelAndView ajaxGetLessonList(//
			@RequestParam("pageNow") int refPageNow, // 当前页
			@RequestParam("courseId") String refCourseId, // 课程ID
			@RequestParam("subjectType") int refSubjectType, // 科目类型
			HttpSession session) {
		ModelAndView curRtn = new ModelAndView("result");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		LessonSummaryListModel lessonSummaryListModel = DataFactory.getMetaWebData().getLessonSummaryListModel(
				curUserSummary.getInstitutionId(), curUserSummary.getUserId(), curUserSummary.getCharacterType(),
				refSubjectType, refCourseId, 10, refPageNow);
		Gson gson = new Gson();
		Map<String, Object> jsonDataMap = new HashMap<>();
		if (lessonSummaryListModel.getDetails().size() > 0) {
			jsonDataMap.put("serverTime", new Date());
			jsonDataMap.put("lessonSummaryListModel", lessonSummaryListModel);
			curRtn.addObject("result", gson.toJson(jsonDataMap));
		} else {
			curRtn.addObject("result", "[]");
		}
		return curRtn;
	}

}
