package com.blog.BlogPostApplication.model;

import java.util.Date;

public class Post {
    //components of the post or blog
    private String title;
    private String body;
    private Date Date;

    //getter and setters

    public String getTitle() {

        return title;
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
