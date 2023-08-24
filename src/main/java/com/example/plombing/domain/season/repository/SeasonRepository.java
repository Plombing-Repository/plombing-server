package com.example.plombing.domain.season.repository;

import com.example.plombing.domain.season.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeasonRepository extends JpaRepository<Season, Long> {
    Optional<Season> findSeasonBySeasonIndex(Long seasonIndex);
}
