<%@ page language="java" contentType="text/html;"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>手机商城</title>
<script language="javascript">
<!--
		function check_name(form)
		{
			if(form.c_name.value=="")
			{
				alert("请输入您的用户名");
				form.c_name.focus();
				return false;
			}
		}
-->
</script>
</head>

<body>
	<jsp:include page="top.jsp" flush="true"/><!--动态包含-->
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="navigation.jsp" flush="true"/>
	
	<center>
<form action="forgetPass" method="post" onSubmit="return check_name(this);">
<table width="782" border="0" cellpadding="0" cellspacing="0">
  <!--DWLayoutTable-->
  <tr>
    <td height="40" colspan="3" align="center"><span class="STYLE10">密码查询</span> </td>
  </tr>
  <tr>
    <td height="20" colspan="3" align="center"><!--DWLayoutEmptyCell-->&nbsp;</td>
  </tr>
  <tr>
    <td width="322" align="right"><span class="STYLE1">请输入您的用户名</span>：</td>
	<td width="195" height="34" align="left"><input type="text" name="c_name" value="" /></td>
    <td width="265" align="left"><input name="Submit" type="submit" class="STYLE1" value=" 确定 "  /></td>
  </tr>
  <tr>
    <td height="34" colspan="3" align="left"><!--DWLayoutEmptyCell-->&nbsp;</td>
	</tr>
</table>
</form>
</center>
	<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>