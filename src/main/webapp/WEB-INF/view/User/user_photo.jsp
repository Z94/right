<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工照</title>
</head>
<body>
	
	<form action="Up" method="post" enctype="multipart/form-data">
		文件：<input type="file" name="imageFile">
		<input type="submit">
	</form>
	
	<img src = "<c:url value="${ fileUrl }"/>" />
</body>
</html>