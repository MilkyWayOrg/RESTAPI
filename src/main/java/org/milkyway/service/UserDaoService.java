package org.milkyway.service;

import java.util.List;

import org.milkyway.model.User;
import org.springframework.stereotype.Component;

public interface UserDaoService {

	public List<User> getAllUsers();
	public User getUserById(String id);
	public User saveUser(User user);
}
