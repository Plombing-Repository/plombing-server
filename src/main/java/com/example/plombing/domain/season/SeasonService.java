package com.example.plombing.domain.season;

import com.example.plombing.domain.season.dto.GetProgressResponseDto;
import com.example.plombing.domain.season.dto.PostContributeRequestDto;
import com.example.plombing.domain.season.dto.PostContributeResponseDto;
import com.example.plombing.domain.season.repository.LevelRepository;
import com.example.plombing.domain.season.repository.PersonalTrashRepository;
import com.example.plombing.domain.season.repository.PlombingRepository;
import com.example.plombing.domain.season.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeasonService {

    private final LevelRepository levelRepository;
    private final PersonalTrashRepository personalTrashRepository;
    private final PlombingRepository plombingRepository;
    private final SeasonRepository seasonRepository;

    public GetProgressResponseDto getProgress(String date) {

        return null;
    }

    public PostContributeResponseDto postContribute(PostContributeRequestDto postContributeRequestDto) {
        return null;
    }
}
