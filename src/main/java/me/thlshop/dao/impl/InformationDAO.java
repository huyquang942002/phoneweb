package me.thlshop.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import me.thlshop.dao.IInformationDAO;
import me.thlshop.entity.InformationEntity;
import me.thlshop.utils.DBUtil;

public class InformationDAO implements IInformationDAO{

	@Override
	public InformationEntity findOne(Integer infId) {
		Transaction transaction = null;
		InformationEntity informationEntity = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			informationEntity = session.get(InformationEntity.class, infId);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return informationEntity;
	}

	@Override
	public void update(InformationEntity informationEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(informationEntity);
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
	public Integer insert(InformationEntity informationEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Integer id = (Integer)session.save(informationEntity);
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
	public void delete(Integer informationId) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			InformationEntity info = session.get(InformationEntity.class, informationId);
            if (info != null) {
                session.delete(info);
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
