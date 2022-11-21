//--HomePageImage-Left---Next,Back
const homePageImage = document.querySelector(".homepage-left-img");
const homePageImageNext = document.querySelector(".homepage-left-icon-next")
const homePageImageBack = document.querySelector(".homepage-left-icon-back")
const arraySrc = ["https://tintuc.dienthoaigiakho.vn/wp-content/uploads/2020/11/banner-tin-tuc-1200x628-1.jpg","https://hoanghamobile.com/tin-tuc/wp-content/uploads/2017/10/tai-ve-hinh-nen-macos-chat-luong.jpg","https://storage.oxii.vn/Cache/Sites/OXII/Storage/Images/2022/9/7/1200x628/nhung-dieu-dang-mong-doi-tai-su-kien-apple-rang-sang-mai-5.png"]
homePageImageNext.addEventListener("click",handleNextSrc);
let countSrc = 0;
function handleNextSrc(event) {
    countSrc = countSrc + 1;
    if(countSrc > 2){
        countSrc = 0;
    }
    homePageImage.setAttribute("src",arraySrc[countSrc]);
    
}
homePageImageBack.addEventListener("click",handleBackSrc);
function handleBackSrc(event) {
    countSrc = countSrc - 1;
    if(countSrc < 0){
        countSrc = 2;
    }
    homePageImage.setAttribute("src",arraySrc[countSrc]);
    
}

const timer = setInterval(function(){
    handleNextSrc();
},5500);