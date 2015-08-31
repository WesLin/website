<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	</head>
	<body>
		
		<form name="importStudent" id="importStudent" method="post" enctype="multipart/form-data" action="/import/student-ope.htm">
			<input type="text" name="institutionId" value="0860571100000010" /><br/>
			<input type="text" name="eduSystemType" value="104001" /><br/>
			<select name="currentGradeType">
				<option value="104001">高一</option>
				<option value="104002">高二</option>
				<option value="104003">高三</option>
			</select>
			<br/>
			<input type="text" name="clazzName" value="" /><br/>
			<input type="file" name="file" id="file" /><br/>
			<input type="submit" id="submit" value="上传" />
		</form>
		
	</body>
</html>