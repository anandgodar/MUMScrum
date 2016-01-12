<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span7">
		<div class="widget widget-nopad">

			<div class="widget widget-table action-table">
				<div class="widget-header">
					<i class="icon-th-list"></i>
					<h3>Sprints</h3>
				</div>
				<!-- /widget-header -->
				<c:if test="${flashSuccessMsg}">
					<div class="alert alert-success">${flashSuccessMsg}</div>
				</c:if>

				<div class="widget-content">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Title</th>
								<th>Description</th>
								<th class="td-actions">Action</th>
								<th class="td-actions">Assign User Story</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sprints}" var="sprint">
								<tr>
									<td><c:out value="${sprint.getName()}" /></td>
									<td><c:out value="${sprint.getDescription()}" /></td>
									<td class="td-actions"><a
										href="<c:url value="/sprint/edit/${rid}/${sprint.getId()}"/>"
										class="btn btn-small btn-success"><i
											class="btn-icon-only icon-ok"> </i></a><a
										href="<c:url value="/sprint/delete/${rid}/${sprint.getId()}"/>"
										class="btn btn-danger btn-small" id="deleteMe"><i
											class="btn-icon-only icon-remove"> </i></a></td>
											<td ><a href="<c:url value="/userstory/assignuserstoriestosprint/sprint/${rid}/${sprint.getId()}"/>" class="btn btn-danger" title="Assig User Story to Sprint">  <i class="icon-large icon-plus-sign"></i></a>  </td>	
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
			<form id="add-sprint" class="form-vertical" method="POST"
				action="<spring:url value="${actionText}"/>" data-toggle="validator"
				role="form">
				<fieldset>

					<div class="control-group">
						<label class="control-label" for="name">Title</label>
						<div class="controls">
							<input type="text" name="name" class="span4 " id="name"
								value="${sprint.getName()} " required>
							<p class="help-block">Type the name of the Sprint .</p>
						</div>
						<!-- /controls -->
					</div>
					<!-- /control-group -->



					<div class="control-group">
						<label class="control-label" for="description">Description</label>
						<div class="controls">
							<textarea class="span4" id="description" name="description">${sprint.getDescription()} </textarea>
						</div>
						<!-- /controls -->
					</div>
					<!-- /control-group -->


					<br /> <br />
					<c:if test="${not empty sprint.getId()}">
						<input type="hidden" value="${sprint.getId()}" name="Id">
					</c:if>
					<c:if test="${not empty rid}">
						<input type="hidden" value="${rid}" name="releaseid">
					</c:if>
					<div class="form-actions">
						<button type="submit" class="btn btn-primary" name="submit">Save</button>
						<button class="btn">Cancel</button>
					</div>
					<!-- /form-actions -->
				</fieldset>
			</form>
		</div>
	</div>
	</div>
</div>
