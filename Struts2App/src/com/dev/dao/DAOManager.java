package com.dev.dao;

import java.sql.*;
import java.util.logging.Logger;

import com.dev.USERS;

public class DAOManager {
	
	private Connection conn;
	private Statement stmt;
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	// Gets connections to DB
	public DAOManager() {
		try{
			// Connect to Oracle
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String database = "jdbc:oracle:thin:@10.245.45.43:1552:mpdev";
	        conn = DriverManager.getConnection(database, "DWJOHNST", "dwjohnst");
	        
	        // So something with connection
	        stmt = conn.createStatement();
	          
		} catch(Exception ex) {
			logger.info("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	
	public USERS executeQuery(String sql) {
		USERS user = new USERS();
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
	        // Check to see if we got anything
	        while(rs.next()) {
	        	//user.setLast(rs.getString("USER_FIRST"));
	        }
	        rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	
	/*
	 * checkUserExists
	 * 
	 * @param String sql
	 * 
	 * returns a boolean: PASS or FAIL
	 * 
	 */
	public boolean checkUserExists(String sql) {
		boolean result = false;
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
	        // Check to see if we got anything
	        while(rs.next()) {
	        	if(rs.getInt(1) == 1) {
	        		result = true;
	        	}
	        }
	        rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/*
	 * 
	 * 
	 */
	public boolean createUser(USERS user) {
		boolean res = false;
		
		
		return res;
	}
	
	
	public void close() {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
	
	

}
