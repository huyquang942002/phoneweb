package me.thlshop.service;

import java.util.List;

import me.thlshop.dto.CartDTO;
import me.thlshop.dto.OrderDTO;
import me.thlshop.entity.OrderDetailEntity;

public interface IOrderDetailService {
	void save(CartDTO cart, OrderDTO orderDTO);
	List<OrderDetailEntity> findAll();
	List<OrderDetailEntity> findByOrder(Integer orderId);
	void delete(Integer orderDetailId);
}
