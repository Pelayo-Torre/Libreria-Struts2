package com.miw.business.usermanager;

import com.miw.model.User;

public interface UserManagerService {
	
	public void saveUser(User user) throws Exception ;
	public User getUserByLogin(String login) throws Exception ;
	public boolean userExists(String login, String password) throws Exception;

}
