<%@ page language="java" contentType="text/html;"
    pageEncoding="utf-8"%>
<%@ page import="cn.ziots.dao.*,java.sql.*" %>
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
	pro.setId(Integer.parseInt(request.getParameter("p_id")));
	ResultSet rs = pro.selectProduct(pro);
	rs.next();
%>
	<form action="../UpdateProduct" enctype="multipart/form-data" method="post">
	<input type="hidden" name="id" value="<%=rs.getString("p_id")%>"><br/>
        类型：<input type="text" name="type" value="<%=rs.getString("p_type")%>"><br/>
        品牌：<input type="text" name="brand" value="<%=rs.getString("p_brand")%>"><br/>
      名称：  <input type="text" name="name" value="<%=rs.getString("p_name")%>"><br/>
      价格：  <input type="text" name="price" value="<%=rs.getString("p_price")%>"><br/>
      数量：  <input type="text" name="quantity" value="<%=rs.getString("p_quantity")%>"><br/>
      描述：  <input type="text" name="description" value="<%=rs.getString("p_description")%>"><br/>
       头像 ：<input type="file" name="file"><br/>
        <input type="submit" value="提交">
    </form>
</body>