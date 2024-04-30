package com.example.demo.DTO.userModel;
import jakarta.persistence.*;

public class UserSignup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String email;

    private String name;

    private String password;

    // Constructors
    public UserSignup() {
    }

    public UserSignup(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
