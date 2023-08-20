package com.example.plombing.domain.post.dto;

import com.example.plombing.domain.post.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {


    private Long commentIndex;

    private Long postIndex;

    private String comment;

    private String password;

    public CommentResponseDto (Comment comment) {
        this.commentIndex = comment.getCommentIndex();
        this.postIndex = comment.getPost().getPostIndex();
        this.comment = comment.getComment();
        this.password =comment.getPassword();
    }
}
