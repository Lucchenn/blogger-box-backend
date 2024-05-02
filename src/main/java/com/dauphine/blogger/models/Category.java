package com.dauphine.blogger.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Category {

    private UUID id;
    private String name;
    private List<Post> posts;


    public Category() {}
    public Category(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.posts = new ArrayList<>();
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

}
