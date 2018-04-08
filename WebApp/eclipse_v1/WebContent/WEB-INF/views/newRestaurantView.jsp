<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>OttawaSpoon - New Restaurant</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ospoon.css">
	</head>

	<body>
		 <nav class="navbar navbar-expand-lg main-navbar">
			<div class="container-fluid">		
				<div class="collapse navbar-collapse" id="navbarNav">
					<div class="mr-auto"></div>	
					<%-- <ul class="navbar-nav">
					    <li class="nav-item">
					        <a class="nav-link smooth-link" href="${pageContext.request.contextPath}/signup">Sign Up</a>
					    </li>
				    </ul> --%>
				    <form class="form-inline">
					    <a href="${pageContext.request.contextPath}/restaurants" class="btn smooth-link align-middle btn-primary">Back</a>
				    </form>
			    </div>
		  </div>
		</nav>
		
		<section class="hero bg-overlay" id="login" data-bg="img/hero.jpeg">
			<div class="text py-5">
				<%-- <img src="img/logo-black-spoon.png" alt="Logo" id="logo" href="${pageContext.request.contextPath}/home"> --%>
				<h1>New Restaurant</h1>
				<br/>
				<p>Please enter a restaurant name, type and a url.</p>
				<p style="color: red;">${errorString}</p>
				<div class="cta">
						<form class="contact" method="post" action="${pageContext.request.contextPath}/addrestaurant">
							<input type="text" name="id" value= "${restaurant.id}" class="form-control" placeholder="Restaurant ID">
							<input type="text" name="name" value= "${restaurant.name}" class="form-control" placeholder="Restaurant Name">
							<input type="text" name="type" value= "${restaurant.type}" class="form-control" placeholder="Type">
							<input type="text" name="url" value= "${restaurant.url}" class="form-control" placeholder="URL">
							<br />				
							<input type="submit" value= "Submit" class="btn btn-primary"/>
							<a href="${pageContext.request.contextPath}/restaurants" role="button" class="btn btn-primary" >Cancel</a>
					</form>
				</div>
			</div>
		</section>

		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.easeScroll.js"></script>
		<script src="${pageContext.request.contextPath}/js/ospoon.js"></script>
	</body>
</html>