package com.example.plombing.domain.post.exception;

import com.example.plombing.global.exception.ApplicationException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PostException extends ApplicationException {

    protected PostException(String errorCode, HttpStatus httpStatus, String message) {
        super(errorCode, httpStatus, message);
    }

}