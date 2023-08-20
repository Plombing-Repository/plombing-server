package com.example.plombing.global.entity;

public enum UserType {
    editor("에디터"),
    anonymity("익명"),
    admin("관리자");

    final private String name;

    public String getName(){
        return name;
    }

    private UserType(String name){
        this.name = name;
    }
}
