<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="nhanVienURL" value="/nhanvien" />
<c:url var="editNhanVienURL" value="/nhanvien-chinhsua" />
<c:url var="nhanVienAPI" value="/api/nhanvien" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Thêm nhân viên</title>
</head>
<body>
	<div class="pcoded-content">
		<div class="pcoded-inner-content">
			<div class="main-body">
				<div class="page-wrapper">
					<div class="title-page">
						<i class="feather icon-users"></i> Nhân viên / Danh sách nhân viên
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
																<h1>Cập nhật nhân viên</h1>
															</c:if>
															<c:if test="${empty model.id}">
																<h1>Thêm nhân viên</h1>
															</c:if>

														</div>

														<div class="col-sm-12">
															<!-- Form Thêm sản phẩm -->
															<!-- Tên sản phẩm -->
															<div class="form-group">
																<label for="txtname">Tên nhân viên</label>
																<form:input class="form-control" path="tenNhanVien"
																	id="tenNhanVien" type="text" name="tenNhanVien"
																	value="" />
															</div>
															<div class="form-group">
																<label for="txtname">Ảnh</label> <input
																	class="form-control" onchange="previewFile()" id="img" type="file"
																	name="img" />
															</div>
															<div class="form-group">
																<img id="anh" name ="anh"  src="${model.anh}" height="200" alt="Image preview...."/>
															</div>
															<div class="form-group">
																<label for="txtname">Ngày sinh</label>
																<form:input class="form-control" path="ngaySinh"
																	id="ngaySinh" type="date" name="ngaySinh" value="" />
															</div>
															<div class="form-group">
																<label for="txtname">Quê quán</label>
																<form:input class="form-control" path="queQuan"
																	id="queQuan" type="text" name="queQuan" value="" />
															</div>
															<div class="form-group">
																<label for="txtname">Giới tính</label>
																<form:input class="form-control" path="gioiTinh"
																	id="gioiTinh" type="text" name="gioiTinh" value="" />
															</div>
															<div class="form-group">
																<label for="txtname">Dân tộc</label>
																<form:input class="form-control" path="danToc"
																	id="danToc" type="text" name="danToc" value="" />
															</div>

															<div class="form-group">
																<label for="txtname">Số điện thoại</label>
																<form:input class="form-control" path="soDienThoai"
																	id="soDienThoai" type="number" name="soDienThoai"
																	value="" />
															</div>
															<div class="form-group">
																<label for="txtname">Lương</label>
																<form:input class="form-control" path="luong" id="luong"
																	type="number" name="luong" value="" />
															</div>
															<%-- <div class="form-group">
																<label>Chức vụ</label>
																<form:select class="form-control" path="maChucVu"
																	id="maChucVu" name="maChucVu">
																	<c:forEach var="item" items="${chucvu}">
																		<form:option value="${item.code}">${item.name}</form:option>
																	</c:forEach>
																</form:select>
															</div> --%>
															<div class="form-group">
																<label>Chức vụ</label>
																<form:select class="form-control" path="maChucVu"
																	id="maChucVu" name="maChucVu">
																	<c:if test="${empty model.id}">
																		<form:option value="" selected="selected">-- Chọn loại --</form:option>
																		<c:forEach var="item" items="${chucvu}">
																			<form:option value="${item.key}">${item.value}</form:option>
																		</c:forEach>
																	</c:if>
																	<c:if test="${not empty model.id}">
																		<c:forEach var="item" items="${chucvu}">
																			<c:if test="${item.key == model.maChucVu}">
																				<form:option value="${item.key}" selected="selected">${item.value}</form:option>
																			</c:if>
																			<c:if test="${model.maChucVu != item.key}">
																				<form:option value="${item.key}">${item.value}</form:option>
																			</c:if>
																		</c:forEach>
																	</c:if>

																</form:select>
															</div>
															<div class="form-group">
																<label for="txtname">Trình độ</label>
																	<form:select class="form-control" path="maTrinhDo"
																	id="maTrinhDo" name="maTrinhDo">
																	<c:if test="${empty model.id}">
																		<form:option value="" selected="selected">-- Chọn loại --</form:option>
																		<c:forEach var="item" items="${trinhdo}">
																			<form:option value="${item.key}">${item.value}</form:option>
																		</c:forEach>
																	</c:if>
																	<c:if test="${not empty model.id}">
																		<c:forEach var="item" items="${trinhdo}">
																			<c:if test="${item.key == model.maTrinhDo}">
																				<form:option value="${item.key}" selected="selected">${item.value}</form:option>
																			</c:if>
																			<c:if test="${model.maTrinhDo != item.key}">
																				<form:option value="${item.key}">${item.value}</form:option>
																			</c:if>
																		</c:forEach>
																	</c:if>

																</form:select>
															</div>
															<div class="form-group">
																<label for="txtname">Chuyên môn</label>
																	<form:select class="form-control" path="maChuyenMon"
																	id="maChuyenMon" name="maChuyenMon">
																	<c:if test="${empty model.id}">
																		<form:option value="" selected="selected">-- Chọn loại --</form:option>
																		<c:forEach var="item" items="${chuyenmon}">
																			<form:option value="${item.key}">${item.value}</form:option>
																		</c:forEach>
																	</c:if>
																	<c:if test="${not empty model.id}">
																		<c:forEach var="item" items="${chuyenmon}">
																			<c:if test="${item.key == model.maChuyenMon}">
																				<form:option value="${item.key}" selected="selected">${item.value}</form:option>
																			</c:if>
																			<c:if test="${model.maChuyenMon != item.key}">
																				<form:option value="${item.key}">${item.value}</form:option>
																			</c:if>
																		</c:forEach>
																	</c:if>

																</form:select>
															</div>
															<div class="form-group">
																<label for="txtname">Phòng ban</label>
																	<form:select class="form-control" path="maPhongBan"
																	id="maPhongBan" name="maPhongBan">
																	<c:if test="${empty model.id}">
																		<form:option value="" selected="selected">-- Chọn loại --</form:option>
																		<c:forEach var="item" items="${phongban}">
																			<form:option value="${item.key}">${item.value}</form:option>
																		</c:forEach>
																	</c:if>
																	<c:if test="${not empty model.id}">
																		<c:forEach var="item" items="${phongban}">
																			<c:if test="${item.key == model.maPhongBan}">
																				<form:option value="${item.key}" selected="selected">${item.value}</form:option>
																			</c:if>
																			<c:if test="${model.maPhongBan != item.key}">
																				<form:option value="${item.key}">${item.value}</form:option>
																			</c:if>
																		</c:forEach>
																	</c:if>
																</form:select>
															</div>
															<div class="form-group">
																<label for="txtname">Trạng thái</label>
																<form:input class="form-control" path="trangThai"
																	id="trangThai" type="number" name="trangThai" value="1" />
															</div>
															<form:hidden path="id" id="nhanVienId" />
															<c:if test="${not empty model.id}">
																<button type="submit" class="btn btn-primary"
																	id="btnAddOrUpdateNhanVien"
																	name="btnAddOrUpdateNhanVien">Cập nhật chức vụ</button>
															</c:if>
															<c:if test="${empty model.id}">
																<button type="submit" class="btn btn-primary"
																	id="btnAddOrUpdateNhanVien"
																	name="btnAddOrUpdateNhanVien">Thêm chức vụ</button>
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
		
		$('#btnAddOrUpdateNhanVien').click(function(e) {
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
			var id = $('#nhanVienId');
			data["anh"] = anh;
			if (id != null) {
				addNhanVien(data);
			} else {
				updateNhanVien(data);
			}
		})

		function addNhanVien(data) {
			 $.ajax({
						url : '${nhanVienAPI}',
						type : 'POST',
						enctype : 'multipart/form-data',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${nhanVienURL}?page=1&limit=2&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${nhanVienURL}?page=1&limit=2&message=error_system";
						}
					}); 
		}

		function updateNhanVien(data) {
			$
					.ajax({
						url : '${nhanVienAPI}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${nhanVienURL}?page=1&limit=2&message=update_success";
						},
						error : function(error) {
							window.location.href = "${nhanVienURL}?page=1&limit=2&message=error_system";
						}
					});
		}
	</script>
</body>
</html>