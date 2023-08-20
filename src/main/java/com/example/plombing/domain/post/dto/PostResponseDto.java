package com.example.plombing.domain.post.dto;

import com.example.plombing.domain.post.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long postIndex;

    private Long userIndex;

    private String postTitle;

    private String post;

    private String postTitlePhoto;

    private Long likeCount;


    public PostResponseDto (Post post) {
        this.postIndex = post.getPostIndex();
        this.userIndex = post.getUser().getUserIndex();
        this.postTitle = post.getPostTitle();
        this.post = post.getPost();
        this.postTitlePhoto = post.getPostTitlePhoto();
        this.likeCount = post.getLikeCount();
    }
}
