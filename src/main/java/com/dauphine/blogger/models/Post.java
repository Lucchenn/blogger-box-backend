package com.dauphine.blogger.models;

import java.util.Date;

public class Post {
    private int id;
    private String title;
    private String content;
    private Date createdDate;
    private Category category;

    public Post() {}
    public Post(int id, String title, String content, Date createdDate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.category = category;
    }
}
