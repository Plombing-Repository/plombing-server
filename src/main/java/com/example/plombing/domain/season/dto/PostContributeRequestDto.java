package com.example.plombing.domain.season.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostContributeRequestDto {
    private Long amount;
    private Boolean isMan;
}
