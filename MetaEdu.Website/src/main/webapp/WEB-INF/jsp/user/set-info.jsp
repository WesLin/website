<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="com.metaedu.server.business.metaweb.UserSummary"%>
<%@page import="com.metaedu.server.business.user.CharacterType"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../layout/header.jsp" %>
<%@include file="../layout/panel-pick.jsp" %>

<div class="block_basic_main">
	<div class="block_basic_title" id="block_set_info_title">设置</div>
	
	<div class="block_basic_main_list">
		<div class="block_basic_main_list_set_info_box">
			<p><span class="span_font_weight_center">头像：</span><img alt="" src="/static/style/image/course_default_icon.jpg" /> </p>
			<p><span>昵称：</span><input type="text" /> </p>
			<p><span>姓名：</span><span>季理杰</span> </p>
			<p><span>性别：</span><input name="sex" type="radio" value="男" /> <input name="sex" type="radio" value="女" /></p>
			<p><span>生日：</span><select></select><select></select><select></select> </p>
			<p><span>学号：</span><span>06501003</span> </p>
			<p><span>班级：</span><span>高一三班</span><span>奥数补习班</span> </p>
			<p><span>密码修改：</span><span><input type="text" /></span><span>原密码</span> </p>
			<p><span></span><span></span><input type="text" /><span>新密码</span></p>
			<p><span></span><span><input type="text" /></span><span>确认新密码</span></p>
		</div>
	</div>
	
</div>

<%@include file="../layout/footer.jsp" %>