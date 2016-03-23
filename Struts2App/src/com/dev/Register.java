package com.dev;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.dev.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID 	= 1L;
	private String email;
	private String password;
//	private AccountService service 				= new AccountService();
	private Logger logger 						= Logger.getLogger(this.getClass().getName());
	private HttpServletRequest request;
	private final String success 				= "SUCCESS";
	private final String register 				= "REGISTER";
	private final String list					= "LIST";
	
	public String execute() {
		logger.info(this.getClass().getName() + ": execute() called");
		// who was clicked? [Sign-In] or [Register]
		if(getServletRequest().getParameter("registerButton") != null) {
			// Register was clicked
			return register;
		}
		
		/*
		User user = new User();
		user.setPassword(getPassword());
		user.setEmail(getEmail());
		*/
		
		/*
		// Call service to register user
		if(service.createAccount(user)) {
			// Do something with this user
			return success;
		} 
		
		*/
		return success;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void validate() {
		// Only check if Register NOT clicked!		
		if(getServletRequest().getParameter("registerButton") == null) {
			
			if(getPassword() == null || getPassword().length() == 0 ) {
				addFieldError("password",getText("error.password"));
			}
			
			if(getEmail() == null || getEmail().length() == 0) {
				addFieldError("email",getText("error.email"));
			} 
		}
	}


	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletRequest getServletRequest() {
		return this.request;
	}
}
