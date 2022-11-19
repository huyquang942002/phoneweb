package me.thlshop.service;

import java.util.List;

import me.thlshop.dto.UserDTO;
import me.thlshop.entity.UserEntity;

public interface IUserService {
	UserEntity findByEmailPassword(String email, String password);
	UserEntity save(UserDTO userDTO);
	void update(UserDTO userDTO);
	void delete(Integer userId);
	UserEntity findOne(Integer userId);
	List<UserEntity> findAll();
	Long customerNumber();
	List<UserEntity> findByEmail(String email);
}
