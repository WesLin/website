<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.metaedu.server.business.metaweb.UserSummary"%>
<%@page import="com.metaedu.server.business.metaweb.LessonSummaryListModel"%>
<%@page import="com.metaedu.server.business.metaweb.LessonSummary"%>
<%@page import="com.metaedu.server.business.user.CharacterType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
UserSummary curSummaryLl = (UserSummary)request.getAttribute("summary");
int curCharTypeLl = curSummaryLl.getCharacterType();
Date curDateLl = new Date();
%>
<script type="text/javascript">
// 删除课时操作（课时列表页面）
function lessonDelOpe(refLessonName, refLessonId) {
	if (confirm("确定要删除 " + refLessonName + " ?")) {
		document.getElementById("button_lesson_del_" + refLessonId).disabled = "disabled";
		$.ajax({
			type: "POST",
			url: "/lesson/del-ope.htm",
			data: {
				id : refLessonId
			},
			dataType: "json",
			success: function(data) {
				if (data) { // 如果成功保存
					location.reload(true); // 刷新当前页面
				} else {
					friendlyInform("课程删除失败");
				}
			},
			error: function() {
				friendlyInform("操作出现异常，建议刷新后重试");
			}
		});
	}
}
</script>
<div class="block_basic_main">
	<div class="block_basic_title" id="block_lesson_list_title">课时列表</div>
<%if (curCharTypeLl != CharacterType.STUDENT) { // 如果不是学生，开启操作面板 %>
	<div class="block_basic_main_ope_area">
		<input type="button" value="添加课时" onclick="location.href='/lesson/add.htm';" />
	</div>
<%}%>
	<div id="block_lesson_list_details" class="block_basic_main_list">
<%
LessonSummaryListModel curLessonModelLl = (LessonSummaryListModel)request.getAttribute("lessonModel"); // 获取课时显示模型
List<LessonSummary> curLessonSummariesLl = curLessonModelLl.getDetails(); // 获取课时详细列表
if (curLessonSummariesLl != null && curLessonSummariesLl.size() > 0) { // 如果有有效课时
for (LessonSummary curLessonSummaryLl : curLessonSummariesLl) { // 遍历输出课时信息
%>
		<div class="block_basic_main_list_detail_unit">
			<span class="block_basic_main_list_detail_img"><img src="/static/style/image/course_default_icon.jpg" /></span>
			<span class="block_basic_main_list_detail_content">
				<span class="block_lesson_list_detail_content_title"><%=curLessonSummaryLl.getName() %><cite>主讲：<%=curLessonSummaryLl.getTeacherName() %></cite></span>
				<span class="block_lesson_list_detail_content_course">所属课程：<%=curLessonSummaryLl.getCourseName() %> ( <%=curLessonSummaryLl.getSubjectName() %> )</span>
				<span class="block_lesson_list_detail_content_time">开课时间：<%=curLessonSummaryLl.getBeginTimeText() %> - <%=curLessonSummaryLl.getOverTimeText() %></span>
			</span>
			<span class="block_basic_main_list_detail_ope">
<%			Calendar curCalendarLl = Calendar.getInstance();
				curCalendarLl.add(Calendar.MINUTE, 10); // 提前10分钟进课堂
				if (curCharTypeLl == CharacterType.STUDENT || curCharTypeLl == CharacterType.TEACHER) {
					if ((curLessonSummaryLl.getOverTime().compareTo(new Date()) >= 0) && (curLessonSummaryLl.getBeginTime().compareTo(curCalendarLl.getTime()) <= 0)) { // 判断进入课堂条件 %>
						<input type="button" onclick="window.open('/lesson/live/<%=curLessonSummaryLl.getId()%>.htm')" value="进入课堂" />
<%				} else if (curLessonSummaryLl.getBeginTime().compareTo(curCalendarLl.getTime()) > 0) { // 判断显示课堂未开始条件
						if (curCharTypeLl == CharacterType.STUDENT) { // 如果是学生 %>
							<cite>课时尚未开始</cite>
<%					} else { // 如果是老师 %>
							<input type="button" onclick="location.href='/lesson/edit.htm?lessonId=<%=curLessonSummaryLl.getId() %>&from=/user/index.htm';" value="编辑课时" />
							<input type="button" id="button_lesson_del_<%=curLessonSummaryLl.getId() %>" onclick="lessonDelOpe('<%=curLessonSummaryLl.getName()%>','<%=curLessonSummaryLl.getId()%>');" value="删除课时" />
<%					}
					} else { // 判断是否显示进入录像
						if (!curLessonSummaryLl.getRecordNeed()) { // 如果不是录像课程 %>
						<cite>课时结束（无录像）</cite>
<%					} else if (curLessonSummaryLl.getRecordReady()) { // 如果录像已经就绪 %>
						<input type="button" onclick="window.open('/lesson/record/<%=curLessonSummaryLl.getId()%>.htm')" value="观看录像" />
<%					} else { // 如果录像尚未就绪 %>
						<cite>录像转换中，请稍候</cite>
<%					}
					}
				} else { // 教师与学生业务处理结束，开始管理员业务
					if ((curLessonSummaryLl.getOverTime().compareTo(new Date()) >= 0) && (curLessonSummaryLl.getBeginTime().compareTo(curCalendarLl.getTime()) <= 0)) { // 判断进入课堂条件 %>
						<cite>课时已开始</cite>
<%				} else if (curLessonSummaryLl.getOverTime().compareTo(new Date()) <= 0) { // 课程结束条件 %>
						<cite>课时已结束</cite>
<%				} else { %>
						<input type="button" onclick="location.href='/lesson/edit.htm?lessonId=<%=curLessonSummaryLl.getId() %>&from=/user/index.htm';" value="编辑课时" />
						<input type="button" id="button_lesson_del_<%=curLessonSummaryLl.getId() %>" onclick="lessonDelOpe('<%=curLessonSummaryLl.getName()%>','<%=curLessonSummaryLl.getId()%>');" value="删除课时" />
<%				}
				}
			%>
			</span>
		</div>
<%
}
} else { %>
		<div class="block_lesson_list_detail_unit">当前没有课时安排</div>
<%} %>
	</div>
</div>

