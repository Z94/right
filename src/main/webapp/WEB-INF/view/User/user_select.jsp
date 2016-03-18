<%@ page contentType="text/html; charset=UTF-8" %>

<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="../style/PageStyle.css" type="text/css">
<Script language="javascript" SRC="../style/common.js"></Script>
</head>


<body topmargin="0" bgcolor="#FFFFFF" text="#000000" background="" >
<%
  String id=request.getParameter("id"); 
%>

<form name="form1" method="post" action="">
<HR color="#D7EAF8" size="6" noshade>
<br>
  <table width="80%" border="1" align="center" height="40" cellpadding="0" cellspacing="0"  bordercolordark="#FFFFFF" bordercolorlight="#102884">
          <tr >
            <td colspan="2"  nowrap bgcolor="#C4CAE1" height="44" align="center">
              <div align="center">当前员工：${user.getUser_name() } <font color="red"  ></font></div>
            </td>
          </tr>
          <tr >
            <td colspan="2"  nowrap bgcolor="#C4CAE1" height="44" align="center">
              <div align="center">当前员工密码：${user.getPassword() } <font color="red"  ></font></div>
            </td>
          </tr>
        </table>          
  </form>
<br>
<hr width="95%" noshade size="6" color=#1B4B81>
</body>
</html>



