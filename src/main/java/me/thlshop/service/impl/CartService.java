package me.thlshop.service.impl;

import me.thlshop.dto.CartDTO;
import me.thlshop.dto.CartDetailDTO;
import me.thlshop.dto.ProductDTO;
import me.thlshop.service.ICartService;

public class CartService implements ICartService {

	@Override
	public CartDTO addProductToCart(CartDTO cart, ProductDTO product, Integer quantity) {
		CartDetailDTO cartDetail = new CartDetailDTO();
		cartDetail.setProduct(product);
		cartDetail.setQuantity(quantity);
		if (cart == null) {
			cart = new CartDTO();
			cart.addItem(cartDetail);
		} else if (cart.getCartDetails().size() == 0) {
			cart.addItem(cartDetail);
		} else {
			cart.addProduct(cartDetail);
		}
		return cart;
	}

	@Override
	public void editQuantity(CartDTO cart, ProductDTO product, Integer quantity) {
		CartDetailDTO cartDetail = new CartDetailDTO();
		cartDetail.setProduct(product);
		cartDetail.setQuantity(quantity);
		cart.editQuantity(cartDetail);
	}

	@Override
	public void deleteFromCart(CartDTO cart, Integer productId) {
		cart.deleteProduct(productId);
	}

}
