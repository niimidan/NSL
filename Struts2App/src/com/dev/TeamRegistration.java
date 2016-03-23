package com.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dev.dao.UserDAO;
import com.dev.dao.UserDAOImpl;
import com.dev.listener.HibernateServletContextListener;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeamRegistration extends ActionSupport 
	implements ServletRequestAware, ModelDriven<USERS> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private final String success 					= "SUCCESS";
	private final String registerTeam 				= "REGISTERTEAM";
	private final String list						= "LIST";
	private HttpServletRequest request;
	
	USERS users = new USERS();
	UserDAO userDAO = new UserDAOImpl();
	List<USERS> userList = new ArrayList<USERS>();

	

	@Override
	public USERS getModel() {
		return users;
	}
	

	/*
	public String execute() {
		logger.info(this.getClass().getName() + ": execute() called");
		// who was clicked? [Sign-In] or [Register]
		
		if(getServletRequest().getParameter("registerTeam") != null) {
			// Register was clicked
			return registerTeam;
		}
		
		
		listOfUsers = userDAO.listUser();

		return list;
	}
	*/
	
	public String add()
	{
		userDAO.saveUsers(users);
		return success;
	}
	
	@SuppressWarnings("unchecked")
	public String list()
	{		
		//	userList = userDAO.listUser();
		
		//get hibernate session from the servlet context
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateServletContextListener.KEY_NAME);
		

		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();
		

		try {
			Query q = session.createQuery("FROM USERS");
			userList = q.list();
					
			
			t.commit();
	        session.close();
	        
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return success;
	}
	
	public USERS getUsers() {
		return users;
	}

	public void setUsers(USERS users) {
		this.users = users;
	}

	public List<USERS> getUserList() {
		return userList;
	}
	
	public void setUserList(List<USERS> userList) {
		this.userList = userList;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletRequest getServletRequest() {
		return this.request;
	}
	
}
