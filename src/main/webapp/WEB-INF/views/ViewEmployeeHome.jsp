<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
  
 <head>
    <meta charset="utf-8">
    <title>View Employee</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes"> 
    
<link href="<spring:url value ="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
<link href="<spring:url value ="/resources/css/bootstrap-responsive.min.css"/>" rel="stylesheet" type="text/css" />

<link href="<spring:url value ="/resources/css/font-awesome.css"/>" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
    
<link href="<spring:url value ="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
<link href="<spring:url value ="/resources/css/pages/signin.css"/>" rel="stylesheet" type="text/css">

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
							Back to Homepage
						</a>
						
					</li>
				</ul>
				
			</div><!--/.nav-collapse -->	
	
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->



<div class="account-container register">
	
	<div class="content clearfix">
		
		<form action="viewEmployee" method="post"> <!-- post will use for form it will work but not other place -->
		
					
				
				<p>Enter Employee ID:</p>
				
				
				
				<div class="field">
					<!-- <label for="employee_ID">Employee ID:</label> -->
					<input type="text" id="employee_ID" name="employeeID" value="" placeholder="Employee ID" class="login"/>
				</div> <!-- /field -->
				
				

			
			<div class="login-actions">
								
				<button class="button btn btn-primary btn-large">Submit</button>
				
			</div> <!-- .actions -->
			
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<!-- Text Under Box -->
<div class="login-extra">
	Already have an account? <a href="login.html">Login to your account</a>
</div> <!-- /login-extra -->


<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/bootstrap.js"></script>

<script src="js/signin.js"></script>

</body>

 </html>
