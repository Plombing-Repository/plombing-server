package com.example.plombing.domain.season.entity;

import com.example.plombing.global.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Season {

    @Id
    @Column(name = "season_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seasonIndex;

    @Column(name = "achieved_people")
    private Long achievedPeople;

    @Column(name = "start_period", length = 8)
    private String startPeriod;

    @Column(name = "end_period", length = 8)
    private String endPeriod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_index")
    private User user;

    @OneToMany(mappedBy = "season")
    private List<Plombing> plombingList = new ArrayList<>();

}
