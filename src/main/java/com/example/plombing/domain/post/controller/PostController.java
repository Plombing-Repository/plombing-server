package com.example.plombing.domain.post.controller;

import com.example.plombing.domain.post.dto.request.*;
import com.example.plombing.domain.post.dto.response.ReadCommentDto;
import com.example.plombing.domain.post.dto.response.ReadPostDto;
import com.example.plombing.domain.post.service.PostService;
import com.example.plombing.global.dto.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/post")
public class PostController {

    private final PostService postService;

    // 나도 궁금해요 클릭
    @GetMapping("/{postIndex}/like")
    public ApplicationResponse updatePostLike(@PathVariable Long postIndex){
        postService.updatePostLike(postIndex);
        return ApplicationResponse.ok();
    }

    // 전체 게시판 페이지 조회
    @GetMapping("")
    public ApplicationResponse<List<ReadPostDto>> readPosts(){
        return ApplicationResponse.ok(postService.readPosts());
    }

    // 게시글 하나 조회 (+ 댓글)
    @GetMapping("/{postIndex}")
    public ApplicationResponse<ReadPostDto> readPost(@PathVariable Long postIndex){
        return ApplicationResponse.ok(postService.readPost(postIndex));
    }

    // 게시글 등록
    @PostMapping("")
    public ApplicationResponse<ReadPostDto> createPost(@RequestBody CreatePostDto createPostDto){
        return ApplicationResponse.ok(postService.createPost(createPostDto));
    }

    // 게시글 수정
    @PatchMapping("/{postIndex}")
    public ApplicationResponse<?> updatePost(@PathVariable Long postIndex, @RequestBody UpdatePostDto updatePostDto){
        return ApplicationResponse.ok(postService.updatePost(postIndex, updatePostDto));
    }

    // 게시글 삭제
    @DeleteMapping("/{postIndex}")
    public ApplicationResponse<String> deletePost(@PathVariable Long postIndex){
        return ApplicationResponse.ok(postService.deletePost(postIndex));
    }

    // 게시판 검색
    @GetMapping("/search")
    public ApplicationResponse<?> searchPost(@RequestParam String keyword){
        return ApplicationResponse.ok(postService.searchPost(keyword));
    }

    /////////////////////////////////////////////////////
    // 전체 댓글 조회
    @GetMapping("/{postIndex}/comment")
    public ApplicationResponse<List<ReadCommentDto>> readComment(@PathVariable Long postIndex){
        return ApplicationResponse.ok(postService.readComment(postIndex));
    }

    // 댓글 등록
    @PostMapping("/{postIndex}/comment")
    public ApplicationResponse<ReadCommentDto> createComment(@PathVariable Long postIndex, @RequestBody CreateCommentDto createCommentDto){
        return ApplicationResponse.ok(postService.createComment(postIndex, createCommentDto));
    }

    // 댓글 수정
    @PatchMapping("/comment/{commentIndex}")
    public ApplicationResponse<ReadCommentDto> updateComment(@PathVariable Long commentIndex,
                                                             @RequestBody UpdateCommentDto updateCommentDto,
                                                             @RequestBody String password){
        return ApplicationResponse.ok(postService.updateComment(commentIndex,updateCommentDto, password));
    }

    // 댓글 삭제
    @DeleteMapping("/comment/{commentIndex}")
    public ApplicationResponse<String> deleteComment(@PathVariable Long commentIndex,
                                                     @RequestBody String password){
        return ApplicationResponse.ok(postService.deleteComment(commentIndex, password));
    }

}