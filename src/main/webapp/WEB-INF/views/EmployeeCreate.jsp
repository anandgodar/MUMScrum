<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>HR Admin</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">

<link href="<spring:url value ="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<spring:url value ="/resources/css/bootstrap-responsive.min.css"/>"
	rel="stylesheet" type="text/css" />

<link href="<spring:url value ="/resources/css/font-awesome.css"/>"
	rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
	rel="stylesheet">

<link href="<spring:url value ="/resources/css/style.css"/>"
	rel="stylesheet" type="text/css">
<link href="<spring:url value ="/resources/css/pages/signin.css"/>"
	rel="stylesheet" type="text/css">
	
	<script src="../portal/resources/js/jquery-1.7.2.min.js"></script>
	<script src="../portal/resources/js/bootstrap.js"></script>

	<script src="../portal/resources/js/signin.js"></script>
	
	<script src="../portal/resources/js/base.js"></script>
	

</head>

<body>

	<div class="navbar navbar-fixed-top">

		<div class="navbar-inner">

			<div class="container">

				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="index.html"> HR System Admin </a>

				<div class="nav-collapse">
					<ul class="nav pull-right">
						<li class=""><a href="ViewEmployeeHome" class=""> View
								Employee </a></li>
						<li class=""><a href="UpdateEmployeeHome" class=""> Update
								Employee </a></li>
						<li class=""><a href="DeleteEmployeeHome" class=""> Delete
								Employee </a></li>
						<li class=""><a href="listAllEmployee" class=""> ListEmployees </a></li>
						
						<li class=""><a href="login" class=""> <i
								class="icon-chevron-left"></i> LogOut? Back to Homepage
						</a></li>
					</ul>

				</div>
				<!--/.nav-collapse -->

			</div>
			<!-- /container -->

		</div>
		<!-- /navbar-inner -->

	</div>
	<!-- /navbar -->



	<%-- <div class="account-container register">
	
	<div class="content clearfix">
		
		<form action="employeeCreate" method="post">
		
			<h1>Signup for Free Account</h1>			
			
			<div class="login-fields">
				
				<p>Create your free account:</p> --%>

	<div class="main">

		<div class="main-inner">

			<div class="container">

				<div class="row">

					<div class="span12">

						<div class="widget ">

							<div class="widget-header">
								<i class="icon-user"></i>
								<h3>Create Employee</h3>
							</div>
							<!-- /widget-header -->

							<div class="widget-content">



								<div class="tabbable">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#profilecontrols" data-toggle="tab">Profile
												Deatils</a></li>
										<li><a href="#addresscontrols"
											data-toggle="tab">Address</a></li>
									</ul>

									<br>

<form action="employeeCreate" method="post" class="form-horizontal">
									<div class="tab-content">
										

											<div class="tab-pane active" id="profilecontrols">

												<fieldset>

													<div class="field">
														<label for="firstname">* First Name:</label> <input
															type="text" id="first_name" name="firstName" value=""
															placeholder="First Name" required="required" class="login" /> 
													</div>
													<!-- /field -->

													<div class="field">
														<label for="lastname">* Last Name:</label> <input
															type="text" id="last_name" name="lastName" value=""
															placeholder="Last Name" required="required" class="login" />
													</div>
													<!-- /field -->


													<div class="field">
														<label for="employee_ID">* Employee ID:</label> <input
															type="text" id="employee_ID" name="employeeID" value=""
															placeholder="Employee ID" required="required" class="login" />
													</div>
													<!-- /field -->

													<div class="field">
														<label for="email">* Email Address:</label> <input
															type="text" id="email" name="email" value=""
															placeholder="Email" required="required" class="login" />
													</div>
													<!-- /field -->



													<div class="field">
														<label for="userName">* User Name:</label> <input
															type="text" id="user_Name" name="userName" value=""
															placeholder="user Name" required="required" class="login" />
													</div>
													<!-- /field -->

													<div class="field">
														<label for="password">* Password:</label> <input
															type="password" id="pass_word" name="password" value=""
															placeholder="Password" required="required" class="login" />
													</div>
													<!-- /field -->

													<div class="field">
														<label for="role">* Role:</label> <select name="role"
															class="login">
															<option value="1">Developer</option>
															<option value="2">Tester</option>
															<option value="3">ScrumMaster</option>
															<option value="4">Developer & Tester</option>
															<option value="5">Tester & ScrumMaster</option>
															<option value="6">Developer & ScrumMaster</option>
															<option value="7">ALL</option>
														</select>

													</div>
													<!-- drop down -->
							

												</fieldset>
												
											</div>
											<!-- /Profile-fields -->


											<!-- 2nd tab -->
											<div class="tab-pane " id="addresscontrols">
											<fieldset>
											
											
											<div class="field">
													<label for="street">* Street:</label> <input type="text"
														id="street" name="street" value="" placeholder="Street" required="required"
														class="login" />
												</div>
												<div class="field">
													<label for="city">* City:</label> <input type="text"
														id="city" name="city" value="" placeholder="City" required="required"
														class="login" />
												</div>
												
												
												<!-- /field -->
												<div class="field">
													<label for="state">* State</label> <input type="text"
														id="state" name="state" value="" placeholder="State" required="required"
														class="login" />
												</div>
												<!-- /field -->
												
												<div class="field">
													<label for="country">* Country:</label> <input type="text"
														id="country" name="country" value="" placeholder="Country" required="required"
														class="login" />
												</div>
												
												<div class="field">
													<label for="zip">* Zip:</label> <input type="text"
														id="zip" name="zip" value="" placeholder="Zip" required="required"
														class="login" />
												</div>
												
											
												</fieldset>
												
												<div class="login-actions">
												<button class="button btn btn-primary btn-large">Register</button>
											</div>
											</div> <!--  2nd tab -->
										
											

										

									</div>
									<!-- /content -->

</form> <!-- main form  -->
								</div>
								<!-- /account-container -->

										

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	
</body>

</html>