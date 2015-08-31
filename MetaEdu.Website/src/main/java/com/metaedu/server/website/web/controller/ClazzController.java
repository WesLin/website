package com.metaedu.server.website.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metaedu.server.business.data.hessian.DataFactory;
import com.metaedu.server.business.data.interfaces.education.IClazzData;
import com.metaedu.server.business.education.Clazz;
import com.metaedu.server.business.metaweb.CourseSummary;
import com.metaedu.server.business.metaweb.LessonSummary;
import com.metaedu.server.business.metaweb.LessonSummaryListModel;
import com.metaedu.server.business.metaweb.UserSummary;

/**
 * 班级相关 Controller
 * 
 * @author JiLiJie
 * @version Pre_1.0
 * @since 2015.08.27
 */
@Controller
@RequestMapping(value = "/clazz")
public class ClazzController {
	/** 转向我的班级列表页面（准备我的班级列表页面所需数据） */
	@RequestMapping("/myClazz")
	public ModelAndView toSCourseList(HttpSession session) {
		ModelAndView curModel = new ModelAndView("/clazz/myClazz");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		// 根据用户ID获取该用户的所有班级
	/*	List<Clazz> clazzList = DataFactory.getMetaWebData().get
		curModel.addObject("courseSummaryList", courseSummaryList);*/
		curModel.addObject("summary", curUserSummary);
		return curModel;
	}

	/** 转向班级详情页面（准备页面数据） */
	@RequestMapping("/clazz-info")
	public ModelAndView toClazzInfo(
			@RequestParam("clazzId") String refClazzId, 
			HttpSession session) {
		ModelAndView curModel = new ModelAndView("/clazz/clazz-info");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		// 根据班级ID获取班级详细信息（准备班级详情页面所需数据）
		IClazzData iClazzData = DataFactory.getClazzData();
		curModel.addObject("summary", curUserSummary);
		return curModel;
	}
}
