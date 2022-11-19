package me.thlshop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import me.thlshop.dao.IOrderDetailDAO;
import me.thlshop.entity.OrderDetailEntity;
import me.thlshop.utils.DBUtil;

public class OrderDetailDAO implements IOrderDetailDAO{

	@Override
	public Integer insert(OrderDetailEntity orderDetailEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Integer id = (Integer) session.save(orderDetailEntity);
			transaction.commit();
			session.close();
			return id;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetailEntity> findAll() {
		String hql = "FROM OrderDetailEntity";
		Transaction transaction = null;
		List<OrderDetailEntity> list = new ArrayList<OrderDetailEntity>();
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			list = query.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetailEntity> findByOrder(Integer orderId) {
		String hql = "FROM OrderDetailEntity o WHERE o.orderId.orderId = :orderId";
		
		Transaction transaction = null;
		List<OrderDetailEntity> orderDetailEntity = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			query.setParameter("orderId", orderId);
			orderDetailEntity = query.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return orderDetailEntity;
	}

	@Override
	public void delete(Integer orderDetailId) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			OrderDetailEntity orderDetailEntity = session.get(OrderDetailEntity.class, orderDetailId);
            if (orderDetailEntity != null) {
                session.delete(orderDetailEntity);
            }
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
