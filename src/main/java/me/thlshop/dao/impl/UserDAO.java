package me.thlshop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import me.thlshop.dao.IUserDAO;
import me.thlshop.entity.UserEntity;
import me.thlshop.utils.DBUtil;

public class UserDAO implements IUserDAO {
	@Override
	public Integer insert(UserEntity userEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Integer id = (Integer) session.save(userEntity);
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
	public void update(UserEntity userModel) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(userModel);
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
	public void delete(Integer userId) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			UserEntity user = session.get(UserEntity.class, userId);
            if (user != null) {
                session.delete(user);
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
	public UserEntity findOne(Integer id) {
		Transaction transaction = null;
		UserEntity userModel = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			userModel = session.get(UserEntity.class, id);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return userModel;
	}

	@Override
	public UserEntity findByEmailPassword(String email, String password) {
		String hql = "FROM UserEntity e WHERE e.email = :email AND e.password = :password";
		
		Transaction transaction = null;
		UserEntity userEntity = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			query.setMaxResults(1);
			userEntity = (UserEntity)query.uniqueResult();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return userEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> findAll() {
		Transaction transaction = null;
		List<UserEntity> list = null;
		String hql = "FROM UserEntity";
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

	@SuppressWarnings("rawtypes")
	@Override
	public Long customerNumber() {
		String hql = "SELECT count(u.userId) FROM UserEntity u";
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

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> findByEmail(String email) {
		Transaction transaction = null;
		List<UserEntity> list = null;
		String hql = "FROM UserEntity e WHERE e.email = :email";
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
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

//	@Override
//	public UserModel findByEmailPassword(String email, String password) {
//		StringBuilder sql = new StringBuilder("SELECT * FROM users AS u");
//		sql.append(" INNER JOIN roles AS r ON u.role = r.roleId");
//		sql.append(" WHERE email=? AND password=?");
//		List<UserModel> list = query(sql.toString(), new UserMapper(), email, password);
//		return list.isEmpty() ? null : list.get(0);
//	}
//
//	@Override
//	public Integer save(UserModel userModel) {
//		StringBuilder sql = new StringBuilder("INSERT INTO users");
//		sql.append(" (password, fullName, email, phone, address, role)");
//		sql.append(" VALUES (?,?,?,?,?,?)");
//		return insert(sql.toString(), userModel.getPassword(), userModel.getFullName(),
//				userModel.getEmail(), userModel.getPhone(), userModel.getAddress(), userModel.getRole());
//	}
//
//	@Override
//	public void update(UserModel userModel) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public UserModel findOne(Integer id) {
//		String sql = "SELECT * FROM users WHERE userId = ?";
//		List<UserModel> list = query(sql, new UserMapper(), id);
//		return list.isEmpty() ? null : list.get(0);
//	}
}
