package com.example.plombing.domain.post.dto;

import com.example.plombing.domain.post.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {


    private Long comment_index;

    private Long post_index;

    private String comment;

    private String password;

    public CommentResponseDto (Comment comment) {
        this.comment_index = comment.getComment_index();
        this.post_index = comment.getPost().getPost_index();
        this.comment = comment.getComment();
        this.password =comment.getPassword();
    }
}
