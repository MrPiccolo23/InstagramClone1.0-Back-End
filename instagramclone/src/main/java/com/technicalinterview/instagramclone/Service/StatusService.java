package com.technicalinterview.instagramclone.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalinterview.instagramclone.Entity.Status;
import com.technicalinterview.instagramclone.Entity.Users;
import com.technicalinterview.instagramclone.Repository.StatusRepo;


import java.util.ArrayList;


@Service
public class StatusService {

	@Autowired
	StatusRepo statusRepo;
	
	@Autowired
	UserService userService;
	
	public Status submitDataIntoDB(Status status) {
		return statusRepo.save(status);
	}
	
	public ArrayList<Status> retrieveStatusForUser(String userId) {
	    ArrayList<Status> statusList = statusRepo.findAllByUserId(userId);
	    for (Status statusItem : statusList) {
	        Users user = userService.displayUserMetaData(statusItem.getUserId());
	        if (user != null) {
	            statusItem.setUserName(user.getUserName());
	        } else {
	            statusItem.setUserName("Unkown user");
	        }
	    }
	    return statusList;
	}
}
