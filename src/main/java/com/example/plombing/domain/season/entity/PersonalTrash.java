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
public class PersonalTrash {

    @Id
    @Column(name = "personal_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personalIndex;

    @OneToOne
    @JoinColumn(name = "season_index")
    private Season season;

    @Column(name = "quantity_total")
    private Long quantityTotal;

    private Double percentage;

    @Column(name = "created_at")
    private Timestamp createdAt;

}
