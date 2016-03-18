<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<%request.setCharacterEncoding("UTF-8"); %>
<form name="form1" id="form1" method="post" action="userUpdate">
 <TABLE cellSpacing=0 cellPadding=0  width="100%" align=center border=0><!--DWLayoutTable-->
	  <TBODY>  
		  <tr>
		    <TD width="90%" height=53 background="../../images/333.gif">
		      <div align="center"><b><h1>当前员工名：${user.getUser_name() } </h1></B></DIV></TD>
		    <TD width="10%" height=53 background="../../images/333.gif"><img border="0" src="../../images/xtgl.gif"> </TD>
		  </TR>
	  </TBODY>
 </TABLE>
<HR color="#D7EAF8" size="6" noshade>

  <table width="50%" border="1" align="center" height="40" cellpadding="0" cellspacing="0"  bordercolordark="#FFFFFF" bordercolorlight="#102884">
    
	<tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >员工编号</td>
      <td width="83%" > 
        <input type="text" name="$user_id" readonly value="${user.getUser_id() }" size="50" maxlength="20">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >上级部门</td>
      <td width="83%" > 
      
      <select size="1" name="org_id">	
		<c:forEach var="dep" items="${orgs}">
			<c:choose>
	   			<c:when test="${dep.getOrg_id().equals(user.getOrg_id()) }">   
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
      <td width="17%"  nowrap bgcolor="#C4CAE1" >员工姓名</td>
      <td width="83%" > 
        <input type="text" name="user_name" value="${user.getUser_name() }" size="50" maxlength="20">
        </td>
    </tr>
    
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >员工登录名</td>
      <td width="83%"  > 
        <input type="text" name="login_user" value="${user.getLogin_user() }" size="50" maxlength="10" class="required">
        </td>
    </tr>  
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >员工登录密码</td>
      <td width="83%"  > 
        <input type="text" name="password" value="${user.getPassword() }" size="50" maxlength="10"  class="required">
        </td>
    </tr> 
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >性别</td>
      <td width="83%"  > 
      <c:choose>
	   			<c:when test="${user.getGender().equals('女') }">   
	   			<input type='radio' name='gender' value='女' size='50' maxlength='10' checked>女
	   			<input type='radio' name='gender' value='男' size='50' maxlength='10' >男
	   			</c:when>
	   			<c:otherwise>  
	   				<input type='radio' name='gender' value='男' size='50' maxlength='10' checked>男
	   				<input type='radio' name='gender' value='女' size='50' maxlength='10' >女
	   			</c:otherwise>
	  		</c:choose>	
        </td>
    </tr> 
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >联系地址</td>
      <td width="83%"  > 
        <input type="text" name="address" value="${user.getAddress() }" size="50" maxlength="10">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >邮编</td>
      <td width="83%"  > 
        <input type="text" name="mail" value="${user.getMail() }" size="50" maxlength="10">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >E_MAIL</td>
      <td width="83%"  > 
        <input type="text" name="e_mail" value="${user.getE_mail() }" size="50" maxlength="10"  class="email">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >年龄</td>
      <td width="83%"  > 
        <input type="text" name="age" value="${user.getAge() }" size="50" maxlength="10"  class="number">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >电话</td>
      <td width="83%"  > 
        <input type="text" name="user_tel" value="${user.getUser_tel() }" size="50" maxlength="10">
        </td>
    </tr>
    
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >顺序号</td>
      <td width="83%"  > 
        <input type="text" name="user_order" value="${user.getUser_order() }" size="50" maxlength="10">
        </td>
    </tr>    
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >y员工受控</td>
      <td width="83%"  > 
        <select name="function_control">
        <c:choose>
        	<c:when test="${user.getUser_control().equals('0') }">
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
