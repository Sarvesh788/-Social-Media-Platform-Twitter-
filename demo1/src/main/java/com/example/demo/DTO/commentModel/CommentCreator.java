package com.example.demo.DTO.commentModel;

public class CommentCreator {
    private int userID;
    private String name;

    // Constructor
    public CommentCreator(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
