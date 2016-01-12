<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
       
        <!-- /span6 -->
        <div class="span12">
          <div class="widget">
            <div class="widget-header"> <i class="icon-bookmark"></i>
              <h3>Welcome : Scrum Master</h3>
            </div>
            <!-- /widget-header -->
            <div class="widget-content">
              <div class="shortcuts"> <a href="javascript:;" class="shortcut"><i class="shortcut-icon icon-list-alt"></i><span
                                        class="shortcut-label">Apps</span> </a><a href="javascript:;" class="shortcut"><i
                                            class="shortcut-icon icon-bookmark"></i><span class="shortcut-label">Bookmarks</span> </a><a href="javascript:;" class="shortcut"><i class="shortcut-icon icon-signal"></i> <span class="shortcut-label">Reports</span> </a><a href="javascript:;" class="shortcut"> <i class="shortcut-icon icon-comment"></i><span class="shortcut-label">Comments</span> </a><a href="javascript:;" class="shortcut"><i class="shortcut-icon icon-user"></i><span
                                                class="shortcut-label">Users</span> </a><a href="javascript:;" class="shortcut"><i
                                                    class="shortcut-icon icon-file"></i><span class="shortcut-label">Notes</span> </a><a href="javascript:;" class="shortcut"><i class="shortcut-icon icon-picture"></i> <span class="shortcut-label">Photos</span> </a><a href="javascript:;" class="shortcut"> <i class="shortcut-icon icon-tag"></i><span class="shortcut-label">Tags</span> </a> </div>
              <!-- /shortcuts --> 
            </div>
            <!-- /widget-content --> 
          </div>
          <!-- /widget -->
       
   
       
        </div>
        <!-- /span6 --> 
      </div>
      <!-- /row --> 
      
      <div class="row">
	      	
	      	<div class="span12">
	      		
	      		<div class="widget">
						
					<div class="widget-header">
						<i class="icon-th-large"></i>
						<h3>Current Products</h3>
					</div> <!-- /widget-header -->
					
					<div class="widget-content">
						
						<div class="pricing-plans plans-3">
				<c:forEach items="${listproduct}" var="product">	
					
						<div class="plan-container">
					        <div class="plan">
						        <div class="plan-header">
					                
						        	<div class="plan-title">
						        		<c:out value="${product.getTitle()}" />	        		
					        		</div> <!-- /plan-title -->
					                
						           <!--  <div class="plan-price">
					                	5<span class="term">Releases</span>
									</div> /plan-price -->
									
						        </div> <!-- /plan-header -->	        
						        <div class="plan-actions">				
									<a href="<c:url value="/releasebacklog/listreleases/${product.getId()}"/>" class="btn">Manage Release</a>				
								</div> <!-- /plan-actions -->
								 <div class="plan-actions">				
									<a href="<c:url value="/userstory/listuserstories/product/${product.getId()}"/>" class="btn">Manage User Story</a>				
								</div> <!-- /plan-actions -->
								<div class="plan-actions">				
									<a href="<c:url value="/userstory/assignuserstorytouser/developer/${product.getId()}"/>" class="btn">Assign User Story to Developer</a>				
								</div> <!-- /plan-actions -->
								<div class="plan-actions">				
									<a href="<c:url value="/userstory/assignuserstorytouser/tester/${product.getId()}"/>" class="btn">Assign User Story to Tester</a>				
								</div> <!-- /plan-actions -->
						       
								
								
					
							</div> <!-- /plan -->
					    </div> <!-- /plan-container -->
					 </c:forEach>   
					    
					    
					   
				
				
					</div> <!-- /pricing-plans -->
						
					</div> <!-- /widget-content -->
						
				</div> <!-- /widget -->					
				
		    </div> <!-- /span12 -->     	
	      	
	      	
	      </div>