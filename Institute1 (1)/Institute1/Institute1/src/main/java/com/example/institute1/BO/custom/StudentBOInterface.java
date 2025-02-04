package com.example.institute1.BO.custom;

import com.example.institute1.BO.SuperBO;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.db.DBConnection;
import com.example.institute1.dto.StudentDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface StudentBOInterface extends SuperBO {
    public  boolean saveStudent(StudentDto studentDto, String courseId) throws SQLException, ClassNotFoundException ;

    public  boolean updateStudentWithCourse(StudentDto studentDto, String newCourseId) throws SQLException, ClassNotFoundException ;

    public  boolean deleteStudent(String studentId) throws SQLException, ClassNotFoundException ;

    public List<StudentDto> getAllStudents() throws SQLException, ClassNotFoundException;

    public String getCourseId(String courseName) throws SQLException, ClassNotFoundException;

    public String getNextStudentID() throws SQLException, ClassNotFoundException;
}
