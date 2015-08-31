package com.metaedu.server.website.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metaedu.server.business.data.hessian.DataFactory;
import com.metaedu.server.business.metaweb.LessonSummaryListModel;
import com.metaedu.server.business.metaweb.UserSummary;


/** 用户默认页面 Controller
 * @author Sam
 * @version Pre_1.0
 * @since 2015.05.12
 */
@Controller
@RequestMapping(value="/user")
public class UserIndexController {
	
	
	/** 日志类 */
	//private static LogPak log = new LogPak(UserIndexController.class);
	
	/** 用户默认页面 */
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView curRtn = new ModelAndView("/user/index");
		UserSummary curUserSummary = (UserSummary)session.getAttribute("summary");
		curRtn.addObject("summary", curUserSummary);
		LessonSummaryListModel curLessonModel = DataFactory.getMetaWebData().getLessonSummaryListModel(
				curUserSummary.getInstitutionId(), 
				curUserSummary.getUserId(), 
				curUserSummary.getCharacterType(), 
				0, null, 20, 1); // 获取课程列表，不限定学科，不限定课程编号，每页20条
		curRtn.addObject("lessonModel", curLessonModel); // 添加到返回值
		return curRtn;
	}
	
	/** 课程列表页面 */
	@RequestMapping(value="/course")
	public ModelAndView course(HttpServletRequest request, HttpSession session) {
		ModelAndView curRtn = new ModelAndView("/user/course");
		UserSummary curUserSummary = (UserSummary)session.getAttribute("summary");
		curRtn.addObject("summary", curUserSummary);
//		LessonSummaryListModel curLessonModel = DataFactory.getMetaWebData().getLessonSummaryListModel(
//				curUserSummary.getInstitutionId(), 
//				curUserSummary.getUserId(), 
//				curUserSummary.getCharacterType(), 
//				0, null, 20, 1); // 获取课程列表，不限定学科，不限定课程编号，每页20条
//		curRtn.addObject("lessonModel", curLessonModel); // 添加到返回值
		return curRtn;
	}
	
	
}
