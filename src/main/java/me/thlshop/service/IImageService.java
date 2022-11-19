package me.thlshop.service;

import java.util.List;

import me.thlshop.entity.ImageEntity;

public interface IImageService {
	List<ImageEntity> findAll();
	ImageEntity findOne(Integer imageId);
	Integer save(ImageEntity imageEntity);
	void update(ImageEntity imageEntity);
	void delete(Integer imageId);
}
