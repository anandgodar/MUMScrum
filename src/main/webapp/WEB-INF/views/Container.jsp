 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Dashboard - MUM SCRUM</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<link href="<spring:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<spring:url value="/resources/css/bootstrap-responsive.min.css"/>" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
        rel="stylesheet">
<link href="<spring:url value="/resources/css/font-awesome.css"/>" rel="stylesheet">
<link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<spring:url value="/resources/css/pages/dashboard.css"/>" rel="stylesheet">
<link href="<spring:url value="/resources/css/pages/plans.css"/>" rel="stylesheet">



<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="<spring:url value="/resources/js/jquery-1.7.2.min.js"/>"></script> 
<script src="<spring:url value="/resources/js/excanvas.min.js"/>"></script> 
<script src="<spring:url value="/resources/js/chart.min.js"/>" type="text/javascript"></script> 
<script src="<spring:url value="/resources/js/bootstrap.js"/>"></script>
<script src="<spring:url value="/resources/js/validator.js"/>"></script>
<script src="<spring:url value="/resources/js/bootbox.min.js"/>"></script>
<script language="javascript" type="text/javascript" src="<spring:url value="/resources/js/full-calendar/fullcalendar.min.js"/>"></script>
 
<script src="<spring:url value="/resources/js/base.js"/>"></script> 
<script type="text/javascript">
<!-- not working -->

$(function(){
$("#deleteMe").on("click", ".alert", function(e) {
	bootbox.alert("Hello world!");
	}); 
}); 

</script>
</head>
<body>
<jsp:include page="Header.jsp" />

<div class="main">
  <div class="main-inner">
    <div class="container">
         
        <jsp:include page="${page}.jsp" />
    </div>
    <!-- /container --> 
  </div>
  <!-- /main-inner --> 
</div>
<!-- /main -->
<jsp:include page="Footer.jsp" />
 