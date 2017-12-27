<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="cn.ziots.dao.*"%>
<%@ page language="java" contentType="text/html;"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*,cn.ziots.util.*,cn.ziots.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>手机商城</title>
</head>

<body>
	<jsp:include page="top.jsp" flush="true"/><!--动态包含-->
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="navigation.jsp" flush="true"/>
	
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="index.jsp">Home</a></li>
						<li><a href="cart.jsp">Cart</a></li>
					</ul>
				</div>
			</div>
			<%
				String uid=session.getAttribute("me").toString();
				Carts cart = new Carts();
				CartsDao dcart = new CartsDao();
				Product pro = new Product();
				ProductDao dpro = new ProductDao();
				double price=0;
				cart.setUid(uid);
				LinkedList<Carts> llcart = dcart.getGoodsByUid(cart);
				//for(int i = 0;i<llcart.size();i++)
				Iterator<Carts> it = llcart.iterator();
				while(it.hasNext()){
					cart = it.next();
					pro.setId(cart.getPid());
					pro = dpro.getProductByPid(pro);
				price += pro.getPrice()*cart.getPnumber();
			
			%>
			<div class="row">
				<div class="product well">
					<div class="col-md-3">
						<div class="image">
							<img src="showpicture.jsp?p_id=<%=cart.getPid() %>" />
						</div>
					</div>
					<div class="col-md-9">
						<div class="caption">
							<div class="name"><h3><a href="product.html"><%= pro.getName() %></a></h3></div>
							<div class="info">	
								<ul>
									<li>Brand: <%= pro.getBrand() %></li>
									<li>ID: <%= cart.getPid() %></li>
								</ul>
							</div>
							<div class="price"><%= "RMB:"+pro.getPrice() %><span><%= "RMB:"+(int)(pro.getPrice()*0.8) %></span></div>
							<label>Qty: </label> <input class="form-inline quantity" type="text" value="<%= cart.getPnumber() %>"><a href="#" class="btn btn-2 ">Update</a>
							<hr>
							<a href="deleteCart?id=<%=cart.getId() %>" class="btn btn-default pull-right">移除</a>
						</div>
					</div>
					<div class="clear"></div>
				</div>	
			</div>
			
			<%
				}
			%>
			
			<div class="row">
				<div class="col-md-4 col-md-offset-8 ">
					<center><a href="index.jsp" class="btn btn-1">再买几件</a></center>
				</div>
			</div>
			<div class="row">
				<div class="pricedetails">
					<div class="col-md-4 col-md-offset-8">
						<table>
							<h6>Price Details</h6>
							<tr>
								<td>总计</td>
								<td><%= price %></td>
							</tr>
							<tr>
								<td>折扣</td>
								<td><%=price*0.2 %></td>
							</tr>
							<tr>
								<td>邮费</td>
								<td>100</td>
							</tr>
							<tr style="border-top: 1px solid #333">
								<td><h5>应付</h5></td>
								<td><%=0.8*price+100 %></td>
							</tr>
						</table>
						<center><a href="#" class="btn btn-1">Checkout</a></center>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>