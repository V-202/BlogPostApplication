package service;

import com.blog.BlogPostApplication.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //contain all the business logic to communicate to data base
    public boolean login(User user){
        if(user.getUsername().equals("vanshaj_kaistha") && user.getPassword().equals("chitkara"))
            return true;
        else
            return false;
    }
}
