package com.example.plombing.domain.post.dto;

import com.example.plombing.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {


    private String postTitle;

    private String post;

    private String postTitlePhoto;

    private Long likeCount;

    @Builder
    PostRequestDto (Post post) {
        this.postTitle = post.getPostTitle();
        this.post = post.getPost();
        this.postTitlePhoto = post.getPostTitlePhoto();
        this.likeCount = post.getLikeCount();
    }

}
