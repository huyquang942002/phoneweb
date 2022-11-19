package me.thlshop.dao;

import java.util.List;

import me.thlshop.entity.RoleEntity;

public interface IRoleDAO {
	List<RoleEntity> findAll();
	RoleEntity findOne(Integer roleId);
}
