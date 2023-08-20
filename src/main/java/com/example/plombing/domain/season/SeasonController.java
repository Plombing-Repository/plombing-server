package com.example.plombing.domain.season;

import com.example.plombing.global.dto.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/season")
public class SeasonController {

    @GetMapping("/test")
    public ApplicationResponse<?> test(){
        return ApplicationResponse.ok("테스트 api입니다.");
    }

}
