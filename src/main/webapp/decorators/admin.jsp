<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Trang chủ</title>
<!-- Meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="#">
<meta name="keywords"
	content="Admin , Responsive, Landing, Bootstrap, App, Template, Mobile, iOS, Android, apple, creative app">
<meta name="author" content="#">
<!-- Favicon icon -->
<link rel="icon"
	href="<c:url value='/template/files/assets/images/favicon.ico'/>"
	type="image/x-icon">
<!-- Google font-->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600"
	rel="stylesheet">
<!-- Required Fremwork -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/files/bower_components/bootstrap/css/bootstrap.min.css'/>">
<!-- feather Awesome -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/files/assets/icon/feather/css/feather.css'/>">
<!-- Style.css -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/files/assets/css/style.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/files/assets/css/jquery.mCustomScrollbar.css'/>">

<!-- sweetalert -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/files/assets/sweetalert/sweetalert2.min.css'/>">
<script
	src="<c:url value='/template/files/assets/sweetalert/sweetalert2.min.js'/>"></script>
<!-- font a ware some -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<style type="text/css">
.title-page {
	ont-size: 20px;
	font-weight: bold;
	padding: 10px;
}
</style>
</head>

<body>

	<%@ include file="/common/admin/header.jsp"%>
	<%@ include file="/common/admin/nav.jsp"%>

	<dec:body />

	<%@ include file="/common/admin/footer.jsp"%>

	<!-- Required Jquery -->

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="template/files/assets/paging/jquery.twbsPagination.js"></script>
	<script type="text/javascript"
		src="template/files/bower_components/jquery-ui/js/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="template/files/bower_components/popper.js/js/popper.min.js"></script>
	<script type="text/javascript"
		src="template/files/bower_components/bootstrap/js/bootstrap.min.js"></script>
	<!-- jquery slimscroll js -->
	<script type="text/javascript"
		src="template/files/bower_components/jquery-slimscroll/js/jquery.slimscroll.js"></script>
	<!-- modernizr js -->
	<script type="text/javascript"
		src="template/files/bower_components/modernizr/js/modernizr.js"></script>
	<!-- Chart js -->
	<script type="text/javascript"
		src="template/files/bower_components/chart.js/js/Chart.js"></script>
	<!-- amchart js -->
	<script src="template/files/assets/pages/widget/amchart/amcharts.js"></script>
	<script src="template/files/assets/pages/widget/amchart/serial.js"></script>
	<script src="template/files/assets/pages/widget/amchart/light.js"></script>
	<script
		src="template/files/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript"
		src="template/files/assets/js/SmoothScroll.js"></script>
	<script src="template/files/assets/js/pcoded.min.js"></script>
	<!-- custom js -->
	<script src="template/files/assets/js/vartical-layout.min.js"></script>
	<script type="text/javascript"
		src="template/files/assets/pages/dashboard/custom-dashboard.js"></script>
	<script type="text/javascript"
		src="template/files/assets/js/script.min.js"></script>

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async=""
		src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-23581568-13');
	</script>
	<!-- 	<script type="text/javascript">
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : 35,
				visiblePages : 10,
				onPageClick : function(event, page) {
					console.info(page + ' (from options)');
				}
			}).on('page', function(event, page) {
				console.info(page + ' (from event listening)');
			});
		});
	</script> -->
</body>

</html>
