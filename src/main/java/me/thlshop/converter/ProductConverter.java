package me.thlshop.converter;

import me.thlshop.dto.ProductDTO;
import me.thlshop.entity.ProductEntity;

public class ProductConverter {
	public ProductEntity toEntity(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductName(productDTO.getProductName());
		productEntity.setDescription(productDTO.getDescription());
		productEntity.setPrice(productDTO.getPrice());
		return productEntity;
	}
	
	public ProductDTO toDto(ProductEntity productEntity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(productEntity.getProductId());
		productDTO.setProductName(productEntity.getProductName());
		productDTO.setCategoryId(productEntity.getCategoryId().getCategoryId());
		productDTO.setDescription(productEntity.getDescription());
		productDTO.setImageId(productEntity.getImageId().getImageId());
		productDTO.setInfoId(productEntity.getInfoId().getInfoId());
		productDTO.setPrice(productEntity.getPrice());
		return productDTO;
	}
}
