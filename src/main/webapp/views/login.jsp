<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
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
                <form class="form" action="<c:url value='/dang-nhap'/>" method="post">
                    <input type="hidden" name="action" value="login">
                    <div class="form__title">Đăng Nhập</div>
                    <div class="form__group form__group-signin">
                        <div class="form__item">
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email" class="form__input" > 
                        </div>
                        <div class="form__item">
                            <label for="password">Mật khẩu</label>
                            <input type="password" name="password" id="password" class="form__input" > 
                        </div>
                    </div>
                    <div class="form__term">
                        <input type="checkbox" name="" id="checkbox">
                        <label for="checkbox" class="checkbox__label">
                            Nhớ mật khẩu 
                            <i class="fas fa-check"></i>
                        </label>
                    </div>
                    <button type="submit" class="btn__submit btn__submit-signin">
                        Đăng Nhập
                    </button>
                    <div class="form__already">
                        <p>Chưa có tài khoản ? </p>
                        <a href="<c:url value='/dang-ky?action=signup'/>" class="signup">Đăng ký</a>
                    </div>
                </form> 
            </div>
        </div>
    </div>
</div>

</body>
</html>