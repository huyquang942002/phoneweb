<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanks</title>
</head>
<body>
    <script>
        const checkOut = document.querySelector(".checkout-step");
checkOut.classList.add("thank-bar");
const iconColor = document.querySelectorAll(".checkout-step-icon");
[...iconColor][2].classList.add("icon-color");
    </script>
    <div class="content single__product-container">
        <div class="content__container  ">
            <div class="thank">
                <div class="thank__content">
                    <h3>ĐẶT HÀNG THÀNH CÔNG</h3>
                    <div style="margin-bottom: 2rem;" class="thank__img">
                        <img  src="https://scontent.fsgn2-4.fna.fbcdn.net/v/t1.15752-9/255039166_604229364348215_210144821470031028_n.png?_nc_cat=101&ccb=1-5&_nc_sid=ae9488&_nc_ohc=NcVuv4llrdIAX8QbmBI&tn=5q8TAZohD0lQzUbg&_nc_ht=scontent.fsgn2-4.fna&oh=879195a1794644678291d0d92a9d067b&oe=61AFCD3D" alt="">
                    </div>
                    <p>Cám ơn khách hàng đã cho chúng tôi cơ hội được phục vụ</p>
                    <p style="margin-bottom: 1rem;">Nhân viên THLShop sẽ liên hệ cho Quý Khách để xác nhận đơn hàng</p>
                    <p style="font-size: 1.4rem;" >Mọi thắc mắc vui lòng liên hệ 18006666 hoặc 18009999</p>
                </div>
                <a href="<c:url value='/trang-chu'/>" class="thank__btn">
                    <p>TIẾP TỤC MUA HÀNG</p>
                </a>
            </div>
    </div>
    </div>
</body>
</html>