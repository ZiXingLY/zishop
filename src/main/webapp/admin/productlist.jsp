<%@page import="cn.ziots.dao.ProductDao"%>
<%@ page language="java" contentType="text/html;"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">admin</a>
<%
	ProductDao pro = new ProductDao();
	ResultSet rs=pro.showProduct();
%>
<table>
	<th><td>品牌</td>品名<td>描述</td><td>价格</td></th>
<%	
	while(rs.next()){
%>
	<tr> <td><%=rs.getString("p_brand") %></td> <td><%=rs.getString("p_name") %></td> <td><%=rs.getString("p_description") %></td> <td><%=rs.getString("p_price") %></td>
	<td><a href="../DeleteProduct?p_id=<%=rs.getString("p_id")%>" >delete</a></td><td><a href="updateproduct.jsp?p_id=<%=rs.getString("p_id")%>" >update</a></td></tr>
<%		
	}
%>
</table>
</body>
</html>