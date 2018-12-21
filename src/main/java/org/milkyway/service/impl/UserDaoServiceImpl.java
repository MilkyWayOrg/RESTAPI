package org.milkyway.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.milkyway.model.User;
import org.milkyway.service.UserDaoService;

public class UserDaoServiceImpl implements UserDaoService{
	private static List<User> users=new ArrayList<User>();
	private static int userCount=2;
	static {
	
	
	List<String> roles=new ArrayList<String>();
	roles.add("ADMIN");
	List<String> projects=new ArrayList<String>();
	projects.add("4G");
	
	
	List<String> applications=new ArrayList<String>();
	applications.add("App1");
	applications.add("App2");
	
	User user1=new User("1234","ABC","CBA", "abc@techm.com", roles, "AT&T",projects ,applications);
	
	
	projects.add("5G");
	applications.add("App3");
	roles.add("DEVELOPER");
	User user2=new User("12345","XYZ","zyx","xyz@techm.com", roles, "AT&T",projects ,applications);
	
	users.add(user1);
	users.add(user2);
	}
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User getUserById(String id) {
		Iterator<User>  userIterator=users.iterator();
		while(userIterator.hasNext()) {
			User user=userIterator.next();
			if(user.getId().equals(id))
				return user;
		}
		return null;
	}

	@Override
	public User saveUser(User user) {
		users.add(user);
		return user;
	}

}
