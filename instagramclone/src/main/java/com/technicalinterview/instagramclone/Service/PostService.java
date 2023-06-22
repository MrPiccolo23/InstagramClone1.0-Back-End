package com.technicalinterview.instagramclone.Service;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalinterview.instagramclone.Entity.Post;
import com.technicalinterview.instagramclone.Entity.Users;
import com.technicalinterview.instagramclone.Repository.PostRepo;

@Service
public class PostService {
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	UserService userService;
	
	public Post submitPostToDataBase(Post post) {
		return postRepo.save(post);
	}
	
	public ArrayList<Post> retrievePostsForUser(String userId) {
	    ArrayList<Post> postList = postRepo.findAllByUserId(userId);
	    for (Post postItem : postList) {
	        Users user = userService.displayUserMetaData(postItem.getUserId());
	        if (user != null) {
	            postItem.setUserName(user.getUserName());
	        } else {
	            postItem.setUserName("Unkown user");
	        }
	    }
	    Collections.sort(postList,(a,b)->b.getId()-a.getId());
	    return postList;
	}

}
