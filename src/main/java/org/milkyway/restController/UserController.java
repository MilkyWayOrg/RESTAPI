package org.milkyway.restController;

import java.util.List;

import org.milkyway.model.User;
import org.milkyway.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class UserController {

	@Autowired
	UserDaoService userDaoService;

	@GetMapping(path="/users")
	public List<User> getUsers() {
		List<User> userList=userDaoService.getAllUsers();
		return userList;
	}

	@GetMapping(path="/user/{id}")
	public User getUsers(@PathVariable String id) {
		User user=userDaoService.getUserById(id);

		return user;
	}

	@PostMapping(path="/user")
	public void createUser(@RequestBody User user ) {
		User savedUser=userDaoService.saveUser(user);	
	}


}
