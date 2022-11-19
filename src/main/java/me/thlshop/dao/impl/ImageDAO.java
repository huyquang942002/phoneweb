package me.thlshop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import me.thlshop.dao.IImageDAO;
import me.thlshop.entity.ImageEntity;
import me.thlshop.utils.DBUtil;

public class ImageDAO implements IImageDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<ImageEntity> findAll() {
		Transaction transaction = null;
		List<ImageEntity> list = null;
		String hql = "FROM ImageEntity";
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
	public ImageEntity findOne(Integer imageId) {
		Transaction transaction = null;
		ImageEntity imageEntity = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			imageEntity = session.get(ImageEntity.class, imageId);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return imageEntity;
	}

	@Override
	public Integer insert(ImageEntity imageEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Integer id = (Integer)session.save(imageEntity);
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
	public void delete(Integer imageId) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			ImageEntity image = session.get(ImageEntity.class, imageId);
            if (image != null) {
                session.delete(image);
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

	@Override
	public void update(ImageEntity imageEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(imageEntity);
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
