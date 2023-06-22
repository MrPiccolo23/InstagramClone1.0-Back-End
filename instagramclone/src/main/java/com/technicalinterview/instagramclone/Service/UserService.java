package com.technicalinterview.instagramclone.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalinterview.instagramclone.Entity.Users;
import com.technicalinterview.instagramclone.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public Users submitMetaDataOfUser(Users user) {
		return userRepo.save(user);
	}
	
	public Users displayUserMetaData(String userid) {
		return userRepo.findByUserId(userid);
	}
	

	public Users validateUser(Users user) {
		Users foundUser = userRepo.findByUserName(user.getUserName());
	    // Here I'm assuming you are storing passwords in plain text. 
	    // It's highly recommended to use password hashing for security reasons.
	    if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
	        return foundUser;
	    } else {
	        return null;
	    }
	    

	}
}