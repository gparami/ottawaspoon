<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<title>Ottawa's Best Rated Restaurants</title>
		<!-- <meta charset="utf-8"> -->
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ospoon.css">
	</head>

	<body>
		<nav class="navbar navbar-expand-lg main-navbar">
			<div class="container-fluid">			
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
				<!-- <img src="img/logo-black-spoon.png" alt="Logo" id="logo"> -->
				<h2>Login</h2>
				<p>Please enter your User ID and Password.</p>
				<div class="cta">
						<form class="search" action="#">
							<input type="text" name="username" class="form-control" placeholder="User ID">
							<input type="password" name="password" class="form-control" placeholder="Password">
						</form>				
					<div class = "search">						
						<button class="btn btn-primary">Login</button>
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
				// console.log(logoHolder.src);
				// console.log(logoHolder.image);
				// if (logoHolder.src != image) {
					logoHolder.src = "img/logo-black-spoon.png";
				// } else {
					logoHolder.src = image;
				// }
			}
		</script>

		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.easeScroll.js"></script>
		<script src="${pageContext.request.contextPath}/js/ospoon.js"></script>
	</body>
</html>