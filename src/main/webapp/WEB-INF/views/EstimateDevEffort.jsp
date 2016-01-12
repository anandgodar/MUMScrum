<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Estimate Developer Effort</title>

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

<script src="../resources/js/jquery-1.7.2.min.js"></script>
<script src="../resources/js/bootstrap.js"></script>

<script src="../resources/js/signin.js"></script>

<script src="../resources/js/base.js"></script>


</head>

<body>

	<div class="navbar navbar-fixed-top">

		<div class="navbar-inner">

			<div class="container">

				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="index.html"> Estimate Effort By Developer - ${userInfo.userName } </a>

				<div class="nav-collapse">
					<ul class="nav pull-right">

						<li class=""><a
							href=${pageContext.request.contextPath}/
							class=""> <i class="icon-chevron-left"></i> Back to Homepage
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
								<h3>Estimate Effort by ${userInfo.userName}</h3>
							</div>
							<!-- /widget-header -->

							<div class="widget-content">



								<div class="tabbable">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#userStoryDetails"
											data-toggle="tab">User Story Details</a></li>

									</ul>

									<br>

									<form action="${pageContext.request.contextPath}/estimateEffort" method="get"
										class="form-horizontal">
										<input type="hidden" name="id"
											value="${productBackLogUserStory.id}">


										<div class="tab-content">


											<div class="tab-pane active" id="#userStoryDetails">

												<fieldset>

													<div class="field">
														<label for="productBkLogId">product BkLog_id:</label> <input
															type="text" id="Prdt_BKlog_Id" name="productBkLogId"
															value="${productBackLogUserStory.productid}"
															placeholder="ProductBkLogId" class="login" />
													</div>
													<!-- /field -->

													<div class="field">
														<label for="userStory_Id">User Story Id:</label> <input
															type="text" id="User_Story_Id" name="userStory_Id"
															value="${productBackLogUserStory.userStory_Id}"
															placeholder="User Story Id" class="login" />
													</div>
													<!-- /field -->


													<div class="field">
														<label for="USDesc">User Story Desc:</label> <input
															type="text" id="US_Desc" name="USDesc"
															value="${productBackLogUserStory.userStory_Desc}"
															placeholder="UserStoryDesc" class="login" />
													</div>
													<!-- /field -->

													<div class="field">
														<label for="estimateEffort_Dev">Estimate Effort:</label> <input
															type="text" id="estimateEffort_Dev" name="estimateEffort_Dev"
															value="${productBackLogUserStory.estimateEffort_Dev}" placeholder="EstimateEffort Dev" class="login" />
													</div>
													<!-- /field -->



													<div class="field">
														<label for="employeeID">EmployeeId:</label> <input
															type="text" id="employee_ID" name="employeeID"
															value="${productBackLogUserStory.developerID}"
															placeholder="Employee ID" class="login" />
													</div>
													<!-- /field -->

													

													<!-- /field -->


												</fieldset>

												<div class="login-actions">
													<button class="button btn btn-primary btn-large">Update</button>
												</div>

											</div>
											<!-- /Profile-fields -->







										</div>
										<!-- /content -->

									</form>
									<!-- main form  -->
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