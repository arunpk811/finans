package com.finapps.management.finans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finapps.management.finans.models.Users;
import com.finapps.management.finans.models.response.StringResponse;
import com.finapps.management.finans.services.UserService;


@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService jwtUserService;
	
	@GetMapping("/api/users")
	public List<Users> getUsers(){
		return jwtUserService.getUsers();
	}
	
	@GetMapping("/api/users/{username}")
	public Users getUsers(@PathVariable String username){
		return jwtUserService.getUserByUsername(username);
	}
	
	@PostMapping("/api/users")
	public Users create(@RequestBody Users userDetail) {
		return jwtUserService.create(userDetail);
	}
	
	@DeleteMapping("/api/users/{id}")
	public ResponseEntity<StringResponse> delete(@PathVariable Long id) {
		return new ResponseEntity<>(new StringResponse(jwtUserService.delete(id)), HttpStatus.OK);
	}
	
}
