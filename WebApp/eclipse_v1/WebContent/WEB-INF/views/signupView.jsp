<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<title>OttawaSpoon - Signup</title>
		<!-- <meta charset="utf-8"> -->
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ospoon.css">
	</head>

	<body>
		 <nav class="navbar navbar-expand-lg main-navbar">
			<div class="container-fluid">			
			    <form class="form-inline">
				    <a href="${pageContext.request.contextPath}/home" class="btn smooth-link align-middle btn-primary">Back</a>
			    </form>
			    <li class="nav-item">
			        <a class="nav-link smooth-link" href="${pageContext.request.contextPath}/login">Login</a>
			      </li>
		  </div>
		</nav>
		
		<section class="hero bg-overlay" id="signup" data-bg="img/hero.jpeg">
			<div class="text py-5">
				<%-- <img src="img/logo-black-spoon.png" alt="Logo" id="logo" href="${pageContext.request.contextPath}/home"> --%>
				<h1>Create a Rater Profile</h1>
				<br/>
				<p>Please enter the following information.</p>
				<p style="color: red;">${errorString}</p>
				<div class="cta">
						<form class="contact" method="post" action="${pageContext.request.contextPath}/login">
							<input type="text" name="email" value= "${user.email}" class="form-control" placeholder="Email">
							<input type="text" name="name" value= "${user.name}" class="form-control" placeholder="Name">
							<input type="text" name="userName" value= "${user.userName}" class="form-control" placeholder="User ID">
							<input type="password" name="password" value= "${user.password}" class="form-control" placeholder="Password">
							<div class="btn-group show-on-hover">
					          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
					            Action <span class="caret"></span>
					          </button>
					          <ul class="dropdown-menu" role="menu">
					            <li><a href="#">Action</a></li>
					            <li><a href="#">Another action</a></li>
					            <li><a href="#">Something else here</a></li>
					            <li class="divider"></li>
					            <li><a href="#">Separated link</a></li>
					          </ul>
					        </div>
							<br>
							<br />				
							<input type="submit" value= "Submit" class="btn btn-primary"/>
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