<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="../style/PageStyle.css" type="text/css">
</head>

<body topmargin="0" bgcolor="#FFFFFF" text="#000000" >
<form name="form1" method="post" action="moduleUpdate">
 <TABLE cellSpacing=0 cellPadding=0  width="100%" align=center border=0><!--DWLayoutTable-->
	  <TBODY>  
		  <tr>
		    <TD width="90%" height=53 background="../../images/333.gif">
		      <div align="center"><b><h1>编辑模块 </h1></B></DIV></TD>
		    <TD width="10%" height=53 background="../../images/333.gif"><img border="0" src="../../images/xtgl.gif"> </TD>
		  </TR>
	  </TBODY>
 </TABLE>
<HR color="#D7EAF8" size="6" noshade>

  <table width="50%" border="1" align="center" height="40" cellpadding="0" cellspacing="0"  bordercolordark="#FFFFFF" bordercolorlight="#102884">
    
	<tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >模块编号</td>
      <td width="83%" > 
        <input type="text" name="module_id" readonly value="${module.getModule_id() }" size="50" maxlength="20">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >模块名称</td>
      <td width="83%" > 
        <input type="text" name="module_name" value="${module.getModule_name() }" size="50" maxlength="20">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >顺序号</td>
      <td width="83%"  > 
        <input type="text" name="module_order" value="${module.getModule_order() }" size="50" maxlength="10">
        </td>
    </tr>    
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >模块链接</td>
      <td width="83%"  > 
        <input type="text" name="module_url" value="${module.getModule_url() }" size="50" maxlength="10">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >模块受控</td>
      <td width="83%"  > 
        <select name="function_control">
        <c:choose>
        	<c:when test="${module.getModule_control().equals('0') }">
	        	<option value="0" selected>0</option>
	        	<option value="1" >1</option>
        	</c:when>
        	<c:otherwise>	
	        	<option value="0">0</option>
	        	<option value="1" selected>1</option>
        	</c:otherwise>
        </c:choose>
        </select>
        </td>
    </tr>
  </table>
  <div align="center">
    <input type="image" border="0" name="imageField34" src="../images/ok.gif"  onmouseout="src='../images/ok.gif'" onmouseover="src='../images/ok1.gif'" onclick="">
    <input type="image" border="0" name="imageField32" src="../images/cancel.gif"  onmouseout="src='../images/cancel.gif'" onmouseover="src='../images/cancel1.gif'" onclick="form1.reset(); return false;">    
  </div>
</form>
</body>
</html>
