package com.example.demo.DTO.userModel;

public class UserResponse {

    private String name;
    private int userID;
    private String email;

    // Constructors
    public UserResponse() {
    }

    public UserResponse(String name, int userID, String email) {
        this.name = name;
        this.userID = userID;
        this.email = email;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method
    @Override
    public String toString() {
        return "UserResponse{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
