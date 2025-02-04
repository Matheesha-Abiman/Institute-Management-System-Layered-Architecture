package com.example.institute1.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Lecture {
    private String lectureId;
    private String moduleId;
    private String lectureName;
    private String lectureEmail;
}
