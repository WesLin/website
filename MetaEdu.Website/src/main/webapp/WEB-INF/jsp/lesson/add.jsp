<%@page import="java.util.List"%>
<%@page import="com.metaedu.server.business.metaweb.CourseSummary"%>
<%@page import="com.metaedu.server.business.user.CharacterType"%>
<%@page import="com.metaedu.server.business.metaweb.UserSummary"%>
<%@page import="com.metaedu.server.utils.text.TimeUtils"%>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.Date" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../layout/header.jsp" %>
<%@include file="../layout/panel-pick.jsp" %>
<%
UserSummary curSummaryLA = (UserSummary)request.getAttribute("summary");
int curCharTypeLA = curSummaryLA.getCharacterType();
if (curCharTypeLA == CharacterType.STUDENT) { // 如果是学生权限
	response.sendRedirect("/#noright"); // 退出到登录界面
}
List<CourseSummary> curCourseSummariesLA = (List<CourseSummary>)request.getAttribute("courseSummaries");

//输出服务器时间
Date dateLA = new Date();
String serverTimeLA = TimeUtils.getDateStandard(dateLA); // 获取当前服务器时间输出
%>

<script src="/static/script/page-lesson-add-edit.js"></script>
<script type="text/javascript">
// 日期数据生成
var currentTime = new Date();
currentTime.setTime(Date.parse("<%=serverTimeLA%>"));
initLessonTimePicker(currentTime); // 初始化课次时间选择器

// 课程数据索引生成
var courseList = new Array();
<%
if (curCourseSummariesLA.size() > 0) {
	for (int i=0; i<curCourseSummariesLA.size(); i++) {
		int curIndex = i;
		CourseSummary curCourseSumLA = curCourseSummariesLA.get(i);
%>
		courseList[<%=curIndex%>] = new Object();
		courseList[<%=curIndex%>].id = '<%=curCourseSumLA.getId()%>';
		courseList[<%=curIndex%>].name = '<%=curCourseSumLA.getName() %>';
		courseList[<%=curIndex%>].teachers = new Array();
<%
		if (curCourseSumLA.getTeacherSummaries().size()>0) {
			List<UserSummary> curTeacherSummariesLA = curCourseSumLA.getTeacherSummaries();
			for (int j=0; j<curTeacherSummariesLA.size(); j++) {
%>
				courseList[<%=curIndex%>].teachers[<%=j%>] = new Object();
				courseList[<%=curIndex%>].teachers[<%=j%>].id = '<%=curTeacherSummariesLA.get(j).getUserId() %>';
				courseList[<%=curIndex%>].teachers[<%=j%>].name = '<%=curTeacherSummariesLA.get(j).getFullName() %>';
<%
			}
		}
	}
}
%>


// 刷新教师用下拉选单
function refreshTeacherList() {
	var curTeaSel = document.getElementById("lesson_teacher");
	if (curTeaSel.options.length > 0) {
		for (var i=(curTeaSel.options.length - 1); i>=0; i--) curTeaSel.remove(i);
	}
	var curCouSel = document.getElementById("lesson_course");
	if (curCouSel.value != null && curCouSel.value != '') { // 如果有效课程选择
		if (courseList.length > 0) { // 如果有课程信息存在
			var isFound = false;
			for (var i=0; i<courseList.length; i++) { // 遍历课程信息列表
				if (courseList[i].id == curCouSel.value) { // 如果找到当前对应的课程的信息
					var curTeaInfos = courseList[i].teachers;
					if (curTeaInfos.length >0) {
						for (var j=0; j<curTeaInfos.length; j++) {
							curTeaSel.add(new Option(curTeaInfos[j].name, curTeaInfos[j].id));
						}
					} else friendlyInform("课程尚未指定老师，请检查");
					isFound = true;
					break;
				}
			} // 课程信息遍历结束
			if (!isFound) friendlyInform("没有找到选定课程的信息，请重新检查");
		} else friendlyInform("没有任何课程信息，请确认已经添加过课程");
	}
}

// 保存新建课程
function lessonAddOpe() {
	if ($("#lesson_course").val() != "" 
		&& $("#lesson_teacher").val() != "" 
		&& $("#lesson_name").val() != "" 
		&& $("#lesson_beginTime").val() != "" 
		&& $("#lesson_overTime").val() != "" 
	) {
		document.getElementById("lesson_save").disabled = "disabled";
		$.ajax({
			type: "POST",
			url: "/lesson/add-ope.htm",
			data: {
				id : "",
				courseId : $("#lesson_course").val(),
				teacherId : $("#lesson_teacher").val(),
				name : $("#lesson_name").val(),
				beginTime : $("#lesson_beginTime").val(),
				overTime : $("#lesson_overTime").val(),
				recordNeed : false
			},
			dataType: "json",
			success: function(data) {
				if (data) { // 如果成功保存
					location.href = "/user/index.htm"; // 转向到课时列表
				} else {
					friendlyInform("课程信息保存失败");
				}
			}
		});
	} else friendlyInform("请完整填写所有信息");
}

</script>
<div class="block_basic_main">
	<div class="block_basic_title" id="block_lesson_edit_title">添加课时</div>
	<div class="block_basic_main_edit_area">
		<div class="edit_area_row">
			<span class="edit_title">所属课程</span>
			<span class="edit_interactive">
				<select id="lesson_course" class="select_drop_big" onchange="refreshTeacherList();">
					<option value="">-- 请选择 --</option>
				</select>
			</span>
		</div>
		<div class="edit_area_row">
			<span class="edit_title">授课教师</span>
			<span class="edit_interactive">
				<select id="lesson_teacher" class="select_drop_big">
				</select>
			</span>
		</div>
		<div class="edit_area_row">
			<span class="edit_title">课时名称</span>
			<span class="edit_interactive"><input class="input_text_big" type="text" id="lesson_name" /></span>
		</div>
		<!-- <div class="edit_area_row">
			<span class="edit_title">上下课时间</span>
			<span class="edit_interactive">
				<input class="input_text_big"  type="text" id="lesson_beginTime" value="" readonly="readonly" 
					onclick="laydate({elem:'#lesson_beginTime',festival:true,istime:true,format:'YYYY-MM-DD hh:mm:ss',isclear:false,issure:true});" />
				<cite class="word">-</cite>
				<input class="input_text_big"  type="text" id="lesson_overTime" value="" readonly="readonly" 
					onclick="laydate({elem:'#lesson_overTime',festival:true,istime:true,format:'YYYY-MM-DD hh:mm:ss',isclear:false,issure:true});" />
			</span>
		</div>-->
		<div class="edit_area_row">
			<span class="edit_title">上下课时间</span>
			<span class="edit_interactive">
				
			</span>
		</div>
		<!-- <div class="edit_area_row" >
			<span class="edit_title">是否录像</span>
			<span class="edit_interactive">
				<input type="checkbox" id="lesson_recordNeed">
			</span>
		</div>	-->
		<div class="edit_area_row">
			<span class="edit_title">&nbsp;&nbsp;</span>
			<span class="edit_interactive">
				<input class="input_button_90" type="button" id="lesson_save" value="保存" onclick="lessonAddOpe();" />
			</span>
		</div>
	</div>
</div>

<script type="text/javascript">
// 添加新建课时所需课程信息
if (courseList.length > 0) {
	var curSel = document.getElementById("lesson_course");
	for (var i=0; i<courseList.length; i++) {
		curSel.add(new Option(courseList[i].name, courseList[i].id));
	}
}
</script>
<%@include file="../layout/footer.jsp" %>