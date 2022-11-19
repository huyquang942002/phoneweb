<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Dashboard - Admin</title>

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css'/>" />
		<link rel="stylesheet" href="<c:url value='/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css'/>" />
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
		integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
		crossorigin="anonymous" />
		<link rel="stylesheet" href="<c:url value='/template/admin/assets/fonts/fonts.googleapis.com.css'/>" />

		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
	    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script type='text/javascript' src='<c:url value="/template/admin/assets/js/jquery.2.1.1.min.js" />'></script>
	    <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
	    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

		<!-- ace styles -->
		<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css'/>" class="ace-main-stylesheet" id="main-ace-style" />
		<!-- ace settings handler -->
		<script src="<c:url value='/template/admin/assets/js/ace-extra.min.js'/>"></script>
		
		<link rel="stylesheet" href="<c:url value='/template/admin/style.css'/>" />
	</head>
<body class="no-skin">
		<!-- header -->
		<%@include file="/common/admin/header.jsp"%>
		<div class="main-container" id="main-container">
			
			<%@ include file="/common/admin/menu.jsp" %>
			

				<dec:body/>
			
			
			
			<!-- footer -->
			<%@include file="/common/admin/footer.jsp"%>
		</div>

	<script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js'/>"></script>

	<!-- ace scripts -->
	<script src="<c:url value='/template/admin/assets/js/ace-elements.min.js'/>"></script> 
</body>
</html>