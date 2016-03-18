<%@ page contentType="text/html; charset=UTF-8" %>

<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="../style/PageStyle.css" type="text/css">
<Script language="javascript" SRC="../style/common.js"></Script>
</head>


<body topmargin="0" bgcolor="#FFFFFF" text="#000000" background="" >

<form name="form1" method="post" action="sa_delete.jsp?aHref=../sa_tree.jsp&_oid=${function.getFunction_id() }&_downid=${function.getFunction_id() }">
 <TABLE cellSpacing=0 cellPadding=0  width="100%" align="center" border=0>
	  <TBODY>  
		  <tr>
		    <TD width="90%" height=53 background="../images/333.gif">
		      <div align="center"><span style="letter-spacing: 2pt"><b><h1>功能管理</h1></B></SPAN></DIV></TD>
		    <TD width="10%" height=53 background="../images/333.gif"><img border="0" src="../images/xtgl.gif"> </TD>
		  </TR>
	  </TBODY>
 </TABLE>
<HR color="#D7EAF8" size="6" noshade>
<br>
  <table width="80%" border="1" align="center" height="40" cellpadding="0" cellspacing="0"  bordercolordark="#FFFFFF" bordercolorlight="#102884">
          <tr >
            <td colspan="2"  nowrap bgcolor="#C4CAE1" height="44" align="center">
              <div align="center">当前功能名：${function.getFunction_name() } <font color="red"  ></font></div>
            </td>
          </tr>
          <tr >
            <td width="50%"  bgcolor="#C4CAE1" height="33" align="center"><a href="function_edit?id=${function.getFunction_id() }">编辑功能</a></td>
            <td width="50%"  bgcolor="#C4CAE1"  height="30" align="center">
			  <a href="../Common/FormReceiveJSP?tableName=d_function&tableAction=3&$function_id=${function.getFunction_id() }" 
			  onClick="return Conwin('确定要删除吗？');">删除功能</a></td>
          </tr>
		  <tr >
            <td width="50%"  bgcolor="#C4CAE1"  height="30" align="center">
            	<a href="function_user?id=${function.getFunction_id() }">功能用户授权</a></td>
            <td width="257"  bgcolor="#C4CAE1" height="30" align="center">
             <a href="function_role?id=${function.getFunction_id() }">功能角色授权</a></td>
          </tr>
          <tr >
            <td width="50%"  bgcolor="#C4CAE1"  height="30" align="center">
            	<a href="function_manager?id=${function.getFunction_id() }">功能管理员授权</a></td>
            <td width="257"  bgcolor="#C4CAE1" height="30" align="center">
             <a href=""></a></td>
          </tr>
        </table>          
  </form>
<br>
<hr width="95%" noshade size="6" color=#1B4B81>
</body>
</html>



