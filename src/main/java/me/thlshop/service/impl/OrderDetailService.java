package me.thlshop.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.thlshop.dao.IOrderDAO;
import me.thlshop.dao.IOrderDetailDAO;
import me.thlshop.dao.IProductDAO;
import me.thlshop.dto.CartDTO;
import me.thlshop.dto.CartDetailDTO;
import me.thlshop.dto.OrderDTO;
import me.thlshop.entity.OrderDetailEntity;
import me.thlshop.service.IOrderDetailService;

public class OrderDetailService implements IOrderDetailService{
	
	@Inject
	private IOrderDetailDAO orderDetailDAO;
	
	@Inject
	private IProductDAO productDAO;
	
	@Inject
	private IOrderDAO orderDAO;

	@Override
	public void save(CartDTO cart, OrderDTO orderDTO) {
		OrderDetailEntity detailEntity = new OrderDetailEntity();
		for(CartDetailDTO cartDetailDTO : cart.getCartDetails()) {
			detailEntity.setPrice(cartDetailDTO.getTotal());
			detailEntity.setQuantity(cartDetailDTO.getQuantity());
			detailEntity.setOrderId(orderDAO.findOne(orderDTO.getOrderId()));
			detailEntity.setProductId(productDAO.findOne(cartDetailDTO.getProduct().getProductId()));
			orderDetailDAO.insert(detailEntity);
		}
	}

	@Override
	public List<OrderDetailEntity> findAll() {
		return orderDetailDAO.findAll();
	}

	@Override
	public List<OrderDetailEntity> findByOrder(Integer orderId) {
		return orderDetailDAO.findByOrder(orderId);
	}

	@Override
	public void delete(Integer orderDetailId) {
		orderDetailDAO.delete(orderDetailId);
	}
	
}
