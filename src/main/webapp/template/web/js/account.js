const icon = document.querySelectorAll(".icon");
const form = document.querySelectorAll(".account-form");
[...icon].forEach((item) => item.addEventListener("click",function(e){
    [...icon].forEach(item => item.classList.remove("active"));
    [...form].forEach(item => item.classList.remove("show"));
    e.target.classList.add("active");
    const data = e.target.dataset.choice;
    if(data == 2){
       [...form][1].classList.add("show");
   }
   else if(data == 1){
       [...form][0].classList.add("show");
   }
}))


const status = document.querySelectorAll(".status");
[...status].forEach((item) => {
    let text = item.textContent;
    console.log(text);
    if(text === "1"){
        item.textContent = "Thành công";
        item.classList.add("success");
    }
    if(text === "0"){
        item.textContent = "Đang xử lý";
        item.classList.add("processing");
    }
    if(text === "2"){
        item.textContent = "Thất bại";
        item.classList.add("failed");
    }
})
