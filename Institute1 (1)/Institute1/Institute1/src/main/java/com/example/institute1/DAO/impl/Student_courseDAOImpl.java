package com.example.institute1.DAO.impl;

import com.example.institute1.DAO.blueprint.Student_courseDAOInterface;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.dto.StudentCourseDto;
import com.example.institute1.entity.Student_course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student_courseDAOImpl implements Student_courseDAOInterface {
    @Override
    public List<Student_course> getAll() throws SQLException, ClassNotFoundException {
        List<Student_course> sCourses = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT student_id, course_id FROM Student_course");
        while (resultSet.next()) {
            sCourses.add(new Student_course(
                    resultSet.getString("student_id"),
                    resultSet.getString("course_id")
            ));
        }
        return sCourses;
    }

    @Override
    public boolean save(Student_course adminDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Student_course adminDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String adminId) throws SQLException, ClassNotFoundException {
        return false;
    }
}
