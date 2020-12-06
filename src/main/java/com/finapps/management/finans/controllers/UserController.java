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
	public ResponseEntity<List<Users>> getUsers(){
		return new ResponseEntity<>(jwtUserService.getUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/api/users/{username}")
	public ResponseEntity<Users> getUsers(@PathVariable String username){
		return new ResponseEntity<>(jwtUserService.getUserByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping("/api/users")
	public ResponseEntity<Users> create(@RequestBody Users userDetail) {
		return new ResponseEntity<>(jwtUserService.create(userDetail), HttpStatus.OK);
	}
	
	@DeleteMapping("/api/users/{id}")
	public ResponseEntity<StringResponse> delete(@PathVariable Long id) {
		return new ResponseEntity<>(new StringResponse(jwtUserService.delete(id)), HttpStatus.OK);
	}
	
}
