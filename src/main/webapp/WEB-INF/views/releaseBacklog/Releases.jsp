<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span8">
		<div class="widget widget-nopad">
			
			<div class="widget widget-table action-table">
				<div class="widget-header">
					<a href="<c:url value="/releasebacklog/add/${pid}"/>"><i class="icon-plus-sign"></i>
					<h3>Add New Release</h3>
					</a>
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
								<th >Action</th>
								<th>Add/View Sprint</th>
								<th>Assign UStory</th>
							</tr>
						</thead>
						<tbody>
		<c:forEach items="${releasebacklogs}" var="releasebacklog">
							<tr>
								<td><c:out value="${releasebacklog.getName()}" /></td>
								<td><c:out value="${releasebacklog.getDescription()}" /></td>
								<td class="td-actions"><a href="<c:url value="/releasebacklog/edit/${releasebacklog.getProductId()}/${releasebacklog.getId()}"/>"
									class="btn btn-small btn-success"><i
										class="btn-icon-only icon-ok"> </i></a><a href="<c:url value="/releasebacklog/delete/${releasebacklog.getProductId()}/${releasebacklog.getId()}"/>"
									class="btn btn-danger btn-small" id="deleteMe"><i
										class="btn-icon-only icon-remove"> </i></a></td>
										
								<td ><a href="<c:url value="/sprint/add/${releasebacklog.getId()}"/>" class="btn btn-danger">  <i class="icon-large icon-plus-sign"></i></a>  &nbsp;&nbsp;&nbsp;
								<a href="<c:url value="/sprint/listsprints/${releasebacklog.getId()}"/>" class="btn  btn-success">  <i class="icon-large icon-eye-open"></i></a></td>
								<td ><a href="<c:url value="/userstory/assignuserstoriestorelease/release/${releasebacklog.getProductId()}/${releasebacklog.getId()}"/>" class="btn btn-danger" title="Assig User Story to Release">  <i class="icon-large icon-plus-sign"></i></a>  &nbsp;&nbsp;&nbsp;
								<a href="<c:url value="/sprint/listsprints/${releasebacklog.getId()}"/>" class="btn  btn-success">  <i class="icon-large icon-eye-open"></i></a></td>			
							</tr>
							
			</c:forEach>				
							
						</tbody>
					</table>
				</div>
				<!-- /widget-content -->
			</div>
		</div>
	</div>
	
	
	<div class="span4">
		<div class="widget ">

			<div class="widget-header">
				<i class="icon-user"></i>
				<h3>${actionTitle}</h3>
			</div>
			<!-- /widget-header -->

			<div class="widget-content">


							<form id="add-sprint" class="form-vertical" method="POST"
								action="<spring:url value="${actionText}"/>"
								data-toggle="validator" role="form">
								<fieldset>

									<div class="control-group">
										<label  for="name">Title</label>
										<div class="controls">
											<input type="text" name="name" class="span3" id="name"
												value="${release.getName()} " required>
											<p class="help-block">Type the name of the Release .</p>
										</div>
										<!-- /controls -->
									</div>
									<!-- /control-group -->



									<div class="control-group">
										<label for="description">Description</label>
										<div class="controls">
											<textarea class="span3" id="description" name="description">${release.getDescription()} </textarea>
										</div>
										<!-- /controls -->
									</div>
									<!-- /control-group -->


									<br /> <br />

									<c:if test="${not empty productId}">
										<input type="hidden" value="${productId}" name="productId">
									</c:if>
									<c:if test="${not empty id}">
										<input type="hidden" value="${id}" name="Id   ">
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


			<!-- /widget-content -->

		</div>
		<!-- /widget -->

