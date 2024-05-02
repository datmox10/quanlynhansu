<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="bangCapURL" value="/bangcap" />
<c:url var="editBangCapURL" value="/bangcap-chinhsua" />
<c:url var="bangCapAPI" value="/api/bangcap" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Thêm bằng cấp</title>
</head>
<body>
	<div class="pcoded-content">
		<div class="pcoded-inner-content">
			<div class="main-body">
				<div class="page-wrapper">
					<div class="title-page">
						<i class="feather icon-users"></i> Bằng cấp / Danh sách bằng cấp
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
																<h1>Cập nhật bằng cấp</h1>
															</c:if>
															<c:if test="${empty model.id}">
																<h1>Thêm bằng cấp</h1>
															</c:if>

														</div>

														<div class="col-sm-12">
															<!-- Form Thêm sản phẩm -->
															<!-- Tên sản phẩm -->
															<div class="form-group">
																<label for="txtname">Tên bằng cấp</label>
																<form:input class="form-control" path="tenBangCap"
																	id="tenBangCap" type="text" name="tenBangCap"
																	value="" />
															</div>
															<div class="form-group">
																<label for="txtname">Ảnh</label> <input
																	class="form-control" onchange="previewFile()" id="img" type="file"
																	name="img" />
															</div>
															<div class="form-group">
															<c:if test="${empty model.id}">
																<img id="anh" path="anh" name ="anh"  src="" height="200" alt="Image preview...."/>
															</c:if>
															<c:if test="${not empty model.id}">
																<img id="anh" path="anh" name ="anh"  src="${model.anh}" height="200" alt="Image preview...."/>
															</c:if>
															</div>
															<div class="form-group">
																<label>Nhân viên</label>
																<form:select class="form-control" path="maNhanVien"
																	id="maNhanVien" name="maNhanVien">
																	<c:if test="${empty model.id}">
																		<form:option value="" selected="selected">-- Chọn loại --</form:option>
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
															<form:hidden path="id" id="bangCapId" />
															<c:if test="${not empty model.id}">
																<button type="submit" class="btn btn-primary"
																	id="btnAddOrUpdateBangCap"
																	name="btnAddOrUpdateBangCap">Cập nhật bằng cấp</button>
															</c:if>
															<c:if test="${empty model.id}">
																<button type="submit" class="btn btn-primary"
																	id="btnAddOrUpdateBangCap"
																	name="btnAddOrUpdateBangCap">Thêm bằng cấp</button>
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
		function previewFile(){
			const imgPreview = document.querySelector("#anh");
			const file = document.querySelector("#img").files[0];
			const reader= new FileReader();
			
			reader.addEventListener("load",function(){
				
				imgPreview.src = reader.result;
			},false);
			
			if(file){
				reader.readAsDataURL(file);
			}
		}
		
		$('#btnAddOrUpdateBangCap').click(function(e) {
			e.preventDefault();
			var data = {};
			var anh = document.querySelector("#anh").getAttribute('src');
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			/* var anh;
			var fileInput = document.getElementById('anh');
			var file = fileInput.files[0]; // Lấy tập tin đã chọn
			var reader = new FileReader();
			reader.onload = function(event) {
				var imageData = event.target.result; // Dữ liệu base64 của file ảnh
				data["anh"] = imageData;
			};
			reader.readAsDataURL(file); */

			// Chuyển đối tượng Date thành chuỗi
			var id = $('#bangCapId');
			data["anh"] = anh;
			if (id != null) {
				addBangCap(data);
			} else {
				updateBangCap(data);
			}
		})

		function addBangCap(data) {
			 $.ajax({
						url : '${bangCapAPI}',
						type : 'POST',
						enctype : 'multipart/form-data',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${bangCapURL}?page=1&limit=2&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${bangCapURL}?page=1&limit=2&message=error_system";
						}
					}); 
		}

		function updateBangCap(data) {
			$
					.ajax({
						url : '${bangCapAPI}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${bangCapURL}?page=1&limit=2&message=update_success";
						},
						error : function(error) {
							window.location.href = "${bangCapURL}?page=1&limit=2&message=error_system";
						}
					});
		}
	</script>
</body>
</html>