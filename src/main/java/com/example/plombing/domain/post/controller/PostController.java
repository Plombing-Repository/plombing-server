package com.example.plombing.domain.post.controller;

import com.example.plombing.global.ResponseService;
import com.example.plombing.global.result.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/post")
public class PostController {

    private final ResponseService responseService;

//    @GetMapping("/test")
//    public CommonResult test(){
//        return responseService.getSingleResult("테스트 api입니다.");
//    }
//
//    // 전체 게시판 페이지 조회
//    @GetMapping("")
//    public ResponseEntity<>() {
//
//    }
//
//    // 게시판 검색
//    @GetMapping("/search?")
//    public ResponseEntity<>(){
//
//    }
//
//    // 게시판 등록
//    @PostMapping("")
//    public ResponseEntity<>() {
//
//    }
//
//
//    // 게시판 수정
//    @PatchMapping("/{post_index}")
//    public
//
//    // 게시판 삭제
//    @DeleteMapping("/{post_index}")
//    public ResponseEntity<> deletePost(@PathVariable post_index) {
//
//    }


}
