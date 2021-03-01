package com.blog.BlogPostApplication.controller;

import com.blog.BlogPostApplication.model.Post;
import com.blog.BlogPostApplication.model.User;
import com.blog.BlogPostApplication.service.PostService;
import com.blog.BlogPostApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import java.util.List;

@Controller
public class UserController {
    private UserService userService=new UserService();
    private PostService postService=new PostService();
    ///This is get request to /users/login
    @RequestMapping(method = RequestMethod.GET, value="/users/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "users/login";
    }

    //Post Request to */users/login
    @RequestMapping(method = RequestMethod.POST, value="/users/login")
    public String loginUser(User user){
        //check if the credentials match
        if(userService.login(user)){
            return "redirect:/posts";
        }else{
            return "users/login";
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/users/registration")
    public String registration(User user){

        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/registration")
    public String userRegistration(User user){
        //Business logic to save the credentials of the given database
        return "redirect:/users/login";
    }
    @RequestMapping( value = "/users/logout")
    public String userLogout(Model model){
        List<Post> posts=postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "redirect:/";
    }
}
