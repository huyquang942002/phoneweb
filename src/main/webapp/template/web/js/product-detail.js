
const btnBuy = document.querySelector(".single__product-infor-btn");
btnBuy.addEventListener("click", handleUpdateCart);
function handleUpdateCart(event) {
	
	$(document).click("submit", "#formAddToCart", function(event) {
		event.preventDefault();
	})
	window.alert("Đã thêm vào giỏ hàng");
	
};
