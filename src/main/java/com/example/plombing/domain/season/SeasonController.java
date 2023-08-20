package com.example.plombing.domain.season;

import com.example.plombing.global.ResponseService;
import com.example.plombing.global.result.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/season")
public class SeasonController {

    private final ResponseService responseService;

    @GetMapping("/test")
    public CommonResult test(){
        return responseService.getSingleResult("테스트 api입니다.");
    }

}
