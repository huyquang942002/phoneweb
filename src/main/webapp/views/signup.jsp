<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api-user"/>
<c:url var="URLVerify" value="/verify-email"/>
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
                <form id="formSubmit" class="form form-singup">                    
                    <div class="form__title">Đăng ký</div>
                    <div class="form__group">
                        <div class="form__item">
                            <label for="name">Họ và tên</label>
                            <input type="text" name="fullName" id="fullName" value="" class="form__input" required="required"> 
                        </div>
                        <div class="form__item">
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email" value="" class="form__input" required="required"> 
                        </div>
                        <div class="form__item">
                            <label for="phone">Phone</label>
                            <input type="text" name="phone" id="phone" value="" class="form__input" required="required"> 
                        </div>
                        <div class="form__item">
                            <label for="address">Address</label>
                            <input type="text" name="address" id="address" value="" class="form__input" required="required"> 
                        </div>
                        <div class="form__item">
                            <label for="password">Mật khẩu</label>
                            <input type="password" name="password" id="password" value="" class="form__input" required="required"> 
                        </div>
                    </div>
                    <div class="form__term">
                        <input type="checkbox" name="" id="checkbox">
                        <label for="checkbox" class="checkbox__label">
                           <p>Tôi đã đọc và đồng ý</p> <a href="#">Điều khoản dịch vụ</a> 
                            <i class="fas fa-check"></i>
                        </label>
                    </div>
                    <input type="button" class="btn__submit" value="Đăng ký" id="btnAddUser">
                    <div class="form__already">
                        <p>Đã có tài khoản ? </p>
                        <a href="<c:url value='/dang-nhap?action=login'/>" class="return-sigin">Đăng nhập</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
	$('#btnAddUser').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
	        data[""+v.name+""] = v.value;
	    });
	    addUser(data);
	    
	});
	function addUser(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	if(result == "emailExisted"){
            		window.location.href = "${dangnhap}?action=signup&message=email_existed&alert=danger";
            		
            	}else{
            		window.location.href = "${URLVerify}";
            	}
            	
            },
            error: function (error) {
            	window.location.href = "${dangnhap}?action=signup&message=singup_err&alert=danger";
            }
        });
    }/* ?action=login&message=singup_success&alert=success  
    ?action=login&message=singup_err&alert=success*/
</script>
</body>
</html>