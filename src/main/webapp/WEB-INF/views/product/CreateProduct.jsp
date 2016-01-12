<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">

	<div class="span12">

		<div class="widget ">

			<div class="widget-header">
				<i class="icon-user"></i>
				<h3>${actionTitle}</h3>
			</div>
			<!-- /widget-header -->

			<div class="widget-content">



				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#formcontrols" data-toggle="tab">${actionTitle}</a>
						</li>

					</ul>

					<br>

					<div class="tab-content">
						<div class="tab-pane active" id="formcontrols">
					
							<form id="add-sprint" class="form-horizontal" method="POST"
								 action="<spring:url value="${actionText}"/>"  data-toggle="validator" role="form">
								<fieldset>

									<div class="control-group">
										<label class="control-label" for="name">Title</label>
										<div class="controls">
											<input type="text" name="title" class="span6 " id="title"
												value="${product.getTitle()} " required>
											<p class="help-block">Type the name of the Sprint .</p>
										</div>
										<!-- /controls -->
									</div>
									<!-- /control-group -->



									<div class="control-group">
										<label class="control-label" for="description">Description</label>
										<div class="controls">
											<textarea class="span6" id="description" name="description">${product.getDescription()} </textarea>
										</div>
										<!-- /controls -->
									</div>
									<!-- /control-group -->

									
									<br />
									<br />
								<c:if test="${not empty product.getId()}">
									<input type="hidden" value="${product.getId()}" name="Id">
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
			<!-- /widget-content -->

		</div>
		<!-- /widget -->
		

	</div>
	<!-- /span8 -->




</div>
<!-- /row -->