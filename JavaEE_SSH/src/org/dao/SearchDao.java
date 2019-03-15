package org.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.util.HibernateSessionFactory;
import org.vo.Warrior;

public class SearchDao {
	public List searchAll() {
		HibernateSessionFactory hsf = new HibernateSessionFactory();
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Warrior");
		List lists = query.list();
		return lists;
	}
	public Warrior searchWar(int id) {
		Warrior war = null;
		HibernateSessionFactory hsf = new HibernateSessionFactory();
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		String sql = "from Warrior where id = ? ";
		Query query = session.createQuery(sql);
		query.setParameter(0, id);
		List list = query.list();
		for (int i = 0;i < list.size();i++) {
			war = (Warrior)list.get(i);
		}
		tx.commit();
		session.close();
		return war;
	}
}
