<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span7">
		<div class="widget widget-nopad">
			
			<div class="widget widget-table action-table">
				<div class="widget-header">
					<i class="icon-th-list"></i>
					<h3>User Stories</h3>
				</div>
				<!-- /widget-header -->
				<c:if test="${flashSuccessMsg}">
				<div class="alert alert-success">${flashSuccessMsg}</div>
				</c:if>
				
				<div class="widget-content">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>#</th>
								
								<th>Description</th>
								
								<th class="td-actions">Action</th>
							</tr>
						</thead>
						<tbody>
		<c:forEach items="${userStories}" var="US">
							<tr>
								<td><c:out value="${US.getId()}" /></td>
							
								<td><c:out value="${US.getUserStory_Desc()}" /></td>
								
								<td class="td-actions"><a href="<c:url value="/userstory/removeuserstoryfromproduct/product/${US.getProductid()}/${US.getId()}"/>"
									class="btn btn-danger btn-small" id="Remove"><i
										class="btn-icon-only icon-remove"> </i></a></td>
							</tr>
							
			</c:forEach>				
							
						</tbody>
					</table>
				</div>
				<!-- /widget-content -->
			</div>
		</div>
	</div>
	
	<div class="span5">

		<div class="widget ">

			<div class="widget-header">
				<i class="icon-user"></i>
				<h3>${actionTitle}</h3>
			</div>
			<!-- /widget-header -->

			<div class="widget-content">

							<form id="add-sprint" class="form-horizontal" method="POST" action="<spring:url value="${actionText}"/>" data-toggle="validator" role="form">
								
							


											<textarea class="span4" id="description" name="description">${userStory.getUserStory_Desc()} </textarea>
									
									<%-- <c:if test="${not empty userstory.getId()}">
										<input type="hidden" value="${userStory.getId()}" name="id">
									</c:if> --%>
									
									
									
									<c:if test="${id!=null}">
										<input type="hidden" value="${id}" name="id">
									</c:if>
									
									<c:if test="${productid!=null}">
										<input type="hidden" value="${productid}" name="productid">
									</c:if>
									
									<c:if test="${releaseid!=null}">
										<input type="hidden" value="${releaseid}" name="releaseid">
									</c:if>
									
									<c:if test="${sprintid!=null}">
										<input type="hidden" value="${sprintid}" name="sprintid">
									</c:if>
									
									<div class="form-actions">
										<button type="submit" class="btn btn-primary" name="submit">Save</button>
										<button class="btn">Cancel</button>
									</div>
							
							</form>
						</div>



		</div>
		<!-- /widget -->
	</div>
</div>
