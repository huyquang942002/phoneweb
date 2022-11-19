<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanh toán</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
    crossorigin="anonymous" />
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/web/js/jquery.2.1.1.min.js' />"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="<c:url value='/template/web/css/reset.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/css/style.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/css/login.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/css/account.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/css/cart.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/css/product-details.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/css/payment.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/css/thanks.css'/>">
</head>
<body>
		<!-- header -->
		<%@include file="/common/payment/header.jsp"%>
		
		<div class="body">
			<dec:body/>
		</div>
		<!-- footer -->
		<%@include file="/common/web/footer.jsp"%>


	<script src="<c:url value='/template/web/js/header.js'/>"></script>
	<script src="<c:url value='/template/web/js/homepage.js'/>"></script>
	<script src="<c:url value='/template/web/js/catalog.js'/>"></script>
</body>
</html>