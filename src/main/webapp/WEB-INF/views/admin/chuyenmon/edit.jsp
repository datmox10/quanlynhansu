<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="chuyenMonURL" value="/chuyenmon" />
<c:url var="editChuyeMonURL" value="/chuyenmon-chinhsua" />
<c:url var="chuyenMonAPI" value="/api/chuyenmon" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Thêm chuyên môn</title>
</head>
<body>
	<div class="pcoded-content">
		<div class="pcoded-inner-content">
			<div class="main-body">
				<div class="page-wrapper">
					<div class="title-page">
						<i class="feather icon-users"></i> Nhân viên / Chuyên môn / Thao tác
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
																<h1>Cập nhật chuyên môn</h1>
															</c:if>
															<c:if test="${empty model.id}">
																<h1>Thêm chuyên môn</h1>
															</c:if>

														</div>

														<div class="col-sm-12">
															<!-- Form Thêm sản phẩm -->
															<!-- Tên sản phẩm -->
															<div class="form-group">
																<label for="txtname">Tên chuyên môn</label>
																<form:input class="form-control" path="tenChuyenMon"
																	id="tenChuyenMon" type="text" name="tenChuyenMon" value="" />
															</div>
															<!-- Mô tả sản phẩm -->
															<div class="form-group">
																<label for="txtdesc">Mô tả</label>
																<form:textarea path="moTa" class="form-control"
																	id="moTa" name="moTa" rows="3" />

															</div>
															<form:hidden path="id" id="chuyenMonId" />
															<c:if test="${not empty model.id}">
																<button type="submit" class="btn btn-primary"
																	id="btnAddOrUpdate" name="btnAddOrUpdate">Cập
																	nhật chuyên môn</button>
															</c:if>
															<c:if test="${empty model.id}">
																<button type="submit" class="btn btn-primary"
																	id="btnAddOrUpdate" name="btnAddOrUpdate">Thêm
																	chuyên môn</button>
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
		$('#btnAddOrUpdate').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});

			var id = $('#chuyenMonId');

			if (id != null) {
				addChucVu(data);
			} else {
				updateChucVu(data);
			}
		})

		function addChucVu(data) {
			$.ajax({
						url : '${chuyenMonAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${chuyenMonURL}?page=1&limit=2&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${chuyenMonURL}?page=1&limit=2&message=error_system";
						}
					});
		}

		function updateChucVu(data) {
			$.ajax({
						url : '${chuyenMonAPI}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${chuyenMonURL}?page=1&limit=2&message=update_success";
						},
						error : function(error) {
							window.location.href = "${chuyenMonURL}?page=1&limit=2&message=error_system";
						}
					});
		}
	</script>
</body>
</html>