<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="createBangLuongURL" value="/bangluong-chinhsua" />
<c:url var="createChucVuURL" value="/bangluong-chinhsua" />
<c:url var="bangLuongAPI" value="/api/bangluong" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chức vụ</title>
</head>
<body>
	<div class="pcoded-content">
		<div class="pcoded-inner-content">
			<div class="main-body">
				<div class="page-wrapper">
					<div class="title-page">
						<i class="feather icon-users"></i> Chi tiết bảng lương
					</div>
					<form action="<c:url value ='/bangluong'/>" method="GET"
						id="formSubmit">
						<div class="page-body">
							<div class="row">
								<div class="col-xl-12 col-md-12">
									<div class="alert alert-${alert}">${message}</div>
								</div>
								<div class="col-xl-12 col-md-12">
									<div class="card table-card">
										<div class="card-header">
											<h5>Mã nhân viên: ${nhanvien.id}</h5><br>
											<h5>${nhanvien.tenNhanVien}</h5>
											<br><br>
											<div class="page-body">
											<img src="${nhanvien.anh}"
																	alt="icon Quantrimang.com" class="rounded" width="100"
																	width="100">
											</div>
										</div>
									
										<div class="card-block">
											<div class="table-responsive">
												<table class="table table-hover  table-borderless">
													<thead>
														<tr>
															<th>Mã bảng lương</th>
															<th>Mã nhân viên</th>
															<th>Ngày tính công</th>
															<th>Số ngày công</th>
															<th>Thực lãnh</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${model.listResult}">
															<tr>
																<td colspan="1" id="">${item.id}</td>
																<td>${item.maNhanVien}</td>
																<td>${item.ngayTinhCong}</td>
																<td>${item.soNgayCong}</td>
																<td>${item.tongTien}</td>
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
					</form>
				</div>
				<div id="styleSelector"></div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		
		
		function warningBeforeDelete(id) {
			swal({
			  title: "Xác nhận xóa",
			  text: "Bạn có chắc chắn muốn xóa hay không",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonClass: "btn-success",
			  cancelButtonClass: "btn-danger",
			  confirmButtonText: "Xác nhận",
			  cancelButtonText: "Hủy bỏ",
			}).then(function(isConfirm) {
			  if (isConfirm) {
				  deleteChucVu(id)
			  }
			});
	} 
	function deleteChucVu(data) {
        $.ajax({
            url: '${bangLuongAPI}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location.href = "${chucVuURL}?page=1&limit=2&message=delete_success";
            },
            error: function (error) {
            	window.location.href = "${bangLuongURL}?page=1&limit=2&message=error_system";
            }
        });
    }
	</script>
</body>

</html>
