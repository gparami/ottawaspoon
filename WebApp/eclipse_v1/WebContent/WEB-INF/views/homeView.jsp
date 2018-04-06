<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Ottawa's Best Rated Restaurants</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ospoon.css">
	</head>

	<body>
		<nav class="navbar navbar-expand-lg main-navbar">
			<div class="container-fluid">			
			<!-- if we want to put a logo on the nav bar it goes here -->
<!--			  <a class="navbar-brand" href="#"></a>-->
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon">
			    	<i class="ion-navicon"></i>
			    </span>
			  </button>
			  <div class="collapse navbar-collapse" id="navbarNav">
				  <div class="mr-auto"></div>
			    <ul class="navbar-nav">
			    	<li class="nav-item">
			        <a class="nav-link smooth-link" href="${pageContext.request.contextPath}/query">Advanced Queries</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link smooth-link" href="#mostpopular">Most Popular</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link smooth-link" href="#categories">Categories</a>
			      </li>
			    </ul>'
			    <form class="form-inline">
				    <a href="${pageContext.request.contextPath}/login" class="btn smooth-link align-middle btn-primary">Login</a>
			    </form>
			  </div>
		  </div>
		</nav>
		<section class="hero bg-overlay" id="hero" data-bg="img/hero.jpeg">
			<div class="text py-5">
				<img src="img/logo-black-spoon.png" alt="Logo" id="logo">
				<h1>Ottawa<span class="bold">Spoon</span></h1>
				<p>Ottawa's Best Rated Restaurants.</p>
				<div class="cta">
						<form class="search" action="#">
							<input type="text" name="restaurantName" class="form-control" placeholder="Restaurant name">
							<button class="btn btn-primary">Find</button>
						</form>				
					<div class="link">						
						<a href="${pageContext.request.contextPath}/restaurants">List of All Restaurants</a>
					</div>
				</div>
			</div>
		</section>

		<footer>
			<div class="container">
<!--				<figure><img src="img/logo-black-spoon.png" alt="Logo"></figure>-->
				<!-- <p>Copyright &copy; 2018 OttawaSpoon</p> -->
				<p>
					A Project By <a href="javascript:" onclick="changeLogo('img/logo-animate-fast.gif');">Parami</a>, 
					<a href="javascript:" onclick="changeLogo('img/logo-artem.png');">Artem</a> &amp; 
					<a href="javascript:" onclick="changeLogo('img/logo-alex.png');">Alex</a>.
				</p>
			</div>
		</footer>
		
		<!-- TODO: Make this a toggle -->
		<script type="text/javascript">
			function changeLogo(image){
				var logoHolder = document.getElementById("logo");
					logoHolder.src = "img/logo-black-spoon.png";
					logoHolder.src = image;
			}
		</script>

		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.easeScroll.js"></script>
		<script src="${pageContext.request.contextPath}/js/ospoon.js"></script>
	</body>
</html>