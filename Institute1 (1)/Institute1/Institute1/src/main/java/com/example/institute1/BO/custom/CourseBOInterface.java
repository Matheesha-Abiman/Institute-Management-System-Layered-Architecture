package com.example.institute1.BO.custom;

import com.example.institute1.BO.SuperBO;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.dto.CourseDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CourseBOInterface extends SuperBO {
    public String getNextCourseID() throws SQLException, ClassNotFoundException;

    public List<CourseDto> getAllCourses() throws SQLException, ClassNotFoundException;

    public boolean saveCourse(CourseDto courseDto) throws SQLException, ClassNotFoundException;

    public boolean updateCourse(CourseDto courseDto) throws SQLException, ClassNotFoundException;

    public boolean deleteCourse(String courseId) throws SQLException, ClassNotFoundException;

    public ArrayList<String> getAllCourseId() throws SQLException, ClassNotFoundException;

    public CourseDto searchById(String selectCourseId) throws SQLException, ClassNotFoundException;
}