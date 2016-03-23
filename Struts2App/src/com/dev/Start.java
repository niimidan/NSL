package com.dev;

import java.util.logging.Logger;

//import com.ibm.ws.i18n.context.Locale;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Start extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(this.getClass().getName());
	private String expandTheme = "dano";
	
	public String execute() throws Exception {
		logger.info("Executing action code");
		
		//logger.info(ActionContext.getContext().getName() + " - Lingo: " + ActionContext.getContext().getLocale().getDisplayLanguage().toString());
		
		// Set the locale to ja
		//ActionContext.getContext().setLocale(java.util.Locale.JAPANESE);
		//ActionContext.getContext().setLocale(java.util.Locale.JAPAN);
		
		logger.info(ActionContext.getContext().getName() + " - Lingo: " + ActionContext.getContext().getLocale().getDisplayLanguage().toString());
		return "SUCCESS";
	}

	public String getExpandTheme() {
		return expandTheme;
	}

	public void setExpandTheme(String expandTheme) {
		this.expandTheme = expandTheme;
	}

}
