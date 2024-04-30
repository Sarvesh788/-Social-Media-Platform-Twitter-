package com.example.demo;

public class ResponseStructure {
    private String error;

    public ResponseStructure(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "{\"Error\": \"" + error + "\"}";
    }
}


