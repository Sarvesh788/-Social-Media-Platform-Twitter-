package com.example.demo.DTO.postModel;

import com.example.demo.DTO.commentModel.CommentResponse;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.List;

public class PostResponse {
    private int postID;
    private String postBody;

    @Temporal(TemporalType.DATE) // Use TemporalType.DATE for LocalDate
    private LocalDate date;
    private List<CommentResponse> comments;

    public PostResponse(int postID, String postBody, LocalDate date, List<CommentResponse> comments) {
        this.postID = postID;
        this.postBody = postBody;
        this.date = date;
        this.comments = comments;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<CommentResponse> getComments() {
        return comments;
    }

    public void setComments(List<CommentResponse> comments) {
        this.comments = comments;
    }
}
