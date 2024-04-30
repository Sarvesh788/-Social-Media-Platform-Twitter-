package com.example.demo.DTO.postModel;

public class PostUpdate {
    private String postBody;
    private int postID;

    // Getters and setters
    public PostUpdate() {
    }

    public int getPostID() {
        return postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public PostUpdate(int postID, String postBody) {
        this.postID = postID;
        this.postBody = postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
}
