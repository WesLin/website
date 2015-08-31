<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="com.metaedu.server.business.metaweb.UserSummary"%>
<%@page import="com.metaedu.server.business.user.CharacterType"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../layout/header.jsp"%>
<%@include file="../layout/panel-pick.jsp"%>
<link href="/static/style/courseAndClazz-info.css" rel="stylesheet"
	type="text/css" />
<div class="block_basic_main">
	<!-- 隐藏控件 -->
	<input id="hide_courseId" type="hidden" value="${courseSummary.id }" />
	<input id="hide_subjectType" type="hidden"
		value="${courseSummary.subjectType }" /> <input id="hide_pageNow"
		type="hidden" value="0" />
	<!-- 隐藏控件END -->
	<div class="block_basic_title" id="block_course_list_title">我的课程</div>
	<div class="block_course_info_outer_box">
		<div class="block_course_info_inner_box">
			<div class="block_course_info_inner_basicInfo">
				<div class="block_course_info_inner_basicInfo_left">
					<img class="block_course_info_inner_basicInfo_left_image" alt=""
						src="/static/style/image/course_cover.png">
				</div>
				<div class="block_course_info_inner_basicInfo_right">
					<p class="block_course_info_inner_basicInfo_right_entries">
						<span class="block_course_info_inner_basicInfo_right_entries_span">课程名称：</span>${courseSummary.name }
					</p>
					<p class="block_course_info_inner_basicInfo_right_entries">
						<span class="block_course_info_inner_basicInfo_right_entries_span">科目类型：</span>${courseSummary.subjectType }
					</p>
					<p class="block_course_info_inner_basicInfo_right_entries">
						<span class="block_course_info_inner_basicInfo_right_entries_span">授课老师：</span>
						<span
							class="block_course_info_inner_basicInfo_right_entries_span_teachers"><c:forEach
								items="${courseSummary.teacherSummaries }"
								var="teacherSummaries">
							${teacherSummaries.fullName };
						</c:forEach></span>
					</p>
					<p class="block_course_info_inner_basicInfo_right_entries">
						<span class="block_course_info_inner_basicInfo_right_entries_span">上课时间：</span>${courseSummary.beginTimeText }~${courseSummary.overTimeText }
					</p>
					<p class="block_course_info_inner_basicInfo_right_entries">
						<span class="block_course_info_inner_basicInfo_right_entries_span">共享范围：</span>无
					</p>
				</div>

			</div>
			<div class="block_course_info_inner_lessionTimes">
				<div id="block_course_info_inner_lessionTimes_head">
					<span class="block_course_info_inner_lessionTimes_head_title">课时安排</span>
					<p class="block_course_info_inner_lessionTimes_head_page">
						<span class="block_course_info_inner_lessionTimes_head_page_box">
							<span><a id="page_first"
								class="block_course_info_inner_lessionTimes_head_page_firstAndLastAndTo page_defoult_backColor">首页</a></span>
							<span><a id="page_pre"
								class="block_course_info_inner_lessionTimes_head_page_preAndNext page_defoult_backColor">上一页</a></span>
							<span><a id="page_view"
								class="block_course_info_inner_lessionTimes_head_page_numView page_defoult_backColor">1/100</a></span>
							<span><a id="page_next"
								class="block_course_info_inner_lessionTimes_head_page_preAndNext page_active_backColor">下一页</a></span>
							<span><a id="page_last"
								class="block_course_info_inner_lessionTimes_head_page_firstAndLastAndTo page_defoult_backColor">尾页</a></span>
							<span><input
								id="block_course_info_inner_lessionTimes_head_page_num"
								type="text" /></span> <span><a id="page_jump"
								class="block_course_info_inner_lessionTimes_head_page_firstAndLastAndTo page_defoult_backColor">跳转</a></span>
						</span>
					</p>
				</div>
				<div id="lessionTimesEntriesBox"
					class="block_course_info_inner_lessionTimes_entries_box">
					
				</div>

			</div>
			<div class="block_course_info_inner_back">
				<a class="block_course_info_inner_back_a"
					href="javascript:history.go(-1)">返 回</a>
			</div>
		</div>
	</div>


</div>
<script charset="utf-8" type="text/javascript"
	src="/static/script/pageUtil.js"></script>
<script charset="utf-8" type="text/javascript"
	src="/static/script/course-info.js"></script>
<%@include file="../layout/footer.jsp"%>