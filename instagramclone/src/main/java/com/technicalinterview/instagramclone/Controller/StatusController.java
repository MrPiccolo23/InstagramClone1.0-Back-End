package com.technicalinterview.instagramclone.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technicalinterview.instagramclone.Entity.Status;
import com.technicalinterview.instagramclone.Service.StatusService;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/status")
public class StatusController {

	@Autowired
	StatusService statusService;
	
	@PostMapping("")
	private Status submitStatus(@RequestBody Status status) {
		return statusService.submitDataIntoDB(status);
	}
	
	@GetMapping("/{userId}")
	private ArrayList<Status> getAllStatus(@PathVariable("userId") String userId){
	    return statusService.retrieveStatusForUser(userId);
	}

}
