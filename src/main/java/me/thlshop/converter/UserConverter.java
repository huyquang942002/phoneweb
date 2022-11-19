package me.thlshop.converter;

import me.thlshop.dto.UserDTO;
import me.thlshop.entity.UserEntity;

public class UserConverter {
	public UserEntity toEntity(UserEntity userEntity, UserDTO userDTO) {
		if(userDTO.getUserId() != null) {
			userEntity.setUserId(userDTO.getUserId());
		}
		if(userDTO.getFullName() != null) {
			userEntity.setFullName(userDTO.getFullName());
		}
		if(userDTO.getEmail() != null) {
			userEntity.setEmail(userDTO.getEmail());
		}
		if(userDTO.getAddress() != null) {
			userEntity.setAddress(userDTO.getAddress());		
		}
		if(userDTO.getPassword() != null) {
			userEntity.setPassword(userDTO.getPassword());
		}
		if(userDTO.getPhone() != null) {
			userEntity.setPhone(userDTO.getPhone());
		}
		return userEntity;
	}

	public UserDTO toDto(UserEntity userEntity) {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(userEntity.getUserId());
		userDto.setFullName(userEntity.getFullName());
		userDto.setEmail(userEntity.getEmail());
		userDto.setAddress(userEntity.getAddress());
		userDto.setPassword(userEntity.getPassword());
		userDto.setPhone(userEntity.getPhone());
		userDto.setRoleId(userEntity.getRole().getRoleId());
		return userDto;
	}
}
