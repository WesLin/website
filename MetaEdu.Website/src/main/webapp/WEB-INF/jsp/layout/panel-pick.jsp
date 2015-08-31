<%@page import="com.metaedu.server.business.metaweb.UserSummary"%>
<%@page import="com.metaedu.server.business.user.CharacterType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
UserSummary summary = (UserSummary)request.getAttribute("summary"); // 获取用户信息摘要
Integer characterType = summary.getCharacterType(); // 获取角色信息

if (characterType == CharacterType.ADMIN) { %>
	<%@include file="../layout/admin-panel.jsp" %>
<% }
else if (characterType == CharacterType.STUDENT) { %>
	<%@include file="../layout/student-panel.jsp" %>
<% }
else if (characterType == CharacterType.TEACHER) { %>
	<%@include file="../layout/teacher-panel.jsp" %>
<%}%>
