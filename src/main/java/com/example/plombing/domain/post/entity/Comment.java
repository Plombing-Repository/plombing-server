package com.example.plombing.domain.post.entity;

import com.example.plombing.domain.post.dto.request.CreateCommentDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "comment_index", nullable = false)
    private Long commentIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postIndex", nullable = false)
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

    public static Comment of(Post post, CreateCommentDto createCommentDto){
        return Comment.builder()
                .post(post)
                .comment(createCommentDto.getComment())
                .password(createCommentDto.getPassword())
                .build();
    }

    public void editComment(String comment, String password){
        this.comment = comment;
        this.password = password;
    }

}
