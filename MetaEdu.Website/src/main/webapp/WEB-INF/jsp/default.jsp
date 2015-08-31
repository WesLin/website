<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="layout/header.jsp" %>

<script type="text/javascript" src="/static/script/page-default.js"></script>
<link href="/static/style/default.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

$(document).ready(function() {
	$("form[name='loginform']").submit(function(e) {
		e.preventDefault();
		login();
	});
	var url = document.location.href;
	if (url.indexOf('#nologin') != -1) {
		friendlyInform("登录超时啦，请重新登录");
	} else if (url.indexOf('#illegal') != -1) {
		friendlyInform("非法操作被拦截，请重新登录");
	} else if (url.indexOf("#noright") != -1) {
		friendlyInform("越权操作被拦截，请重新登录");
	}
});

function clearPreWord(refCtrl) {
	refCtrl.value = '';
	refCtrl.onfocus = null;
	refCtrl.style.color = "#333333";
}

var summaryIndex = -1; // 学校选取的默认索引

function keyListener(event) {
	var sumCount = summaryTab.childNodes.length;
	if (sumCount > 0) { // 统计元素数量
		if (event.keyCode == 37) { // 左键
			// 无操作
		} else if (event.keyCode == 38) { // 上键
			if (summaryIndex == -1) summaryIndex = sumCount - 1;
			else summaryIndex = (summaryIndex - 1) >= 0 ? summaryIndex - 1 : sumCount - 1;
			//alert(summaryIndex);
			summaryTab.childNodes[summaryIndex].pick();
		} else if (event.keyCode == 40) { // 下键
			if (summaryIndex == -1) summaryIndex = 0;
			else summaryIndex = (summaryIndex + 1) >= sumCount ? 0 : summaryIndex + 1;
			//alert(summaryIndex);
			summaryTab.childNodes[summaryIndex].pick();
		} else if (event.keyCode == 39) { // 右键
			// 无操作
		} else if (event.keyCode == 27) { // ESC
			// 无操作
		} else if (event.keyCode == 13) { // 回车
			if (summaryIndex != -1) {
				summaryTab.childNodes[summaryIndex].sel();
			}
		} else { // 其他
			// 无操作
		}
		
	}
}

// 原查询值参考
var preInstitutionRefer = "";

// 获取机构摘要信息
function getInstitutionSummary() {
	document.getElementById("block_login_input_institutionId").value = "";
	if (preInstitutionRefer != $("#block_login_input_insticode").val()) {
		preInstitutionRefer = $("#block_login_input_insticode").val();
		$.ajax({
			type: "POST",
			url: "/institutionInfos.htm",
			data: {
				institutionName : preInstitutionRefer
			},
			dataType: "json",
			success: function(data) {
				if (data.length > 0) {
					showInstitutionSummary(data);
				}
			}
		});
	}
}

// 可选机构列表
var summaryTab = null;

