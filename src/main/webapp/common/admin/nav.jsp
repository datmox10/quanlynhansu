<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- Sidebar inner chat end-->
<div class="pcoded-main-container">
	<div class="pcoded-wrapper">
		<nav class="pcoded-navbar">
			<div class="pcoded-inner-navbar main-menu">
				<div class="pcoded-navigatio-lavel">MENU</div>
				<ul class="pcoded-item pcoded-left-item">
				
				<!-- NAV TRANG CHỦ -->
					<li class="" id="home_page"><a href="<c:url value ='/home'/>"> <span
							class="pcoded-micon"><i class="feather icon-home"></i></span> 
							<span class="pcoded-mtext">Trang chủ</span>
					</a></li>
					
					<!-- QUản lý nhân viên -->
					<li class="pcoded-hasmenu"><a href="javascript:void(0)"> <span
							class="pcoded-micon"><i class="feather icon-users"></i></span>
							<span class="pcoded-mtext">Quản lý nhân viên</span>
					</a>
						<ul class="pcoded-submenu">
							<li class=""><a href="<c:url value ='/chucvu?page=1&limit=2'/>"> <span
									class="pcoded-mtext">Chức vụ</span>
							</a></li>
							<li class=" "><a href="<c:url value ='trinhdo?page=1&limit=2'/>"> <span
									class="pcoded-mtext">Trình độ</span>
							</a></li>
							<li class=" "><a href="<c:url value ='/chuyenmon?page=1&limit=2'/>" >
									<span class="pcoded-mtext">Chuyên môn</span>
							</a></li>
							<li class=" "><a href="<c:url value ='/bangcap?page=1&limit=2'/>"> <span
									class="pcoded-mtext">Bằng cấp</span>
							</a></li>
							<li class=" "><a href="<c:url value ='/nhanvien?page=1&limit=2'/>" > <span
									class="pcoded-mtext">Danh sách nhân viên</span>
							</a></li>
						</ul></li>
						<!-- Quản lý phòng ban -->
					<li class=""><a href="<c:url value ='/phongban?page=1&limit=2'/>"> <span
							class="pcoded-micon"><i class="feather icon-briefcase"></i></span> <span
							class="pcoded-mtext">Quản lý phòng ban</span>
					</a></li>
					<!-- Quản lý lương -->
					<li class=""><a href="<c:url value ='/bangluong?page=1&limit=2'/>"> <span
							class="pcoded-micon"><i class="feather icon-slack"></i></span> <span
							class="pcoded-mtext">Quản lý lương</span>
					</a></li>
					<!-- Quản lý công tác -->
					<li class=""><a href="<c:url value ='/congtac?page=1&limit=2'/>"> <span
							class="pcoded-micon"><i class="feather icon-globe"></i></span> <span
							class="pcoded-mtext">Quản lý công tác</span>
					</a></li>
				
					<!-- QUản lý khen thưởng-kỷ lật -->
					<li class="pcoded-hasmenu"><a href="javascript:void(0)"> <span
							class="pcoded-micon"><i class="feather icon-star"></i></span>
							<span class="pcoded-mtext">Quản lý kt - kl </span>
					</a>
						<ul class="pcoded-submenu">
							<li class=" "><a href="<c:url value ='/khenthuong?page=1&limit=2'/>"> <span
									class="pcoded-mtext">Khen thưởng</span>
							</a></li>
							<li class=" "><a href="<c:url value ='/kyluat?page=1&limit=2'/>"> <span
									class="pcoded-mtext">Kỷ luật</span>
							</a></li>
						</ul></li>
					
				</ul>
			</div>
		</nav>