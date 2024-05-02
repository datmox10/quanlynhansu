<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="trinhDoURL" value="/trinhdo" />
<c:url var="editTrinhDoURL" value="/trinhdo-chinhsua" />
<c:url var="trinhDoAPI" value="/api/trinhdo" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Thêm trình độ</title>
</head>
<body>
	<div class="pcoded-content">
		<div class="pcoded-inner-content">
			<div class="main-body">
				<div class="page-wrapper">
					<div class="title-page">
						<i class="feather icon-users"></i> Nhân viên / Trình độ / Thao tác
					</div>
					<div class="page-body">
						<div class="row">
							<div class="col-xl-12 col-md-12">
								<div class="alert alert-${alert}">${message}</div>
							</div>
							<div class="col-xl-12 col-md-12">
								<div class="card table-card">
									<div class="card-header">
										<div class="card-header-right">
											<ul class="list-unstyled card-option">
												<li><i class="feather icon-maximize full-card"></i></li>
											</ul>
										</div>
									</div>
									<div class="card-block">
										<form:form role="form" enctype="multipart/form-data"
											id="formSubmit" modelAttribute="model">
											<div class="table-responsive">
												<div class="container form-text">
													<div class="row">
														<div class="col-sm-12">
															<c:if test="${not empty model.id}">
																<h1>Cập nhật trình độ</h1>
															</c:if>
															<c:if test="${empty model.id}">
																<h1>Thêm trình độ</h1>
															</c:if>

														</div>

														<div class="col-sm-12">
															<!-- Form Thêm sản phẩm -->
															<!-- Tên sản phẩm -->
															<div class="form-group">
																<label for="txtname">Tên trình độ</label>
																<form:input class="form-control" path="tenTrinhDo"
																	id="tenTrinhDo" type="text" name="tenTrinhDo" value="" />
															</div>
															<!-- Mô tả sản phẩm -->
															<div class="form-group">
																<label for="txtdesc">Mô tả</label>
																<form:textarea path="moTa" class="form-control"
																	id="moTa" name="moTa" rows="3" />

															</div>
															<form:hidden path="id" id="trinhDoId" />
															<c:if test="${not empty model.id}">
																<button type="submit" class="btn btn-primary"
																	id="btnAddOrUpdateTrinhDo" name="btnAddOrUpdateTrinhDo">Cập
																	nhật trình độ</button>
															</c:if>
															<c:if test="${empty model.id}">
																<button type="submit" class="btn btn-primary"
																	id="btnAddOrUpdateTrinhDo" name="btnAddOrUpdateTrinhDo">Thêm
																	trình độ</button>
															</c:if>
															<button type="submit" class="btn btn-primary"
																name="btnsubmit">Xóa</button>

														</div>
													</div>
												</div>
											</div>
										</form:form>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>

				<div id="styleSelector"></div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

	<script type="text/javascript">
		$('#btnAddOrUpdateTrinhDo').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});

			var id = $('#trinhDoId');

			if (id != null) {
				addTrinhDo(data);
			} else {
				updateTrinhDo(data);
			}
		})

		function addTrinhDo(data) {
			$.ajax({
						url : '${trinhDoAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${trinhDoURL}?page=1&limit=2&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${trinhDoURL}?page=1&limit=2&message=error_system";
						}
					});
		}

		function updateTrinhDo(data) {
			$.ajax({
						url : '${trinhDoAPI}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${trinhDoURL}?page=1&limit=2&message=update_success";
						},
						error : function(error) {
							window.location.href = "${trinhDoURL}?page=1&limit=2&message=error_system";
						}
					});
		}
	</script>
</body>
</html>