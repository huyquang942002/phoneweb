package me.thlshop.converter;

import me.thlshop.dto.OrderDetailDTO;
import me.thlshop.entity.OrderDetailEntity;

public class OrderDetailConverter {
	public OrderDetailEntity toEntity(OrderDetailDTO ordertDetailDTO) {
		OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
		orderDetailEntity.setPrice(ordertDetailDTO.getPrice());
		orderDetailEntity.setQuantity(ordertDetailDTO.getQuantity());
		return orderDetailEntity;
	}
	
	public OrderDetailDTO toDto(OrderDetailEntity orderDetailEntity) {
		OrderDetailDTO ordertDetailDTO = new OrderDetailDTO();
		ordertDetailDTO.setOrderDetailId(orderDetailEntity.getOrderDetailId());
		ordertDetailDTO.setOrderId(orderDetailEntity.getOrderId().getOrderId());
		ordertDetailDTO.setPrice(orderDetailEntity.getPrice());
		ordertDetailDTO.setProductId(orderDetailEntity.getProductId().getProductId());
		ordertDetailDTO.setQuantity(orderDetailEntity.getQuantity());
		return ordertDetailDTO;
	}
}
