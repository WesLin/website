<%@page import="java.util.List"%>
<%@page import="com.metaedu.server.utils.text.TimeUtils"%>
<%@page import="com.metaedu.server.business.metaweb.CourseSummary"%>
<%@page import="com.metaedu.server.business.user.CharacterType"%>
<%@page import="com.metaedu.server.business.education.Lesson"%>
<%@page import="com.metaedu.server.business.metaweb.UserSummary"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../layout/header.jsp" %>
<%@include file="../layout/panel-pick.jsp" %>
<%
UserSummary curSummaryLE = (UserSummary)request.getAttribute("summary");
String curFromUri = (String)request.getAttribute("from");
int curCharTypeLE = curSummaryLE.getCharacterType();
if (curCharTypeLE == CharacterType.STUDENT) { // 如果是学生权限
	response.sendRedirect("/#noright"); // 退出到登录界面
}
Lesson curLessonLE = (Lesson)request.getAttribute("lesson");
List<CourseSummary> curCourseSummariesLE = (List<CourseSummary>)request.getAttribute("courseSummaries");
%>
<script src="/static/script/laydate/laydate.js"></script>
<script>
laydate.now(); // 强行初始化开始时间

var courseList = new Array();
<%
if (curCourseSummariesLE.size() > 0) {
	for (int i=0; i<curCourseSummariesLE.size(); i++) {
		int curIndex = i;
		CourseSummary curCourseSumLE = curCourseSummariesLE.get(i);
%>
		courseList[<%=curIndex%>] = new Object();
		courseList[<%=curIndex%>].id = '<%=curCourseSumLE.getId()%>';
		courseList[<%=curIndex%>].name = '<%=curCourseSumLE.getName() %>';
		courseList[<%=curIndex%>].teachers = new Array();
<%
		if (curCourseSumLE.getTeacherSummaries().size()>0) {
			List<UserSummary> curTeacherSummariesLE = curCourseSumLE.getTeacherSummaries();
			for (int j=0; j<curTeacherSummariesLE.size(); j++) {
%>
				courseList[<%=curIndex%>].teachers[<%=j%>] = new Object();
				courseList[<%=curIndex%>].teachers[<%=j%>].id = '<%=curTeacherSummariesLE.get(j).getUserId() %>';
				courseList[<%=curIndex%>].teachers[<%=j%>].name = '<%=curTeacherSummariesLE.get(j).getFullName() %>';
<%
			}
		}
	}
}
%>

// 刷新教师用下拉选单：如果指定教师主键，则选项为此值时自动选中
function refreshTeacherList(refTeacherId) {
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
							if (refTeacherId != null && refTeacherId == curTeaInfos[j].id) curTeaSel.selectedIndex = j;
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

var curFromUri = '<%=curFromUri%>';

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
			url: "/lesson/edit-ope.htm",
			data: {
				id : $("#lesson_id").val(),
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
					//location.href = "/user/index.htm"; // 转向到课时列表
					location.href = curFromUri; // 转向到来源地址
				} else {
					friendlyInform("课程信息保存失败");
				}
			}
		});
	} else friendlyInform("请完整填写所有信息");
}
</script>

<div class="block_basic_main">
	<div class="block_basic_title" id="block_lesson_edit_title">编辑课时</div>
	<div class="block_basic_main_edit_area">
		<div class="edit_area_row">
			<span class="edit_title">所属课程</span>
			<span class="edit_interactive">
				<select id="lesson_course" class="select_drop_big" onchange="refreshTeacherList();" disabled="disabled">
					<option value="<%=curCourseSummariesLE.get(0).getId()%>"><%=curCourseSummariesLE.get(0).getName()%></option>
				</select>
				<input type="hidden" id="lesson_id" value="<%=curLessonLE.getId()%>" />
				<cite class="word">&nbsp;&nbsp;课时修改时不能更改所属课程</cite>
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
			<span class="edit_interactive"><input class="input_text_big" type="text" id="lesson_name" value="<%=curLessonLE.getName()%>" /></span>
		</div>
		<div class="edit_area_row">
			<span class="edit_title">上下课时间</span>
			<span class="edit_interactive">
				<input class="input_text_big"  type="text" id="lesson_beginTime" value="<%=TimeUtils.getDateStandard(curLessonLE.getBeginTime()) %>" readonly="readonly" 
					onclick="laydate({elem:'#lesson_beginTime',festival:true,istime:true,format:'YYYY-MM-DD hh:mm:ss',isclear:false,issure:true});" />
				<cite class="word">-</cite>
				<input class="input_text_big"  type="text" id="lesson_overTime" value="<%=TimeUtils.getDateStandard(curLessonLE.getOverTime()) %>" readonly="readonly" 
					onclick="laydate({elem:'#lesson_overTime',festival:true,istime:true,format:'YYYY-MM-DD hh:mm:ss',isclear:false,issure:true});" />
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
// 将教师数据绑定
refreshTeacherList('<%=curLessonLE.getTeacherId()%>');
</script>
<%@include file="../layout/footer.jsp" %>
