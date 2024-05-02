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
						<i class="feather icon-users"></i> Bảng lương
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
											<h5>Danh sách bảng lương</h5>
											<div class="card-header-right">
												<ul class="list-unstyled card-option">
													<li><a href="${createBangLuongURL}" 
														class="btn btn-primary"><i class="fa fa-plus"
															style="color: white;"></i>Thêm bảng lương</a></li>
													<li><i class="feather icon-maximize full-card"></i></li>
												</ul>
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
															<th>Chi tiết</th>
															<th>Xóa</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${model.listResult}">
															<tr>
																<td colspan="1" id="">${item.id}</td>
																<c:forEach var="nhanvien" items="${nhanvien}">
																<c:if test="${nhanvien.key == item.maNhanVien}"> 
																<td>${nhanvien.value}</td>
																</c:if>
																</c:forEach>
																<td>${item.ngayTinhCong}</td>
																<td>${item.soNgayCong}</td>
																<td>${item.tongTien}</td>
																<td><c:url var="chiTietBangLuong"
																		value="/bangluong-chitiet">
																		<c:param name="id">${item.maNhanVien}</c:param>
																	</c:url> <a
																	class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
																	data-toggle="tooltip" title='Chi tiết'
																	href="${chiTietBangLuong}"><i
																		class="fa fa-pencil"></i></a></td>
																<td><button id="btnDelete" type="button" onclick="warningBeforeDelete(${item.id})"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bảng lương'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
												</button>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
												<div class="center">
													<div class="container">
														<nav aria-label="Page navigation">
															<ul style="justify-content: center;" class="pagination"
																id="pagination"></ul>
														</nav>
													</div>
												</div>
												<input type="hidden" value="" id="page" name="page"/>
												<input type="hidden" value="" id="limit" name="limit"/>		
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
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(2);
						$('#page').val(page)
						$('#formSubmit').submit();
					}

				}
			});
		});
		
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
