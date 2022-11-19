<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Giỏ Hàng</title>
</head>
<body>
	<!-- ------------------------------------------------------------------------------------Body-->
	<div class="content">
		<div class="content__container">
			<div class="cart">

				<p class="cart__title">GIỎ HÀNG</p>

				<div class="cart__form">
					<input type="hidden" name="" value="">
					<div class="cart__product">
						<c:forEach var="item" items="${cart.cartDetails}">
							<div class="cart__product-item">
								<div class="cart__product-thumbnail">
									<c:forEach var="img" items="${listImage}">
										<c:if test="${img.imageId == item.product.imageId}">
											<a href='<c:url value="/product-detail?productId=${item.product.productId}"></c:url>'> 
												<img src='<c:url value="images/imageProduct/${img.imageSmall}"/>' alt="Hinh">
											</a>
										</c:if>
									</c:forEach>									
								</div>
								<div class="cart__product-name">
									<a href="#">${item.product.productName}</a>
								</div>
								<div class="cart__product-price">
									<span>${item.getTotal()} VNĐ</span>
								</div>

								<div class="cart__product-quanlity">
									<div class="quanlity">
										<form action='<c:url value="/cart"></c:url>' method="post">
											<input type="hidden" name="action" value="editQuantity">
											<input type="hidden" name="productId"
												value="${item.product.productId}"> <input
												type="number" name="quantity" min="1"
												value='<c:out value="${item.quantity}"></c:out>'>
											<button type="submit">
												<i class="fas fa-sync-alt"></i>
											</button>
										</form>
									</div>
								</div>

								<div class="cart__product-delete">
									<form action='<c:url value="/cart"></c:url>' method="post">
										<input type="hidden" name="action" value="deleteProduct">
										<input type="hidden" name="quantity" value="${item.quantity}">
										<input type="hidden" name="productId"
											value="${item.product.productId}">
										<button>
											<i class="far fa-trash-alt"></i>
										</button>
									</form>
								</div>
							</div>
						</c:forEach>
					</div>

					<div class="cart__info">
						<div class="cart-coupon">
							<label for="coupon_code">Mã khuyến mãi</label> <input type="text"
								name="" class="input-text" id="coupon_code">
							<button type="submit" name="" value="Áp dụng">Áp dụng</button>
						</div>
						<div class="cart-collaterals">
							<div class="cart_totals">
								<table class="cart_totals-table">
									<tbody>
										<tr class="cart-subtotal">
											<th>Tạm Tính</th>
											<td>${totalSum} VND</td>
										</tr>
										<tr class="order-total">
											<th>Tổng</th>
											<td>${totalSum}  VND</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="cart-btn">
							<button type="submit" class="button"></button>
							<div class="btn-payment">
								<c:if test="${sumQuantity > 0}">
									<a href="<c:url value='/payment'></c:url>">Tiến hành thanh toán</a>
								</c:if>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>