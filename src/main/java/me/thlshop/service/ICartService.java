package me.thlshop.service;

import me.thlshop.dto.CartDTO;
import me.thlshop.dto.ProductDTO;

public interface ICartService {
	CartDTO addProductToCart(CartDTO cart, ProductDTO product, Integer quantity);
	void editQuantity(CartDTO cart, ProductDTO product, Integer quantity);
	void deleteFromCart(CartDTO cart, Integer productId);
}
