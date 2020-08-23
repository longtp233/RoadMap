<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<c:url var="NewURL" value="/admin-new" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài viết</title>
</head>

<body>
	<div class="main-content">
		<form action="<c:url value='/admin-new'/>" id="formSubmit"
			method="get">
			<div class="main-content-inner">

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty messageResponse}">
								<div class="alert alert-${alert}">${messageResponse}</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info"
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm bài viết'
												href='<c:url value="/admin-list?type=new"/>'> <span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>

										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>ID</th>
													<th>name</th>
													<th>category</th>
													<th style ="padding:auto; ">content</th>
													<th></th>
													<th></th>
												</tr>
											</thead>
											<tbody>

												<c:forEach var="item" items="${model.listResult}">
													<!--  item no chinh la nhung phan tu nho ben trong items -->
													<tr>
														<td>${item.id}</td>
														<td>${item.title}</td>
														<td>${item.categoryId}</td>
														<td>${item.content}</td>
														<td><c:url var="editURL" value="/admin-list">
																<c:param name="type" value="edit" />
																<c:param name="id" value="${item.id}" />
															</c:url> <a  data-toggle="tooltip" title="Cập nhật bài viết"
															href='${editURL}'><i class="fa fa-pencil-square-o"
																aria-hidden="true"></i> </a>
														</td>
														<td><c:url var="editURL" value="/admin-list">
																<c:param name="type" value="delete" />
																<c:param name="id" value="${item.id}" />
															</c:url> <a id="btnDelete" class="fa fa-trash-o bigger-110 pink"
															data-toggle="tooltip" title="delete"
															href='${editURL}'> </a>
														
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	
</body>

</html>