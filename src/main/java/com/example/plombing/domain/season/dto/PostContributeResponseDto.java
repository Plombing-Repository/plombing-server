package com.example.plombing.domain.season.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class PostContributeResponseDto {
    private final Long myTrash;
    private final Long nowLevelPercent;
    private final Long workResult;
}
