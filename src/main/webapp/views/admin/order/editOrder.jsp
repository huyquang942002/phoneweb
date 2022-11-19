<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIAdminOrder" value="/api-admin-order"/>
<c:url var ="OrderURL" value="/admin-order"/>
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

            <div style="font-family: Arial, Helvetica, sans-serif; font-size :2rem" class="page-header">           
                   ĐƠN HÀNG           
            </div>
            <div class="container__right-order " >
            	<c:if test="${not empty messageResponse}">
					<div class="alert alert-${alert}">
								${messageResponse}
					</div>
				</c:if>
				<c:if test="${not empty orderDetail}">
					<p>* Order of customer ID: ${orderDetail[0].orderId.userId.userId} 
					- FullName: ${orderDetail[0].orderId.userId.fullName}</p>
					<p>* Delivery Address: ${orderDetail[0].orderId.address}</p>
					<p>* Total: ${orderDetail[0].orderId.total} VNĐ</p>
				</c:if>
				<p>Order Detail</p>
                <div class="container__right-content">
                 <table style="font-family: Arial, Helvetica, sans-serif;" class="table">
                     <thead>
                         <th style="width: 20%" >Product ID</th>
                         <th style="width: 30%" >Product Name</th>
                         <th style="width: 20%" >Quantity</th>
                         <th style="width: 30%" >Price</th>                        
                     </thead>
                     <tbody>
                     <c:forEach var="item" items="${orderDetail}">
                         <tr>
                             <td>${item.productId.productId}</td>
                             <td>${item.productId.productName}</td>
                             <td>${item.quantity}</td>
                             <td>${item.price} VNĐ</td>                                                      
                         </tr>
                       </c:forEach>	
                     </tbody>
                 </table>
                 <div class="form-item btn-status">
                    	<c:if test="${not empty orderDetail}">
                        	<button class="form-btn" type="button" value="Update" id="btnUpdateOrder">Update</button>                     
                        </c:if>
                    </div>
                 <div class="form-item select-status">
                       <select id="status" name="status">
                           <c:if test="${empty orderDetail}">
                             	<option>Choose one</option>						     								
								<option value="1">Chờ xử lý</option>
								<option value="2">Đặt hàng thành công</option>												
                              </c:if>
                              
                              <c:if test="${not empty orderDetail}">                                    	
						        <option value="${orderDetail[0].orderId.status}">
						        	<c:if test="${orderDetail[0].orderId.status == 1}">Đặt hàng thành công</c:if>
						        	<c:if test="${orderDetail[0].orderId.status == 0}">Chờ xử lý</c:if>
						        </option>
						        <c:if test="${orderDetail[0].orderId.status == 1}">								
									<option value="0">Chờ xử lý</option>
								</c:if>
								<c:if test="${orderDetail[0].orderId.status == 0}">								
									<option value="1">Đặt hàng thành công</option>
								</c:if>						        													
                             </c:if>
                             
                       </select>
                   </div>
                   
                                   
                    <input type="hidden" value="${orderDetail[0].orderId.orderId}" id="orderId" name="orderId"/>           
            </div>
        </div>
        			
    </div>
   </div>
   
<script>
	$('#btnUpdateOrder').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    data['orderId'] = $('#orderId').val();
	    data['status'] = $('#status').val();
	    /* data['address'] = $('#address').val();
	    data['orderDate'] = $('#orderDate').val();
	    data['phone'] = $('#phone').val();
	    data['total'] = $('#total').val();
	    data['userId'] = $('#userId').val(); */
	    if (orderId != "") {
	        updateOrder(data);
	    }
	    
	});
    function updateOrder(data) {
        $.ajax({
            url: '${APIAdminOrder}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${OrderURL}?type=edit&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${OrderURL}?type=list&message=error_system";
            }
        });
    }
</script>
</body>
</html>