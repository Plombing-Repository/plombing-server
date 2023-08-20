package com.example.plombing.domain.post.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long comment_index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_index", nullable = false)
    private Post post;

    @Column(nullable = false)
    private String comment;

    @Column
    private String password;

    @Builder
    public Comment (Post post, String comment, String password) {
        this.post = post;
        this.comment = comment;
        this.password = password;
    }

}
