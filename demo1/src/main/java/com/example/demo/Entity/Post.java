package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postID;
    private String postBody;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private Users user;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate date;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    // Constructors
    public Post() {

    }

    public Post(String postBody, Users user) {
        this.postBody = postBody;
        this.user = user;
        this.date = LocalDate.now();
    }

    // Getters and Setters
    public int getPostId() {
        return postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setPostId(int id) {
        this.postID = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    // Additional helper methods to manage comments
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setPost(null);
    }

    // toString method
    @Override
    public String toString() {
        return "Post{" +
                "id=" + postID +
                ", postBody='" + postBody + '\'' +
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}
