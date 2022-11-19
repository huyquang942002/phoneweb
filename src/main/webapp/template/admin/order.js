

const editOrder = document.querySelector("#edit-order")

editOrder.addEventListener("click",function(event){
    const form = document.querySelector(".form__wapper-order-edit");
    form.classList.add("active");
    const exit = document.querySelector("#exit-order");
    exit.addEventListener("click",function(event){
        form.classList.remove("active");
   })
})
