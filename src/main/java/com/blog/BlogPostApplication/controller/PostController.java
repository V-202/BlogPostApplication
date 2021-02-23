package com.blog.BlogPostApplication.controller;

import com.blog.BlogPostApplication.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.PostService;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class PostController {
    @RequestMapping("/posts")
    public String getUserPost(Model model) {
        PostService postService = new PostService();
        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/posts/newpost")
    public String newPost() {

        return "posts/create";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/posts/create")
    public String createNewPost(Post newPost){
        PostService postService=new PostService();
        newPost.setDate(new Date());
        postService.createPost(newPost);
        return "redirect:/posts";
    }
}
