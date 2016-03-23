package com.dev.dao;

import java.util.List;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import com.dev.USERS;
import com.dev.listener.HibernateServletContextListener;
//import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
//import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;;


public class UserDAOImpl implements UserDAO {
	
	 //  @SessionTarget
	   Session session;

	 //  @TransactionTarget
	 //  Transaction transaction;
	   

	@Override
	public void saveUsers(USERS user) {
		
		//get hibernate session from the servlet context
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateServletContextListener.KEY_NAME);
		
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);		
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<USERS> listUser() {
		
		//get hibernate session from the servlet context
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateServletContextListener.KEY_NAME);
		
		
		session = sessionFactory.openSession();
		
		
		List<USERS> users = new ArrayList<USERS>();
		
		try {
			users = session.createQuery("from USERS").list();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return users;
	}
	
	

}
