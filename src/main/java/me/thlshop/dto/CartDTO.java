package me.thlshop.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
	private List<CartDetailDTO> cartDetails;

	public CartDTO() {
		cartDetails = new ArrayList<CartDetailDTO>();
	}

	public List<CartDetailDTO> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetailDTO> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public void addItem(CartDetailDTO cartDetail) {
		cartDetails.add(cartDetail);
	}
	public void addProduct(CartDetailDTO cartDetail) {
		Boolean flag = false;
		for(CartDetailDTO prod: cartDetails) {
			if(prod.getProduct().getProductId().equals(cartDetail.getProduct().getProductId())) {
				prod.setQuantity(prod.getQuantity()+1);
				flag = true;
			}
		}
		if (flag) {

		} else {
			cartDetails.add(cartDetail);
		}
	}
	public void editQuantity(CartDetailDTO cartDetail) {
		for(CartDetailDTO prod: cartDetails) {
			if(prod.getProduct().getProductId().equals(cartDetail.getProduct().getProductId())) {
				prod.setQuantity(cartDetail.getQuantity());
			}
		}
	}

	public void deleteProduct(Integer productId) {
		for(CartDetailDTO prod: cartDetails) {
			if(prod.getProduct().getProductId().equals(productId)) {
				cartDetails.remove(prod);
				return;
			}
		}
	}

	public Long getSumTotal() {
		Long sum = 0L;
		for(CartDetailDTO prod: cartDetails) {
			sum += prod.getTotal();
		}
		return sum;
	}
	
	public Integer getSumQuantity() {
		Integer sum = 0;
		for(CartDetailDTO prod: cartDetails) {
			sum += prod.getQuantity();
		}
		return sum;
	}
}
