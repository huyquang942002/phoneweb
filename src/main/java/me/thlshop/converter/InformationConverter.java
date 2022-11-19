package me.thlshop.converter;

import me.thlshop.dto.InformationDTO;
import me.thlshop.entity.InformationEntity;

public class InformationConverter {
	public InformationEntity toEntity(InformationDTO informationDTO) {
		InformationEntity inEntity = new InformationEntity();
		inEntity.setCamera(informationDTO.getCamera());
		inEntity.setCameraSelfie(informationDTO.getCameraSelfie());
		inEntity.setCell(informationDTO.getCell());
		inEntity.setCpu(informationDTO.getCpu());
		inEntity.setGpu(informationDTO.getGpu());
		inEntity.setMemory(informationDTO.getMemory());
		inEntity.setOs(informationDTO.getOs());
		inEntity.setRam(informationDTO.getRam());
		inEntity.setScreen(informationDTO.getScreen());
		inEntity.setSim(informationDTO.getSim());
		return inEntity;
	}
	
	public InformationDTO toDto(InformationEntity informationEntity) {
		InformationDTO informationDTO = new InformationDTO();
		informationDTO.setInfoId(informationEntity.getInfoId());
		informationDTO.setCamera(informationEntity.getCamera());
		informationDTO.setCameraSelfie(informationEntity.getCameraSelfie());
		informationDTO.setCell(informationEntity.getCell());
		informationDTO.setCpu(informationEntity.getCpu());
		informationDTO.setGpu(informationEntity.getGpu());
		informationDTO.setMemory(informationEntity.getMemory());
		informationDTO.setOs(informationEntity.getOs());
		informationDTO.setRam(informationEntity.getRam());
		informationDTO.setScreen(informationEntity.getScreen());
		informationDTO.setSim(informationEntity.getSim());
		return informationDTO;
	}
}
