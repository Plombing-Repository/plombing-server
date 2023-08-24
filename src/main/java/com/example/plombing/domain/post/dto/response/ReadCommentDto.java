package com.example.plombing.domain.post.dto.response;

import com.example.plombing.domain.post.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadCommentDto {
    private Long commentIndex;
    private String comment;
    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public static ReadCommentDto of(Comment comment){
        return ReadCommentDto.builder()
                .commentIndex(comment.getCommentIndex())
                .comment(comment.getComment())
                .password(comment.getPassword())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
