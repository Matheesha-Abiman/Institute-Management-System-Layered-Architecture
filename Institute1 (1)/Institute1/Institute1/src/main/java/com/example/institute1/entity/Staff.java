package com.example.institute1.entity;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    private String staffId;
    private String adminId;
    private String staffName;
    private String email;
    private String description;
    private Double salary;
}
