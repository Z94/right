<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="../style/PageStyle.css" type="text/css">
<Script language="javascript" SRC="../style/common.js"></Script>
</head>


<body topmargin="0" bgcolor="#FFFFFF" text="#000000" background="" >
<c:choose>
	<c:when test="${manager.getManager_id().equals('1') }">
		<c:out value="当前管理员为超级管理员${manager.getManager_name() },无法进行操作！"></c:out>
	</c:when>
	<c:otherwise>
<form name="form1" method="post" action="sa_delete.jsp?aHref=../sa_tree.jsp&_oid=${manager.getManager_id() }&_downid=${manager.getManager_id() }">
 <TABLE cellSpacing=0 cellPadding=0  width="100%" align="center" border=0>
	  <TBODY>  
		  <tr>
		    <TD width="90%" height=53 background="../images/333.gif">
		      <div align="center"><span style="letter-spacing: 2pt"><b><h1>管理员管理</h1></B></SPAN></DIV></TD>
		    <TD width="10%" height=53 background="../images/333.gif"><img border="0" src="../images/xtgl.gif"> </TD>
		  </TR>
	  </TBODY>
 </TABLE>
<HR color="#D7EAF8" size="6" noshade>
<br>
  <table width="80%" border="1" align="center" height="40" cellpadding="0" cellspacing="0"  bordercolordark="#FFFFFF" bordercolorlight="#102884">
          <tr >
            <td colspan="2"  nowrap bgcolor="#C4CAE1" height="44" align="center">
              <div align="center">当前管理员名：${manager.getManager_name() } <font color="red"  ></font></div>
            </td>
          </tr>
          <tr >
            <td width="50%"  bgcolor="#C4CAE1" height="33" align="center"><a href="manager_update?id=${manager.getManager_id() }">编辑管理员</a></td>
            <td width="50%"  bgcolor="#C4CAE1"  height="30" align="center">
			   <a href="FormReceiveJSP?tableName=d_manager&tableAction=3&$manager_id=${manager.getManager_id() }"  onClick="return Conwin('确定删除吗？');">删除管理员</a></td>
 
          </tr>
          <tr >
            <td width="50%"  bgcolor="#C4CAE1"  height="30" align="center">
			  <a href="manager_module?id=${manager.getManager_id() }">管理员模块授权</a></td>
            <td width="257"  bgcolor="#C4CAE1" height="30" align="center">
             <a href="manager_function?id=${manager.getManager_id() }">管理员功能授权</a></td>
          </tr>
          <tr>
          	<td width="257"  bgcolor="#C4CAE1" height="30" align="center">
             <a href="manager_select?id=${manager.getManager_id() }">管理员密码查询</a></td>
             <td width="257"  bgcolor="#C4CAE1" height="30" align="center">
             <a href=""></a></td>
          </tr>
        </table>          
  </form>
 </c:otherwise>
</c:choose>
<br>
<hr width="95%" noshade size="6" color=#1B4B81>
</body>
</html>



