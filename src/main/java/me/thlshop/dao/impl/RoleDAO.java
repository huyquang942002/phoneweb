package me.thlshop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import me.thlshop.dao.IRoleDAO;
import me.thlshop.entity.RoleEntity;
import me.thlshop.utils.DBUtil;

public class RoleDAO implements IRoleDAO{
	@SuppressWarnings("unchecked")
	@Override
	public List<RoleEntity> findAll() {
		Transaction transaction = null;
		List<RoleEntity> list = null;
		String hql = "FROM RoleEntity";
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
	public RoleEntity findOne(Integer roleId) {
		Transaction transaction = null;
		RoleEntity roleModel = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			roleModel = session.get(RoleEntity.class, roleId);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return roleModel;
	}

}
