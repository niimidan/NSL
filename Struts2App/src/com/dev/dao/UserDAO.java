package com.dev.dao;


import java.util.List;
import com.dev.USERS;


public interface UserDAO {
	
	public void saveUsers(USERS user);
	public List<USERS> listUser();
	
}
