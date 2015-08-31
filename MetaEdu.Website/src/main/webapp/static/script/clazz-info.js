/**
 * 班级相关 js
 * 
 * @author JiLiJie
 * @version Pre_1.0
 * @since 2015.08.31
 */
var clazz = {};
//判断当前【点击查看】按钮的状态
clazz.memberShow = false;
/**
 * 【点击查看】按钮鼠标单击事件
 */
$("#clazzMemberView").click(function(event){
	if(clazz.memberShow === false){
		$(this).css("backgroundColor","#14bfb1");
		$(this).css("color","#eee");
		clazz.memberShow = true;
	}else{
		$(this).css("backgroundColor","#ecf2f0");
		$(this).css("color","#666");
		clazz.memberShow = false;
	}
	$("#clazzMemberBox").slideToggle(500);
	event.stopPropagation();
});
/**
 * 点击空白区域收拢下拉框
 */
$("html,body").click(function(event){
	$("#clazzMemberView").css("backgroundColor","#ecf2f0");
	$("#clazzMemberView").css("color","#666");
	$("#clazzMemberBox").slideUp(500);
	clazz.memberShow = false;
});
