package me.thlshop.service;

import me.thlshop.dto.InformationDTO;
import me.thlshop.dto.ProductDetailDTO;

public interface IInformationService {
	InformationDTO findOne(Integer infId);
	void update(ProductDetailDTO productDetailDTO);
	Integer save(ProductDetailDTO productDetailDTO);
}
