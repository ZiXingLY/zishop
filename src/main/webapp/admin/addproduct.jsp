<%@ page language="java" contentType="text/html;"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">admin</a>
	<form action="../addProduct" enctype="multipart/form-data" method="post">
       ID： <input type="text" name="id" value="0001"><br/>
        类型：<input type="text" name="type" value="0001"><br/>
        品牌：<input type="text" name="brand" value="zishop"><br/>
      名称：  <input type="text" name="name" value="zishop"><br/>
      价格：  <input type="text" name="price" value="1999"><br/>
      数量：  <input type="text" name="quantity" value="100"><br/>
      描述：  <input type="text" name="description" value="zishop"><br/>
       头像 ：<input type="file" name="file"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>