// 显示可选机构列表
function showInstitutionSummary(refData) {
	if (summaryTab == null) { // 如果列表对象为空
		summaryTab = document.createElement("div");
		summaryTab.id = "tab_selectInstitution";
		document.body.appendChild(summaryTab);
	}
	clearSummary();
	var tmpShow = true;
	if (refData.length > 0) {
		for (var i=0; i<refData.length; i++) {
			if (refData[i]['name'] == $("#block_login_input_insticode").val()) {
				clearSummary();
				document.getElementById("block_login_input_insticode").value = refData[i]['name'];
				document.getElementById("block_login_input_institutionId").value = refData[i]['id'];
				tmpShow = false;
				break;
			} else {
				var tmpSpan = document.createElement("span");
				tmpSpan.innerHTML = refData[i]['name'];
				tmpSpan.id = refData[i]['id'];
				tmpSpan.onmouseover = function() {
					this.pick();
				}
				tmpSpan.pick = function() {
					document.getElementById("block_login_input_insticode").blur();
					var subCount = summaryTab.childNodes.length;
					var subIndex = 0;
					for (var j=0; j<subCount; j++) {
						summaryTab.childNodes[j].style.backgroundColor = '#ffffff';
						summaryTab.childNodes[j].style.color = "#666666";
						summaryTab.childNodes[j].style.fontWeight = "normal";
						if (summaryTab.childNodes[j] == this) subIndex = j;
					}
					summaryIndex = subIndex;
					this.style.backgroundColor = '#c5eff8';
					this.style.color = "#333333";
					this.style.fontWeight = "bold";
				}
// 				tmpSpan.onmouseout = function() {
// 					this.style.backgroundColor = '#ffffff';
// 					this.style.color = "#666666";
// 					this.style.fontWeight = "normal";
// 				}
				tmpSpan.onclick = function() {
					this.sel();
				}
				tmpSpan.sel = function() {
					var tmpName = this.innerHTML;
					var tmpId = this.id;
					clearSummary();
					document.getElementById("block_login_input_insticode").value = tmpName;
					document.getElementById("block_login_input_institutionId").value = tmpId;
					document.getElementById("block_login_input_insticode").focus();
				}
				summaryTab.appendChild(tmpSpan);
			}
		}
		if (tmpShow) {
			$(document).keyup(keyListener); // 添加键盘监听
			summaryTab.style.display = 'inline';
			summaryTab.style.left = ($("#block_login_input_insticode").offset().left + 3) + 'px';
		}
	}
}

// 清除和隐藏机构表
function clearSummary() {
	summaryTab.innerHTML = '';
	summaryTab.style.display = 'none';
	document.getElementById("block_login_input_institutionId").value = "";
	summaryIndex = -1;
	$(document).unbind("keyup", keyListener); // 移除键盘监听
}

function login() {
	if ($("#block_login_input_institutionId").val() != ""
		&& $("#block_login_input_username").val() != "" && $("#block_login_input_username").val() != "学号或者工号" 
		&& $("#block_login_input_password").val() != ""
	) {
		$.ajax({
			type: "POST",
			url: "/login.htm",
			data: {
				institutionId : $("#block_login_input_institutionId").val(),
				account : $("#block_login_input_username").val(),
				password : $("#block_login_input_password").val()
			},
			dataType: "json",
			success: function(data) {
				if (!data) {
					friendlyInform('登录失败');
				} else location.href = '/user/index.htm';
			}
		});
	} else {
		friendlyInform("请填写完整的登录信息");
	}
	return false;
}

</script>

<div id="block_login_area">
	<div id="block_login_metalogo_area">
		<img src="/static/style/image/page_default_metalogo.jpg" />
	</div>
	<div id="block_login_input_area">
		<div id="block_login_typesel_area">
			<span id="block_login_typesel_metauser" class="disable"><a onclick="friendlyInform('程序员偷懒，还没有实现啦')">麦獭云用户登录</a></span>
			<span id="block_login_typesel_instiuser" class="enable"><a>学校账号登录</a></span>
		</div>
		<div id="block_login_logininfo_area">
			<form name="loginform" action="" >
			<span class="institution_span" id="block_login_input_insticode_container">
				<input class="loginInput_pre" id="block_login_input_insticode" onkeyup="getInstitutionSummary();" value="学校名称" type="text" onfocus="clearPreWord(this);" autocomplete="off" />
				<input type="hidden" id="block_login_input_institutionId" value="" />
			</span>
			<span class="username_span"><input class="loginInput_pre" id="block_login_input_username" onfocus="clearPreWord(this);" value="学号、工号或办公系统号" type="text"  autocomplete="off"  /></span>
			<span class="password_span"><input class="loginInput" id="block_login_input_password" type="password" /></span>
			<span id="block_login_logininfo_tips">
				${test}
			</span>
			<span id="block_login_login_area">
				<input  id="block_login_login_ope" type="submit" style="display:online;" value="登录" />
				<a id="block_login_forget_password">忘记密码</a>
				
			</span>
			</form>
		</div>
		
	</div>
</div>
<div id="block_defalut_page_intro" style="padding-top:40px;">
	<img src="/static/style/image/page_default_intro.jpg" />
</div>

<%@include file="layout/footer.jsp" %>