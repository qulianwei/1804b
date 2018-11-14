<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ include file="common/mystyle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	padding-top:200px;
	width:100%;
    height:100%
    font-family: "华文细黑";
 	background:url("<%=request.getContextPath()%>bg.jpg") no-repeat;
 	background-size: 100%;
}
</style>

</head>
<body background="bg.jpg" >
	<div class="container" >

	<div class="row">
	  <div class="col-md-4"></div>
	  <div class="col-md-4">
	 
	  	<form action="<c:url value='/user/login.do' />" method="post">
		  <div class="form-group">
		    <label for="exampleInputEmail1" style="color:white">name</label>
		    <input type="text" class="form-control" name="userName" id="exampleInputEmail1" placeholder="name">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1" style="color:white">Password</label>
		    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
		  </div>
		  <div align="center">
		  <button type="submit" class="btn btn-default" onclick="" style="width:70px">登录</button>
		  <button type="button" class="btn btn-default" style="width:70px">注册</button>
		  </div>
		</form>	
	  </div>
	  <div class="col-md-4"></div>
	</div>
	
	</div>
</body>

	<script type="text/javascript">
		
	
	</script>
</html>