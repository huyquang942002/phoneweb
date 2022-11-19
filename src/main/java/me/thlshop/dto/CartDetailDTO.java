package me.thlshop.dto;

public class CartDetailDTO {
	private ProductDTO product;
	private Integer quantity;
//	private Long total;

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getTotal() {
		return product.getPrice() * quantity;
	}

}
