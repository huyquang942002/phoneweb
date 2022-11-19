package me.thlshop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import me.thlshop.dao.IProductDAO;
import me.thlshop.entity.ProductEntity;
import me.thlshop.utils.DBUtil;

public class ProductDAO implements IProductDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEntity> findAll() {
		Transaction transaction = null;
		List<ProductEntity> list = null;
		String hql = "FROM ProductEntity";
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
	public ProductEntity findOne(Integer productId) {
		Transaction transaction = null;
		ProductEntity productEntity = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			productEntity = session.get(ProductEntity.class, productId);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return productEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEntity> findByBrand(Integer brandId) {
		String hql = "FROM ProductEntity p WHERE p.brandId.brandId = :brandId";
		
		Transaction transaction = null;
		List<ProductEntity> productEntities = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			query.setParameter("brandId", brandId);
			productEntities = query.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return productEntities;
	}

	@Override
	public void update(ProductEntity productEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(productEntity);
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
	public Integer insert(ProductEntity productEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Integer id = (Integer) session.save(productEntity);
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
	public void delete(Integer productId) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			ProductEntity prod = session.get(ProductEntity.class, productId);
            if (prod != null) {
                session.delete(prod);
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
	public List<ProductEntity> search(String keyWord) {
		String hql = "FROM ProductEntity p WHERE p.productName like :keyWord";
		Transaction transaction = null;
		List<ProductEntity> productEntities = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			query.setParameter("keyWord", "%"+ keyWord +"%");
			productEntities = query.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return productEntities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEntity> findByCategory(Integer categoryId) {
		String hql = "FROM ProductEntity p WHERE p.categoryId.categoryId = :categoryId";
		
		Transaction transaction = null;
		List<ProductEntity> productEntities = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			query.setParameter("categoryId", categoryId);
			productEntities = query.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return productEntities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEntity> findProductOutstanding() {
		Transaction transaction = null;
		List<ProductEntity> list = null;
		String hql = "FROM ProductEntity";
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			query.setMaxResults(12);
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

	@SuppressWarnings("rawtypes")
	@Override
	public Long productNumber() {
		String hql = "SELECT count(p.productId) FROM ProductEntity p";
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
