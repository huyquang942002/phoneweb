package me.thlshop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import me.thlshop.dao.IOrderDAO;
import me.thlshop.entity.OrderEntity;
import me.thlshop.utils.DBUtil;

public class OrderDAO implements IOrderDAO{
	@Override
	public Integer insert(OrderEntity orderEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Integer id = (Integer) session.save(orderEntity);
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

	@Override
	public OrderEntity findOne(Integer id) {
		Transaction transaction = null;
		OrderEntity orderEntity = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			orderEntity = session.get(OrderEntity.class, id);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return orderEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderEntity> findByUser(Integer userId) {
		String hql = "FROM OrderEntity o WHERE o.userId.userId = :userId ORDER BY o.orderId DESC";
		Transaction transaction = null;
		List<OrderEntity> list = new ArrayList<OrderEntity>();
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			query.setParameter("userId", userId);
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
	public List<OrderEntity> findAll() {
		Transaction transaction = null;
		List<OrderEntity> list = null;
		String hql = "FROM OrderEntity o ORDER BY o.orderId DESC";
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

	@Override
	public void update(OrderEntity orderEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.update(orderEntity);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer orderId) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			OrderEntity orderEntity = session.get(OrderEntity.class, orderId);
            if (orderEntity != null) {
                session.delete(orderEntity);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderEntity> findByStatus(Integer status) {
		String hql = "FROM OrderEntity o WHERE o.status = :status ORDER BY o.orderId DESC";
		List<OrderEntity> orderEntities = null;
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			query.setParameter("status", status);
			orderEntities = query.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return orderEntities;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Long getEarning() {
		String hql = "SELECT sum(o.total) FROM OrderEntity o";
		Transaction transaction = null;
		List results = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			results = query.list();
			transaction.commit();
			session.close();
			return (Long) results.get(0);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Long orderSuccessNumber() {
		String hql = "SELECT count(o.orderId) FROM OrderEntity o";
		Transaction transaction = null;
		List results = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			results = query.list();
			transaction.commit();
			session.close();
			return (Long) results.get(0);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}
}
