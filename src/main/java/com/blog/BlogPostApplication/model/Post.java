package com.blog.BlogPostApplication.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "posts")
public class Post {
    //components of the post or blog
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="body")
    private String body;

    @Column(name="date")
    private Date Date;

    //getter and setters

    public String getTitle() {

        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {

        this.title = title;
    }
    public String getBody() {

        return body;
    }

    public void setBody(String body) {

        this.body = body;
    }

    public Date getDate() {

        return Date;
    }

    public void setDate(Date date) {

        this.Date = date;
    }
}
