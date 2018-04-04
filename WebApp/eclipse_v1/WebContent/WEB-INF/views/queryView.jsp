<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en">
	<head>
		<title>OttawaSpoon - Queries</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ospoon.css">
		
		<script>
		//hack to get the nav bar to show up black without scrolling
    	window.onload = function() {
    		document.body.scrollTop = document.documentElement.scrollTop = 0;
    	}
		</script>
	</head>

	<body>
		 <nav class="navbar navbar-expand-lg main-navbar">
			<div class="container-fluid">			
			    <form class="form-inline">
				    <a href="${pageContext.request.contextPath}/home" class="btn smooth-link align-middle btn-primary">Home</a>
			    </form>
		  </div>
		</nav>
		
		
		<section class="padding bg-grey" id="contact">
			<div class="container">
				<h2 class="section-title text-center">Let's Run Queries</h2>
				<p class="section-lead text-center text-muted">Select a Query from the left.</p>
				<div class="section-body">				
					<div class="row col-spacing">
						<div class="col-12 col-md-5">
							<form action="">							
								<div class="dropdown">
								  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    Select Query
								  </button>
								  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">a</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">b</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">c</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">d</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">e</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">f</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">g</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">h</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">i</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">j</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">k</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">l</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">m</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">n</a>
								    <a class="dropdown-item" href="${pageContext.request.contextPath}/query">o</a>
								  </div>
								</div>
							</form>
						</div>
						<div class="col-12 col-md-7">
							
						</div>
					</div>
				</div>
			</div>
		</section>

		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.easeScroll.js"></script>
		<script src="${pageContext.request.contextPath}/js/ospoon.js"></script>
		<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
		
		<script type="text/javascript">

		  function handleClick(clickedId)
		  {
		     if(clickedId == "customerId")
		       document.getElementById('tableTextId').value = "customer";
		     else
		       document.getElementById('tableTextId').value = "company";
		  }
		</script>
	</body>
</html>