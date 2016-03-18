<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../style/PageStyle.css" type="text/css">
<title>Insert title here</title>
</head>
<script language="JavaScript">
	function moveOption(e1, e2){
	  for(var i=0;i<e1.options.length;i++){
		   if(e1.options[i].selected){
			    var e = e1.options[i];
			    var option = new Option(e.text, e.value);
			    e2.options.add(option);
			    e1.remove(i);
			    for(var j=0;j<e2.options.length;j++){
				    if(e2.options[j].value.equals(option.value)){
				    	e2.options[j].selected="selected";
				    }
			    }
			    i=i-1;
		   }
	  }
	  
	}
	function moveAll(e1,e2){
		for(var i=0;i<e1.options.length;i++){
			var e = e1.options[i];
			e2.options.add(new Option(e.text,e.value));
			e1.remove(i);
			i=i-1;
		}
	}
	function selected(e){
		for(var i=0;i<e.length;i++){
					e.options[i].selected="selected";
		}
	}
</script>
<%request.setCharacterEncoding("UTF-8"); %>
<body>
	<form name="form1" method="post" action="right">
		<input type="hidden" name="id" value="${module.getModule_id() }">
		<input type="hidden" name="tableName" value="d_r_module_manager">
		
		<input type="hidden" name="deleteName" value="module_id">
		<table align="center">
		
		<tr>
			<td colspan="2"  nowrap bgcolor="#C4CAE1" height="44" align="center">
              <div align="center">当前模块名：${module.getModule_name() } <font color="red"  ></font></div>
            </td>
            </tr>
			<tr>
				<td width="40%">未拥有该模块的管理员</td>
				<td width="20%"></td>
				<td width="40%">拥有该模块的管理员</td>
			</tr>
			<tr>
				<td width="40%">
					<select style="width:100%;" multiple id = "list1"  size="20" 
						ondblclick="moveOption(document.getElementById('list1'),document.getElementById('list2'))">
					<c:forEach var="item" items="${managers }">
						
						<option  value="${item.getManager_id() }">${item.getManager_name() }</option> 
					</c:forEach>	
					</select>
				</td>
				<td width="20%" align="center">
			  		<input type="button" value="全部选择" onclick="moveAll(document.getElementById('list1'),document.getElementById('list2'));"><br><br>
			 	 	<input type="button" value="选择" onclick="moveOption(document.getElementById('list1'), document.getElementById('list2'));"><br><br>
			  		<input type="button" value="删除" onclick="moveOption(document.getElementById('list2'), document.getElementById('list1'))"><br><br>
			  		<input type="button" value="全部删除" onclick="moveAll(document.getElementById('list2'),document.getElementById('list1'))">
	      		</td>
	      		<td width="40%">
			  		<select style="width:100%;" multiple id="list2" size="20" name="ids" ondblclick="moveOption(document.getElementById('list2'), document.getElementById('list1'))">
			  			<c:forEach var="item" items="${name }">
						
						<option  value="${item.getManager_id() }">${item.getManager_name() }</option> 
					</c:forEach>
			  		</select>
	   	  		</td>
			</tr>
	
		</table>
		<div align="center">
    		<input type="image" border="0" name="imageField34" src="../images/ok.gif"  onmouseout="src='../images/ok.gif'" onmouseover="src='../images/ok1.gif'" onclick="selected(document.getElementById('list2'))">
   		 	<input type="image" border="0" name="imageField32" src="../images/cancel.gif"  onmouseout="src='../images/cancel.gif'" onmouseover="src='../images/cancel1.gif'" onclick="form1.reset(); return false;">    
  		</div>
	</form>
</body>
</html>