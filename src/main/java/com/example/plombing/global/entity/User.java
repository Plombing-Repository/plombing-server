package com.example.plombing.global.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
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

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Builder
    public User(String user_name, UserType userType) {
        this.user_name = user_name;
        this.userType = userType;
    }

}
