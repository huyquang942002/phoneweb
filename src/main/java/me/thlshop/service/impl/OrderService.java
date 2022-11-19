package me.thlshop.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.thlshop.converter.OrderConverter;
import me.thlshop.dao.IOrderDAO;
import me.thlshop.dao.IUserDAO;
import me.thlshop.dto.OrderDTO;
import me.thlshop.entity.OrderDetailEntity;
import me.thlshop.entity.OrderEntity;
import me.thlshop.service.IOrderDetailService;
import me.thlshop.service.IOrderService;

public class OrderService implements IOrderService{
	
	@Inject
	private IOrderDAO orderDAO;
	
	@Inject
	private IUserDAO userDAO;
	
	@Inject OrderConverter orderConverter;
	
	@Inject
	private IOrderDetailService orderDetailService;
	
	
	@Override
	public OrderDTO save(OrderDTO orderDTO) {
		OrderEntity orderEntity = orderConverter.toEntity(orderDTO);
		orderEntity.setUserId(userDAO.findOne(orderDTO.getUserId()));
		Integer id = orderDAO.insert(orderEntity);
		return orderConverter.toDto(orderDAO.findOne(id));
	}
	@Override
	public List<OrderEntity> findByUser(Integer useId) {
		return orderDAO.findByUser(useId);
	}
	@Override
	public List<OrderEntity> findAll() {
		return orderDAO.findAll();
	}
	@Override
	public void update(OrderDTO orderDTO) {
		OrderEntity orderEntity = orderDAO.findOne(orderDTO.getOrderId());
		orderEntity.setStatus(orderDTO.getStatus());
		orderDAO.update(orderEntity);
	}
	@Override
	public void delete(Integer orderId) {
		List<OrderDetailEntity> orderDetails = orderDetailService.findByOrder(orderId);
		for(OrderDetailEntity order: orderDetails) {
			orderDetailService.delete(order.getOrderDetailId());
		}
		orderDAO.delete(orderId);
	}
	@Override
	public List<OrderEntity> findByStatus(Integer status) {
		return orderDAO.findByStatus(status);
	}
	@Override
	public Long getEarning() {
		return orderDAO.getEarning();
	}
	@Override
	public Long orderSuccessNumber() {
		return orderDAO.orderSuccessNumber();
	}
}
