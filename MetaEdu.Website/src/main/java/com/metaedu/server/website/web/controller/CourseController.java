package com.metaedu.server.website.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.metaedu.server.business.data.hessian.DataFactory;
import com.metaedu.server.business.metaweb.CourseSummary;
import com.metaedu.server.business.metaweb.LessonSummary;
import com.metaedu.server.business.metaweb.LessonSummaryListModel;
import com.metaedu.server.business.metaweb.UserSummary;
import com.metaedu.server.business.user.User;

/**
 * 课程相关 Controller
 * 
 * @author Sam
 * @version Pre_1.0
 * @since 2015.05.14
 */
@Controller
@RequestMapping(value = "/course")
public class CourseController {

	/** 转向我的课程列表页面（准备课程列表页面所需数据） */
	@RequestMapping("/course-list")
	public ModelAndView toSCourseList(HttpSession session) {
		ModelAndView curModel = new ModelAndView("/course/course-list");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		// 根据用户ID获取该用户的所有课程
		List<CourseSummary> courseSummaryList = DataFactory.getMetaWebData()
				.getCourseSummaries(curUserSummary.getInstitutionId(), null, 0, true, true, true);
		curModel.addObject("courseSummaryList", courseSummaryList);
		curModel.addObject("summary", curUserSummary);
		return curModel;
	}

	/** 转向课程详情页面（准备页面数据） */
	@RequestMapping("/course-info")
	public ModelAndView toCourseInfo(@RequestParam("courseId") String refCourseId,
			@RequestParam("subjectType") int refSubjectType, HttpSession session) {
		ModelAndView curModel = new ModelAndView("/course/course-info");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		// 根据课程ID获取课程详细信息（准备课程详情页面所需数据）
		CourseSummary courseSummary = DataFactory.getMetaWebData()
				.getCourseSummaries(curUserSummary.getInstitutionId(), refCourseId, 0, true, true, true).get(0);
		curModel.addObject("summary", curUserSummary);
		curModel.addObject("courseSummary", courseSummary);
		return curModel;
	}

}
