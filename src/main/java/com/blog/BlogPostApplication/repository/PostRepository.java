package com.blog.BlogPostApplication.repository;

import com.blog.BlogPostApplication.model.Post;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {
        PostRepository(){
            System.out.println("*** POST REPOSITORY ***");
        }
    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory entityManagerFactory;


    public List<Post> getAllPosts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Post> query = entityManager.createQuery("SELECT p from Post p", Post.class);
        List<Post> result = query.getResultList();
        return result;

    }


    public void createPost(Post newPost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newPost);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
    }
    public void deletePost(Integer posts){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Post post = entityManager.find(Post.class, postId);
            entityManager.remove(post);
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
}
