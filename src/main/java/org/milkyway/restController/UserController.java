package org.milkyway.restController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.milkyway.model.User;
import org.milkyway.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@GetMapping(path="/users/{id}")
	public Resource<User> getUser(@PathVariable String id) {
		User user=userDaoService.getUserById(id);

		Resource<User> userResource=new Resource<User>(user);
		ControllerLinkBuilder usersListLink=linkTo(methodOn(this.getClass()).getUsers());
		userResource.add(usersListLink.withRel("all-users"));
		return userResource;
	}

	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@RequestBody User user ) {
		User savedUser=userDaoService.saveUser(user);
		// CREATED
		// /user/{id}     savedUser.getId()
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
