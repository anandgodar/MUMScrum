<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">

	<div class="span8">

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
											<input type="text" name="name" class="span6 " id="name"
												value="${sprint.getName()} " required>
											<p class="help-block">Type the name of the Sprint .</p>
										</div>
										<!-- /controls -->
									</div>
									<!-- /control-group -->



									<div class="control-group">
										<label class="control-label" for="description">Description</label>
										<div class="controls">
											<textarea class="span6" id="description" name="description">${sprint.getDescription()} </textarea>
										</div>
										<!-- /controls -->
									</div>
									<!-- /control-group -->


									<br />
									<br />
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
			<!-- /widget-content -->

		</div>
		<!-- /widget -->
		

	</div>
	<!-- /span8 -->
	<div class="span4">
			<div class="widget">
            <div class="widget-header"> <i class="icon-file"></i>
              <h3> Current Release</h3>
            </div>
            <!-- /widget-header -->
            <div class="widget-content">
              <ul class="messages_layout">
              <c:forEach items="${releasebacklogs}" var="releasebacklog">
                <li class="from_user">
                  <div class="message_wrap"><span class="arrow"></span>
                    <div class="info"> <a class="name"><c:out value="${releasebacklog.getName()}" /></a> 
                      <div class="options_arrow">
                        <div class="dropdown pull-right"> <a class="dropdown-toggle " id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#"> <i class=" icon-caret-down"></i> </a>
                          <ul class="dropdown-menu " role="menu" aria-labelledby="dLabel">
                            <li><a href="<c:url value="/sprint/add/${releasebacklog.getId()}"/>"><i class="icon-plus-sign icon-large"></i> Add New Sprint</a></li>
                            <li><a href="<c:url value="/sprint/listsprints/${releasebacklog.getId()}"/>"><i class=" icon-list icon-large"></i> View All Sprints</a></li>
                            
                          </ul>
                        </div>
                      </div>
                    </div>
                    <div class="text"> <c:out value="${releasebacklog.getDescription()}" /> </div>
                  </div>
                </li>
                </c:forEach>
                 
               
              </ul>
            </div>
            <!-- /widget-content --> 
          </div>
	</div>



</div>
<!-- /row -->