package com.blog.BlogPostApplication.service;

import com.blog.BlogPostApplication.model.Post;
import com.blog.BlogPostApplication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    // Using Jpa -> communicate | EntityManagerFactory -> EntityManager
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    public void createPost(Post newPost){
        postRepository.createPost(newPost);
    }

    public void deletePost(Integer postId){
        postRepository.deletePost(postId);
    }
}
