<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.quanlynhansu.util.SecurityUtils" %>
<!-- Pre-loader start -->
<!-- <div class="theme-loader">
	<div class="ball-scale">
		<div class='contain'>
			<div class="ring">
				<div class="frame"></div>
			</div>
			<div class="ring">
				<div class="frame"></div>
			</div>
			<div class="ring">
				<div class="frame"></div>
			</div>
			<div class="ring">
				<div class="frame"></div>
			</div>
			<div class="ring">
				<div class="frame"></div>
			</div>
			<div class="ring">
				<div class="frame"></div>
			</div>
			<div class="ring">
				<div class="frame"></div>
			</div>
			<div class="ring">
				<div class="frame"></div>
			</div>
			<div class="ring">
				<div class="frame"></div>
			</div>
			<div class="ring">
				<div class="frame"></div>
			</div>
		</div>
	</div>
</div> -->
<!-- Pre-loader end -->
<div id="pcoded" class="pcoded">
	<div class="pcoded-overlay-box"></div>
	<div class="pcoded-container navbar-wrapper">
		<nav class="navbar header-navbar pcoded-header">
			<div class="navbar-wrapper">
				<div class="navbar-logo">
					<a class="mobile-menu" id="mobile-collapse" href="#!"> <i
						class="feather icon-menu"></i>
					</a> <a href="index-1.htm"> <img style="max-width :60%" class="img-fluid"
						src="<c:url value ='/template/image/logo/FEDI-logo.png'/>"
						alt="Theme-Logo">
					</a> <a class="mobile-options"> <i
						class="feather icon-more-horizontal"></i>
					</a>
				</div>

				<div class="navbar-container container-fluid">
					<ul class="nav-left">
						<li class="header-search">
							<div class="main-search morphsearch-search">
								<div class="input-group">
									<span class="input-group-addon search-close"><i
										class="feather icon-x"></i></span> <input type="text"
										class="form-control"> <span
										class="input-group-addon search-btn"><i
										class="feather icon-search"></i></span>
								</div>
							</div>
						</li>
						<li><a href="#!" onclick="javascript:toggleFullScreen()">
								<i class="feather icon-maximize full-screen"></i>
						</a></li>
					</ul>
					<ul class="nav-right">
						<li class="header-notification">
							<div class="dropdown-primary dropdown">
								<div class="dropdown-toggle" data-toggle="dropdown">
									<i class="feather icon-bell"></i> <span class="badge bg-c-pink">1</span>
								</div>
								<ul class="show-notification notification-view dropdown-menu"
									data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
									<li>
										<h6>Thông báo</h6> <label class="label label-danger">Mới</label>
									</li>
									<li>
										<div class="media">
											<img class="d-flex align-self-center img-radius"
												src="<c:url value ='/template/image/user/avatar.jpg'/>"
												alt="Generic placeholder image">
											<div class="media-body">
												<h5 class="notification-user">Admin</h5>
												<p class="notification-msg">Bạn vừa đăng nhập.</p>
												<span class="notification-time">1 minutes ago</span>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</li>
						<li class="user-profile header-notification">
							<div class="dropdown-primary dropdown">
								<div class="dropdown-toggle" data-toggle="dropdown">
									<img src="<c:url value ='/template/image/user/avatar.jpg'/>"
										class="img-radius" alt="User-Profile-Image"> 
										<span>Xin chào , <%=SecurityUtils.getPrincipal().getFullName() %></span> 
										<i class="feather icon-chevron-down"></i>
								</div>
								<ul class="show-notification profile-notification dropdown-menu"
									data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
									<li><a href="#!"> <i class="feather icon-settings"></i>
											Settings
									</a></li>
									<!-- <li><a href="user-profile.htm"> <i
											class="feather icon-user"></i> Profile
									</a></li>
									<li><a href="email-inbox.htm"> <i
											class="feather icon-mail"></i> My Messages
									</a></li>
									<li><a href="auth-lock-screen.htm"> <i
											class="feather icon-lock"></i> Lock Screen
									</a></li> -->
									<li><a href="<c:url value='/thoat'/>"> <i
											class="feather icon-log-out"></i> Logout
									</a></li>
								</ul>

							</div>
						</li>
					</ul>
				</div>
			</div>
		</nav>

		