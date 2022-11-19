package me.thlshop.service.impl;

import javax.inject.Inject;

import me.thlshop.converter.InformationConverter;
import me.thlshop.dao.IInformationDAO;
import me.thlshop.dto.InformationDTO;
import me.thlshop.dto.ProductDetailDTO;
import me.thlshop.entity.InformationEntity;
import me.thlshop.service.IInformationService;

public class InformationService implements IInformationService{

	@Inject
	private IInformationDAO informationDAO;
	
	@Inject
	private InformationConverter informationConverter;
	
	@Override
	public InformationDTO findOne(Integer infId) {
		InformationEntity inEntity = informationDAO.findOne(infId);
		return informationConverter.toDto(inEntity);
	}

	@Override
	public void update(ProductDetailDTO productDetailDTO) {
		InformationEntity inEntity = new InformationEntity();
		inEntity.setInfoId(productDetailDTO.getInfoId());
		inEntity.setScreen(productDetailDTO.getScreen());
		inEntity.setCameraSelfie(productDetailDTO.getCameraSelfie());
		inEntity.setRam(productDetailDTO.getRam());
		inEntity.setCamera(productDetailDTO.getCamera());
		inEntity.setCpu(productDetailDTO.getCpu());
		inEntity.setMemory(productDetailDTO.getMemory());
		inEntity.setGpu(productDetailDTO.getGpu());
		inEntity.setCell(productDetailDTO.getCell());
		inEntity.setSim(productDetailDTO.getSim());
		inEntity.setOs(productDetailDTO.getOs());
		informationDAO.update(inEntity);
	}

	@Override
	public Integer save(ProductDetailDTO productDetailDTO) {
		InformationEntity inEntity = new InformationEntity();
		inEntity.setInfoId(productDetailDTO.getInfoId());
		inEntity.setScreen(productDetailDTO.getScreen());
		inEntity.setCameraSelfie(productDetailDTO.getCameraSelfie());
		inEntity.setRam(productDetailDTO.getRam());
		inEntity.setCamera(productDetailDTO.getCamera());
		inEntity.setCpu(productDetailDTO.getCpu());
		inEntity.setMemory(productDetailDTO.getMemory());
		inEntity.setGpu(productDetailDTO.getGpu());
		inEntity.setCell(productDetailDTO.getCell());
		inEntity.setSim(productDetailDTO.getSim());
		inEntity.setOs(productDetailDTO.getOs());
		return informationDAO.insert(inEntity);
	}

}
