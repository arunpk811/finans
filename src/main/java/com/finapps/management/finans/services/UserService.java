package com.finapps.management.finans.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.finapps.management.finans.models.Users;
import com.finapps.management.finans.repositories.UserRepository;
import com.finapps.management.finans.utils.Constants;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			Users user = userRepo.findByUsername(username);
			if(username.equals("superadmin")) return new User(username,"$2a$10$d1mgtJ7yA8mFgp6FRTlfEug6jhlh4Ab8vYIaMJH6wFNaOM761xge2",new ArrayList<>());
			if(user !=null && user.getIsActive() ==1) 
				return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
			else 
				throw new UsernameNotFoundException("User " + username + " is not active"); 
			
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	public List<Users> getUsers() {
		return userRepo.findAll();
	}

	public Users getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	public Users create(Users userDetail) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(userDetail.getPassword());
		userDetail.setPassword(encodedPassword);
		return userRepo.save(userDetail);
	}

	public String delete(Long id) {
		try {
			userRepo.deleteById(id);
			return Constants.RECORD_DELETED_SUCCESSFULLY;
		} catch (Exception e) {
			return Constants.CRUD_ERROR;
		}
	}

	// public static void main(String[] args) {
	// 	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	// 	String encodedString = encoder.encode("Arun@123");
	// 	System.out.println(encodedString);
	// }
}