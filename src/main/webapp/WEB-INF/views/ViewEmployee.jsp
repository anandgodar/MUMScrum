<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
  
 <head>
    <meta charset="utf-8">
    <title></title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes"> 
    
<link href="<spring:url value ="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
<link href="<spring:url value ="/resources/css/bootstrap-responsive.min.css"/>" rel="stylesheet" type="text/css" />

<link href="<spring:url value ="/resources/css/font-awesome.css"/>" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
    
<link href="<spring:url value ="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
<link href="<spring:url value ="/resources/css/pages/signin.css"/>" rel="stylesheet" type="text/css">

<!-- <script src="http://code.jquery.com/jquery-1.7.2.min.js" type="text/javascript"></script> -->

<script src="../portal/resources/js/jquery-1.7.2.min.js"></script>
	<script src="../portal/resources/js/bootstrap.js"></script>

	<script src="../portal/resources/js/signin.js"></script>
	
	<script src="../portal/resources/js/base.js"></script>
	
<script type="text/javascript">

$(function(){
	 $(".content :input").prop("disabled", true);
})
</script>
 
</head>

<body>
	
	<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a>
			
			<a class="brand" href="index.html">
				HR System Admin				
			</a>		
			
			<div class="nav-collapse">
				<ul class="nav pull-right">
					
					<li class="">						
						<a href="login" class="">
							<i class="icon-chevron-left"></i>
							Back? to Homepage
						</a>
						
					</li>
				</ul>
				
			</div><!--/.nav-collapse -->	
	
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->



<div class="account-container register">
	
	<div class="content clearfix">
		
		<form action="viewEmployeeDetails" method="post">
		
			<h1>Employee Details</h1>			
			
				
				
				
				<div class="field">
					<label for="firstname">First Name:</label>
					<input type="text" id="first_name" name="firstName" value="${viewemployee.firstName}" placeholder="First Name" class="login" />
				</div> <!-- /field -->
				
				<div class="field">
					<label for="lastname">Last Name:</label>	
					<input type="text" id="last_name" name="lastName" value="${viewemployee.lastName}" placeholder="Last Name" class="login" />
				</div> <!-- /field -->
				
				
				<div class="field">
					<label for="employee_ID">Employee ID:</label>
					<input type="text" id="employee_ID" name="employeeID" value="${viewemployee.employeeID}" placeholder="Employee ID" class="login"/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="email">Email Address:</label>
					<input type="text" id="email" name="email" value="${viewemployee.email}" placeholder="Email" class="login"/>
				</div> <!-- /field -->
				
				
				
				<div class="field">
					<label for="userName">User Name:</label>
					<input type="text" id="user_Name" name="userName" value="${viewemployee.userName}" placeholder="user Name" class="login"/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="password">Password:</label>
					<input type="text" id="pass_word" name="password" value="${viewemployee.password}" placeholder="Password" class="login"/>
				</div> <!-- /field -->
				
				 <div class="field">
					<label for="role">Role:</label>
					<select name="role" class="login">
						<option value="${viewemployee.role}">${viewemployee.role}</option>
						
					</select>
					
				</div> <!-- drop down -->
				<div class="field">
					<label for="street">Street:</label>
					<input type="text" id="street" name="street" value="${viewemployee.street}" placeholder="Street" class="login"/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="city">City:</label>
					<input type="text" id="city" name="city" value="${viewemployee.city}" placeholder="City" class="login"/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="state">State:</label>
					<input type="text" id="state" name="state" value="${viewemployee.state}" placeholder="State" class="login"/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="country">Country:</label>
					<input type="text" id="country" name="country" value="${viewemployee.country}" placeholder="Country" class="login"/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="zip">Zip:</label>
					<input type="text" id="zip" name="zip" value="${viewemployee.zip}" placeholder="Zip" class="login"/>
				</div> <!-- /field -->
				
	
			
			
		
			
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<!-- Text Under Box -->
<div class="login-extra">
	Back? <a href="login.html">click here</a>
</div> <!-- /login-extra -->




</body>

 </html>
