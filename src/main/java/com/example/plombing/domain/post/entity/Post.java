package com.example.plombing.domain.post.entity;

import com.example.plombing.global.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Post")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_index", nullable = false)
    private Long postIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "post_title")
    private String postTitle;

    @Column
    private String post;

    @Column(name = "post_title_photo")
    private String postTitlePhoto;

    @Column(name = "like_count")
    private Long likeCount;

    @Builder
    public Post (User user, String postTitle, String post, String postTitlePhoto, Long likeCount ) {
        this.user = user;
        this.postTitle = postTitle;
        this.post = post;
        this.postTitlePhoto = postTitlePhoto;
        this.likeCount = likeCount;
    }


}
