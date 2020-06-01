package com.finapps.management.finans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finapps.management.finans.models.UserDetail;
import com.finapps.management.finans.services.JwtUserDetailsService;


@RestController
public class UserController {
	
	@Autowired
	JwtUserDetailsService jwtUserService;
	
	@GetMapping("/users")
	public List<UserDetail> getUsers(){
		return jwtUserService.getUsers();
	}
	
	@GetMapping("/users/{username}")
	public UserDetail getUsers(@PathVariable String username){
		return jwtUserService.getUserByUsername(username);
	}
	
	@PostMapping("/users")
	public UserDetail create(@RequestBody UserDetail userDetail) {
		return jwtUserService.create(userDetail);
	}
	
	@DeleteMapping("/users/{id}")
	public String delete(@PathVariable Long id) {
		return jwtUserService.delete(id);
	}
	
}
