//.....
const header = document.querySelector(".header");


//--Menu-toggle
const menuToggle = document.querySelector(".masthead__menu-toggle");
menuToggle.addEventListener("click",handleMenuToggle);
function handleMenuToggle(event) {
    const t = `
    <div class="menu">
    <div class="menu-toggle">
    <div class="menu-toggle-list"> 
        <a href="#" class="menu-toggle-item">
            <i class="fas fa-mobile-alt"></i>
            <span class="">Điện Thoại Phổ Thông</span>
        </a href="#">
        <a href="#" class="menu-toggle-item">
            <i class="fas fa-mobile"></i>
            <span class="">Điện Thoại Flagship</span>
        </a href="#">
        <a href="#" class="menu-toggle-item">
            <i class="fas fa-gamepad"></i>
            <span class="">Điện Thoại Gaming</span>
        </a href="#">
        <a href="#" class="menu-toggle-item">
            <i class="fas fa-headphones-alt"></i>
            <span class="">Tai nghe</span>
        </a href="#">
        <a href="#" class="menu-toggle-item">
            <i class="fas fa-car-battery"></i>
            <span class="">Pin sạc dự phòng</span>
        </a href="#">
        <a href="#" class="menu-toggle-item">
            <i class="fab fa-usb"></i>
            <span class="">Sạc, cáp</span>
        </a href="#">
        </div>
    </div>
</div>`;
    
    header.insertAdjacentHTML("afterbegin",t);
}
document.body.addEventListener("click",function(event){
    if(event.target.matches(".menu")){
        event.target.parentNode.removeChild(event.target);
    }
});



























//-Sroll
// function debounceFn(func, wait, immediate) {
//     let timeout;
//     return function () {
//       let context = this,
//         args = arguments;
//       let later = function () {
//         timeout = null;
//         if (!immediate) func.apply(context, args);
//       };
//       let callNow = immediate && !timeout;
//       clearTimeout(timeout);
//       timeout = setTimeout(later, wait);
//       if (callNow) func.apply(context, args);
//     };
//   }

// const header = document.querySelector(".header");
// window.addEventListener("scroll",debounceFn(function(event){
//     const scrollY = this.window.pageYOffset;
//     if(scrollY >= 165 ){
//         header && header.classList.add("is-fixed"); 
//         document.body.classList.add("has-space")
//     } else{
//         header && header.classList.remove("is-fixed"); 
//         document.body.classList.remove("has-space")
//     }
// },100));


//-User
// const headerLogin = document.querySelector(".header__login");
// headerLogin.addEventListener("mouseenter",handleUser);
// function handleUser(event) {
//     const t = ` <div class="user">
//     <a class="user__login">
//         <span>Đăng nhập</span>
//     </a>
//     <a class="user__signup">
//         <span>Tạo tài khoản</span>
//     </a>
// </div>
// `;
// document.body.insertAdjacentHTML("afterbegin",t);
// const cords = event.target.getBoundingClientRect();
// const {top,left,width,height} = cords;
// const user = document.querySelector(".user");
// const userHeight = user.offsetHeight;
// user.style.left = `${left - (width/2)}px`;
// user.style.top = `${top + (height) + 10}px`;

// user.addEventListener("mouseleave",handleRemoveUser);
// function handleRemoveUser(event) {
//     user.parentNode.removeChild(user);
// }

// document.addEventListener("click",function(event){
//     console.log(event.target);
//         if(!user.contains(event.target) && !event.target.matches(".header__login")){
//             user.parentNode.removeChild(user);
//         }
// })
//}; 

