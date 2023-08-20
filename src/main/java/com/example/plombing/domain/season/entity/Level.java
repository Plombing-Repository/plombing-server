package com.example.plombing.domain.season.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Level {

    @Id
    @Column(name = "level_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer levelIndex;

    private String url;
}
