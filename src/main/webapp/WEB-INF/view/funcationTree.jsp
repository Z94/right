
<%@page import="com.right.service.TreeService"%>
<%@ page contentType="text/html;charset=gb2312" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<link rel="stylesheet" href="./style/PageStyle.css" type="text/css">

</head>
<body leftmargin="0" bgcolor="#D7EAF8" background="images/111.gif" onmouseover="self.status=' ${userName} ：您好！ 欢 迎 使 用 索 创 系 统';return true">
<form name="form1" method="post" action="">
<table width=151 border=0 cellspacing=0 cellpadding=0 align="left" height="28">
  <tbody>
  <tr>
    <td>
    	${tree }
    </td>
  </tr>
</TABLE>
<input type="hidden" name="reloadMark" value="0">
</form>
</BODY>
</HTML>
