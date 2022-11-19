package me.thlshop.service;

import java.util.List;

import me.thlshop.entity.CategoryEntity;

public interface ICategoryService {
	List<CategoryEntity> findAll();
}
