<%@ page contentType="text/html; charset=UTF-8"%>
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
<form name="form1" id="form1" method="post" action="functionAdd">
 <TABLE cellSpacing=0 cellPadding=0  width="100%" align=center border=0><!--DWLayoutTable-->
	  <TBODY>  
		  <tr>
		    <TD width="90%" height=53 background="../../images/333.gif">
		      <div align="center"><b><h1>添加功能 </h1></B></DIV></TD>
		    <TD width="10%" height=53 background="../../images/333.gif"><img border="0" src="../../images/xtgl.gif"> </TD>
		  </TR>
	  </TBODY>
 </TABLE>
<HR color="#D7EAF8" size="6" noshade>

    <input type="hidden" name="module_id" value="${module.getModule_id() }" >
  <table width="50%" border="1" align="center" height="40" cellpadding="0" cellspacing="0"  bordercolordark="#FFFFFF" bordercolorlight="#102884">


	
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >角色所属模块</td>
      <td width="83%" > 
        <input type="text" name="module_name" readonly value="${module.getModule_name() }" size="50" maxlength="20">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >功能名</td>
      <td width="83%" > 
        <input type="text" name="function_name" value="" size="50" maxlength="20">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >URL</td>
      <td width="83%"  > 
        <input type="text" name="function_url" value="" size="50" maxlength="">
        </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >打开方式</td>
      <td width="83%" >        
		<select size="1" name="function_target">	
			<option  value="rhs" selected>右边</option>
			<option  value="lhs">左边</option>		
		</select>
      </td>
    </tr>
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >功能描述</td>
      <td width="83%"  > 
        <input type="text" name="function_des" value="" size="50" maxlength="10">
        </td>
    </tr>     
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >顺序号</td>
      <td width="83%"  > 
        <input type="text" name="function_order" value="" size="50" maxlength="10"  class="required number">
        </td>
    </tr> 
    <tr >
      <td width="17%"  nowrap bgcolor="#C4CAE1" >功能受控</td>
      <td width="83%"  > 
        <select name="function_control">
        	<option value="0">0</option>
        	<option value="1" selected>1</option>
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
