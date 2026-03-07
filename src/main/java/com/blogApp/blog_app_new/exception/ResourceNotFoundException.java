package com.blogApp.blog_app_new.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String meggage;

    public ResourceNotFoundException(String message) {
        super(message);
        this.meggage = meggage;
    }
}
