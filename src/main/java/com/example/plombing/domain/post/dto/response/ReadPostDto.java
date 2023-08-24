package com.example.plombing.domain.post.dto.response;

import com.example.plombing.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadPostDto {
    private Long postIndex;
    private String postTitle;
    private String post;

    private Long likeCount;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    private List<ReadCommentDto> readCommentDtos;

    public static ReadPostDto of(Post post){
        List<ReadCommentDto> readCommentDtos = new ArrayList<>();
        if(post.getCommentList() != null){
            post.getCommentList().forEach(comment -> {
                readCommentDtos.add(ReadCommentDto.of(comment));
            });
        }

        return ReadPostDto.builder()
                .postIndex(post.getPostIndex())
                .postTitle(post.getPostTitle())
                .post(post.getPost())
                .likeCount(post.getLikeCount())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .readCommentDtos(readCommentDtos)
                .build();
    }

}
