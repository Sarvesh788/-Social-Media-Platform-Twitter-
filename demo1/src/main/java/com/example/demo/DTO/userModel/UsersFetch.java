package com.example.demo.DTO.userModel;


public class UsersFetch {

    private int userID;
    private String name;

    // Constructors
    public UsersFetch() {
    }

    public UsersFetch(String name, int userID) {
        this.userID = userID;
        this.name = name;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }


    // toString method
    @Override
    public String toString() {
        return "UserResponse{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                '}';
    }
}
