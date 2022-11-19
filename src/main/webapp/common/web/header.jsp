<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!-- ----------------------------------------------------------------------------------Header -->
<!-- ----------------------------------------------------------------------------Header-Banner-->
<div class="header">
	<!-- --------------------------------------------------------------------------Header-Top-Bar-->
	<div class="top-bar">
	    <div class="top-bar__container">
	        <a class="top-bar-phone">
	            <i class="fas fa-headset"></i>
	            <span>Tư vấn mua hàng : 1800 6666</span>
	        </a>
	        <a class="top-bar-phone">
	            <i class="fas fa-headset"></i>
	            <span>CSKH : 1800 9999</span>
	        </a>
	    </div>
	</div>
	<!-- -------------------------------------------------------------------------Header-Masthead-->
	<div class="masthead">
	    <div class="masthead__container">
	        <div class="masthead__logo">  
	            <a href="<c:url value='/trang-chu'/>" class="masthead__logo-text">THLShop</a>
	            <i class="fas fa-bars masthead__menu-toggle"></i>
	        </div>
        	<form class="masthead__find" action='<c:url value="/all-product-by-brand"></c:url>' method="get">
        		<input type="hidden" name="search" value ="true">
	        	<input type="text" name="keyWord" class="masthead__find-input" placeholder="Bạn tìm gì...">
	            <button type="submit" class="masthead__find-btn" >
	                <i class="fa fa-search"></i>
	                <span>Tìm kiếm</span>
	                <span></span>
	            </button>
        	</form>       
	        <div class="masthead__icon">
	        	<c:if test="${not empty USERMODEL}">
					<a  href="<c:url value='/profile'/>" class="masthead__login">
					<i class="fa fa-user"></i>
                    <p class="masthead__login-item">${USERMODEL.fullName}</p></a>
				</c:if>
				<c:if test="${empty USERMODEL}">
					<a href="<c:url value='/dang-nhap?action=login'/>" class="masthead__login">
		                <i class="fa fa-user"></i>
		                <p class="masthead__login-item">Tài Khoản</p>
	            	</a>
				</c:if>
	            <a href='<c:url value="/cart"></c:url>' class="masthead__cart">
	            	<c:if test="${empty sumQuantity}">
	            		<div class="number">0</div>
	            	</c:if>
	            	<c:if test="${not empty sumQuantity}">
	            		<div class="number">${sumQuantity}</div>
	            	</c:if>
	                
	                <i class="fa fa-shopping-cart"></i>
	                <p class="masthead__cart-item">Giỏ Hàng</p>
	            </a>
	        </div>
	        </div>
	    </div>
	    <div class="navbar">
	        <div class="navbar__container">
	            <div class="catalog">
	                <div class="catalog-title">
	                    <i class="fas fa-bars"></i>
	                    <span>DANH MỤC SẢN PHẨM</span>
	                </div>
	                <div class="catalog-group"> 
	                    <a href='<c:url value="/all-product-by-category?categoryId=1"></c:url>' class="catalog-item">
	                        <i class="fas fa-mobile-alt"></i>
	                        <span class="catalog-name">Điện Thoại Phổ Thông</span>
	                        <i class="fa fa-angle-right arrow" ></i>
	                    </a>
	                    <a href='<c:url value="/all-product-by-category?categoryId=2"></c:url>' class="catalog-item">
	                        <i class="fas fa-mobile"></i>
	                        <span class="catalog-name">Điện Thoại Flagship</span>
	                        <i class="fa fa-angle-right arrow"></i>
	                    </a>
	                    <a href='<c:url value="/all-product-by-category?categoryId=3"></c:url>' class="catalog-item">
	                        <i class="fas fa-gamepad"></i>
	                        <span class="catalog-name">Điện Thoại Gaming</span>
	                        <i class="fa fa-angle-right arrow"></i>
	                    </a>
	                    <!-- <a href="#" class="catalog-item">
	                        <i class="fas fa-headphones-alt"></i>
	                        <span class="catalog-name">Tai nghe</span>
	                        <i class="fa fa-angle-right arrow"></i>
	                    </a>
	                    <a href="#" class="catalog-item">
	                        <i class="fas fa-car-battery"></i>
	                        <span class="catalog-name">Pin sạc dự phòng</span>
	                        <i class="fa fa-angle-right arrow"></i>
	                    </a>
	                    <a href="#" class="catalog-item">
	                        <i class="fab fa-usb"></i>
	                        <span class="catalog-name">Sạc, cáp</span>
	                        <i class="fa fa-angle-right arrow"></i>
	                    </a> -->
	                    
	                </div>
	            </div>
	            <div class="navbar__menu">
	                <ul class="navbar__menu-group">
	                    <li class="navbar__menu-item">
	                        <a href="#">
	                            <i class="far fa-credit-card"></i>
	                            <p>Hướng dẫn thanh toán</p>
	                        </a>
	                    </li>
	                    <li class="navbar__menu-item">
	                        <a href="#">
	                        <i class="fas fa-truck-moving"></i>
	                        <p>Chính sách giao hàng</p>
	                    </a>
	                    </li>
	                    <li class="navbar__menu-item">
	                        <a href="#">
	                        <i class="fas fa-shield-alt"></i>
	                        <p>Chính sách bảo hành</p>
	                    </a>
	                    </li>
	                    <li class="navbar__menu-item">
	                        <a href="#">
	                        <i class="fas fa-tags"></i>
	                        <p>Tổng hợp khuyến mãi</p>
	                    </a>
	                    </li>
	                </ul>
	            </div>
	        </div>
	    </div>
</div>