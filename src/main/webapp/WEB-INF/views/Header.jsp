<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"><span class="icon-bar"></span><span
				class="icon-bar"></span><span class="icon-bar"></span> </a><a
				class="brand" href="/portal">MUM SCRUM </a>
			<div class="nav-collapse">
				<ul class="nav pull-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="icon-cog"></i> Account <b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:;">Settings</a></li>
							<li><a href="/portal">Help</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="icon-user"></i>
							${userInfo.userName } <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value="/"/>">Profile</a></li>
							<li><a href="<c:url value="/dologout"/>">Logout</a></li>
						</ul></li>
				</ul>
				<form class="navbar-search pull-right">
					<input type="text" class="search-query" placeholder="Search">
				</form>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!-- /container -->
	</div>
	<!-- /navbar-inner -->
</div>
<!-- /navbar -->
<div class="subnavbar">
	<div class="subnavbar-inner">
		<div class="container">
			<ul class="mainnav">
<<<<<<< HEAD
=======
			
			<c:if test="${userInfo.getRoleID()==8}">
			
				<li class="active"><a href='<c:url value='view/${userInfo.getEmployee().getId()}' ></c:url>'><i	class="icon-list-alt"></i><span>View Profile</span> </a>
				</li>
				<li class="active"><a href="<c:url value='edit/${userInfo.getEmployee().getId()}' ></c:url>"><i	class="icon-list-alt"></i><span>Update Profile</span> </a>
				</li>
				<li>
		
			
			</c:if>
			
			<c:if test="${userInfo.getRoleID()==11}">
			
>>>>>>> be6682e89d3bddcfc4f1dd051f0dc6a0f399ee35
				<li class="active"><a href="/portal"><i
						class="icon-dashboard"></i><span>Dashboard</span> </a></li>
				<li><a href="#"><i class="icon-list-alt"></i><span>Reports</span>
				</a></li>
<<<<<<< HEAD
		
				
				<li class="dropdown"><a href="javascript:;"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-bar-chart"></i><span>Product Release </span> <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li class=""><a href="<c:url value="/releasebacklog/listreleases/1"/>" class=""> Product One </a></li>
						<li class=""><a href="<c:url value="/releasebacklog/listreleases/2"/>"
							class=""> Product Two </a></li>
						<li class=""><a href="<c:url value="/releasebacklog/listreleases/3"/>"
							class=""> Product Three </a></li>

					</ul></li>
				
=======
				<li><a href="#"><i class="icon-facetime-video"></i><span>Products</span>
				</a></li>
				<li><a href="#"><i class="icon-bar-chart"></i><span>Release</span>
				</a></li>
>>>>>>> be6682e89d3bddcfc4f1dd051f0dc6a0f399ee35

				<li class="dropdown"><a href="javascript:;"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-code"></i><span>HR Admin</span> <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li class=""><a href="ViewEmployeeHome" class=""> View
								Employee </a></li>
						<li class=""><a href="<c:url value="/EmployeeCreate"/>"
							class=""> Add Employee </a></li>
						<li class=""><a href="<c:url value="/UpdateEmployeeHome"/>"
							class=""> Update Employee </a></li>
						<li class=""><a href="<c:url value="/DeleteEmployeeHome"/>"
							class=""> Delete Employee </a></li>
						<li class=""><a href="<c:url value="/listAllEmployee"/>"
							class=""> ListEmployees </a></li>

<<<<<<< HEAD
					</ul></li>
=======
					</ul>
				</li>

>>>>>>> be6682e89d3bddcfc4f1dd051f0dc6a0f399ee35

				<li class="dropdown"><a href="javascript:;"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-long-arrow-down"></i><span>Sprints</span> <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/sprint/add/"/>">Add Sprint</a></li>
						<li><a href="<c:url value="/sprint/listsprints/"/>">View
								Sprints</a></li>

<<<<<<< HEAD
					</ul></li>
=======
					</ul>
				</li>
				
				</c:if>
				
				
>>>>>>> be6682e89d3bddcfc4f1dd051f0dc6a0f399ee35
			</ul>
		</div>
		<!-- /container -->
	</div>
	<!-- /subnavbar-inner -->
</div>
<!-- /subnavbar -->