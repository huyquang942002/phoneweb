<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sản phẩm</title>
</head>
<body>
	<div class="content">
		<div class="content__container">
			<div class="main">
				<div class="homepage">
					<!-- <div class="homepage-image">
						<div class="homepage-left">
							<i class="fas fa-chevron-left homepage-left-icon-back"></i> <a
								href="#" class="homepage-left-item"> <img
								src="https://64.media.tumblr.com/61202e7924136b19331383346dc414b6/eebf17869bdf627f-39/s1280x1920/06bdd4c4221c59e799c474751c4e11ce12b52ac5.jpg"
								alt="" class="homepage-left-img">
							</a href="#"> <i class="fas fa-chevron-right homepage-left-icon-next"></i>
						</div>
						<div class="homepage-right">
							<a href="#" class="homepage-right-item"> <img
								src="https://64.media.tumblr.com/248d8ff8c086daf23eafd3c9b3f63686/eebf17869bdf627f-65/s1280x1920/19b587c0b3811187743185164f0ba9331e359098.jpg"
								alt="">
							</a href="#"> <a href="#" class="homepage-right-item"> <img
								src="https://64.media.tumblr.com/6c774930f60733441a43427d5f44b2a7/eebf17869bdf627f-0e/s1280x1920/a442ae0142c7683a1f307fa0dd5cbf1882cc9ad7.jpg"
								alt="">
						</div>
					</div> -->
					<div class="homepage-brands">
						<div class="homepage-brands-title">
							<span style="color:black;">THƯƠNG HIỆU SẢN PHẨM</span>
						</div>
						<div class="homepage-brands-group">
							<div class="homepage-brands-body">
								<div class="homepage-brands-group-top">
									<c:forEach var="brand" items="${brands}">
										<a
											href='<c:url value="/all-product-by-brand?brandId=${brand.brandId}"></c:url>'
											class="homepage-brands-item"> <img
											src='<c:url value="images/imageBrand/${brand.logo}"/>'
											alt="brand"></a>
									</c:forEach>
									
								</div>
								<div class="homepage-brands-group-bot">
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- ------------------------------------------All Product----------------------------------- -->
			<div class="list_product">
				<div class="list_product-info">
					<div class="list_product-info-title">
						<span>TẤT CẢ SẢN PHẨM </span>
						<p>Xếp theo: Nổi bật</p>
					</div>
					<div class="list_product-info-group">
						<div class="list_product-info-list">
							<c:forEach var="item" items="${products}">
								<a
									href='<c:url value="/product-detail?productId=${item.productId}"></c:url>'
									class="list_product-info-item"> <img
									src='<c:url value="images/imageProduct/${item.imageId.imageSmall}"/>'
									alt="Hinh">
									<div class="list_product-info-inf">
										<p class="list_product-info-item-name">${item.productName}</p>
										<p class="list_product-info-item-price">${item.price}VNĐ</p>
									</div>
								</a>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value='/template/web/js/product.js'/>"></script>
</body>
</html>