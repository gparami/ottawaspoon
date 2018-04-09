<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<title>OttawaSpoon - Rater Profile</title>
		<!-- <meta charset="utf-8"> -->
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ospoon.css">
	</head>
	<body>
		<nav class="navbar navbar-expand-lg main-navbar">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="navbarNav">
					<div class="hero bg-overlay text py-1"> <h1>Rater Profile</h1> </div>
					<div class="mr-auto"></div>	
					<ul class="navbar-nav">
					    <li class="nav-item">
					    	<a class="nav-link smooth-link" href="${pageContext.request.contextPath}/hquery?id=${user.userName}">Query H</a>
					    </li>
				    </ul>
				    <form class="form-inline">
					    <a href="${pageContext.request.contextPath}/home" class="btn smooth-link align-middle btn-primary">Home</a>
				    </form>
			    </div>
		  </div>
		</nav>
		
		
		<section class="padding bg-grey" id="contact">
			<div class="container">
				</br>
				</br>
				<h2 class="section-title text-center">Hello ${user.name}</h2>
				<p class="section-lead text-center text-muted">Welcome to your rater profile.</p>
				<div class="section-body">				
					<div>
						<div class="col">
							<p class="contact-text">Thank you for rating on Ottawa Spoon.</p>
							<ul class="contact-icon">
								<!-- <li><i class="ion ion-ios-telephone"></i> <div>+6212345123</div></li> -->
								<li><i class="ion ion-ios-email"></i> <div>${user.email}</div></li>
							</ul>
							<!-- <iframe src="https://snazzymaps.com/embed/10159" style="border:none;" class="maps"></iframe> -->
						</div>
						<div class="col">
							<form class="contact row" id="contact-form">
								<div class="form-group col-6">
									<input type="text" class="form-control" placeholder="Name: ${user.name}" name="name" required="">
								</div>
								<div class="form-group col-6">
									<input type="email" class="form-control" placeholder="Email: ${user.email}" name="email" required="">
								</div>
								<div class="form-group col-12">
									<input type="text" class="form-control" placeholder="Join Date: ${user.join_date}" name="date" required="">
								</div>
								<div class="form-group col-12">
									<textarea class="form-control" placeholder="Ratings" name="ratings" required=""></textarea>
								</div>
								<div class="form-group col-12 mt-2">
									<button class="btn btn-primary">
										Delete Account
									</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>

		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.easeScroll.js"></script>
		<script src="${pageContext.request.contextPath}/js/ospoon.js"></script>
	</body>
</html>