<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page errorPage="errorPage.jsp" %>

<%request.setCharacterEncoding("UTF-8"); %>

<html>
<head>
<title></title>
<link rel="stylesheet" href="../style/PageStyle.css" type="text/css">
</head>
<body bgcolor="#FFFFFF" text="#000000" background="../images/background.gif">
<br>
<div align="center">
<p>
<c:choose>
   <c:when test="${result}">  
         <h5>业务数据提交从成功!</h5>
	<p><a href='javascript:history.back();'><h6>返回</h6></a></p>      
   </c:when>
   <c:otherwise> 
     <h5>业务数据提交从失败!</h5>
	<p><a href='javascript:history.back();'><h6>返回</h6></a></p>
   </c:otherwise>
</c:choose>
</p>
</div>
</body>
</html>
