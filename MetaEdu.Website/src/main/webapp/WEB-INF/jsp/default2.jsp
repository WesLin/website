<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="layout/header.jsp" %>

<script type="text/javascript" src="/static/script/page-default.js"></script>
<link href="/static/style/default.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	
function clearPreWord(refCtrl) {
	refCtrl.value = '';
	refCtrl.onfocus = null;
	refCtrl.style.color = "#333333";
}

// 原查询值参考
var preInstitutionRefer = "";

// 获取机构摘要信息
function getInstitutionSummary() {
	document.getElementById("block_login_input_institutionId").value = "";
	if (preInstitutionRefer != $("#block_login_input_insticode").val()) {
		preInstitutionRefer = $("#block_login_input_insticode").val();
		$.ajax({
			type: "GET",
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
					this.style.backgroundColor = '#c5eff8';
					this.style.color = "#333333";
					this.style.fontWeight = "bold";
				}
				tmpSpan.onmouseout = function() {
					this.style.backgroundColor = '#ffffff';
					this.style.color = "#666666";
					this.style.fontWeight = "normal";
				}
				tmpSpan.onclick = function() {
					var tmpName = this.innerHTML;
					var tmpId = this.id;
					clearSummary();
					document.getElementById("block_login_input_insticode").value = tmpName;
					document.getElementById("block_login_input_institutionId").value = tmpId;
				}
				summaryTab.appendChild(tmpSpan);
			}
		}
		if (tmpShow) {
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
}

function login() {
	if ($("#block_login_input_institutionId").val() != ""
		&& $("#block_login_input_username").val() != "" && $("#block_login_input_username").val() != "学号或者工号" 
		&& $("#block_login_input_password").val() != ""
	) {
		$.ajax({
			type: "GET",
			url: "/login.htm",
			data: {
				institutionId : $("#block_login_input_institutionId").val(),
				account : $("#block_login_input_username").val(),
				password : $("#block_login_input_password").val()
			},
			dataType: "json",
			success: function(data) {
				alert(data);
			}
		});
	} else {
		alert($("#block_login_input_institutionId").val());
		alert($("#block_login_input_username").val());
		alert($("#block_login_input_password").val());
		friendlyInform("请填写完整的登录信息");
	}
}

</script>

<div id="block_login_area">
	<div id="block_login_metalogo_area">
		<img src="/static/style/image/page_default_metalogo.jpg" />
	</div>
	<div id="block_login_input_area">
		<div id="block_login_typesel_area">
			<span id="block_login_typesel_metauser" class="disable"><a onclick="friendlyInform('<fmt:message key="general.sorryForUndo" />')"><fmt:message key="default.metaUserLogin" /></a></span>
			<span id="block_login_typesel_instiuser" class="enable"><a><fmt:message key="default.instiUserLogin" /></a></span>
		</div>
		<div id="block_login_logininfo_area">
			<span class="institution_span" id="block_login_input_insticode_container">
				<input class="loginInput_pre" id="block_login_input_insticode" onkeyup="getInstitutionSummary();" value="学校名称" type="text" onfocus="clearPreWord(this);" />
				<input type="hidden" id="block_login_input_institutionId" value="" />
			</span>
			<span class="username_span"><input class="loginInput_pre" id="block_login_input_username" onfocus="clearPreWord(this);" value="<fmt:message key="default.studentId" />" type="text" /></span>
			<span class="password_span"><input class="loginInput" id="block_login_input_password" type="password" /></span>
			<span id="block_login_logininfo_tips">
				${test}
			</span>
			<span id="block_login_login_area">
				<a id="block_login_login_ope" onclick="login();"><fmt:message key="general.signin" /></a>
				<a id="block_login_forget_password"><fmt:message key="general.forgotPassword" /></a>
			</span>
		</div>
	</div>
</div>
<div id="block_defalut_page_intro" style="padding-top:40px;">
	<img src="/static/style/image/page_default_intro.jpg" />
</div>

<%@include file="layout/footer.jsp" %>