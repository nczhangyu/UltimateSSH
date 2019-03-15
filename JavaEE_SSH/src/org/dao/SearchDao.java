package org.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.util.HibernateSessionFactory;

public class SearchDao {
	public List searchAll() {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Warrior");
		List lists = query.list();
		return lists;
	}
}
