package com.example.demo.DTO.userModel;
import jakarta.persistence.*;

public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String email;

    private String password;

    // Constructors
    public UserLogin() {
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                '}';
    }
}
