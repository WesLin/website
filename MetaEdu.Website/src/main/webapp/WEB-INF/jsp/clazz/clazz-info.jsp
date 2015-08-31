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
	<div class="block_basic_title" id="block_clazz_list_title">我的班级</div>
	<div class="block_clazz_info_outer_box">
		<div class="block_clazz_info_inner_box">
			<div class="block_clazz_info_inner_basicInfo">
				<div class="block_clazz_info_inner_basicInfo_left">
					<img class="block_clazz_info_inner_basicInfo_left_image" alt=""
						src="/static/style/image/clazz_cover.png">
				</div>
				<div class="block_clazz_info_inner_basicInfo_right">
					<p class="block_clazz_info_inner_basicInfo_right_entries">
						<span class="block_clazz_info_inner_basicInfo_right_entries_span">班级名称：</span>高一(三)班
					</p>
					<p class="block_clazz_info_inner_basicInfo_right_entries">
						<span class="block_clazz_info_inner_basicInfo_right_entries_span">教育程度：</span>工商管理
					</p>
					<p class="block_clazz_info_inner_basicInfo_right_entries">
						<span class="block_clazz_info_inner_basicInfo_right_entries_span">所属学制：</span>王大锤
					</p>
					<p class="block_clazz_info_inner_basicInfo_right_entries">
						<span class="block_clazz_info_inner_basicInfo_right_entries_span">所属年段：</span>11月11日~12月11日
					</p>
					<p class="block_clazz_info_inner_basicInfo_right_entries">
						<span class="block_clazz_info_inner_basicInfo_right_entries_span">班级属性：</span>行政班
					</p>
					<p class="block_clazz_info_inner_basicInfo_right_entries">
						<span class="block_clazz_info_inner_basicInfo_right_entries_span">参加课程：</span>高一语文、高一数学、高一化学
					</p>
					<p class="block_clazz_info_inner_basicInfo_right_entries">
						<span class="block_clazz_info_inner_basicInfo_right_entries_span">班级成员：</span><a
							id="clazzMemberView">点击查看</a>
							<span id="clazzMemberBox" class="block_clazz_info_inner_basicInfo_right_entries_clazzMembers">
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
								<span class="block_clazz_info_inner_basicInfo_right_entries_clazzMember">季理杰</span>
							</span>
					</p>
				</div>

			</div>
			<div class="block_clazz_info_inner_lessionTimes">
				<div id="block_clazz_info_inner_lessionTimes_head">
					<span class="block_clazz_info_inner_lessionTimes_head_title">课时安排</span>
					<p class="block_clazz_info_inner_lessionTimes_head_page">
						<span class="block_clazz_info_inner_lessionTimes_head_page_box">
							<span><a
								class="block_clazz_info_inner_lessionTimes_head_page_firstAndLastAndTo page_defoult_backColor">首页</a></span>
							<span><a
								class="block_clazz_info_inner_lessionTimes_head_page_preAndNext page_defoult_backColor">上一页</a></span>
							<span><a
								class="block_clazz_info_inner_lessionTimes_head_page_numView page_defoult_backColor">1/100</a></span>
							<span><a
								class="block_clazz_info_inner_lessionTimes_head_page_preAndNext page_active_backColor">下一页</a></span>
							<span><a
								class="block_clazz_info_inner_lessionTimes_head_page_firstAndLastAndTo page_defoult_backColor">尾页</a></span>
							<span><input
								id="block_clazz_info_inner_lessionTimes_head_page_num"
								type="text" /></span> <span><a
								class="block_clazz_info_inner_lessionTimes_head_page_firstAndLastAndTo page_defoult_backColor">跳转</a></span>
						</span>
					</p>
				</div>
				<div class="block_clazz_info_inner_lessionTimes_entries_box">
					<p class="block_course_info_inner_lessionTimes_entries_title">
						<span
							class="block_course_info_inner_lessionTimes_entries_title_date">时期</span>
						<span
							class="block_course_info_inner_lessionTimes_entries_title_name">课时名</span>
						<span
							class="block_course_info_inner_lessionTimes_entries_title_time">时间</span>
						<span
							class="block_course_info_inner_lessionTimes_entries_title_state">状态</span>
						<span
							class="block_course_info_inner_lessionTimes_entries_title_operation">操作</span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月22日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第一节第一节第一节第一节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">已结束</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_video">查看录像</a></span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月23日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第二节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">正在上课</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_inClazz">进入课堂</a></span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月24日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第三节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">未开始</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_notBegin">未开始</a></span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月22日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第一节第一节第一节第一节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">已结束</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_video">查看录像</a></span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月23日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第二节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">正在上课</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_inClazz">进入课堂</a></span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月24日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第三节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">未开始</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_notBegin">未开始</a></span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月22日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第一节第一节第一节第一节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">已结束</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_video">查看录像</a></span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月23日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第二节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">正在上课</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_inClazz">进入课堂</a></span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月24日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第三节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">未开始</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_notBegin">未开始</a></span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月22日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第一节第一节第一节第一节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">已结束</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_video">查看录像</a></span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月23日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第二节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">正在上课</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_inClazz">进入课堂</a></span>
					</p>
					<p class="block_clazz_info_inner_lessionTimes_entries_detail">
						<span
							class="block_clazz_info_inner_lessionTimes_entries_detail_date">11月24日</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_name">第三节</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_time">上课时间：11:00~12:00</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_state">未开始</span><span
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation"><a
							class="block_clazz_info_inner_lessionTimes_entries_detail_operation_notBegin">未开始</a></span>
					</p>
				</div>
			</div>
			<div class="block_clazz_info_inner_back">
				<a class="block_clazz_info_inner_back_a"
					href="javascript:history.go(-1)">返 回</a>
			</div>
		</div>
	</div>


</div>
<script charset="utf-8" type="text/javascript" src="/static/script/clazz-info.js"></script>
<%@include file="../layout/footer.jsp"%>