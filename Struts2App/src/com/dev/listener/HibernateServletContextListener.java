package com.dev.listener;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateServletContextListener implements ServletContextListener {
	
	private SessionFactory factory;
	public static final String KEY_NAME = "HibernateServletContextListener";

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// get the SessionFactory and close it
		SessionFactory sf = (SessionFactory) sce.getServletContext().getAttribute("SessionFactory");
        sf.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent scEvent) {
		
		try {
		//	URL url = HibernateServletContextListener.class.getResource("/hibernate.cfg.xml");
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.configure("hibernate.cfg.xml");
	    //    config.configure(url);
	        
	        factory = config.buildSessionFactory();
	        
	      //save the Hibernate session factory into serlvet context
	        scEvent.getServletContext().setAttribute(KEY_NAME, factory);
		} catch( Exception ex) {
			ex.printStackTrace();
		}
	}
}
