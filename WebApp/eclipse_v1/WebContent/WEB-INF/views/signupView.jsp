<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>OttawaSpoon - Signup</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
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
				<h1>Create a Rater Profile</h1>
				<br/>
				<p>Please enter the following information.</p>
				<p style="color: red;">${errorString}</p>
				<div class="cta">
						<form class="contact" method="post" action="${pageContext.request.contextPath}/login">
							<input type="text" name="name" value= "${user.name}" class="form-control" placeholder="Name" required>
							<input type="email" name="email" value= "${user.email}" class="form-control" placeholder="Email" required>
							<input type="text" name="userName" value= "${user.userName}" class="form-control" placeholder="User ID" required>
							<input type="password" name="password" value= "${user.password}" class="form-control" placeholder="Password" required>
							<select class="form-control" id="type" required>
								<option value="" selected disabled>Type</option>
						    	<option value= "${user.type}">Blog</option>
						    	<option value= "${user.type}">Online</option>
						    	<option value= "${user.type}">Food Critic</option>
						    </select>		
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