package com.blog.BlogPostApplication.controller;

import com.blog.BlogPostApplication.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.Date;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String getAllPost(Model model){
        //Business logic

        ArrayList<Post> posts = new ArrayList<>();
        Post post1=new Post();
        post1.setTitle("Android");
        post1.setBody("android is far better than IOS");
        post1.setDate(new Date());


        Post post2=new Post();
        post2.setTitle("Beauty");
        post2.setBody("powder na lag");
        post2.setDate(new Date());


        Post post3=new Post();
        post3.setTitle("Shoes");
        post3.setBody("Rubber");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        //Gave this post to the view
        model.addAttribute("posts", posts);
        return "index";//Html file
    }
}