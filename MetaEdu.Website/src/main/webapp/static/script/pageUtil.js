/**
 * 分页相关 js
 * 
 * @author JiLiJie
 * @version Pre_1.0
 * @since 2015.08.27
 */
var pageUtil = {
	page : {
		cssUable : " ",// 表示按钮不可操作的css样式【必须，class="A B",B为该样式】
		cssEnable : " ",// 表示按钮可操作的css样式【必须，class="A B",B为该样式】
		oPageView : null,// 显示页码信息区域【必须】
		oFirstPage : null,// 首页控件【必须】
		oPrePage : null,// 上一页控件【必须】
		oNextPage : null,// 下一页控件【必须】
		oLastPage : null,// 尾页控件【必须】
		oJump : null,// 跳转控件【必须】
		oHidePageNow : null,// 页面隐藏的用于保存当前页的隐藏控件【必须】
		oInputPage : null,// 用户输入跳转页码【必须】
		currentPage : 0,// 当前页
		totalPage : 0,// 总页数
		detailsCount : 0,// 总数据条数
		detailsPerPage : 0
	// 每页数据条数
	},
	ajaxFunction : null//用于异步请求的方法【必须】
};
/**
 * 初始化分页页码信息
 * 
 * @param cssUable
 *            表示控件不可操作的CSS样式
 * @param cssEnable
 *            表示控件可操作的CSS样式
 * @param oPageView
 *            页码信息显示区域
 * @param oFirstPage
 *            首页按钮对象
 * @param oPrePage
 *            上一页按钮对象
 * @param oNextPage
 *            下一页按钮对象
 * @param oLastPage
 *            尾页按钮对象
 * @param oJump
 *            跳转按钮对象
 * @param currentPage
 *            当前页
 * @param detailsCount
 *            总记录数
 * @param detailsPerPage
 *            每页显示记录数
 * @return 包含页码信息的对象
 */
pageUtil.initData = function(cssUable, cssEnable, oPageView, oFirstPage,
		oPrePage, oNextPage, oLastPage, oJump, oHidePageNow, oInputPage,
		currentPage, detailsCount, detailsPerPage) {
	this.page.cssUable = cssUable;
	this.page.cssEnable = cssEnable;
	this.page.oPageView = oPageView[0];
	this.page.oFirstPage = oFirstPage[0];
	this.page.oPrePage = oPrePage[0];
	this.page.oNextPage = oNextPage[0];
	this.page.oLastPage = oLastPage[0];
	this.page.oJump = oJump[0];
	this.page.oHidePageNow = oHidePageNow[0];
	this.page.oInputPage = oInputPage[0];
	this.page.currentPage = currentPage;
	this.page.detailsCount = detailsCount;
	this.page.detailsPerPage = detailsPerPage;
	return this.page;
};
/**
 * 判断按钮是否可操作
 * 
 * @param obj
 *            按钮对象
 * @param strUableCss
 *            不可操作的css样式
 */
pageUtil.isEnable = function(obj, strUableCss) {
	var obj_css = obj.className;
	var csss = obj_css.split(" ");
	if (csss[1] === strUableCss) {
		return false;
	} else {
		return true;
	}
}
/**
 * 初始化按钮事件
 */
