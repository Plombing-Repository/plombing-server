package com.example.plombing.domain.season.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class PostContributeRequestDto {
    private final Long amount;
    private final Boolean isMan;
}
