<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>麦獭课堂直播 - ${lessonName}</title>        
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style type="text/css" media="screen"> 
			html, body  { height:100%; }
			body { margin:0; padding:0; overflow:auto; text-align:center; background-color: #ffffff; }
			object:focus { outline:none; }
			#flashContent { display:none; }
		</style>
		<link rel="stylesheet" type="text/css" href="history/history.css" />
		<script type="text/javascript" src="history/history.js"></script>
		<script type="text/javascript" src="websupport.js"></script>
		<script type="text/javascript" src="swfobject.js"></script>
		<script type="text/javascript">
			var swfVersionStr = "11.1.0"; // 最低 FlashPlayer 版本要求 11
			var xiSwfUrlStr = "playerProductInstall.swf";
			var flashvars = {
				isRecord : false,
				isGeneralLogin : false,
				account : "${user.getCharacterNumber()}",
				password : "${user.getCharacterPassword()}",
				institutionId : "${user.getInstitutionId()}",
				conversationId : "${lessonId}",
				messageAddress : "${messageServer}",
				streamAddress : "${streamServer}",
				fileUploadAddress : "${fileUploadAddress}",
				fileDownloadAddress : "${fileDownloadAddress}"
			};
			var params = {};
			params.quality = "high";
			params.bgcolor = "#ffffff";
			params.allowscriptaccess = "sameDomain";
			params.allowfullscreen = "true";
			params.wmode = "transparent";
			var attributes = {};
			attributes.id = "MetaClass";
			attributes.name = "MetaClass";
			attributes.align = "middle";
			swfobject.embedSWF("MetaClass.swf?data=150814", "flashContent", "100%", "100%", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
			swfobject.createCSS("#flashContent", "display:block;text-align:left;");
			
			// Flash 关闭页面
			function onAsCloseWindow() {
				var userAgent = navigator.userAgent;
				if (userAgent.indexOf("Firefox") != -1 || userAgent.indexOf("Presto") != -1) {
					window.location.replace("about:blank");
				} else {
					window.opener = null;
					window.open("", "_self");
					window.close();
				}
			}
		</script>
	</head>
	<body>
		<div id="flashContent">
			<p>课堂程序无法正常加载，请安装 Adobe Flash Player 并确保版本在 11 以上</p>
			<script type="text/javascript"> 
				var pageHost = ((document.location.protocol == "https:") ? "https://" : "http://"); 
				document.write("<a href='http://www.adobe.com/go/getflashplayer'><img src='" 
					+ pageHost + "www.adobe.com/images/shared/download_buttons/get_flash_player.gif' alt='Get Adobe Flash player' /></a>" ); 
			</script> 
		</div>
		<noscript>
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="100%" height="100%" id="MetaClass">
				<param name="movie" value="MetaClass.swf" />
				<param name="quality" value="high" />
				<param name="bgcolor" value="#ffffff" />
				<param name="allowScriptAccess" value="sameDomain" />
				<param name="allowFullScreen" value="true" />
				<!--[if !IE]>-->
				<object type="application/x-shockwave-flash" data="MetaClass.swf" width="100%" height="100%">
					<param name="quality" value="high" />
					<param name="bgcolor" value="#ffffff" />
					<param name="allowScriptAccess" value="sameDomain" />
					<param name="allowFullScreen" value="true" />
				<!--<![endif]-->
				<!--[if gte IE 6]>-->
					<p>当前页面的脚本被禁止播放，或者 Adobe Flash Player 11 及以上的版本尚未安装</p>
				<!--<![endif]-->
					<a href="http://www.adobe.com/go/getflashplayer">
						<img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="点击获取最新版本的 Adobe Flash Player" />
					</a>
				<!--[if !IE]>-->
				</object>
				<!--<![endif]-->
			</object>
		</noscript>     
	</body>
</html>
