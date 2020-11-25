package com.example.movierecord.resource;

public class ErrorResource {
    private String message;
    public ErrorResource(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResource{" +
                "message='" + message + '\'' +
                '}';
    }
}
