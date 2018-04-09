<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>OttawaSpoon - New Menu Item</title>
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
				    <form class="form-inline">
					    <a href="${pageContext.request.contextPath}/restaurant?id=${restaurant.restaurantID}" class="btn smooth-link align-middle btn-primary">Back</a>
				    </form>
			    </div>
		  </div>
		</nav>
		
		<section class="hero bg-overlay" id="login" data-bg="img/hero.jpeg">
			<div class="text py-5">
				<h1>New Menu Item</h1>
				<br/>
				<p>Please enter the following information.</p>
				<p style="color: red;">${errorString}</p>
				<div class="cta">
						<form class="contact" method="post" action="${pageContext.request.contextPath}/addmenuitem?rid=${restaurant.restaurantID}">
							<input type="text" name="iid" value= "${menuitem.itemID}" class="form-control" placeholder="ID">
							<input type="text" name="name" value= "${menuitem.name}" class="form-control" placeholder="Name">
							<input type="text" name="description" value= "${menuitem.description}" class="form-control" placeholder="Description">
							<input type="number" name="price" value= "${menuitem.price}" class="form-control" placeholder="Price">
							<select class="form-control" name="type" id="type" required>
								<option value="" selected disabled>Type</option>
						    	<option>Food</option>
						    	<option>Beverage</option>
						    </select>
							<select class="form-control" name="category" id="category" required>
								<option value="" selected disabled>Category</option>
						    	<option>Starter</option>
						    	<option>Main</option>
						    	<option>Dessert</option>
						    </select>
							<br />				
							<input type="submit" value= "Submit" class="btn btn-primary"/>
							<a href="${pageContext.request.contextPath}/restaurant?id=${restaurant.restaurantID}" role="button" class="btn btn-primary" >Cancel</a>
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