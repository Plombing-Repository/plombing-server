package com.example.plombing.domain.season.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Plombing {

    @Id
    @Column(name = "plombing_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plombingIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seasonIndex")
    private Season season;

    @OneToOne
    @JoinColumn(name = "levelIndex")
    private Level level;

    private Long quantity;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "end_at")
    private Timestamp endAt;

}
