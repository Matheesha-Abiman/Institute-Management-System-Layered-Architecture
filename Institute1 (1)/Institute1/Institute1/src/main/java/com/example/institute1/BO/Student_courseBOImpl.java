package com.example.institute1.BO;

import com.example.institute1.BO.custom.Student_courseBOInterface;
import com.example.institute1.DAO.DAOFactory;
import com.example.institute1.DAO.impl.Student_courseDAOImpl;
import com.example.institute1.dto.StudentCourseDto;
import com.example.institute1.entity.Student_course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student_courseBOImpl implements Student_courseBOInterface {

   Student_courseDAOImpl student_courseDAO = (Student_courseDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT_COURSE);

    @Override
    public List<StudentCourseDto> getAllStudentCourses() throws SQLException, ClassNotFoundException {
        ArrayList<Student_course> studentCourses = (ArrayList<Student_course>) student_courseDAO.getAll();
        ArrayList<StudentCourseDto> studentCourseDtos = new ArrayList<>();
        for (Student_course studentCourse : studentCourses) {
            studentCourseDtos.add(new StudentCourseDto(studentCourse.getStudentId(),studentCourse.getCourseId()));
        }
        return studentCourseDtos;
    }
}
