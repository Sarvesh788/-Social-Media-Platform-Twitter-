package com.example.demo.DTO.commentModel;

import com.example.demo.DTO.userModel.UsersFetch;

public class CommentResponse {
    private int commentID;
    private String commentBody;
    private UsersFetch commentCreator;

    public CommentResponse(int commentID, String commentBody, UsersFetch commentCreator) {
        this.commentID = commentID;
        this.commentBody = commentBody;
        this.commentCreator = commentCreator;
    }

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

    public UsersFetch getCommentCreator() {
        return commentCreator;
    }

    public void setCommentCreator(UsersFetch commentCreator) {
        this.commentCreator = commentCreator;
    }

}
