package com.example.institute1.BO.custom;

import com.example.institute1.BO.SuperBO;
import com.example.institute1.dto.StudentCourseDto;

import java.sql.SQLException;
import java.util.List;

public interface Student_courseBOInterface extends SuperBO {
    public List<StudentCourseDto> getAllStudentCourses() throws SQLException, ClassNotFoundException;
}
