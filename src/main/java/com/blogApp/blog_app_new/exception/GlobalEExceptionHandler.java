package com.blogApp.blog_app_new.exception;

import com.blogApp.blog_app_new.utility.ConstantCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalEExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorObject> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest req){
        ExceptionDetails exceptionDetails=new ExceptionDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                req.getDescription(false),
                ConstantCodes.HTTP_404
        );
        List<ExceptionDetails> details=new ArrayList<>();
        details.add(exceptionDetails);
        ErrorObject eo=new ErrorObject(false,details);
        return new ResponseEntity<>(eo, HttpStatus.NOT_FOUND);
    }
}
