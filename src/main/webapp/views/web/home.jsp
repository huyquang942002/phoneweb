<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Phone Store</title>
</head>
<body>
	<!-- ------------------------------------------------------------------------------------Body-->
	<div class="content">
		<div class="content__container">
			<div class="main">
				<div class="homepage">
					<div class="homepage-image">
						<div class="homepage-left">
							<i class="fas fa-chevron-left homepage-left-icon-back"></i> <a
								href="" class="homepage-left-item"> <img
								src="https://64.media.tumblr.com/61202e7924136b19331383346dc414b6/eebf17869bdf627f-39/s1280x1920/06bdd4c4221c59e799c474751c4e11ce12b52ac5.jpg"
								alt="" class="homepage-left-img">
							</a> <i class="fas fa-chevron-right homepage-left-icon-next"></i>
						</div>
						<div class="homepage-right">
							<a href="#" class="homepage-right-item"> <img
								src="https://64.media.tumblr.com/248d8ff8c086daf23eafd3c9b3f63686/eebf17869bdf627f-65/s1280x1920/19b587c0b3811187743185164f0ba9331e359098.jpg"
								alt="">
							</a> <a href="#" class="homepage-right-item"> <img
								src="https://64.media.tumblr.com/6c774930f60733441a43427d5f44b2a7/eebf17869bdf627f-0e/s1280x1920/a442ae0142c7683a1f307fa0dd5cbf1882cc9ad7.jpg"
								alt="">
							</a>
						</div>
					</div>

<%--					<div class="homepage-brands">--%>
<%--						<div class="homepage-brands-title">--%>
<%--							<span>THƯƠNG HIỆU SẢN PHẨM</span>--%>
<%--						</div>--%>
<%--						<div class="homepage-brands-group">--%>
<%--							<div class="homepage-brands-body">--%>
<%--								<div class="homepage-brands-group-top">--%>
<%--									<c:forEach var="brand" items="${brands}">--%>
<%--										<a href='<c:url value="/all-product-by-brand?brandId=${brand.brandId}"></c:url>' class="homepage-brands-item"> <img src='<c:url value="${brand.logo}"/>' alt="brand"></a>--%>
<%--									</c:forEach>--%>
<%--								</div>--%>
<%--								<div class="homepage-brands-group-bot">--%>
<%--									<a href="#" class="homepage-brands-item"> <img--%>
<%--										src="https://64.media.tumblr.com/99d930cdc70fb6f2aa57cce10a8e10ef/8f558b9db27c8cb7-50/s640x960/5079c2e39722f6301e58730340524ba4d6f618fc.jpg"--%>
<%--										alt=""></a>--%>
<%--									<a href="#" class="homepage-brands-item"> <img--%>
<%--										src="https://64.media.tumblr.com/98717ecce9b931f2964c1d3a60413e0e/8f558b9db27c8cb7-02/s640x960/0c94e4968feaf32a85864a2edf3830bb5a046eba.jpg"--%>
<%--										alt="">--%>
<%--									</a> <a href="#" class="homepage-brands-item"> <img--%>
<%--										src="https://64.media.tumblr.com/948379ddfda1dc7e7228676e55572f32/8f558b9db27c8cb7-ba/s640x960/9bdb5e144e3d19685930ebf8dab5a5cfc9f44a58.jpg"--%>
<%--										alt="">--%>
<%--									</a> <a href="#" class="homepage-brands-item"> <img--%>
<%--										src="https://gstatic.gearvn.com/2021/08/Sony-2.png" alt="">--%>
<%--									</a> <a href="#" class="homepage-brands-item"> <img--%>
<%--										src="https://gstatic.gearvn.com/2021/08/JBL-1.png" alt="">--%>
<%--									</a> <a href="#" class="homepage-brands-item"> <img--%>
<%--										src="https://gstatic.gearvn.com/2021/08/logitech.png" alt="">--%>
<%--									</a>--%>
<%--								</div>--%>
<%--							</div>--%>


<%--						</div>--%>
<%--					</div>--%>


				</div>
			</div>
			<!-- ------------------------------------------Sale----------------------------------- -->
			<div class="list_product">
				<div class="list_product-info sale-background">
					<div class="list_product-info-title sale-background-title">
						<img
							src="https://scontent.fsgn13-2.fna.fbcdn.net/v/t1.15752-9/245849585_1249486075570417_3169783331560524360_n.png?_nc_cat=108&ccb=1-5&_nc_sid=ae9488&_nc_ohc=n9M-Q-bZLLIAX9aqDzf&_nc_ht=scontent.fsgn13-2.fna&oh=0630424ccd68a740bd1db3688f44c696&oe=61994A8E"
							alt="">
					</div>
					<div class="list_product-info-group ">
						<div class="list_product-info-list sale-background-list ">

						</div>
					</div>
				</div>
			</div>
			<!-- ------------------------------------------Top_Sell_Phone----------------------------------- -->
			<div class="list_product">
				<div class="list_product-info">
					<div class="list_product-info-title">
						<span>ĐIỆN THOẠI NỔI BẬT NHẤT</span> <a href="">Xem tất cả</a>
					</div>
					<div class="list_product-info-group">
						<div class="list_product-info-list">
							<c:forEach var="item" items="${listProduct}">
								<a
									href='<c:url value="/product-detail?productId=${item.productId}"></c:url>'
									class="list_product-info-item">
									<img src='<c:url value="${item.imageId.imageSmall}"/>' alt="Hinh">
									<p class="list_product-info-item-name">${item.productName}</p>

									<p class="list_product-info-item-price">${item.price  } VNĐ</p>
								</a>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<!--------------------------------------------Top_New_info----------------------------------- -->
			
			
		</div>
	</div>
	<script src="<c:url value='/template/web/js/cataloghome.js'/>"></script>
</body>
</html>