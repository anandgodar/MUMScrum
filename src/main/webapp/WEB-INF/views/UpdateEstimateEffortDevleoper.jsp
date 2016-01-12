<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Update Estimate Effort</title>

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
				</a> <a class="brand" href="index.html"> Update Estimate Effort By Developer - ${userInfo.userName } </a>

				<div class="nav-collapse">
					<ul class="nav pull-right">
						
						
						<li class=""><a href="${pageContext.request.contextPath}/" class=""> <i
								class="icon-chevron-left"></i> Back to Homepage
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




	<div class="row">
		<div class="span10">
			<div class="widget widget-nopad">

				<div class="widget widget-table action-table">
					<div class="widget-header">
						<i class="icon-th-list"></i>
						<h3>User Stories</h3>
					</div>

					<div>
						<c:if test="${listOfUserStories.size()==0}">
							<p>No User Story Records Records Found</p>
						</c:if>
					</div>

					<!-- /widget-header -->
					<div class="widget-content">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>UserStoryID</th>
									<th>UserStoryDescription</th>
									<th>Action</th>
									

								</tr>
							</thead>
							<tbody>

								<c:forEach items="${listOfUserStories}" var="userStory">
									<!-- for each avaiable in jstl core tag -->
									<tr>
									
										<td><c:out value="${userStory.getUserStory_Id()}" /></td>
										<td><c:out value="${userStory.getUserStory_Desc()}" /></td>
										
										<td class="td-actions"><a href="<c:url value="/estimateEffortUserStory/${userStory.getId()}" />"
									class="btn btn-small btn-success"><i
										class="btn-icon-only icon-ok"> </i></a>
										
										<%-- <a href="delete/${employee.getId()}"
									class="btn btn-danger btn-small"><i
										class="btn-icon-only icon-remove"> </i></a> --%>
										</td>


									</tr>


								</c:forEach>
								<tr>
									<td colspan="4" align="center"><c:forEach var="i" begin="0" end="${totalNumberOfRecord}">
   										<a href="<c:url value="/updateEstimateEffortDeveloper/${i}" />"><c:out value="${i}" /></a>
										</c:forEach></td>
								</tr>



							</tbody>
						</table>
					</div>
					<!-- /widget-content -->
				</div>
			</div>
		</div>
	</div>

</body>

</html>