<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIUser" value="/api-user"/>
<c:url var ="profile" value="/profile"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tài khoản</title>
</head>
<body>
    <!-- ------------------------------------------------------------------------------------Body-->
    <div class="content">
        <div class="content__container">
            <div class="account">
                <div class="account__left">
                    <p class=" icon active" data-choice="1" >
                        <i class="fas fa-user"></i>
                        <span>
                            Thông tin tài khoản
                        </span>
                    </p>
                    <p class="icon" data-choice="2">
                        <i class="fab fa-elementor"></i>
                        <span>
                            Quản lý đơn hàng
                        </span>
                    </p>
                    <a href="<c:url value='/logout?action=logout'/>" class="icon" data-choice="3">
                        <i class="fas fa-power-off"></i>
                        Đăng xuất
                    </a>
                </div>
                <div class="account__right">
                    <div class="account-info-container">
                        <form class="account-form show" data-form="1" id="form-profile" onsubmit="btnUpdateUser.disabled=true; return true;">
                            <p>Thông tin tài khoản</p>
                            <div class="form-group">
                                <label for="fullName">Họ và tên</label>
                                <input type="text" name="fullName" id="fullName" value="${USERMODEL.fullName}" required="required">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" name="email" id="email" value="${USERMODEL.email}" required="required" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="phone">Số điện thoại</label>
                                <input type="text" name="phone" id="phone" value="${USERMODEL.phone}" required="required">
                            </div>
                            <div class="form-group">
                                <label for="address">Địa chỉ giao hàng</label>
                                <input type="text" name="address" id="address" value="${USERMODEL.address}" required="required">
                            </div>
                            <div class="form-group">
                                <button type="button" name="btnUpdateUser" id="btnUpdateUser">Cập nhật</button>
                            </div>
                            <input type="hidden" value="${USERMODEL.userId}" id="userId" name="userId"/>
                        </form>
                        <form action="" class="account-form" data-form="2">
                            <p>Quản lý đơn hàng</p>
                            <table class="table">
                                <thead>
                                    <th style="width: 15%" >Mã đơn hàng</th>
									<th style="width: 15%" >Ngày mua</th>
                                    <th style="width: 35%" >Sản phẩm</th>
                                    <th style="width: 20%" >Tổng tiền</th>
                                    <th style="width: 15%" >Trạng thái</th>
                                </thead>
                                <tbody>
                                	<c:forEach var="order" items="${listOrder}">
                                		<tr>
                                        <td>${order.orderId}</td>
                                        <td>${order.orderDate}</td>
                                        <td>
	                                       <c:forEach var="orderDetail" items="${listOrderDetail}">
	                                        	<c:if test="${orderDetail.orderId.orderId == order.orderId && order.userId.userId == USERMODEL.userId}">	                                        		                                       			
                                       				x${orderDetail.quantity} - ${orderDetail.productId.productName} <br>                                       				                                        			                                        		
	                                        	</c:if>	                                       			                                       		
	                                        </c:forEach>
                                        </td>
                                        <td>${order.total} VNĐ</td>
                                        <td class="status" >${order.status}</td>
                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<script src="<c:url value='/template/web/js/account.js'/>"></script>
<script>
	$('#btnUpdateUser').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    console.log("aa");
	    var formData = $('#form-profile').serializeArray();
	    $.each(formData, function (i, v) {
	        data[""+v.name+""] = v.value;
	    });
	    updateUser(data);
	    
	});
    function updateUser(data) {
        $.ajax({
            url: '${APIUser}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${profile}";
            },
            error: function (error) {
            	window.location.href = "${profile}";
            }
        });
    }
</script>
</body>
</html>