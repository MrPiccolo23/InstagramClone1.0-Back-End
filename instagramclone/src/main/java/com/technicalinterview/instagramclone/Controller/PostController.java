package com.technicalinterview.instagramclone.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;  
import com.technicalinterview.instagramclone.Entity.Post;
import com.technicalinterview.instagramclone.Service.PostService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:3000")  
public class PostController {
	
    @Autowired
    PostService postService;
	
    @PostMapping("")
    private Post submitUserPost(@RequestBody Post post) {
        return postService.submitPostToDataBase(post); 
    }
	
    @GetMapping("/{userId}")
    private ArrayList<Post> getAllPost(@PathVariable("userId") String userId){
        return postService.retrievePostsForUser(userId);
    }

}
