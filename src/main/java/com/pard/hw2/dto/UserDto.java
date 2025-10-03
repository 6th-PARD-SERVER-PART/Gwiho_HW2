package com.pard.hw2.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder

public class UserDto {
    private String name;
    private int age;
    private String beltColor;
    private String network;
}
