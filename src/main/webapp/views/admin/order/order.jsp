<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIAdminOrder" value="/api-admin-order" />
<c:url var="OrderURL" value="/admin-order" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content home-page">
				<div class="ace-settings-container" id="ace-settings-container">
					<div class="ace-settings-box clearfix" id="ace-settings-box">
					</div>
				</div>

				<div
					style="font-family: Arial, Helvetica, sans-serif; font-size: 2rem"
					class="page-header">ĐƠN HÀNG</div>
				<div class="container__right-order ">				
					<c:if test="${not empty messageResponse}">
						<div class="alert alert-${alert}">${messageResponse}</div>
					</c:if>
					<form class="form filter" action='<c:url value="/admin-order"/>' method="get">					
						<input type="hidden" name="type" value="filter">
						<div class="form-item select-filter">
							<select id="status" name="status">
								<option value="2">All Order</option>
								<option value="0">By Processing Order</option>
								<option value="1">By Completed Order</option>
							</select>
						</div>
						<button value="Add" type="submit">Lọc</button>  
					</form>

					<div class="container__right-content">
						<table style="font-family: Arial, Helvetica, sans-serif;"
							class="table">
							<thead>
								<th style="width: 5%">ID</th>
								<th style="width: 10%">Order day</th>
								<th style="width: 8%">Customer ID</th>
								<th style="width: 15%">Customer Name</th>
								<th style="width: 15%">Product</th>
								<th style="width: 17%">Address</th>
								<th style="width: 10%">Total</th>
								<th style="width: 10%">Status</th>
								<th style="width: 10%">Action</th>
							</thead>
							<tbody>
								<c:forEach var="item" items="${model}">
									<tr>
										<td>${item.orderId}</td>
										<td>${item.orderDate}</td>
										<td>${item.userId.userId}</td>
										<td>${item.userId.fullName}</td>
										<td><c:forEach var="orderDetail" items="${OrderDetail}">
												<c:if test="${orderDetail.orderId.orderId == item.orderId}">
													<span>x${orderDetail.quantity} -
														${orderDetail.productId.productName}</span>
													<br>
												</c:if>
											</c:forEach></td>
										<td>${item.address}</td>
										<td>${item.total}Đ</td>
										<td class="status">${item.status}</td>
										<td><a
											href='<c:url value="/admin-order?type=edit&orderId=${item.orderId}"/>'><i
												id="edit-order" style="color: #438eb9;"
												class=" icon fas fa-edit"></i></a> <a id="btnDeleteOrder"
											data-id="${item.orderId}" type="button"
											style="pointer-events: all;"> <i style="color: red;"
												class=" icon fas fa-trash-alt"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value='/template/web/js/account.js'/>"></script>
	<script>
	const btnDeleteOrder = document.querySelectorAll(`#btnDeleteOrder`);
	btnDeleteOrder.forEach((item) => item.addEventListener("click", function(e) {
		e.preventDefault();
		const orderId = item.dataset.id;
	    var data = {};
		data['orderId'] = orderId;
		deleteOrder(data);
	}))
	function deleteOrder(data) {
        $.ajax({
            url: '${APIAdminOrder}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
            	window.location.href = "${OrderURL}?type=list&message=delete_success";
            },
            error: function (error) {
            	window.location.href = "${OrderURL}?type=list&message=error_system";
            }
        });
    }
</script>
</body>
</html>