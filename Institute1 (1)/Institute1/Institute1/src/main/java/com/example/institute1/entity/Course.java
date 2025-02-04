package com.example.institute1.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    private String courseId;
    private String adminId;
    private String courseName;
    private String courseFee;
    private String courseDescription;
}
