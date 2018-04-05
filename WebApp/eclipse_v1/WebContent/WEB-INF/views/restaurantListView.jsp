<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>OttawaSpoon - Restaurants</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ospoon.css">
		
		<!--=COLORLIB TABLE================================================================================-->
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/animate/animate.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/select2/select2.min.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/perfect-scrollbar/perfect-scrollbar.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/css/colorlib-util.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/css/colorlib-main.css">
		<!--===============================================================================================-->
		
	</head>

	<body>
		 <nav class="navbar navbar-expand-lg main-navbar">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="navbarNav">
					<div class="hero bg-overlay text py-1"> <h1>Resturants</h1> </div>
					<div class="mr-auto"></div>	
				    <form class="form-inline">
					    <a href="${pageContext.request.contextPath}/home" class="btn smooth-link align-middle btn-primary">Back</a>
				    </form>
			    </div>
		  </div>
		</nav>
		
		<section class="hero bg-overlay" id="login" data-bg="img/hero.jpeg">
			<div class="text py-1">
			<p style="color: red;">${errorString}</p>
			<br>
			<br>
			<!-- Table -->
			<div class="table-responsive-sm">
				  <table class="table table-hover">
				  <thead>
				    <tr>
				      <th scope="col" class="text-center">ID</th>
				      <th scope="col" class="text-center">Name</th>
				      <th scope="col" class="text-center">Type</th>
				      <th scope="col" class="text-center">URL</th>
				    </tr>
				  </thead>
				  <tbody>
				  
				  <c:forEach items="${restaurantList}" var="restaurant">
				    <tr class='clickable-row'>
				      <td>${restaurant.restaurantID}</td>
				      <td>${restaurant.name}</td>
				      <td>${restaurant.type}</td>
				      <td>${restaurant.url}</td>
				    </tr>
				  </c:forEach>
				  </tbody>
				</table>
				</div>
				<%-- 
				<table border="1" cellpadding="5" cellspacing="1" >
				    <tr>
				       <th>Code</th>
				       <th>Name</th>
				       <th>Price</th>
				       <th>Edit</th>
				       <th>Delete</th>
				    </tr>
				    <c:forEach items="${productList}" var="product" >
				       <tr>
				          <td>${product.code}</td>
				          <td>${product.name}</td>
				          <td>${product.price}</td>
				          <td>
				             <a href="editProduct?code=${product.code}">Edit</a>
				          </td>
				          <td>
				             <a href="deleteProduct?code=${product.code}">Delete</a>
				          </td>
				       </tr>
				    </c:forEach>
				 </table>
				<img src="img/logo-black-spoon.png" alt="Logo" id="logo" href="${pageContext.request.contextPath}/home">
				<h1>Resturants </h1>
				<br/>
				<p>Please enter your User ID and Password.</p>
				<p style="color: red;">${errorString}</p>
				<div class="cta">
						<form class="contact" method="post" action="${pageContext.request.contextPath}/login">
							<input type="text" name="userName" value= "${user.userName}" class="form-control" placeholder="User ID">
							<input type="password" name="password" value= "${user.password}" class="form-control" placeholder="Password">
							<input type="checkbox" name="rememberMe" value= "N"> Remember Me<br>
							<br />				
							<input type="submit" value= "Submit" class="btn btn-primary"/>
					</form>
				</div> --%>
				
			</div>
		</section>

		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.easeScroll.js"></script>
		<script src="${pageContext.request.contextPath}/js/ospoon.js"></script>
		
		<!--=COLORLIB TABLE================================================================================-->
			<script src="${pageContext.request.contextPath}/colorlib/jquery/jquery-3.2.1.min.js"></script>
			<script src="${pageContext.request.contextPath}/colorlib/bootstrap/js/popper.js"></script>
			<script src="${pageContext.request.contextPath}/colorlib/bootstrap/js/bootstrap.min.js"></script>
			<script src="${pageContext.request.contextPath}/colorlib/select2/select2.min.js"></script>
			<script src="${pageContext.request.contextPath}/colorlib/perfect-scrollbar/perfect-scrollbar.min.js"></script>
			<script>
				$('.js-pscroll').each(function(){
					var ps = new PerfectScrollbar(this);
					$(window).on('resize', function(){
						ps.update();
					})
				});
			</script>
			<script src="js/main.js"></script>
		<!--===============================================================================================-->
			
	</body>
</html>