//--HomePageImage-Left---Next,Back
const homePageImage = document.querySelector(".homepage-left-img");
const homePageImageNext = document.querySelector(".homepage-left-icon-next")
const homePageImageBack = document.querySelector(".homepage-left-icon-back")
const arraySrc = ["https://64.media.tumblr.com/61202e7924136b19331383346dc414b6/eebf17869bdf627f-39/s1280x1920/06bdd4c4221c59e799c474751c4e11ce12b52ac5.jpg", "https://64.media.tumblr.com/248d8ff8c086daf23eafd3c9b3f63686/eebf17869bdf627f-65/s1280x1920/19b587c0b3811187743185164f0ba9331e359098.jpg", "https://64.media.tumblr.com/6c774930f60733441a43427d5f44b2a7/eebf17869bdf627f-0e/s1280x1920/a442ae0142c7683a1f307fa0dd5cbf1882cc9ad7.jpg"]
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