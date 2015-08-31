/**
 * 班级相关 js
 * 
 * @author JiLiJie
 * @version Pre_1.0
 * @since 2015.08.31
 */
var clazz = {};
// 获取tab按钮控件集合
clazz.oButtons = $("#clazzTypeBox > span");
// 获取tab按钮子控件集合
clazz.oSubButtons = $("#clazzTypeBox").find("a");
// 初始化tabTableUtil
// 参数1:tab控件集合
// 参数2:tab子控件集合
// 参数3:默认css样式
// 参数4:鼠标经过css样式
// 参数5:选中后的css样式
tabTableUtil.initTabTable(clazz.oButtons, clazz.oSubButtons,
		"block_basic_main_clazz_list_clazzType_default",
		"block_basic_main_clazz_list_clazzType_active",
		"block_basic_main_clazz_list_clazzType_checked");
// 初始化控件事件
tabTableUtil.initEvent();
