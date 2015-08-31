

/** 改变语言类型
 * @param refType 1简中 2繁中 3英文
 */
function changeLanguage(refType) {
	var curCode = "en_US"; // 默认语言编码为英文
	switch (refType) {
		case 1 : curCode = "zh_CN"; break;
		case 2 : curCode = "zh_TW"; break;
		case 3 : default : curCode = "en_US"; break;
	}
	//$.cookie("language", curCode);
	document.cookie = "language=" + curCode;
	location.reload();
}

/** 友好提示倒计时 */
var timeout_friendlyInform = null;

/** 友好提示
 * @param refContent 提示内容
 * @param refTitle 提示标题
 * @param refKeepTime 持续时间（单位：毫秒），需要大于 1000，暂时强制为 5000
 */
function friendlyInform(refContent, refTitle, refKeepTime) {
	if ($("#window_friendlyInform").size() == 0) {
		var curW = $("<div>", { // 创建模拟窗体
			"id" : "window_friendlyInform",
			"html" : //'<div class="title"></div>' +
				'<div class="content"></div>' +
				'<div class="background"></div>'
		}).get(0);
		$(curW).appendTo("body"); // 添加
		$(curW).fadeOut(0); // 快速隐藏
		//alert($(window).height());
		//alert($(document.body).height());
		$(curW).css({
			left : ($(window).width() - $(curW).outerWidth())/2,
			//top : $(document.body).height() <= $(window).height() ? ($(document.body).height() - $(curW).outerHeight())/3 : ($(window).height() - $(curW).outerHeight())/3 + $(document).scrollTop()
			top : $(document).scrollTop() + 46
		});
		curW.hide = function() { // 定义提示隐藏方法
			$(curW).fadeOut(1000);
		};
		curW.show = function() { // 定义提示显示方法
			$(curW).fadeIn(1000);
		};
		curW.setTime = function(refTime) { // 定义提示设置时间方法
			clearTimeout(timeout_friendlyInform);
			timeout_friendlyInform = setTimeout(this.hide, refTime);
		};
	}
	if (refContent == null || typeof(refContent) == "undefined") refContent = "";
	if (refTitle == null || typeof(refTitle) == "undefined") refTitle = "";
	$("#window_friendlyInform > .content").html(refContent);
	//$("#window_friendlyInform > .title").html(refTitle);
	$("#window_friendlyInform").get(0).show();
	$("#window_friendlyInform").get(0).setTime(5000);
	
}