package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentID;

    private String commentBody;

    @ManyToOne
    @JoinColumn(name = "postid", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private Users user;

    // Constructors
    public Comment() {
    }

    public Comment(String commentBody, Post post, Users user) {
        this.commentBody = commentBody;
        this.post = post;
        this.user = user;
    }

    // Getters and Setters
    public int getCommentID() {
        return commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setCommentID(int id) {
        this.commentID = id;
    }

    // toString method
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + commentID +
                ", commentBody='" + commentBody + '\'' +
                ", post=" + post +
                ", user=" + user +
                '}';
    }
}
