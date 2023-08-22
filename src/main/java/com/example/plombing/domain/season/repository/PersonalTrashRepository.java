package com.example.plombing.domain.season.repository;

import com.example.plombing.domain.season.entity.PersonalTrash;
import com.example.plombing.domain.season.entity.Plombing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalTrashRepository extends JpaRepository<PersonalTrash, Long> {
}
