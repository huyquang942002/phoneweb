package me.thlshop.dao;

import java.util.List;

import me.thlshop.entity.UserEntity;

public interface IUserDAO{
	Integer insert(UserEntity userEntity);
	void update(UserEntity userEntity);
	void delete(Integer userId);
	UserEntity findOne(Integer id);
	UserEntity findByEmailPassword(String email, String password);
	List<UserEntity> findAll();
	Long customerNumber();
	List<UserEntity> findByEmail(String email);
}
