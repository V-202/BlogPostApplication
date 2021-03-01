package com.blog.BlogPostApplication.service;


import com.blog.BlogPostApplication.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // Contain all the business logic and communicate to db
    public boolean login(User user) {
        if(user.getUsername().equals("vanshaj") && user.getPassword().equals("chitkara"))
            return true;
        else
            return false;
    }
}
