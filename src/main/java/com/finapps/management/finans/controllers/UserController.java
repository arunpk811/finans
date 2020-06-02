package com.finapps.management.finans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finapps.management.finans.models.Users;
import com.finapps.management.finans.services.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService jwtUserService;
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		return jwtUserService.getUsers();
	}
	
	@GetMapping("/users/{username}")
	public Users getUsers(@PathVariable String username){
		return jwtUserService.getUserByUsername(username);
	}
	
	@PostMapping("/users")
	public Users create(@RequestBody Users userDetail) {
		return jwtUserService.create(userDetail);
	}
	
	@DeleteMapping("/users/{id}")
	public String delete(@PathVariable Long id) {
		return jwtUserService.delete(id);
	}
	
}
