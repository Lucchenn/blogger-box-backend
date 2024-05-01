package com.dauphine.blogger.models;

import java.util.List;

public class Category {
    private int id;
    private String name;

    public Category() {}
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
