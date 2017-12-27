<%@ page language="java" contentType="text/html;"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>手机商城</title>
</head>

<body>
	<jsp:include page="/top.jsp" flush="true"/><!--动态包含-->
	<jsp:include page="/header.jsp" flush="true"/>
	<jsp:include page="/navigation.jsp" flush="true"/>
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="heading"><h2>添加商品</h2></div>
					<form name="form2" id="ff2" method="post" action="addProduct" enctype="multipart/form-data">
						<div class="form-group">
							ID：<input type="text" class="form-control"  placeholder="ID :" name="id" value="0001" id="firstname" required>
						</div>
						<div class="form-group">
							类型：<input type="text" class="form-control"  name="type" value="0001" id="firstname" required>
						</div>
						<div class="form-group">
							品牌：<input type="text" class="form-control"  name="brand" value="zishop" id="firstname" required>
						</div>
						<div class="form-group">
							名称：<input type="text" class="form-control"  name="name" value="zishop" id="firstname" required>
						</div>
						<div class="form-group">
							价格：<input type="text" class="form-control"  name="price" value="1999" id="firstname" required>
						</div>
						<div class="form-group">
							数量：<input type="text" class="form-control"  name="quantity" value="100" id="firstname" required>
						</div>
						<div class="form-group">
							描述：<input type="text" class="form-control"  name="description" value="zishop" id="firstname" required>
						</div>
						<div class="form-group">
							<input type="file" class="form-control" placeholder="file :" name="description" value="zishop" id="firstname" required>
						</div>
						
						<button type="submit" class="btn btn-1">添加</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	
<div id="page-content" class="single-page">	
		<form action="Upload" enctype="multipart/form-data" method="post">
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
	</div>
	<jsp:include page="/footer.jsp" flush="true"/>
</body>
</html>