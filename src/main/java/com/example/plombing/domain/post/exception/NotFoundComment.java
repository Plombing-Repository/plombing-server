package com.example.plombing.domain.post.exception;

public class NotFoundComment extends PostException {
    public NotFoundComment() {
        super(PostExceptionList.NOT_FOUND_COMMENT.getCODE(),
                PostExceptionList.NOT_FOUND_COMMENT.getHttpStatus(),
                PostExceptionList.NOT_FOUND_COMMENT.getMESSAGE()
        );
    }
}