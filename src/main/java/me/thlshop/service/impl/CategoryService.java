package me.thlshop.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.thlshop.dao.ICategoryDAO;
import me.thlshop.entity.CategoryEntity;
import me.thlshop.service.ICategoryService;

public class CategoryService implements ICategoryService{

	@Inject
	private ICategoryDAO categoryDAO;
	@Override
	public List<CategoryEntity> findAll() {
		return categoryDAO.findAll();
	}

}
