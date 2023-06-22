package com.technicalinterview.instagramclone.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.technicalinterview.instagramclone.Entity.Users;
import com.technicalinterview.instagramclone.Service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("")
	public Users submitUser(@RequestBody Users users) {
	    logger.info("Received request to submit user: " + users.getUserId() + ", userName: " + users.getUserName() + ", profileImage: " + users.getProfileImage());
	    return userService.submitMetaDataOfUser(users);
	   
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Users user) {
	    Users validUser = userService.validateUser(user);
	    if (validUser != null) {
	        return new ResponseEntity<>(validUser, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
	    }
	}


	
	@GetMapping("/{userid}")
	public Users getUserDetails(@PathVariable("userid")String userId) {
		return userService.displayUserMetaData(userId);
	}
}
