package com.blogApp.blog_app_new.exception;

import lombok.Data;

import java.util.List;

@Data
public class ErrorObject {
    public ErrorObject(boolean success, List<ExceptionDetails> exceptionDetails) {
        this.success = success;
        this.exceptionDetails = exceptionDetails;
    }

    boolean success;
    List<ExceptionDetails> exceptionDetails;
}
