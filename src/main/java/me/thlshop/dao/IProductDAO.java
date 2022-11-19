package me.thlshop.dao;

import java.util.List;

import me.thlshop.entity.ProductEntity;

public interface IProductDAO {
	List<ProductEntity> findAll();
	ProductEntity findOne(Integer productId);
	List<ProductEntity> findByBrand(Integer brandId);
	void update(ProductEntity productEntity);
	Integer insert(ProductEntity productEntity);
	void delete(Integer productId);
	List<ProductEntity> search(String keyWord);
	List<ProductEntity> findByCategory(Integer categoryId);
	List<ProductEntity> findProductOutstanding();
	Long productNumber();
}
