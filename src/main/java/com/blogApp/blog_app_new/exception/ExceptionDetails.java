package com.blogApp.blog_app_new.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionDetails {
    public ExceptionDetails(LocalDateTime localDateTime, String message, String description, String errorCode) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.description = description;
        this.errorCode = errorCode;
    }

    private LocalDateTime localDateTime;
    private String message;
    private String description;
    private String errorCode;
}
