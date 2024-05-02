<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>x
<head>
<meta charset="UTF-8">
<title>HOME PAGE ADMIN</title>
</head>
<body>
	<div class="pcoded-content">
		<div class="pcoded-inner-content">
			<div class="main-body">
				<div class="page-wrapper">
					<div class="title-page"><i class="feather icon-home"></i> Trang chủ </div>
					<div class="page-body">
						<div class="row">
							 <!-- task, page, download counter  start -->
                                            <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-yellow update-card">
                                                    <div class="card-block">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${nhanvien}</h4>
                                                                <h6 class="text-white m-b-0">Nhân viên</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <i class="feather icon-users text-white f-14 m-r-10" style="font-size: 2rem;"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>Cập nhật : 2:15 am</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-green update-card">
                                                    <div class="card-block">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${phongban }</h4>
                                                                <h6 class="text-white m-b-0">Phòng ban</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-2" height="50"></canvas>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>Cập nhật : 2:15 am</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-pink update-card">
                                                    <div class="card-block">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${congtac }</h4>
                                                                <h6 class="text-white m-b-0">Đang công tác</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-3" height="50"></canvas>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>Cập nhật : 2:15 am</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-lite-green update-card">
                                                    <div class="card-block">
                                                        <div class="row align-items-end">
                                                            <div class="col-8">
                                                                <h4 class="text-white">${taikhoan }</h4>
                                                                <h6 class="text-white m-b-0">Tài khoản người dùng</h6>
                                                            </div>
                                                            <div class="col-4 text-right">
                                                                <canvas id="update-chart-4" height="50"></canvas>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="card-footer">
                                                        <p class="text-white m-b-0"><i class="feather icon-clock text-white f-14 m-r-10"></i>Cập nhật : 2:15 am</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- task, page, download counter  end -->
							<!--  sale analytics end -->

							<div class="col-xl-8 col-md-12">
								<div class="card table-card">
									<div class="card-header">
										<h5>Danh sách phòng ban</h5>
										<div class="card-header-right">
											<ul class="list-unstyled card-option">
												<li><i class="feather icon-maximize full-card"></i></li>
												<li><i class="feather icon-minus minimize-card"></i></li>
												<li><i class="feather icon-trash-2 close-card"></i></li>
											</ul>
										</div>
									</div>
									<div class="card-block">
										<div class="table-responsive">
											<table class="table table-hover  table-borderless">
												<thead>
													<tr>
															<th>Mã phòng ban</th>
															<th>Tên phòng ban</th>
															<th>Mô tả</th>
															<th>Người tạo</th>
															<th>Ngày tạo</th>
															<th>Người sửa</th>
															<th>Ngày sửa</th>
														</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${viewphongban.listResult}">
															<tr>
																<td colspan="1">${item.id}</td>
																<td>${item.tenPhongBan}</td>
																<td>${item.moTa}</td>
																<td>${item.createdBy}</td>
																<td>${item.createdDate}</td>
																<td>${item.modifiedBy}</td>
																<td>${item.modifiedDate}</td>
															</tr>
														</c:forEach>
												</tbody>
											</table>
											<div class="text-center">
												<a href="<c:url value ='/phongban?page=1&limit=2'/>" class=" b-b-primary text-primary">
												Tất cả phòng ban</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xl-4 col-md-12">
								<div class="card user-activity-card">
									<div class="card-header">
										<h5>Công tác</h5>
									</div>
									<div class="card-block">
									<c:forEach var="item" items="${viewcongtac.listResult}">
									<div class="row m-b-25">
											<div class="col">
												<c:forEach var="nhanvien" items="${nhanvienlist}">
																<c:if test="${nhanvien.key == item.maNhanVien}"> 
																<h6 class="m-b-5">${nhanvien.value }</h6>
																</c:if>
																</c:forEach>
												<p class="text-muted m-b-0">${item.moTa }</p>
												<p class="text-muted m-b-0">
													<i class="feather icon-clock m-r-10"></i>${item.tuNgay} - ${item.denNgay}
												</p>
											</div>
										</div>
									</c:forEach>
										
										

										<div class="text-center">
											<a href="<c:url value ='/congtac?page=1&limit=2'/>" class="b-b-primary text-primary">Tất cả</a>
										</div>
									</div>
								</div>
							</div>

							
							<!-- social download  start -->
							<div class="col-xl-4 col-md-6">
								<div class="card social-card bg-simple-c-blue">
									<div class="card-block">
										<div class="row align-items-center">
											<div class="col-auto">
												<i class="feather icon-mail f-34 text-c-blue social-icon"></i>
											</div>
											<div class="col">
												<h6 class="m-b-0">Mail</h6>
												<p>231.2w downloads</p>
												<p class="m-b-0">Lorem Ipsum is simply dummy text of the
													printing</p>
											</div>
										</div>
									</div>
									<a href="#!" class="download-icon"><i
										class="feather icon-arrow-down"></i></a>
								</div>
							</div>
							<div class="col-xl-4 col-md-6">
								<div class="card social-card bg-simple-c-pink">
									<div class="card-block">
										<div class="row align-items-center">
											<div class="col-auto">
												<i class="feather icon-twitter f-34 text-c-pink social-icon"></i>
											</div>
											<div class="col">
												<h6 class="m-b-0">twitter</h6>
												<p>231.2w downloads</p>
												<p class="m-b-0">Lorem Ipsum is simply dummy text of the
													printing</p>
											</div>
										</div>
									</div>
									<a href="#!" class="download-icon"><i
										class="feather icon-arrow-down"></i></a>
								</div>
							</div>
							<div class="col-xl-4 col-md-12">
								<div class="card social-card bg-simple-c-green">
									<div class="card-block">
										<div class="row align-items-center">
											<div class="col-auto">
												<i
													class="feather icon-instagram f-34 text-c-green social-icon"></i>
											</div>
											<div class="col">
												<h6 class="m-b-0">Instagram</h6>
												<p>231.2w downloads</p>
												<p class="m-b-0">Lorem Ipsum is simply dummy text of the
													printing</p>
											</div>
										</div>
									</div>
									<a href="#!" class="download-icon"><i
										class="feather icon-arrow-down"></i></a>
								</div>
							</div>
							<!-- social download  end -->

						</div>
					</div>
				</div>
				<div id="styleSelector"></div>
			</div>
		</div>
	</div>
</body>
<script>
var homePage = document.getElementById("home_page");
homePage.className = 'active'
</script>
</html>
