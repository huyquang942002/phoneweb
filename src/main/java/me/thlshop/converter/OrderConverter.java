package me.thlshop.converter;

import me.thlshop.dto.OrderDTO;
import me.thlshop.entity.OrderEntity;

public class OrderConverter {
	public OrderEntity toEntity(OrderDTO orderDTO) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setAddress(orderDTO.getAddress());
		orderEntity.setOrderDate(orderDTO.getOrderDate());
		orderEntity.setPhone(orderDTO.getPhone());
		orderEntity.setStatus(orderDTO.getStatus());
		orderEntity.setTotal(orderDTO.getTotal());
		return orderEntity;
	}
	
	public OrderDTO toDto(OrderEntity orderEntity) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setUserId(orderEntity.getUserId().getUserId());
		orderDTO.setAddress(orderEntity.getAddress());
		orderDTO.setOrderDate(orderEntity.getOrderDate());
		orderDTO.setOrderId(orderEntity.getOrderId());
		orderDTO.setPhone(orderEntity.getPhone());
		orderDTO.setStatus(orderEntity.getStatus());
		orderDTO.setTotal(orderEntity.getTotal());
		
		return orderDTO;
	}
}
