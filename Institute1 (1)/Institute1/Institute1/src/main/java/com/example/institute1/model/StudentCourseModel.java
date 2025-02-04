//package com.example.institute1.model;
//
//import com.example.institute1.crud.CrudUtil;
//import com.example.institute1.dto.StudentCourseDto;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StudentCourseModel {
//
//    public static List<StudentCourseDto> getAllStudentCourses() throws SQLException, ClassNotFoundException {
//        List<StudentCourseDto> sCourses = new ArrayList<>();
//        ResultSet resultSet = CrudUtil.execute("SELECT student_id, course_id FROM Student_course");
//        while (resultSet.next()) {
//            sCourses.add(new StudentCourseDto(
//                    resultSet.getString("student_id"),
//                    resultSet.getString("course_id")
//            ));
//        }
//        return sCourses;
//    }
//}
