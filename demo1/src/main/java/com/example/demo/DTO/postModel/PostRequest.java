package com.example.demo.DTO.postModel;

public class PostRequest {
    private String postBody;
    private int userID;

    // Constructors
    public PostRequest() {
    }

    public PostRequest(String postBody, int userID) {
        this.postBody = postBody;
        this.userID = userID;
    }

    // Getters and Setters
    public String getPostBody() {
        return postBody;
    }

    public int getUserID() {
        return userID;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
