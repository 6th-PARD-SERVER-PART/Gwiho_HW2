package com.pard.hw2.dto;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
public class UserResponseDto {
    private String studentName;
    private int age;
}
