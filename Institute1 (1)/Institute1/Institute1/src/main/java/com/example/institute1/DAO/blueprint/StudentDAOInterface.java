package com.example.institute1.DAO.blueprint;

import com.example.institute1.DAO.CrudDAO;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.db.DBConnection;
import com.example.institute1.dto.StudentDto;
import com.example.institute1.entity.Student;

import java.sql.Connection;
import java.sql.SQLException;

public interface StudentDAOInterface extends CrudDAO<Student> {
    public  boolean saveStudent(Student studentDto, String courseId) throws SQLException, ClassNotFoundException ;

    public  boolean updateStudentWithCourse(Student studentDto, String newCourseId) throws SQLException, ClassNotFoundException ;

    public String getCourseId(String courseName) throws SQLException, ClassNotFoundException;

    public String getNextStudentID() throws SQLException, ClassNotFoundException;

}
