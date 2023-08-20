package com.example.plombing.domain.post.exception;

public class NotFoundPost extends PostException {
    public NotFoundPost() {
        super(PostExceptionList.NOT_FOUND_POST.getCODE(),
                PostExceptionList.NOT_FOUND_POST.getHttpStatus(),
                PostExceptionList.NOT_FOUND_POST.getMESSAGE()
        );
    }
}