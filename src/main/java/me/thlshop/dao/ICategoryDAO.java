package me.thlshop.dao;

import java.util.List;

import me.thlshop.entity.CategoryEntity;

public interface ICategoryDAO {
	List<CategoryEntity> findAll();
	CategoryEntity findOne(Integer categoryId);
}
