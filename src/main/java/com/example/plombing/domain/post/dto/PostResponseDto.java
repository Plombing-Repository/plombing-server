package com.example.plombing.domain.post.dto;

import com.example.plombing.domain.post.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long post_index;

    private Long user_index;

    private String post_title;

    private String post;

    private String post_title_photo;

    private Long like_count;


    public PostResponseDto (Post post) {
        this.post_index = post.getPost_index();
        this.user_index = post.getUser().getUserIndex();
        this.post_title = post.getPost_title();
        this.post = post.getPost();
        this.post_title_photo = post.getPost_title_photo();
        this.like_count = post.getLike_count();
    }
}
