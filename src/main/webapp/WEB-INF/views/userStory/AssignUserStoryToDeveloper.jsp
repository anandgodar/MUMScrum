<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
	<div class="span6">
		<div class="widget widget-nopad">
			<div class="widget-header">
				<i class="icon-list-alt"></i>
				<h3>Developers</h3>
			</div>
			<!-- /widget-header -->
			<div class="widget-content">
				<ul class="news-items">
					<c:forEach items="${developers}" var="developer">
						<li>

							<!-- <div class="news-item-date">
								<div class="control-group">

									<div class="controls">
										<label class="checkbox inline"> <input type="checkbox">
										</label>
									</div>
									/controls
								</div>
							</div> -->
							<div class="news-item-detail">
								
								<p class="news-item-preview">
									<c:out value="${developer.getUserName()}" />
								</p><a href="<c:url value="/userstory/assignuserstoriestodeveloperandtester/${usertype}/${pid}/${developer.getId()}"/>"  class="news-item-title" >
								Assign User Stories </a>
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



	
</div>

