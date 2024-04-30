package com.example.demo.DTO.commentModel;

// CreateCommentRequest.java
public class CommentCreate {
    private String commentBody;
    private int postID;
    private int userID;

    // Constructors, getters, and setters
    public CommentCreate() {
    }

    public CommentCreate(String commentBody, int postID, int userID) {
        this.commentBody = commentBody;
        this.postID = postID;
        this.userID = userID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public int getPostID() {
        return postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "CommentRequest{" +
                "commentBody='" + commentBody + '\'' +
                ", postID=" + postID +
                ", userID=" + userID +
                '}';
    }
}