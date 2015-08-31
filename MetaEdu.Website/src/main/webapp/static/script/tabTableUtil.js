/**
 * tab页相关 js
 * 
 * @author JiLiJie
 * @version Pre_1.0
 * @since 2015.08.31
 */
var tabTableUtil = {
	// tab页类
	tabTable : {
		// 默认css样式
		cssDefault : "",
		// 鼠标经过css样式
		cssActive : "",
		// 选中后的css样式
		cssChecked : "",
		// 按钮集合
		oButtons : [],
		// 子按钮集合
		oSubButtons : []
	},
};
/**
 * 选中变更css样式方法
 * 
 * @param obj
 *            当前操作对象
 */
tabTableUtil.changeCssByClickFunction = function(obj) {
	// 所有兄弟控件样式设置为默认样式
	for (var i = 0; i < tabTableUtil.tabTable.oSubButtons.length; i++) {
		tabTableUtil.tabTable.oSubButtons[i].className = tabTableUtil.tabTable.cssDefault;
	}
	// 设置当前操作对象样式为选中样式
	obj.className = tabTableUtil.tabTable.cssChecked;
};
/**
 * 鼠标经过移出变更css样式方法
 * 
 * @param obj
 *            当前操作对象
 * @param event
 *            当前事件
 */
tabTableUtil.changeCssByMouseOverAndOutFunction = function(obj, event) {
	// 判断当前操作对象是否为已选中对象，是，则不对其更改样式
	if (obj.firstChild.className !== tabTableUtil.tabTable.cssChecked) {
		// 判断鼠标事件类型为mouseover
		if (event.type === "mouseover") {
			obj.firstChild.className = tabTableUtil.tabTable.cssActive;
			// 判断鼠标事件类型为mouseout
		} else if (event.type === "mouseout") {
			obj.firstChild.className = tabTableUtil.tabTable.cssDefault;
		}
	}
};
/**
 * 初始化tabTableUtil
 * 
 * @param _oButtons
 *            tab按钮
 * @param _oSubButtons
 *            tab按钮内部子按钮
 * @param _cssDefault
 *            默认css样式
 * @param _cssActive
 *            鼠标经过css样式
 * @param _cssChecked
 *            选中后css样式
 */
tabTableUtil.initTabTable = function(_oButtons, _oSubButtons, _cssDefault,
		_cssActive, _cssChecked) {
	// tab按钮集合
	this.tabTable.oButtons = _oButtons;
	// tab按钮子按钮集合
	this.tabTable.oSubButtons = _oSubButtons;
	// 默认css样式
	this.tabTable.cssDefault = _cssDefault;
	// 鼠标经过css样式
	this.tabTable.cssActive = _cssActive;
	// 选中后css样式
	this.tabTable.cssChecked = _cssChecked;
	return this;
};
/**
 * 初始化控件事件
 */
tabTableUtil.initEvent = function() {
	// 绑定tab按钮内部子按钮的鼠标点击事件
	for (var i = 0; i < tabTableUtil.tabTable.oSubButtons.length; i++) {
		tabTableUtil.tabTable.oSubButtons[i].onclick = function() {
			tabTableUtil.changeCssByClickFunction(this);
		};
	}
	// 绑定tab按钮鼠标经过事件
	for (var i = 0; i < tabTableUtil.tabTable.oButtons.length; i++) {
		tabTableUtil.tabTable.oButtons[i].onmouseover = function(event) {
			tabTableUtil.changeCssByMouseOverAndOutFunction(this, event);
		};
	}
	// 绑定tab按钮鼠标移出事件
	for (var i = 0; i < tabTableUtil.tabTable.oButtons.length; i++) {
		tabTableUtil.tabTable.oButtons[i].onmouseout = function(event) {
			tabTableUtil.changeCssByMouseOverAndOutFunction(this, event);
		};
	}
};
