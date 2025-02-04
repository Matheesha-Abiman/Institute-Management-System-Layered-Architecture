package com.example.institute1.DAO.impl;

import com.example.institute1.DAO.blueprint.CourseDAOInterface;
import com.example.institute1.DAO.blueprint.LectureDAOInterface;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.dto.CourseDto;
import com.example.institute1.entity.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAOInterface{

    @Override
    public List<Course> getAll() throws SQLException, ClassNotFoundException {
        List<Course> courses = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Course");
        while (resultSet.next()) {
            courses.add(new Course(
                    resultSet.getString("course_id"),
                    resultSet.getString("admin_id"),
                    resultSet.getString("name"),
                    resultSet.getString("fee"),
                    resultSet.getString("description")
            ));
        }
        return courses;
    }

    @Override
    public boolean save(Course courseDto) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("INSERT INTO Course (course_id, admin_id, name, fee, description) VALUES (?, ?, ?, ?, ?)",
                courseDto.getCourseId(), courseDto.getAdminId(), courseDto.getCourseName(), courseDto.getCourseFee(), courseDto.getCourseDescription());
    if (result) {
        System.out.println("Course saved");
    }else{
        System.out.println("Course not saved");
    }
    return result;
    }

    @Override
    public boolean update(Course courseDto) throws SQLException, ClassNotFoundException {
       boolean result = CrudUtil.execute("UPDATE Course SET admin_id = ?, name = ?, fee = ?, description = ? WHERE course_id = ?",
               courseDto.getAdminId(), courseDto.getCourseName(), courseDto.getCourseFee(), courseDto.getCourseDescription(), courseDto.getCourseId());
    if (result){
        System.out.println("Course updated");
    }else {
        System.out.println("Course not updated");
    }
    return result;
    }

    @Override
    public boolean delete(String courseId) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("DELETE FROM Course WHERE course_id = ?", courseId);
    if (result){
        System.out.println("Course deleted");
    }else {
        System.out.println("Course not deleted");
    }
    return result;
    }

    @Override
    public String getNextCourseID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT course_id FROM Course ORDER BY course_id DESC LIMIT 1");
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            int nextIndex = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("C%03d", nextIndex);
        }
        return "C001";
    }

    @Override
    public CourseDto searchById(String selectCourseId) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM Course WHERE course_id=?",selectCourseId);
        if(set.next()){
            return new CourseDto(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5)
            );
        }
        return null;
    }

    @Override
    public ArrayList<String> getAllCourseId() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT name From Course");

        ArrayList<String> courseIds = new ArrayList<>();
        while (set.next()){
            courseIds.add(set.getString(1));
        }
        return courseIds;
    }
}
