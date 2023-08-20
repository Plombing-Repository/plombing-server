package com.example.plombing.domain.post.dto;

import com.example.plombing.domain.post.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {

    private String comment;

    private String password;


    @Builder
    public CommentRequestDto (Comment comment) {
        this.comment = comment.getComment();
        this.password = comment.getPassword();
    }
}
