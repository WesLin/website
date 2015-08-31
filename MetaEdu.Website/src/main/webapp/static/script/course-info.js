/**
 * 课程相关 js
 * 
 * @author JiLiJie
 * @version Pre_1.0
 * @since 2015.08.27
 */
var course = {};
/**
 * 发送异步请求获取课时列表
 * 
 * @param prePageNow
 *            当前页
 * @param preCourseId
 *            课程ID
 * @param preSubjectType
 *            科目类型
 */
pageUtil.ajaxFunction = course.ajaxGetLessonList = function() {
	// 发送异步请求
	$.ajax({
				type : "POST",// 请求方式为POST
				url : "/lesson/ajax-lesson-list.htm",// 请求URL
				data : {
					pageNow : $("#hide_pageNow").val(),// 当前页
					courseId : $("#hide_courseId").val(),// 课程ID
					subjectType : $("#hide_subjectType").val()
				// 科目类型
				},
				dataType : "json",// 数据格式为JSON
				success : function(data) {
					course.serverTime = data["serverTime"];
					// 如果返回的课时列表内有数据
					if (data["lessonSummaryListModel"]["details"].length > 0) {
						// 封装页码信息
						var oPage = pageUtil
								.initData(
										"page_defoult_backColor",
										"page_active_backColor",
										$("#page_view"),
										$("#page_first"),
										$("#page_pre"),
										$("#page_next"),
										$("#page_last"),
										$("#page_jump"),
										$("#hide_pageNow"),
										$("#block_course_info_inner_lessionTimes_head_page_num"),
										data["lessonSummaryListModel"]["currentPage"],
										data["lessonSummaryListModel"]["detailsCount"],
										data["lessonSummaryListModel"]["detailsPerPage"]);
						console.dir(oPage);
						// 填充页面页码信息
						pageUtil.fullPageDate(oPage);
						// 初始化页面控件事件
						pageUtil.initEvent(oPage);
						// 填充页面课时列表区数据
						course.fullLessonListDate($("#lessionTimesEntriesBox"),
								data["lessonSummaryListModel"]["details"]);
					}
				}
			});
};
/**
 * 初始化课时列表数据
 */
course.initData = function() {
	course.ajaxGetLessonList();
};
/**
 * 填充课时数据
 * 
 * @param oPrentBox
 *            父容器
 * @param data
 *            课时列表JSON数据
 */
course.fullLessonListDate = function(oPrentBox, data) {
	// 清空父容器内容
	oPrentBox[0].innerHTML = "";
	// 课时开始时间
	var beginTime = null;
	// 课时结束时间
	var overTime = null;
	// 服务器当前时间
	var nowTime = new Date(course.serverTime);
	// 课时显示HTML模板拼接
	var strHtml = "<p class=\"block_course_info_inner_lessionTimes_entries_title\">"
			+ "<span class=\"block_course_info_inner_lessionTimes_entries_title_date\">日期</span>"
			+ "<span class=\"block_course_info_inner_lessionTimes_entries_title_name\">课时名</span>"
			+ "<span class=\"block_course_info_inner_lessionTimes_entries_title_time\">上课时间</span>"
			+ "<span class=\"block_course_info_inner_lessionTimes_entries_title_state\">状态</span>"
			+ "<span class=\"block_course_info_inner_lessionTimes_entries_title_operation\">操作</span></p>";
	for (var i = 0; i < data.length; i++) {
		beginTime = new Date(data[i]["beginTime"]);
		console.dir(beginTime);
		overTime = new Date(data[i]["overTime"]);
		strHtml += "<p class=\"block_course_info_inner_lessionTimes_entries_detail\">"
				+ "<span class=\"block_course_info_inner_lessionTimes_entries_detail_date\">"
				// 格式化日期
				+ ((beginTime.getMonth() + 1) > 9 ? (beginTime.getMonth() + 1)
						: ("0" + (beginTime.getMonth() + 1)))
				+ "月"
				+ (beginTime.getDate() ? beginTime.getDate() : ("0" + beginTime
						.getDate()))
				+ "日"
				+ "</span><span class=\"block_course_info_inner_lessionTimes_entries_detail_name\">"
				+ data[i]["name"]
				+ "</span><span class=\"block_course_info_inner_lessionTimes_entries_detail_time\">"
				// 格式化时间
				+ (beginTime.getHours() > 9 ? beginTime.getHours()
						: ("0" + beginTime.getHours()))
				+ ":"
				+ (beginTime.getMinutes() > 9 ? beginTime.getMinutes()
						: ("0" + beginTime.getMinutes()))
				+ "~"
				+ (overTime.getHours() > 9 ? overTime.getHours()
						: ("0" + overTime.getHours()))
				+ ":"
				+ (overTime.getMinutes() > 9 ? overTime.getMinutes()
						: ("0" + overTime.getMinutes()))
				+ "</span><span class=\"block_course_info_inner_lessionTimes_entries_detail_state\">";
		if (nowTime > overTime) {
			strHtml += "已结束";
		} else if (nowTime > beginTime && nowTime < overTime) {
			strHtml += "正在上课";
		} else {
			strHtml += "未开始";
		}
		strHtml += "</span>";
		strHtml += "<span class=\"block_course_info_inner_lessionTimes_entries_detail_operation\">";
		if (nowTime > overTime) {
			if (data[i]["recordReady"]) {
				strHtml += "<a class=\"block_course_info_inner_lessionTimes_entries_detail_operation_video\">查看录像</a>";
			} else {
				strHtml += "<a class=\"block_course_info_inner_lessionTimes_entries_detail_operation_unable\">没有录像</a>";
			}
		} else if (nowTime > beginTime && nowTime < overTime) {
			strHtml += "<a class=\"block_course_info_inner_lessionTimes_entries_detail_operation_inClazz\">进入课堂</a>";
		} else {
			strHtml += "<a class=\"block_course_info_inner_lessionTimes_entries_detail_operation_unable\">未开始</a>";
		}
		strHtml += "</span></p>";
	}
	// 将拼接完成的HTML加入父容器
	oPrentBox[0].innerHTML = strHtml;
};
// 初始化课时数据
course.initData();
