<%@ page language="java" contentType="text/html;"
    pageEncoding="utf-8"%>
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
						<li><a href="account.jsp">Account</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="heading"><h2>已有账户？在这里登录</h2></div>
					<form name="form1" id="ff1" method="post" action="Login">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="User :" name="username" id="username" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password :" name="password" id="email" required>
						</div>
						<button type="submit" class="btn btn-1" name="login" id="login">Login</button>
						<a href="forgetpass.jsp">忘记密码 ?</a>
					</form>
				</div>
				<div class="col-md-6">
					<div class="heading"><h2>注册账户</h2></div>
					<form name="form2" id="ff2" method="post" action="do_register.jsp">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="用户名 :" name="username" id="firstname" required>
						</div>
						<div class="form-group">
							<input type="email" class="form-control" placeholder="邮箱:" name="email" id="email" required>
						</div>
						<div class="form-group">
							<input type="tel" class="form-control" placeholder="手机 :" name="phone" id="phone" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="密保问题:" name="question" id="firstname" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="密保答案 :" name="answer" id="firstname" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="地址:" name="address" id="firstname" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="密码:" name="password" id="password" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="重复密码:" name="repassword" id="repassword" required>
						</div>
						<div class="form-group">
							<input name="agree" id="agree" type="checkbox" > 同意条款
						</div>
						<button type="submit" class="btn btn-1">确认注册</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>