<%@ page contentType="text/html; charset=UTF-8" %>


<html>

<head>
<link rel="stylesheet" href="PageStyle.css" type="text/css">
<Script language="javascript" SRC="./style/common.js"></Script>

<title>登录</title>
<script>
function sf(){document.form1.userName.focus();}
</script>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#D7EAF8" background="images/111.gif" onLoad="sf();" 
   onmouseover="self.status='欢 迎 使 用 系 统';return true">

<div align="center">
<form name="form1" method="post" action="login.do">
<br>


  <div align="center">
          <table border="0" cellpadding="0" cellspacing="0" width="600">
            <tr> 
              <td valign="middle" align="center" height="493%" background="image/td_bg.gif"> 
                <img border="0" src="images/login3.jpg" width="547" height="300"> 
              </td>
            </tr>
            <tr> 
              <td valign="middle" align="center" height="8" background="images/td_bg.gif"> 
                <p align="center"> <font color="red"> </font> 
                  　 
              </td>
            </tr>
            <tr> 
              <td valign="bottom" align="center" height="12" background="image/td_bg.gif"> 
                <div align="center"><b><font color="#000000">用户名：</font></b> 
                  <input type="text" name="userName" value="" maxlength="20" size="15" mustFill=true promptName="用户名">
                  &nbsp;<font color="#000000">&nbsp;&nbsp;&nbsp;&nbsp; <b>密&nbsp;码：</b></font> 
                  <input type="password" name="password" value="" maxlength="6" size="15" mustFill=true promptName="密码项">
                  &nbsp;&nbsp;&nbsp;&nbsp; 
                  <input type="submit" border="0" name="imageField332" src="images/login-01.gif"  onMouseOut="src='images/login-01.gif'" 
                  onMouseOver="src='images/login-02.gif'" >
                </div>
              </td>
            </tr>
  
          </table>
  </div>

<font color="red">${error }</font>

  </form>
</div>
</body>

</html>
