package org.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.StandardServiceInitiators;
import org.vo.Warrior;


public class HibernateSessionFactory {
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static org.hibernate.SessionFactory sessionFactory;
	private static Configuration configuration = new Configuration();
	private static ServiceRegistry serviceRegistry;
	private static StandardServiceRegistry ssRegistry;
	
	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static Configuration getConfiguration() {
		return configuration;
	}

	static {
		configuration.configure();
		//configuration.addClass(Human.class);
		//configuration.addClass(Live.class);
		configuration.addClass(Warrior.class);
		ssRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(ssRegistry);
		//Session session = sessionFactory.openSession();
		//serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		// С�Ӹð汾��ʱ��Ŷ��ԭ����ServieRegistryBuilder  �Ѿ�������Ϊ StandardServiceRegistryBuilder;
	}
	
	public HibernateSessionFactory(){
		
	}
	
	public static Session getSession() throws HibernateException{				//��ȡsession
		Session session = (Session) threadLocal.get();
		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession():null;
			threadLocal.set(session);
		}
		return session;
	}
	
	public static void rebuildSessionFactory() {								//�ؽ�sessionFactory
		configuration.configure();
		ssRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(ssRegistry);
		
	}
			
	public static void closeSession() throws HibernateException{				//�ر�session
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);
		if (session != null) {
			session.close();
		}
	}
	
}

