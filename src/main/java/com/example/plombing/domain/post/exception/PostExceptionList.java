package com.example.plombing.domain.post.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum PostExceptionList {

    // 게시물
    NOT_FOUND_POST("P0001", HttpStatus.BAD_REQUEST, "등록된 게시글을 찾을 수가 없습니다."),

    // 댓글
    NOT_FOUND_COMMENT("C0001", HttpStatus.BAD_REQUEST, "등록된 댓글을 찾을 수가 없습니다.");

    private final String CODE;
    private final HttpStatus httpStatus;
    private final String MESSAGE;

}