pageUtil.initEvent = function(oPage) {
	/**
	 * 绑定首页鼠标单击事件
	 */
	oPage["oFirstPage"].onclick = function() {
		if (pageUtil.isEnable(this, oPage["cssUable"])) {// 判断按钮是否为可操作
			oPage["oHidePageNow"].value = 1;
			pageUtil.ajaxFunction();
		} else {
			return false;
		}
	};
	/**
	 * 绑定上一页鼠标单击事件
	 */
	oPage["oPrePage"].onclick = function() {
		if (pageUtil.isEnable(this, oPage["cssUable"])) {// 判断按钮是否为可操作
			oPage["oHidePageNow"].value = oPage["currentPage"] - 1;
			pageUtil.ajaxFunction();
		} else {
			return false;
		}
	};
	/**
	 * 绑定下一页鼠标单击事件
	 */
	oPage["oNextPage"].onclick = function() {
		if (pageUtil.isEnable(this, oPage["cssUable"])) {// 判断按钮是否为可操作
			oPage["oHidePageNow"].value = oPage["currentPage"] + 1;
			pageUtil.ajaxFunction();
		} else {
			return false;
		}
	};
	/**
	 * 绑定尾页鼠标单击事件
	 */
	oPage["oLastPage"].onclick = function() {
		if (pageUtil.isEnable(this, oPage["cssUable"])) {// 判断按钮是否为可操作
			oPage["oHidePageNow"].value = oPage["totalPage"];
			pageUtil.ajaxFunction();
		} else {
			return false;
		}
	};
	/**
	 * 绑定跳转鼠标单击事件
	 */
	oPage["oJump"].onclick = function() {
		if (pageUtil.isEnable(this, oPage["cssUable"])) {// 判断按钮是否为可操作
			if (oPage["oInputPage"].value < 1
					|| oPage["oInputPage"].value > oPage["totalPage"]) {
				return false;
			} else {
				oPage["oHidePageNow"].value = oPage["oInputPage"].value;
				oPage["oInputPage"].value = "";
				pageUtil.ajaxFunction();
			}
		} else {
			return false;
		}
	};
};
/**
 * 填充分页页码信息
 * 
 * @param cssUable
 *            表示控件不可操作的CSS样式
 * @param cssEnable
 *            表示控件可操作的CSS样式
 * @param oPageView
 *            页码信息显示区域
 * @param oFirstPage
 *            首页按钮对象
 * @param oPrePage
 *            上一页按钮对象
 * @param oNextPage
 *            下一页按钮对象
 * @param oLastPage
 *            尾页按钮对象
 * @param oJump
 *            跳转按钮对象
 * @param currentPage
 *            当前页
 * @param detailsCount
 *            总记录数
 * @param detailsPerPage
 *            每页显示记录数
 */
pageUtil.fullPageDate = function(oPage) {

	// 获取各个控件的css样式
	var oFirstPageCss = oPage["oFirstPage"].className.split(" ")[0] + " ";
	var oPrePageCss = oPage["oPrePage"].className.split(" ")[0] + " ";
	var oNextPageCss = oPage["oNextPage"].className.split(" ")[0] + " ";
	var oLastPageCss = oPage["oLastPage"].className.split(" ")[0] + " ";
	var oJumpCss = oPage["oJump"].className.split(" ")[0] + " ";
	// 将页码信息转换为int类型
	var intCurrentPage = parseInt(oPage["currentPage"]);
	var intDetailsCount = parseInt(oPage["detailsCount"]);
	var intDetailsPerPage = parseInt(oPage["detailsPerPage"]);
	// 计算总页数
	var intTotalPage = intDetailsCount % intDetailsPerPage > 0 ? Math
			.ceil((intDetailsCount / intDetailsPerPage)) : Math
			.ceil((intDetailsCount / intDetailsPerPage));
	oPage["totalPage"] = intTotalPage;
	// 当当前页小于1或大于总页数禁止操作
	if (intCurrentPage < 1 || intCurrentPage > intTotalPage) {
		return false;
	}
	// 变更页码显示区内容
	oPage["oPageView"].innerHTML = intCurrentPage + "/" + intTotalPage;
	// 总页数>1时，跳转按钮可操作；反之不能
	if (!intTotalPage > 1) {
		oPage["oJump"].className = oJumpCss + oPage["cssUable"];
	} else {
		oPage["oJump"].className = oJumpCss + oPage["cssEnable"];
	}
	// 当前页>1时，首页、上一页按钮可操作；反之不能
	if (intCurrentPage > 1) {
		oPage["oFirstPage"].className = oFirstPageCss + oPage["cssEnable"];
		oPage["oPrePage"].className = oPrePageCss + oPage["cssEnable"];
	} else {
		oPage["oFirstPage"].className = oFirstPageCss + oPage["cssUable"];
		oPage["oPrePage"].className = oPrePageCss + oPage["cssUable"];
	}
	// 当前页<总页数时，尾页、下一页按钮可操作；反之不能
	if (intCurrentPage < intTotalPage) {
		oPage["oNextPage"].className = oNextPageCss + oPage["cssEnable"];
		oPage["oLastPage"].className = oLastPageCss + oPage["cssEnable"];
	} else {
		oPage["oNextPage"].className = oNextPageCss + oPage["cssUable"];
		oPage["oLastPage"].className = oLastPageCss + oPage["cssUable"];
	}
};
