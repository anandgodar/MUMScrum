<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
	<div class="span6">
		<div class="widget widget-nopad">
			<div class="widget-header">
				<i class="icon-list-alt"></i>
				<h3>UnAssigned User Stories</h3>
			</div>
			<!-- /widget-header -->
			<div class="widget-content">
				<ul class="news-items">
					<c:forEach items="${userStories}" var="UnAssigneduserStory">
						<li>

							
							<div class="news-item-detail">
								
								<p class="news-item-preview">
									<c:out value="${UnAssigneduserStory.getUserStory_Desc()}" />
								</p><a href="<c:url value="/userstory/updateuserstoriestodeveloperandtester/${usertype}/${pid}/${UnAssigneduserStory.getId()}/${devid}/ "/>"  class="news-item-title" >
								Add to Current Developer/Tester</a>
							</div>

						</li>
					</c:forEach>
				</ul>
			</div>
			<!-- <div class="form-actions">
				<button type="submit" class="btn btn-primary" name="submit">Assign</button>
				<button class="btn">Back</button>
			</div> -->

			<!-- /widget-content -->
		</div>
	</div>



	<div class="span6">


		<div class="widget widget-nopad">

			<div class="widget widget-table action-table">
				<div class="widget-header">
					<a href="#"><i
						class="icon-plus-sign"></i>
						<h3>Current User Stories</h3> </a>
				</div>
				<!-- /widget-header -->
				<c:if test="${flashSuccessMsg}">
					<div class="alert alert-success">${flashSuccessMsg}</div>
				</c:if>

				<div class="widget-content">
					<table class="table table-striped table-bordered">

						<tbody>
							<c:forEach items="${developerStories}" var="developerStory">
								<tr>

									<td><c:out value="${developerStory.getUserStory_Desc()}" /></td>
									

								</tr>

							</c:forEach>

						</tbody>
					</table>
				</div>
				<!-- /widget-content -->
			</div>
		</div>

	</div>

</div>

