<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="header">

    <div class="top-bar">
        <div class="top-bar__container">
            <div class="top-bar__container-wrap">
                <a href='<c:url value="/all-product-by-category?categoryId=1"></c:url>' class="top-bar__container-wrap-link">
                    <span>IPHONE</span>
                </a>
                <a href='<c:url value="/all-product-by-category?categoryId=2"></c:url>' class="top-bar__container-wrap-link">
                    <span>IPAD</span>
                </a>
                <a href='<c:url value="/all-product-by-category?categoryId=3"></c:url>' class="top-bar__container-wrap-link">
                    <span>MACBOOK</span>
                </a>
            </div>

            <div class="top-bar__container-wrap">
                <a class="top-bar-phone">
                    <i class="fas fa-headset"></i>
                    <span>Tư vấn mua hàng : 0963902964</span>
                </a>
                <a class="top-bar-phone">
                    <i class="fas fa-headset"></i>
                    <span>CSKH : 1800 9999</span>
                </a>
            </div>

        </div>
    </div>
        <div class="masthead">
        <div class="masthead__container">
            <div class="masthead__logo">  
                <a href="<c:url value='/trang-chu'/>" class="masthead__logo-text">THLShop</a>
                <i class="fas fa-bars masthead__menu-toggle"></i>
            </div>
            <div class="checkout-step">
                <div class="checkout-step-one">
                    <div class="checkout-step-name">Đăng nhập</div>
                        <div class="checkout-step-icon icon-color">
                            <p>1</p>
                        </div>
                </div>
                <div class="checkout-step-two">
                    <div class="checkout-step-name">Địa chỉ & Thanh toán</div>
                        <div class="checkout-step-icon icon-color">
                            <p>2</p>
                        </div>
                </div>
                <div class="checkout-step-three">
                    <div class="checkout-step-name">Thành công</div>
                        <div class="checkout-step-icon ">
                            <p>3</p>
                        </div>
                </div>
            </div>
            <div class="hotline">
                <div class="hotline-icon">
                    <i class="fas fa-headset"></i>
                </div>
                <div class="hotline-content">
                    <p>Hotline : 18006666</p>
                    <p>Email : huywocker92016@gmail.com</p>
                </div>
            </div>
            
            </div>
        </div>
</div> 