package com.dev.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ActionError;

import com.dev.USERS;
import com.dev.dao.DAOManager;
import com.opensymphony.xwork2.util.ValueStack;

public class AccountService {
	
	// Default constructor
	private DAOManager manager = new DAOManager();
	private ValueStack stack;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public boolean createAccount(USERS user) {
		boolean result = true;
		// Any validation on User can happen here
		if(user == null) {
			result = false; // for clarity
			return result;
		}
		
		// Create user
		if(!manager.createUser(user)) {
			// Not good if we get here
			result = false;
		}
		
		// close connection
		manager.close();
		
		return result;
	}
	
	
	public boolean checkUserExists(String email) {
		boolean result = false;
		
		if(manager.checkUserExists("SELECT 1 FROM DWJOHNST.USERS u WHERE u.USER_EMAIL = '" + email + "'")) {
			// Not good if we get here
			result = true;
		}
		
		return result;
	}

}
