package me.thlshop.service;

import java.util.List;

import me.thlshop.entity.RoleEntity;

public interface IRoleService {
	List<RoleEntity> findAll();
	RoleEntity findOne(Integer roleId);
}
