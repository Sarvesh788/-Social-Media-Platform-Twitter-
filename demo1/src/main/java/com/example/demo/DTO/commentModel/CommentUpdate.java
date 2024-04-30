package com.example.demo.DTO.commentModel;

// CommentUpdate.java
public class CommentUpdate {
    private String commentBody;
    private int commentID;

    // Constructors, getters, and setters

    public CommentUpdate() {
    }

    public CommentUpdate(int commentID, String commentBody) {
        this.commentID = commentID;
        this.commentBody = commentBody;
    }

    public int getCommentID() {
        return commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    @Override
    public String toString() {
        return "CommentUpdate{" +
                "commentID=" + commentID +
                ", commentBody='" + commentBody + '\'' +
                '}';
    }
}