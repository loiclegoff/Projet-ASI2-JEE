package fr.cpe.rest.impl;

import java.util.logging.Logger;

import javax.inject.Inject;

import fr.cpe.rest.IWatcherAuth;
import fr.cpe.model.UserModel;

public class WatcherAuth implements IWatcherAuth {
	
	private static Logger logger = Logger.getLogger(WatcherAuth.class.getName());
	@Override
	public String doPost(String login, String pwd) {
		UserModel user = new UserModel();
		user.setLogin(login);
		user.setPassword(pwd);
		
		System.out.println("login:"+user.getLogin()+", pwd:"+user.getPassword());
		return null;
	}
	
}