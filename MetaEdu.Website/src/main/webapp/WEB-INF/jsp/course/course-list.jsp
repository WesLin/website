<%@page
	import="com.metaedu.server.business.metaweb.LessonSummaryListModel"%>
<%@page import="com.metaedu.server.business.metaweb.LessonSummary"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="com.metaedu.server.business.metaweb.UserSummary"%>
<%@page import="com.metaedu.server.business.user.CharacterType"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../layout/header.jsp"%>
<%@include file="../layout/panel-pick.jsp"%>
<div class="block_basic_main">
	<div class="block_basic_title" id="block_course_list_title">课程列表</div>
	<%
		UserSummary curSummaryCl = (UserSummary) request.getAttribute("summary");
		int curCharTypeCl = curSummaryCl.getCharacterType();
		Date curDateCl = new Date();
		if (curCharTypeCl == CharacterType.ADMIN) { // 如果是管理员，开启操作面板
	%>
	<div class="block_basic_main_ope_area">
		<input type="button" value="添加课程"
			onclick="location.href='/course/add.htm';" />
	</div>
	<%
		}
	%>

	<div class="block_basic_main_list">
		<c:forEach items="${courseSummaryList }" var="courseSummaryList">
			<div class="block_basic_main_list_detail_unit">
				<span class="block_basic_main_list_detail_img"><img
					src="/static/style/image/course_default_icon.jpg" /></span> <span
					class="block_basic_main_list_detail_content"> <span
					class="block_lesson_list_detail_content_title">斗鱼直播课堂<cite>授课教师：<c:forEach items="${courseSummaryList.teacherSummaries}" var="teacherSummaries">
						${teacherSummaries.fullName };
					</c:forEach></cite>
					
					</span>
					<span class="block_lesson_list_detail_content_course">科目：${courseSummaryList.subjectType}&nbsp;&nbsp;&nbsp;&nbsp;是否选修：否&nbsp;&nbsp;&nbsp;&nbsp;报名费：无&nbsp;&nbsp;&nbsp;&nbsp;已排课时：</span>
					<span class="block_lesson_list_detail_content_time">已加入班级：高一一班&nbsp;&nbsp;高一二班</span>
				</span> <span class="block_basic_main_list_detail_ope"> <input
					type="button" value="查看详情"
					onclick="location.href='/course/course-info.htm?courseId=${courseSummaryList.id}&subjectType=${courseSummaryList.subjectType}';" />
				</span>
			</div>
		</c:forEach>


		<div class="block_basic_main_list_detail_unit">
			<span class="block_basic_main_list_detail_img"><img
				src="/static/style/image/course_default_icon.jpg" /></span> <span
				class="block_basic_main_list_detail_content"> <span
				class="block_lesson_list_detail_content_title">斗鱼直播课堂<cite>授课教师：张三&nbsp;&nbsp;李四</cite></span>
				<span class="block_lesson_list_detail_content_course">科目：高中数学&nbsp;&nbsp;&nbsp;&nbsp;是否选修：否&nbsp;&nbsp;&nbsp;&nbsp;报名费：无&nbsp;&nbsp;&nbsp;&nbsp;已排课时：24</span>
				<span class="block_lesson_list_detail_content_time">已加入班级：高一一班&nbsp;&nbsp;高一二班</span>
			</span> <span class="block_basic_main_list_detail_ope"> <input
				type="button" value="查看详情"
				onclick="location.href='/test/course-info.htm';" />
			</span>
		</div>
	</div>


</div>

<%@include file="../layout/footer.jsp"%>