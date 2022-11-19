const catalog = document.querySelector(".catalog-title");
catalog.addEventListener("click",function(event){
    const catalogGroup = document.querySelector(".catalog-group");
    catalogGroup.classList.toggle("open");
});
document.body.addEventListener("click",function(event){
    const catalogGroup = document.querySelector(".catalog-group");
    if(!catalogGroup.contains(event.target) && !event.target.matches(".catalog-title")){
        catalogGroup.classList.remove("open");
    }
});