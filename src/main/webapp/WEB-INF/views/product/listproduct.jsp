<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span10">
		<div class="widget widget-nopad">
			
			<div class="widget widget-table action-table">
				<div class="widget-header">
					<i class="icon-th-list"></i>
					<h3>Products</h3>
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
								<th class="td-actions"></th>
							</tr>
						</thead>
						<tbody>
		<c:forEach items="${listproduct}" var="product">
							<tr>
								<td><c:out value="${product.getTitle()}" /></td>
								<td><c:out value="${product.getDescription()}" /></td>
								<td class="td-actions"><a href="<c:url value="/product/edit/${product.getId()}"/>"
									class="btn btn-small btn-success"><i
										class="btn-icon-only icon-ok"> </i></a><a href="<c:url value="/product/delete/${product.getId()}"/>"
									class="btn btn-danger btn-small" id="deleteMe"><i
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
</div>
