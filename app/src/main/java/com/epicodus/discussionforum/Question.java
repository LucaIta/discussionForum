package com.epicodus.discussionforum;

/**
 * Created by Guest on 7/12/16.
 */
public class Question {
    private String text;
    private String username;
    private String categoryID;

    public Question (String text, String username, String categoryID) {
        this.text = text;
        this.username = username;
        this.categoryID = categoryID;
    }

    public  Question () {

    }

    public String getText() {
        return text;
    }

    public String getUsername() {
        return username;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String pushId) {
        categoryID = pushId;
    }
}
