<%@page import="com.metaedu.server.business.metaweb.UserSummary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
UserSummary curSummary = (UserSummary)request.getAttribute("summary");
%>
<div id="block_user_panel">
	<div id="block_user_setting_area">
		<div id="block_user_avatar_area"><img src="/static/style/image/default_avatar.jpg" /></div>
		<div>
			<span id="block_user_setting_area_username"><%=curSummary.getFullName()%></span>
			<span id="block_user_setting_area_ctrls">
				<input type="button" value="设置" />
				<input type="button" value="充值" />
			</span>
		</div>
	</div>
	<div id="block_user_institution_pick_area">
		<%=curSummary.getInstitutionName()%>
	</div>
	<div id="block_user_operation_area">
		<span id="block_user_operation_area_my_schedule" 
			onclick="location.href='/user/index.htm'" 
			onmouseover="this.className='block_user_operation_area_my_schedule_active';" 
			onmouseout="this.className='';">课时管理</span>
		<span id="block_user_operation_area_my_clazz" onmouseover="this.className='block_user_operation_area_my_clazz_active';" onmouseout="this.className='';">课程管理</span>
		<span id="block_user_operation_area_my_schedule" onmouseover="this.className='block_user_operation_area_my_schedule_active';" onmouseout="this.className='';">用户管理</span>
		<span id="block_user_operation_area_my_course" onmouseover="this.className='block_user_operation_area_my_course_active';" onmouseout="this.className='';">班级管理</span>
	</div>
</div>