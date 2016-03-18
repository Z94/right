<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<script src="../js/jquery-1.11.3.min.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<script>
$().ready(function() {
	 $("#form1").validate();
	});
</script>
<link rel="stylesheet" href="../style/PageStyle.css" type="text/css">
</head>

<body topmargin="0" bgcolor="#FFFFFF" text="#000000" >
<form name="form1" id="form1" method="post" action="roleUpdate">
 <TABLE cellSpacing=0 cellPadding=0  width="100%" align=center border=0><!--DWLayoutTable-->
	  <TBODY>  
		  <tr>
		    <TD width="90%" height=53 background="../../images/333.gif">
		      <div align="center"><b><h1>当前角色名：${role.getRole_name() } </h1></B></DIV></TD>
		    <TD width="10%" height=53 background="../../images/333.gif"><img border="0" src="../../images/xtgl.gif"> </TD>
		  </TR>
	  </TBODY>
 </TABLE>
<HR color="#D7EAF8" size="6" noshade>

  <table width="50%" border="1" align="center" height="40" cellpadding="0" cellspacing="0"  bordercolordark="#FFFFFF" bordercolorlight="#102884">
   
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >角色ID</td>
      <td width="83%" > 
        <input type="text" name="role_id" readonly value="${role.getRole_id() }" size="50" maxlength="20"  class="required">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >所属部门</td>
      <td width="83%"  > 
        <select size="1" name="org_id">	
		<c:forEach var="dep" items="${orgs}">
			<c:choose>
	   			<c:when test="${dep.getOrg_id().equals(role.getOrg_id()) }">   
	   			<option  value="${dep.getOrg_id()}"  selected>${dep.getOrg_name()}</option> 
	   			</c:when>
	   			<c:otherwise>  
	   				<option  value="${dep.getOrg_id()}">${dep.getOrg_name()}</option> 
	   			</c:otherwise>
	  		</c:choose>	
		</c:forEach>		
		</select>
        </td>
    </tr>    
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >角色名称</td>
      <td width="83%"  > 
        <input type="text" name="role_name" value="${role.getRole_name() }" size="50" maxlength="10">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >角色描述</td>
      <td width="83%"  > 
        <input type="text" name="role_describe" value="${role.getRole_describe() }>" size="50" maxlength="10">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >角色顺序</td>
      <td width="83%"  > 
        <input type="text" name="role_order" value="${role.getRole_order() }" size="50" maxlength="10"  class="required number">
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
