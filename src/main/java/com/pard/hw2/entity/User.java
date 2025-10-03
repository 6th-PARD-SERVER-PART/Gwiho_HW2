package com.pard.hw2.entity;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String name;
    private int age;
    private String beltColor;
    private String network;

    public void updateName(String name) {
        this.name = name;
    }
    public void updateAge(int age) {
        this.age = age;
    }
    public void updateBeltColor(String beltColor) {
        this.beltColor = beltColor;
    }
    public void updateNetwork(String network) {
        this.network = network;
    }
}
