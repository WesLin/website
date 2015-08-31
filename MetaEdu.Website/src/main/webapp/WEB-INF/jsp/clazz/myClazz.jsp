<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="com.metaedu.server.business.metaweb.UserSummary"%>
<%@page import="com.metaedu.server.business.user.CharacterType"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../layout/header.jsp"%>
<%@include file="../layout/panel-pick.jsp"%>
<link href="/static/style/myClazz.css" rel="stylesheet" type="text/css" />
<div class="block_basic_main">
	<div class="block_basic_title" id="block_clazz_list_title">我的班级</div>


	<div class="block_basic_main_clazz_list">
		<div id="clazzTypeBox" class="block_basic_main_clazz_list_clazzType">
			<span class=""><a
				class="block_basic_main_clazz_list_clazzType_checked">全部班级</a></span> <span
				class=""><a
				class="block_basic_main_clazz_list_clazzType_default">行政班</a></span> <span
				class=""><a
				class="block_basic_main_clazz_list_clazzType_default">教学班</a></span>
		</div>
		<div class="block_basic_main_clazz_list_tableTitle">
			<span class="block_basic_main_clazz_list_tableTitle_img">图片</span><span
				class="block_basic_main_clazz_list_tableTitle_clazzName">班级名</span><span
				class="block_basic_main_clazz_list_tableTitle_course">课程信息</span><span
				class="block_basic_main_clazz_list_tableTitle_ope">操作</span>
		</div>

		<div class="block_basic_main_clazz_list_unit_box">
			<div class="block_basic_main_clazz_list_unit">
				<span class="block_basic_main_clazz_list_detail_img"><img
					alt="" src="/static/style/image/clazz_cover.png" /></span> <span
					class="block_basic_main_clazz_list_detail_content"> <span
					class="block_basic_main_clazz_list_detail_content_clazzName">高一（3）班</span>
					<span class="block_basic_main_clazz_list_detail_content_course"><span
						class="block_basic_main_clazz_list_detail_content_course_content">
							高一语文、高一数学、高一英语、高一语文、</span></span>
				</span> <span class="block_basic_main_clazz_list_detail_ope"> <a
					href="/test/clazz-info.htm">详 情</a>
				</span>
			</div>
			<div class="block_basic_main_clazz_list_unit">
				<span class="block_basic_main_clazz_list_detail_img"><img
					alt="" src="/static/style/image/clazz_cover.png" /></span> <span
					class="block_basic_main_clazz_list_detail_content"> <span
					class="block_basic_main_clazz_list_detail_content_clazzName">高一（3）班</span>
					<span class="block_basic_main_clazz_list_detail_content_course"><span
						class="block_basic_main_clazz_list_detail_content_course_content">
							高一语文、高一数学、高一英语、高一语文、 高一数学、高一英语</span></span>
				</span> <span class="block_basic_main_clazz_list_detail_ope"> <a
					href="javascript:">详 情</a>
				</span>
			</div>
			<div class="block_basic_main_clazz_list_unit">
				<span class="block_basic_main_clazz_list_detail_img"><img
					alt="" src="/static/style/image/clazz_cover.png" /></span> <span
					class="block_basic_main_clazz_list_detail_content"> <span
					class="block_basic_main_clazz_list_detail_content_clazzName">高一（3）班</span>
					<span class="block_basic_main_clazz_list_detail_content_course"><span
						class="block_basic_main_clazz_list_detail_content_course_content">
							高一语文、高一数学、高一英语、高一语文、高一语文、高一数学、高一英语、高一语文、高一数学、高一英语、 高一数学、高一英语</span></span>
				</span> <span class="block_basic_main_clazz_list_detail_ope"> <a
					href="javascript:">详 情</a>
				</span>
			</div>
		</div>
	</div>


</div>
<script charset="utf-8" type="text/javascript" src="/static/script/tabTableUtil.js"></script>
<script charset="utf-8" type="text/javascript" src="/static/script/myClazz.js"></script>
<%@include file="../layout/footer.jsp"%>