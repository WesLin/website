package com.metaedu.server.website.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metaedu.server.business.complex.Record;
import com.metaedu.server.business.data.hessian.DataFactory;
import com.metaedu.server.business.education.Lesson;
import com.metaedu.server.business.user.User;
import com.metaedu.server.log.LogPak;
import com.metaedu.server.utils.text.HashUtils;

/** 数据转换用 Controller
 * @author Sam
 * @version Pre_1.0
 * @since 2015.08.10
 */
@Controller
@RequestMapping("/trans")
public class TransController {

	/** 日志类 */
	private static LogPak log = new LogPak(TransController.class);
	
	
	/** 创建纯视频课次的录像
	 * @param refLessonId 对应的课程编号
	 * @param refFilePath 视频文件地址
	 * @param refTime 播放时间
	 * @return
	 */
	@RequestMapping("/createVideoLessonRecord")
	public ModelAndView createVideoLessonRecord(
		@RequestParam("lessonId") String refLessonId,
		@RequestParam("fileName") String refFileName,
		@RequestParam("fileSuffix") String refFileSuffix,
		@RequestParam("filePath") String refFilePath,
		@RequestParam("time") Integer refTime
	) {
		String curResult = "fail";
		Lesson curLesson = DataFactory.getLessonData().getValidLessonById(refLessonId); // 获取课程实体
		if (curLesson != null) {
			String curTeacherId = curLesson.getTeacherId(); // 获取授课教师编号
			User curTeacher = DataFactory.getUserData().getValidUserById(curLesson.getTeacherId()); // 获取教师用户实体
			if (curTeacher != null) {
				StringBuilder curRecordBuilder = new StringBuilder();
				String curFileTmpId = HashUtils.getUuidCompact();
				// 添加登录信令
				curRecordBuilder.append("000000"
					+ "250001"
					+ "{\"result\":200,\"complexId\":\"" + curLesson.getId() + "\",\"name\":\"" + curLesson.getName() + "\",\"participantType\":10,"
					+ "\"status\":{\"video\":\"\",\"audio\":\"\",\"clients\":[]},"
					+ "\"onlines\":[{\"id\":\"" + curTeacher.getId() + "\",\"isRaise\":false,\"surname\":\"" + curTeacher.getSurname() + "\",\"name\":\"" + curTeacher.getName() + "\",\"sex\":1}],"
					+ "\"charge\":{\"id\":\"" + curTeacher.getId() + "\",\"videoUrl\":\"\",\"audioUrl\":\"\"},\"talkings\":[],\"enableChat\":false,\"enableRaise\":false,"
					+ "\"activeScreen\":0,\"board\":{\"x\":0.0,\"y\":0.0,\"draws\":[]},\"documents\":{\"activeDocument\":\"\",\"contents\":[]},\"multimedias\":{\"activeMultimedia\":\"\",\"contents\":[]}}");
				// 添加文件引用
				curRecordBuilder.append("|"
					+ "000001"
					+ "350210"
					+ "{\"isDocument\":false,\"name\":\"" + refFileName +"\",\"suffix\":\"" + refFileSuffix + "\",\"id\":\"" + curFileTmpId + "\","
					+ "\"filefoxId\":\"\"," // filefoxId 置空
					+ "\"detail\":\"" + refTime + "\","
					+ "\"path\":\"" + refFilePath + "\",\"page\":1}");
				curRecordBuilder.append("|000001350200{\"screen\":2}"); // 切换到多媒体
				// 生成播放信令
				int msgLoopTime = (int)Math.floor((double)refTime / 5.0);
				for (int i=0; i<msgLoopTime; i++) {
					int curTime = 1 + i*5; // 当前的秒数
					String curTimeStr = "";
					if (curTime < 10) curTimeStr = "00000" + curTime;
					else if (curTime < 100) curTimeStr = "0000" + curTime;
					else if (curTime < 1000) curTimeStr = "000" + curTime;
					else if (curTime < 10000) curTimeStr = "00" + curTime;
					else if (curTime < 100000) curTimeStr = "0" + curTime;
					else curTimeStr = "" + curTime;
					curRecordBuilder.append("|"
						+ curTimeStr
						+ "350303"
						+ "{\"id\":\"" + curFileTmpId + "\",\"ctrlType\":1,\"time\":" + curTime + "}");
				}
				Record curRecord = new Record();
				curRecord.setId(curLesson.getId());
				curRecord.setContent(curRecordBuilder.toString());
				DataFactory.getLessonData().createLessonRecord(curLesson.getId(), curRecord); // 保存录像
				//curResult = curRecordBuilder.toString();
			} else log.debug("createVideoLessonRecord", "不存在或已失效的教师信息");
		} else log.debug("createVideoLessonRecord", "无效的课次信息");
		ModelAndView curModel = new ModelAndView("/result");
		curModel.addObject("result", curResult);
		return curModel;
	}
	
}
