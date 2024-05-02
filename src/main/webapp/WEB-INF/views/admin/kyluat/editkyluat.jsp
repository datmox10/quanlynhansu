<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="kyLuatURL" value="/kyluat" />
<c:url var="editKyLuatURL" value="/kyluat-chinhsua" />
<c:url var="kyLuatAPI" value="/api/kyluat" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Thêm kỷ luật</title>
</head>
<body>
	<div class="pcoded-content">
		<div class="pcoded-inner-content">
			<div class="main-body">
				<div class="page-wrapper">
					<div class="title-page">
						<i class="feather icon-users"></i> Kỷ luật
						/ Thao tác
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
																<h1>Cập nhật kỷ luật</h1>
															</c:if>
															<c:if test="${empty model.id}">
																<h1>Thêm kỷ luật</h1>
															</c:if>

														</div>

														<div class="col-sm-12">
															<!-- Form Thêm sản phẩm -->
															<!-- Tên sản phẩm -->
				
															
															<div class="form-group">
																<label>Nhân viên</label>
																<form:select class="form-control" path="maNhanVien"
																	id="maNhanVien" name="maNhanVien">
																	<c:if test="${empty model.id}">
																		<form:option value="" selected="selected">-- Chọn nhân viên --</form:option>
																		<c:forEach var="item" items="${nhanvien}">
																			<form:option value="${item.key}">${item.value}</form:option>
																		</c:forEach>
																	</c:if>
																	<c:if test="${not empty model.id}">
																		<c:forEach var="item" items="${nhanvien}">
																			<c:if test="${item.key == model.maNhanVien}">
																				<form:option value="${item.key}" selected="selected">${item.value}</form:option>
																			</c:if>
																			<c:if test="${model.maNhanVien != item.key}">
																				<form:option value="${item.key}">${item.value}</form:option>
																			</c:if>
																		</c:forEach>
																	</c:if>
																</form:select>
															</div>
															
															<div class="form-group">
																<label for="txtname">Ngày kỷ luật</label>
																<form:input class="form-control" path="ngay"
																	id="ngay" type="date" name="ngay"
																	value="" />
															</div>
															<div class="form-group">
																<label for="txtdesc">Nội dung</label>
																<form:textarea path="moTa" class="form-control"
																	id="moTa" name="moTa" rows="3" />
															</div>
															<div class="form-group">
																<label for="txtname">Tiền phạt</label>
																<form:input class="form-control" path="tienPhat"
																	id="tienPhat" type="number" name="tienPhat"
																	value="" />
															</div>
															<form:hidden path="id" id="congTacId" />
															<c:if test="${not empty model.id}">
																<button type="submit" class="btn btn-primary"
																	id="btnAddOrUpdateKyLuat"
																	name="btnAddOrUpdateKyLuat">Cập nhật kỷ luật</button>
															</c:if>
															<c:if test="${empty model.id}">
																<button type="submit" class="btn btn-primary"
																	id="btnAddOrUpdateKyLuat"
																	name="btnAddOrUpdateKyLuat">Thêm kỷ luật</button>
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
		
		
		$('#btnAddOrUpdateKyLuat').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			
			// Chuyển đối tượng Date thành chuỗi
			var id = $('#congTacId');
			
			if (id != null) {
				addKhenThuong(data);
			} else {
				updateKhenThuong(data);
			}
		})

		function addKhenThuong(data) {
			 $.ajax({
						url : '${kyLuatAPI}',
						type : 'POST',
						enctype : 'multipart/form-data',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${kyLuatURL}?page=1&limit=2&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${kyLuatURL}?page=1&limit=2&message=error_system";
						}
					}); 
		}

		function updateKhenThuong(data) {
			$
					.ajax({
						url : '${kyLuatAPI}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${kyLuatURL}?page=1&limit=2&message=update_success";
						},
						error : function(error) {
							window.location.href = "${kyLuatURL}?page=1&limit=2&message=error_system";
						}
					});
		}
	</script>
</body>
</html>