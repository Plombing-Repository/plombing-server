package com.example.plombing.domain.post.dto;

import com.example.plombing.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {


    private String post_title;

    private String post;

    private String post_title_photo;

    private Long like_count;

    @Builder
    PostRequestDto (Post post) {
        this.post_title = post.getPost_title();
        this.post = post.getPost();
        this.post_title_photo = post.getPost_title_photo();
        this.like_count = post.getLike_count();
    }

}
