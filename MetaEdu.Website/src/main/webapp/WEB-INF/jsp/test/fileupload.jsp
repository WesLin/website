<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
		<link href="/static/style/general.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		
		<form name="formUpload" id="formUpload" method="post" enctype="multipart/form-data" action="/complex/uploadfile.htm">
			<input type="text" name="complexId" value="0860000100000000-1507071700000001" />
			<input type="text" name="userId" value="testUser" />
			<input type="file" name="file" id="file" />
			<input type="submit" id="submit" value="上传" />
		</form>
		
	</body>
</html>