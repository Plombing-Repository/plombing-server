package com.example.plombing.global.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "user_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIndex;

    @Column(length = 64)
    private String user_name;

    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

}
