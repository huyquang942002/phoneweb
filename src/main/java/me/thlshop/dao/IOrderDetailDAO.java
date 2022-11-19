package me.thlshop.dao;

import java.util.List;

import me.thlshop.entity.OrderDetailEntity;

public interface IOrderDetailDAO {
	Integer insert(OrderDetailEntity orderDetailEntity);
	List<OrderDetailEntity> findAll();
	List<OrderDetailEntity> findByOrder(Integer orderId);
	void delete(Integer orderDetailId);
}
