package com.example.plombing.domain.season.repository;

import com.example.plombing.domain.season.entity.Plombing;
import com.example.plombing.domain.season.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlombingRepository extends JpaRepository<Plombing, Long> {
}
