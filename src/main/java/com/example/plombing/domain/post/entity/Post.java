package com.example.plombing.domain.post.entity;

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
    @Column(nullable = false)
    private Long post_index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column
    private String post_title;

    @Column
    private String post;

    @Column
    private String post_title_photo;

    @Column
    private Long like_count;

    @Builder
    public Post (User user, String post_title, String post, String post_title_photo, Long like_count ) {
        this.user = user;
        this.post_title = post_title;
        this.post = post;
        this.post_title_photo = post_title_photo;
        this.like_count = like_count;
    }


}
