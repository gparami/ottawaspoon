<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>OttawaSpoon - Restaurant Info</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ospoon.css">
		
		<!--=COLORLIB TABLE================================================================================-->
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/animate/animate.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/select2/select2.min.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/perfect-scrollbar/perfect-scrollbar.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/css/colorlib-util.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/colorlib/css/colorlib-main.css">
		<!--===============================================================================================-->
		<style>
		p.uppercase {
		    text-transform: uppercase;
		}
		
		p.lowercase {
		    text-transform: lowercase;
		}
		
		p.capitalize {
		    text-transform: capitalize;
		}
		</style>
		
	</head>

	<body>
		 <nav class="navbar navbar-expand-lg main-navbar">
			<div class="container-fluid">		
				<div class="collapse navbar-collapse" id="navbarNav">
					<div class="hero bg-overlay text py-1"> <h1>${restaurant.name}</h1> </div>
					<div class="mr-auto"></div>	
					<ul class="navbar-nav">
						<li class="nav-item">
					        <a class="nav-link smooth-link" href="#locations">Locations</a>
					    </li>
					    <li class="nav-item">
					        <a class="nav-link smooth-link" href="#menuitems">Menu Items</a>
					    </li>
					    <li class="nav-item">
					        <a class="nav-link smooth-link" href="#mostexpensive">Most Expensive Item</a>
					    </li>
					    <li class="nav-item">
					        <a class="nav-link smooth-link" href="javascript:" onclick="deleteRestaurant();">Delete Restaurant</a>
					    </li>
					    <li class="nav-item">
					        <a class="nav-link smooth-link" href="${pageContext.request.contextPath}/restaurants">All Restaurants</a>
					    </li>
				    </ul>
				    <form class="form-inline">
					    <a href="${pageContext.request.contextPath}/home" class="btn smooth-link align-middle btn-primary">Home</a>
				    </form>
			    </div>
		  </div>
		</nav>
		
		<section class="hero bg-overlay" id="login" data-bg="img/hero.jpeg">
			<div class="text py-5">
				<%-- <img src="img/logo-black-spoon.png" alt="Logo" id="logo" href="${pageContext.request.contextPath}/home"> --%>
				<h1>Restaurant <span class="bold">${restaurant.name}</span></h1>
				<br/>
				<p class="lead">${restaurant.type} Cuisine</p>
				<br/>
				<p class="lead"><a href="http://${restaurant.url}" target="_blank">${restaurant.url}</a></p>
				<p style="color: red;">${errorString}</p>
				<div class="cta">
					<a href="#explore" class="btn btn-primary smooth-link">Explore</a>
				</div>
			</div>
		</section>
		
		<section class="padding" id="explore">
			<div class="container">
				<div class="row">
					<div class="col-12 col-md-4 col-sm-12">
						<div class="list-item">
							<div class="icon">
								<i class="ion-thumbsup"></i>
							</div>
							<div class="desc">
								<h2>Morgan Freeman</h2>
								<p>
									"Food was good indeed."
								</p>
								
							</div>
						</div>
					</div>
					<div class="col-12 col-md-4 col-sm-12">
						<div class="list-item">
							<div class="icon">
								<i class="ion-thumbsup"></i>
							</div>
							<div class="desc">
								<h2>Arnold Schwarzenegger</h2>
								<p>
									"I got the chopper and it was amazing."
								</p>
								
							</div>
						</div>
					</div>
					<div class="col-12 col-md-4 col-sm-12">
						<div class="list-item no-spacing">
							<div class="icon">
								<i class="ion-thumbsdown"></i>
							</div>
							<div class="desc">
								<h2>Gordon Ramsaye</h2>
								<p>
									"The chicken had so much ginger on it. It lost its soul."
								</p>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="padding bg-grey" id="locations">
			<div class="container">
				<h2 class="section-title">Locations</h2>
				<p class="section-lead text-muted">Following table contains all the locations of this restaurant.</p>
				<div class="section-body">
				
					<div class="table100 ver2 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Address</th>
									<th class="cell100 column2">Phone</th>
									<th class="cell100 column3">Hours</th>
									<th class="cell100 column4">Manager</th>
									<th class="cell100 column5">Opened</th>
								</tr>
							</thead>
						</table>
					</div>
					
					<div class="table100-body js-pscroll">
						<table>
							<tbody>
								<c:forEach items="${restaurant.locations}" var="location">
									<tr class="row100 body">
										<td class="cell100 column1">${location.address}</td>
										<td class="cell100 column2">${location.phone}</td>
										<td class="cell100 column3">${location.hours_open}:00 - ${location.hours_close}:00</td>
										<td class="cell100 column4">${location.manager}</td>
										<td class="cell100 column5">${location.open_date}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				</div>
			</div>
		</section>

		<section class="bg-overlay padding" id="mostexpensive">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-12 col-md-6">
						<figure class="projects-picture">
							<img src="${pageContext.request.contextPath}/img/menuitem.png" alt="menuitem">
						</figure>
					</div>
					<div class="col-12 col-md-6">
						<div class="projects-details">
							<div class="projects-badge">
								Most Expensive Menu Item
							</div>
							<h2 class="projects-title">${mostExpensive.menuItem}</h2>
							<p class="projects-description">
								Most expensive menu item at ${mostExpensive.restaurant} is available for a price of $${mostExpensive.price}. This delightful special is brought to you by ${mostExpensive.manager}'s location. This location is open from ${mostExpensive.price}:00h for you to enjoy this amazing treat. 
							</p>
							<div class="projects-cta">
								<a href="http://${mostExpensive.url}" class="btn btn-primary" target="_blank">
									Visit Store Website
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="padding bg-grey" id="menuitems">
			<div class="container">
				<h2 class="section-title">Menu Items</h2>
				<p class="section-lead text-muted">Following table contains all the menu items of this restaurant.</p>
				<div class="section-body">
				
					<div class="table100 ver2 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Name</th>
									<th class="cell100 column3">Category</th>
									<th class="cell100 column5">Price</th>
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
							<tbody>
								<c:forEach items="${menu}" var="menuitem">
									<tr class="row100 body">
										<td class="cell100 column1">${menuitem.name}</td>
										<td class="cell100 column3">${menuitem.category}</td>
										<td class="cell100 column5">$${menuitem.price}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				</div>
			</div>
		</section>

		<footer>
			<div class="container">
				<p>A Project By Parami, Artem &amp; Alex.</p>
			</div>
		</footer>

		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.easeScroll.js"></script>
		<script src="${pageContext.request.contextPath}/js/ospoon.js"></script>
		<script src="${pageContext.request.contextPath}/js/sweetalert2.all.js"></script>
		
		<!--=COLORLIB TABLE================================================================================-->
			<%-- <script src="${pageContext.request.contextPath}/colorlib/jquery/jquery-3.2.1.min.js"></script> --%>
			<script src="${pageContext.request.contextPath}/colorlib/bootstrap/js/popper.js"></script>
			<%-- <script src="${pageContext.request.contextPath}/colorlib/bootstrap/js/bootstrap.min.js"></script> --%>
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
		<script type="text/javascript">
		function deleteRestaurant() {
			swal({
				  title: 'Are you sure?',
				  text: "You won't be able to revert this!",
				  type: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: 'Yes, delete it!'
				}).then((result) => {
				  if (result.value) { 
				    swal(
				      'Deleted!',
				      'Restaurant has been deleted.',
				      'success'
				    )
				    location.href = "deleterestaurant?id=${restaurant.restaurantID}";
				  }
				})
		}
		</script>
		
	</body>
</html>