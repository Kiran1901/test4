package com.kiran.test4.repositories;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.And;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kiran.test4.models.User;

@Repository
@Transactional
public class UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(User user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> getByEmail(String email) {
		List<User> usersList = new ArrayList<User>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from User where active=1 and email=:email");
			query.setParameter("email", email);
			usersList = (List<User>) query.list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public void delete(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("update User set active=0 where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean authenticate(User user) {
		if (user.getEmail() != null && user.getPassword() != null) {
			List<User> usersList = new ArrayList<User>();
			try {
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createQuery("from User where active=1 and email=:email");
				query.setParameter("email", user.getEmail());
				usersList = (List<User>)query.list();
				session.close();
				for (User usr: usersList) {
					if(usr.getPassword().equals(user.getPassword())) {
						return true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
