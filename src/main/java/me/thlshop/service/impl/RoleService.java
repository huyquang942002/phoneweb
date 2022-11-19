package me.thlshop.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.thlshop.dao.IRoleDAO;
import me.thlshop.entity.RoleEntity;
import me.thlshop.service.IRoleService;

public class RoleService implements IRoleService{
	@Inject
	private IRoleDAO roleDAO;
	
	@Override
	public List<RoleEntity> findAll() {
		return roleDAO.findAll();
	}

	@Override
	public RoleEntity findOne(Integer roleId) {
		return roleDAO.findOne(roleId);
	}

}
