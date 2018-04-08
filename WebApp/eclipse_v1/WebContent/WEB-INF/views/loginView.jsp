<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>OttawaSpoon - Login</title>
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
					<ul class="navbar-nav">
					    <li class="nav-item">
					        <a class="nav-link smooth-link" href="${pageContext.request.contextPath}/signup">Sign Up</a>
					    </li>
				    </ul>
				    <form class="form-inline">
					    <a href="${pageContext.request.contextPath}/home" class="btn smooth-link align-middle btn-primary">Back</a>
				    </form>
			    </div>
		  </div>
		</nav>
		
		<section class="hero bg-overlay" id="login" data-bg="img/hero.jpeg">
			<div class="text py-5">
				<%-- <img src="img/logo-black-spoon.png" alt="Logo" id="logo" href="${pageContext.request.contextPath}/home"> --%>
				<h1>Rater Login</h1>
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
				</div>
			</div>
		</section>

		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.easeScroll.js"></script>
		<script src="${pageContext.request.contextPath}/js/ospoon.js"></script>
	</body>
</html>