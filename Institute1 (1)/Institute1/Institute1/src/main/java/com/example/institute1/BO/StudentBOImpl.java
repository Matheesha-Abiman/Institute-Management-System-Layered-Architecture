package com.example.institute1.BO;

import com.example.institute1.BO.custom.StudentBOInterface;
import com.example.institute1.DAO.DAOFactory;
import com.example.institute1.DAO.impl.StudentDAOImpl;
import com.example.institute1.dto.StudentDto;
import com.example.institute1.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBOInterface {
    StudentDAOImpl studentDAO = ( StudentDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public boolean saveStudent(StudentDto studentDto, String courseId) throws SQLException, ClassNotFoundException {
        Student student = new Student(studentDto.getStudentId(),
                studentDto.getAdminId(),
                studentDto.getParentId(),
                studentDto.getName(),
                studentDto.getAddress(),
                studentDto.getDob());


        return studentDAO.saveStudent(student,courseId);
    }

    @Override
    public boolean updateStudentWithCourse(StudentDto studentDto, String newCourseId) throws SQLException, ClassNotFoundException {
        Student student = new Student(studentDto.getStudentId(),
                studentDto.getAdminId(),
                studentDto.getParentId(),
                studentDto.getName(),
                studentDto.getAddress(),
                studentDto.getDob());
        return studentDAO.updateStudentWithCourse(student,newCourseId);
    }

    @Override
    public boolean deleteStudent(String studentId) throws SQLException, ClassNotFoundException {
       return studentDAO.delete(studentId);
    }

    @Override
    public List<StudentDto> getAllStudents() throws SQLException, ClassNotFoundException {
        ArrayList<Student> students = (ArrayList<Student>) studentDAO.getAll();
        ArrayList<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(new StudentDto(student.getStudentId(),student.getAdminId(),student.getParentId(),student.getName(),student.getAddress(),student.getDob()));
        }
        return studentDtos;
    }

    @Override
    public String getCourseId(String courseName) throws SQLException, ClassNotFoundException {
        return studentDAO.getCourseId(courseName);
    }

    @Override
    public String getNextStudentID() throws SQLException, ClassNotFoundException {
        return studentDAO.getNextStudentID();
    }
}
