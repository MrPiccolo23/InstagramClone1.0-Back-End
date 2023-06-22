package com.technicalinterview.instagramclone.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalinterview.instagramclone.Entity.Comments;

import com.technicalinterview.instagramclone.Entity.Users;
import com.technicalinterview.instagramclone.Repository.CommentRepo;

@Service
public class CommentsService {
	
	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	UserService userService;
	
	public Comments submitCommentToDB(Comments comment) {
		return commentRepo.save(comment);
	}
	
	public ArrayList<Comments> getAllCommentsForUser(String userId) {
	    ArrayList<Comments> commentList = commentRepo.findAllByUserId(userId);
	    for (Comments commentItem : commentList) {
	        Users user = userService.displayUserMetaData(commentItem.getUserId());
	        if (user != null) {
	            commentItem.setUserName(user.getUserName());
	        } else {
	            commentItem.setUserName("Unkown user");
	        }
	    }
	    return commentList;
	}
}