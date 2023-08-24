package com.example.plombing.domain.season;

import com.example.plombing.domain.season.dto.GetProgressResponseDto;
import com.example.plombing.domain.season.dto.PostContributeRequestDto;
import com.example.plombing.domain.season.dto.PostContributeResponseDto;
import com.example.plombing.domain.season.entity.Plombing;
import com.example.plombing.domain.season.entity.Season;
import com.example.plombing.domain.season.repository.PersonalTrashRepository;
import com.example.plombing.domain.season.repository.PlombingRepository;
import com.example.plombing.domain.season.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeasonService {
    private final PersonalTrashRepository personalTrashRepository;
    private final PlombingRepository plombingRepository;
    private final SeasonRepository seasonRepository;

    public GetProgressResponseDto getProgress() {
        LocalDate now = LocalDate.now();
        double now_month = now.getMonthValue();
        Long season_index = (long)(Math.floor(now_month/4)) + now.getYear()-2023-1;
        Optional<Season> now_season = seasonRepository.findSeasonBySeasonIndex(season_index);
        if(now_season.isPresent()){
            Long total_users = now_season.get().getPlombingList().stream().count();
            Long total_sum = now_season.get()
                    .getPlombingList()
                    .stream().mapToLong(i -> i.getQuantity())
                    .sum();
            Long total_percent = (total_sum/ 100);
            return GetProgressResponseDto.of(total_percent, total_users);
        } else {
            Season season = new Season();
            season.setSeasonIndex(season_index);
            seasonRepository.save(season);
            return GetProgressResponseDto.of((long)0, (long)0);
        }
    }

    public PostContributeResponseDto postContribute(PostContributeRequestDto postContributeRequestDto) {
        long total_sum = 0;
        long total_percent = 0;
        LocalDate now = LocalDate.now();
        double now_month = now.getMonthValue();
        Long season_index = (long)(Math.floor(now_month/4)) + now.getYear()-2023-1;
        Optional<Season> now_season = seasonRepository.findSeasonBySeasonIndex(season_index);
        Plombing plombing = new Plombing();

        if(now_season.isPresent()){
            plombing.setSeason(now_season.get());
            plombing.setQuantity(postContributeRequestDto.getAmount());
            total_sum = now_season.get()
                    .getPlombingList()
                    .stream().mapToLong(i -> i.getQuantity())
                    .sum();
            total_sum += postContributeRequestDto.getAmount();
            total_percent = (total_sum/ 100);
        } else {
            Season season = new Season();
            season.setSeasonIndex(season_index);
            season.setAchievedPeople((long)0);

            seasonRepository.save(season);
            total_percent = postContributeRequestDto.getAmount() / 100;
        }

        plombingRepository.save(plombing);

        long progress_percent = Math.round(((double)(total_percent % 33) / (double)33)*100);
        if(total_sum >= 10000)
            progress_percent = 0;
        if(postContributeRequestDto.getIsMan()){
            return PostContributeResponseDto.of(postContributeRequestDto.getAmount(), progress_percent,postContributeRequestDto.getAmount()*31);
        } else {
            return PostContributeResponseDto.of(postContributeRequestDto.getAmount(), progress_percent,postContributeRequestDto.getAmount()*23);
        }
    }
}
