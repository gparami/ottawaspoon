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
		
		<style>
		#myTable {
		    padding-top: 20px;
		}
		</style>
		
		
	</head>

	<body>
		 <nav class="navbar navbar-expand-lg main-navbar">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="navbarNav">
					<div class="hero bg-overlay text py-1"> <h1>Resturants</h1> </div>
					<div class="mr-auto"></div>	
					<ul class="navbar-nav">
					    <li class="nav-item">
					    	<a class="nav-link smooth-link" href="${pageContext.request.contextPath}/addrestaurant">Add Restaurant</a>
					        <!-- <a class="nav-link smooth-link" href="javascript:" onclick="createNewAlert();">Add Restaurant</a> -->
					    </li>
				    </ul>
				    <form class="form-inline">
					    <a href="${pageContext.request.contextPath}/home" class="btn smooth-link align-middle btn-primary">Home</a>
				    </form>
			    </div>
		  </div>
		</nav>
		
		<section class="hero bg-overlay" id="login" data-bg="img/hero.jpeg">
			<div class="text py-1">
			<p style="color: red;">${errorString}</p>
			<br>
			<br>
				
		<div>  <!-- class="container-table100" -->
			<div id="myTable">  <!-- class="wrap-table100" -->
			
				<div class="table100 ver3 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<!-- <th scope="col" class="cell100 column1 text-center">ID</th> -->
									<th scope="col" class="cell100 column1 text-center">Name</th>
									<th scope="col" class="cell100 column3 text-center">Type</th>
									<th scope="col" class="cell100 column4 text-center">URL</th>
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
							<tbody>
								<c:forEach items="${restaurantList}" var="restaurant">
								    <tr class="row100 body">
								      <td class="cell100 column1"><a href="restaurant?id=${restaurant.restaurantID}">${restaurant.name}</a></td>
								      <td class="cell100 column3">${restaurant.type}</td>
								      <td class="cell100 column4"><a href="http://${restaurant.url}" target="_blank">${restaurant.url}</a></td>
								    </tr>
								  </c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
				
			</div>
		</section>

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
		function createNewAlert() {
		    swal({
		        title: 'New Restaurant',
		        html:   '<input id="swal-input1" class="swal2-input" placeholder="Name">' +
		                '<input id="swal-input2" class="swal2-input" placeholder="Type">' +
		                '<input id="swal-input3" class="swal2-input" placeholder="URL">',
		        focusConfirm: false,
		        buttonsStyling: true,
		        showCancelButton: true,
		        confirmButtonText: "Add",
		        preConfirm: function() {
		            var promise1 = new Promise(function(resolve, reject) {
		                setTimeout(() => {
		                    if ($('#swal-input1').val() == "" || $('#swal-input2').val() == "" || $('#swal-input3').val() == "") {
		                        swal.showValidationError("All fields are required.");
		                    }
		                    resolve([$('#swal-input1').val(), $('#swal-input2').val(), $('#swal-input3').val()]);
		                    callAddRestaurantServlet($('#swal-input1').val(), $('#swal-input2').val(), $('#swal-input3').val());
		                }, 200);
		            })


		            return promise1;
		        }
		    }).then(function(result) {
		        if (result.value) {
		            swal('Added!', 'New restaurant has been added.', 'success')
		        } else if (result.dismiss === swal.DismissReason.cancel) {
		            swal('Cancelled!', 'I swear, I didn\'t do anything.', 'error')
		        } else if (result.dismiss === swal.DismissReason.backdrop) {} else {
		            swal('Oops!', 'I swear, I didn\'t do anything.', 'error')
		        }
		    }).catch(swal.noop)
		}
		</script>
		
		<script type="text/javascript">
			function callAddRestaurantServlet(var rName, var rType, var rURL) {
			}
		</script>
		
	</body>
</html>