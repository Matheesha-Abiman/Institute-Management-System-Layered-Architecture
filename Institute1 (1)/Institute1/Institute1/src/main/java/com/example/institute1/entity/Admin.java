package com.example.institute1.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {

    private String adminId;
    private String adminName;
    private String adminEmail;
    private String adminPassword;
}
