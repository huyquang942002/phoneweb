<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thanh Toán</title>

</head>
<body>
	<div class="content">
		<div class="content__container">
			<div class="payment__content">
				<form onsubmit="buttonName.disabled=true; return true;" action='<c:url value="/payment"></c:url>' method="post" class="payment__content-left">
					<div class="payment__content-methods">
						<h3>Chọn phương thức thanh toán</h3>
						<div class="payment-form-methods">
							<div class="payment-form-methods-item">
								<input type="radio" name="payment-methods" id="cod"> <label
									for="cod"> <img
									src="https://beta.gearvn.com/wp-content/themes/gearvn-electro-child-v1/assets/images/payments/icon-payment-method-cod.svg"
									alt=""> Trả tiền mặc khi nhận hàng
								</label>
							</div>
							<div class="payment-form-methods-item">
								<input type="radio" name="payment-methods" id="atm"> <label
									for="atm"> <img
									src="https://beta.gearvn.com/wp-content/themes/gearvn-electro-child-v1/assets/images/payments/icon-payment-method-atm.svg"
									alt=""> Thẻ ATM nội địa/Internet Banking
								</label>
							</div>
						</div>
					</div>
					<div class="payment__content-address">
						<h3>Thông tin địa chỉ giao hàng</h3>
						<div class="payment-form-address">
							<div class="address">
								<div class="address-item">
									<label for="address-name">Họ và tên</label> 
									<input type="text" id="address-name" name="fullName" value='<c:out value="${USERMODEL.fullName}"></c:out>' required>
								</div>
								<div class="address-item">
									<label for="address-phone">Số điện thoại</label> 
										<input type="text" id="address-phone" name="phone" value='<c:out value="${USERMODEL.phone}"></c:out>' required>
								</div>
								<div class="address-item">
									<label for="address-email">Địa chỉ email</label> 
									<input type="email" id="address-email" name="email" value='<c:out value="${USERMODEL.email}"></c:out>' required>
								</div>
								<div class="address-item">
									<label for="address-inf">Địa chỉ nhận hàng</label> 
									<input type="text" id="address-inf" name="address" value='<c:out value="${USERMODEL.address}"></c:out>' required>
								</div>
							</div>
						</div>
					</div>
					<div class="payment__content-btn">
						<button type="submit" name="buttonName">Đặt hàng</button>
					</div>
				</form>
				<div class="payment__content-right">
					<div class="payment-form-order">
						<div class="payment-form-order-head">
							<p>Giỏ hàng</p>
							<a href='<c:url value="/cart"></c:url>'><button>Sửa</button></a>

						</div>
						<div class="payment-form-order-group">
							<c:forEach var="item" items="${cart.cartDetails}">
								<div class="payment-form-order-item">
									<span class="product-item"> <span>x${item.quantity}</span> <a
										href="#">${item.product.productName}</a>
									</span> <span class="product-price">${item.getTotal()} VNĐ</span>
								</div>
							</c:forEach>
						</div>
						<div class="payment-form-order-foot">
							<div class="order-totals">
								<div class="order-totals-line">
									<p>Tạm tính :</p>
									<span>${totalSum}</span>
								</div>
								<div class="order-totals-line">
									<p>Phí vận chuyển :</p>
									<span>0 VNĐ</span>
								</div>
								<div class="order-totals-line total ">
									<p>Tổng cộng :</p>
									<span>${totalSum} VNĐ</span>
								</div>
							</div>
						</div>

					</div>

				</div>
			</div>

		</div>
	</div>
</body>
</html>