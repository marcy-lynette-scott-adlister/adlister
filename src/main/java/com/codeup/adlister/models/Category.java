package com.codeup.adlister.models;

public class Category{
    private long id;
    private String category;

    public Category(long id, String category){
        this.id = id;
        this.category = category;
    }

    public Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
