package service;

import com.blog.BlogPostApplication.model.Post;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    //Singleton
    //Business logic

     private static ArrayList<Post> POSTS = new ArrayList<>();
     static {
         Post post1=new Post();
         post1.setTitle("Worldwide");
         post1.setBody("A news in Uttarakhand reported heavy floods in UK districts Aleart has baeen declared");
         post1.setDate(new Date());
         POSTS.add(post1);

         Post post2=new Post();
         post2.setTitle("National");
         post2.setBody("A news in Uttarakhand reported heavy floods in UK districts Aleart has baeen declared");
         post2.setDate(new Date());
         POSTS.add(post2);




     }
     private final String url = "jdbc:postgresql://localhost:5432/technicalblog";
     private final String username = "postgres";
     private final String password = "0000";

     public Connection connect() throws SQLException {
         return DriverManager.getConnection(url, username, password);
     }
     public ArrayList<Post> getAllPosts(){
         try {
             //This will fetch the data from the database
             // Business logic for connecting the database
             //Step 1: connect to the database
             Connection connection =connect();

             //Step 2: Create the statement
             Statement statement = connection.createStatement();

             // It will execute the select query
             ResultSet resultSet = statement.executeQuery("SELECT * FROM posts");
             // Step 4: Loop into the resultant and get the data
             while(resultSet.next()){
                 Post post1=new Post();
                 post1.setTitle(resultSet.getString("title"));
                 post1.setBody(resultSet.getString("body"));
                 post1.setDate(resultSet.getDate("date"));

                // store the date in the singleton
                 POSTS.add(post1);

             }
         }catch(SQLException e){
             System.out.println(e.getMessage());

         }

        return POSTS;

    }
    public void createPost(Post newPost){
         try{
             String query ="Insert INTO posts(title, body, data) VALUES(?, ?, ?)";
             // connect to the database
             Connection connection = connect();

             // Step 2:Prepare a statement
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

             //Step 3: Fix the values from the VIEWS
             preparedStatement.setString(1, newPost.getTitle());
             preparedStatement.setString(2,newPost.getBody());
             preparedStatement.setDate(3, (java.sql.Date) new Date(newPost.getDate().getTime()));
             int updatedRows = preparedStatement.executeUpdate();

             if(updatedRows > 0){
                 System.out.println("Updating is working fine!");
             }
         }catch(SQLException e){
             System.out.println(e.getMessage());
        }
     }
}
