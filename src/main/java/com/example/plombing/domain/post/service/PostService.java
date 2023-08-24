package com.example.plombing.domain.post.service;

import com.example.plombing.domain.post.dto.request.*;
import com.example.plombing.domain.post.dto.response.*;
import com.example.plombing.domain.post.entity.Comment;
import com.example.plombing.domain.post.entity.Post;
import com.example.plombing.domain.post.exception.NotFoundComment;
import com.example.plombing.domain.post.exception.NotFoundPost;
import com.example.plombing.domain.post.repository.CommentRepository;
import com.example.plombing.domain.post.repository.PostRepository;
import com.example.plombing.global.entity.User;
import com.example.plombing.global.entity.UserType;
import com.example.plombing.global.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void updatePostLike(Long postIndex) {
        Post post = postRepository.findById(postIndex)
                .orElseThrow(()-> new NotFoundPost());
        post.updateLikeCount();
        postRepository.save(post);
    }

    public List<ReadPostDto> readPosts() {
        List<Post> posts = postRepository.findAll();
        List<ReadPostDto> readPostDtos = new ArrayList<>();
        posts.forEach(post -> {
            readPostDtos.add(ReadPostDto.of(post));
        });
        return readPostDtos;
    }

    public ReadPostDto readPost(Long postIndex) {
        Post post = postRepository.findById(postIndex)
                .orElseThrow(()-> new NotFoundPost());
        return ReadPostDto.of(post);
    }

    @Transactional
    public ReadPostDto createPost(CreatePostDto createPostDto) {
        User user = userRepository.findByUserType(UserType.anonymity);
        Post post = Post.of(user, createPostDto);
        Post savePost = postRepository.save(post);
        return ReadPostDto.of(savePost);
    }

//    public ReadPostDto updatePost(Long postIndex, UpdatePostDto updatePostDto) {
//        Post post = postRepository.findById(postIndex)
//                .orElseThrow(()-> new NotFoundPost());
//
//    }

    @Transactional
    public String deletePost(Long postIndex) {
        Post post = postRepository.findById(postIndex)
                .orElseThrow(()-> new NotFoundPost());
        postRepository.delete(post);
        return "게시글이 삭제되었습니다.";
    }

//    public List<ReadPostDto> searchPost(String search) {
//    }

    public List<ReadCommentDto> readComment(Long postIndex) {
        Post post = postRepository.findById(postIndex)
                .orElseThrow(()-> new NotFoundPost());
        List<ReadCommentDto> readCommentDtos = new ArrayList<>();
        if(post.getCommentList() != null){
            post.getCommentList().forEach(comment -> {
                readCommentDtos.add(ReadCommentDto.of(comment));
            });
        }
        return readCommentDtos;
    }

    @Transactional // 유무 차이
    public ReadCommentDto createComment(Long postIndex, CreateCommentDto createCommentDto) {
        Post post = postRepository.findById(postIndex)
                .orElseThrow(()-> new NotFoundPost());
        Comment comment = Comment.of(post, createCommentDto);
        Comment saveComment = commentRepository.save(comment);
        return ReadCommentDto.of(saveComment);
    }

    @Transactional
    public ReadCommentDto updateComment(Long commentIndex, UpdateCommentDto updateCommentDto, String password) {
        Comment comment = commentRepository.findByCommentIndexAndPassword(commentIndex, password)
                .orElseThrow(() -> new NotFoundComment());

        comment.editComment(updateCommentDto.getComment() != null ? updateCommentDto.getComment() : comment.getComment(),
                updateCommentDto.getPassword() != null ? updateCommentDto.getPassword() : comment.getPassword());
        Comment saveComment = commentRepository.save(comment);
        return ReadCommentDto.of(saveComment);
    }

    @Transactional
    public String deleteComment(Long commentIndex, String password) {
        Comment comment = commentRepository.findByCommentIndexAndPassword(commentIndex, password)
                .orElseThrow(() -> new NotFoundComment());
        commentRepository.delete(comment);
        return "댓글이 삭제되었습니다.";
    }

}
