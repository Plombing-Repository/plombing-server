package com.example.plombing.domain.article;

import com.example.plombing.global.dto.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/article")
public class ArticleController {

    @GetMapping("/test")
    public ApplicationResponse<?> test(){
        return ApplicationResponse.ok("테스트 api입니다.");
    }

}
