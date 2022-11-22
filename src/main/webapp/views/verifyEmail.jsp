<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api-user"/>
<c:url var ="dangnhap" value="/trang-chu"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>
</head>
<body>
<div class="body">
    <div class="content">
        <div class="content__container">
        	<c:if test="${not empty message}">
				<div class="alert alert-${alert}">
		  			<strong>${message}</strong>
				</div>
			</c:if>
            <div class="signin">
               <form action='<c:url value="/verify-email" />' class="form form-singup" method="post">
               		<div class="form__title">Xác nhận Email</div>
               		<div class="form__group">
	               		<div class="form__item">
	                        <label for="codeVerifyEmail">Nhập mã code đã gửi vào email của bạn: Bao gồm 6 số</label>
	                        <input type="number" name="codeVerifyEmail" id="codeVerifyEmail" class="form__input" required="required"> 
	                    </div>
                    </div>
                    <input type="submit" class="btn__submit" value="Xác nhận">
               </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>