package com.example.institute1.DAO.blueprint;

import com.example.institute1.DAO.CrudDAO;
import com.example.institute1.dto.CourseDto;
import com.example.institute1.entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseDAOInterface extends CrudDAO<Course> {
    public String getNextCourseID() throws SQLException, ClassNotFoundException;

    public CourseDto searchById(String selectCourseId) throws SQLException, ClassNotFoundException;

    public ArrayList<String> getAllCourseId() throws SQLException, ClassNotFoundException;
}
