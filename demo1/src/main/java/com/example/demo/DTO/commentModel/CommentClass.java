package com.example.demo.DTO.commentModel;

public class CommentClass {
    private int commentID;
    private String commentBody;
    private CommentCreator commentCreator;

    // Constructor, getters, and setters
    // Constructor
    public CommentClass(int commentID, String commentBody, CommentCreator commentCreator) {
        this.commentID = commentID;
        this.commentBody = commentBody;
        this.commentCreator = commentCreator;
    }

    // Getters and setters
    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public CommentCreator getCommentCreator() {
        return commentCreator;
    }

    public void setCommentCreator(CommentCreator commentCreator) {
        this.commentCreator = commentCreator;
    }
}
