<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>
	<div class="content single__product-container">
		<div class="content__container  ">
			<div class="single__product-wrapper">
				<div class="single__product-name">
					<p>${product.productName}</p>
				</div>
				<div class="single__product-infor">
					<div class="single__product-infor-left">
						<div class="single__product-infor-img">
							<img src='<c:url value="images/imageProduct/${product.imageId.imageBig}"/>' alt="hinh">
						</div>
					</div>
					<div class="single__product-infor-right">
						<div class="single__product-infor-price">${product.price} VNĐ</div>
						<div class="single__product-infor-color">
							<div class="single__product-infor-color-item active">
								<img
									src="https://images.fpt.shop/unsafe/fit-in/40x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/7/8/637613348978844164_oppo-reno6z-xanh-3.jpg"
									alt="">
								<p class="">Bạc</p>
							</div>
							<div class="single__product-infor-color-item">
								<img
									src="https://images.fpt.shop/unsafe/fit-in/40x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/7/8/637613328718698492_oppo-reno6z-den-3.jpg"
									alt="">
								<p class="">Đen</p>
							</div>
						</div>
						<div class="single__product-infor-boxpromo">
							<div class="title">Nhận ngay khuyến mãi đặc biệt</div>
							<ul class="single__product-infor-boxpromo-list">
								<li><i class="fas fa-check"></i> <span>Bảo hành 2
										năm</span></li>
								<li><i class="fas fa-check"></i> <span>Tặng PMH
										200.000đ</span></li>
								<li><i class="fas fa-check"></i> <span>Giảm đến
										300.000đ khi mua bảo hành (rơi vỡ + vào nước) kèm máy</span></li>
								<li><i class="fas fa-check"></i> <span>Giảm ngay
										120.000đ vòng đeo tay thông minh Oppo Band khi mua kèm ĐTDĐ
										Oppo</span></li>
							</ul>
						</div>
						<div class="single__product-infor-btn">
								<form id="formAddToCart" action="<c:url value='/cart'></c:url>" method="post">
									<input type="hidden" name="productId" value="${product.productId}">
									<input type="hidden" name="quantity" value= "1">
									<button type="submit">
										<i class="fas fa-cart-arrow-down"></i>
										<p>Mua hàng</p>
									</button>
								</form>
						</div>

					</div>
				</div>
			</div>

			<div class="single__product-content">
				<div class="single__product-content-left">
					<div class="single__product-content-detail">
						<div class="text-detail">
							<div class="text-detail-title">
								<h3>Đánh giá chi tiết :</h3>
								<span>${product.productName}</span>
							</div>
							<p>${product.description}</p>
						</div>
					</div>
				</div>
				<div class="single__product-content-right">
					<div class="tableparameter">
						<h3>Thông số kỹ thuật</h3>
						<ul>
							<li><span class="label">Màn hình</span> <span class="value">${product.infoId.screen}</span></li>
							<li><span class="label">Camera sau</span> <span
								class="value">${product.infoId.camera}</span></li>
							<li><span class="label">Camera Selfie</span> <span
								class="value">${product.infoId.cameraSelfie}</span></li>
							<li><span class="label">RAM</span> <span class="value">${product.infoId.ram}</span></li>
							<li><span class="label">Bộ nhớ trong</span> <span
								class="value">${product.infoId.memory}</span></li>
							<li><span class="label">CPU</span> <span class="value">${product.infoId.cpu}</span></li>
							<li><span class="label">GPU</span> <span class="value">${product.infoId.gpu}</span></li>
							<li><span class="label">Dung lượng pin</span> <span
								class="value">${product.infoId.cell}</span></li>
							<li><span class="label">Thẻ sim</span> <span class="value">${product.infoId.sim}</span></li>
							<li><span class="label">Hệ điều hành</span> <span
								class="value">${product.infoId.os}</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value='/template/web/js/product-detail.js'/>"></script>
</body>
</html>