package com.example.plombing.domain.season;

import com.example.plombing.domain.season.dto.*;
import com.example.plombing.global.dto.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/season")
public class SeasonController {

    private final SeasonService seasonService;

    // 플로밍 진척도 확인
    @GetMapping("/progress")
    public ApplicationResponse<GetProgressResponseDto> getProgress(){
        return ApplicationResponse.ok(seasonService.getProgress());
    }

    // 플로밍 기여도 전송
    @PostMapping("/contribute")
    public ApplicationResponse<PostContributeResponseDto> postContribute(@RequestBody PostContributeRequestDto postContributeRequestDto){
        return ApplicationResponse.ok(seasonService.postContribute(postContributeRequestDto));
    }

}
