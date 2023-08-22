package com.example.plombing.domain.season.repository;

import com.example.plombing.domain.season.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
