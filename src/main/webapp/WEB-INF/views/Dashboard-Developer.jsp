<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">

	<!-- /span6 -->
	<div class="span12">
		<div class="widget">
			<div class="widget-header">
				<i class="icon-bookmark"></i>
				<h3>Welcome : ${userInfo.userName } - Developer</h3>
			</div>
			<!-- /widget-header -->
			<div class="widget-content">
				<div class="shortcuts">
				
				
						<a href="<c:url value="updateUserEffortDeveloper/0" ></c:url>" class="shortcut"><i class="shortcut-icon icon-list-alt"></i>
						<span class="shortcut-label">Update UserStory Actual Development Effort </span> </a>
						
						
						
						<a href="<c:url value="updateEstimateEffortDeveloper/0" ></c:url>" class="shortcut"><i class="shortcut-icon icon-list-alt"></i>
						<span class="shortcut-label">Update UserStory Estimate Development Effort</span> </a>
						
						<a	href="javascript:;" class="shortcut"><i	class="shortcut-icon icon-file"></i> 
						<span class="shortcut-label">View All Assigned User Stories</span> </a>
						
						
				</div>
				<!-- /shortcuts -->
			</div>
			<!-- /widget-content -->
		</div>
		<!-- /widget -->



	</div>
	<!-- /span6 -->
</div>
<!-- /row -->
