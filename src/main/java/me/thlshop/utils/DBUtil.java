package me.thlshop.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import me.thlshop.entity.CategoryEntity;
import me.thlshop.entity.ImageEntity;
import me.thlshop.entity.InformationEntity;
import me.thlshop.entity.OrderDetailEntity;
import me.thlshop.entity.OrderEntity;
import me.thlshop.entity.ProductEntity;
import me.thlshop.entity.RoleEntity;
import me.thlshop.entity.UserEntity;

public class DBUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_afc62411b1be16e?reconnect=true");
				settings.put(Environment.USER, "baf4db5b401b9a");
				settings.put(Environment.PASS, "340c5a92");
//				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/phoneweb?useSSL=false");
//				settings.put(Environment.USER, "root");
//				settings.put(Environment.PASS, "");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(UserEntity.class);
				configuration.addAnnotatedClass(RoleEntity.class);
				configuration.addAnnotatedClass(CategoryEntity.class);
				configuration.addAnnotatedClass(ImageEntity.class);
				configuration.addAnnotatedClass(InformationEntity.class);
				configuration.addAnnotatedClass(ProductEntity.class);
				configuration.addAnnotatedClass(OrderDetailEntity.class);
				configuration.addAnnotatedClass(OrderEntity.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
