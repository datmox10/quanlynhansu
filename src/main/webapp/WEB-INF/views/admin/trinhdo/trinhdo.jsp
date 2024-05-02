<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="createTrinhDoURL" value="/trinhdo-chinhsua" />
<c:url var="trinhDoAPI" value="/api/trinhdo" />
<c:url var="trinhDoURL" value="/trinhdo" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trình độ</title>
</head>
<body>
	<div class="pcoded-content">
		<div class="pcoded-inner-content">
			<div class="main-body">
				<div class="page-wrapper">
				<div class="title-page">
						<i class="feather icon-users"></i> Nhân viên / Trình độ
					</div>
				<form action="<c:url value ='/trinhdo'/>" method="GET"
						id="formSubmit">
					<div class="page-body">
						<div class="row">
							<div class="col-xl-12 col-md-12">
									<div class="alert alert-${alert}">${message}</div>
								</div>
							<div class="col-xl-12 col-md-12">
								<div class="card table-card">
									<div class="card-header">
										<h5>Danh sách trình độ</h5>

										<div class="card-header-right">
											<ul class="list-unstyled card-option">
												<li><a href="${createTrinhDoURL}" class="btn btn-primary"><i
														class="fa fa-plus" style="color: white;"></i>Thêm trình độ</a></li>
												<li><i class="feather icon-maximize full-card"></i></li>
											</ul>
										</div>
									</div>
									<div class="card-block">
										<div class="table-responsive">
											<table class="table table-hover  table-borderless">
													<thead>
														<tr>
															<th>Mã trình độ</th>
															<th>Tên trình độ</th>
															<th>Mô tả</th>
															<th>Người tạo</th>
															<th>Ngày tạo</th>
															<th>Người sửa</th>
															<th>Ngày sửa</th>
															<th>Sửa</th>
															<th>Xóa</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${model.listResult}">
															<tr>
																<td colspan="1">${item.id}</td>
																<td>${item.tenTrinhDo}</td>
																<td>${item.moTa}</td>
																<td>${item.createdBy}</td>
																<td>${item.createdDate}</td>
																<td>${item.modifiedBy}</td>
																<td>${item.modifiedDate}</td>
																<td><c:url var="updateTrinhDoURL"
																		value="/trinhdo-chinhsua">
																		<c:param name="id">${item.id}</c:param>
																	</c:url> <a class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Sứa trình độ' href="${updateTrinhDoURL}"><i
																		class="fa fa-pencil"></i></a></td>
																<td><button id="btnDelete" type="button" onclick="warningBeforeDelete(${item.id})"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa trình độ'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
												</button></td>
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
													<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
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
        url: '${trinhDoAPI}',
        type: 'DELETE',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (result) {
            window.location.href = "${trinhDoURL}?page=1&limit=2&message=delete_success";
        },
        error: function (error) {
        	window.location.href = "${trinhDoURL}?page=1&limit=2&message=error_system";
        }
    });
}
	</script>
</body>
</html>s