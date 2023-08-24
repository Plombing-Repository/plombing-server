package com.example.plombing.domain.post.entity;

import com.example.plombing.domain.post.dto.request.CreatePostDto;
import com.example.plombing.global.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Post")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity{

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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    @Builder
    public Post (User user, String postTitle, String post, String postTitlePhoto, Long likeCount ) {
        this.user = user;
        this.postTitle = postTitle;
        this.post = post;
        this.postTitlePhoto = postTitlePhoto;
        this.likeCount = likeCount;
    }

    public static Post of(User user, CreatePostDto createPostDto){
        return Post.builder()
                .user(user)
                .postTitle(createPostDto.getPostTitle())
                .post(createPostDto.getPost())
                .likeCount(0L)
                .build();
    }

    public void updateLikeCount(){
        this.likeCount += 1;
    }

}
