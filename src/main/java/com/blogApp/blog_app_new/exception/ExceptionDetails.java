package com.blogApp.blog_app_new.exception;

import java.time.LocalDateTime;

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
