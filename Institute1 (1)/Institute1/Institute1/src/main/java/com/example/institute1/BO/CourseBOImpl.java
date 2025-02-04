package com.example.institute1.BO;

import com.example.institute1.BO.custom.CourseBOInterface;
import com.example.institute1.DAO.DAOFactory;
import com.example.institute1.DAO.impl.CourseDAOImpl;
import com.example.institute1.dto.CourseDto;
import com.example.institute1.entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBOInterface {

    CourseDAOImpl courseDAO = (CourseDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);

    @Override
    public String getNextCourseID() throws SQLException, ClassNotFoundException {
        return courseDAO.getNextCourseID();
    }

    @Override
    public List<CourseDto> getAllCourses() throws SQLException, ClassNotFoundException {
        ArrayList<Course> courses = (ArrayList<Course>) courseDAO.getAll();
        ArrayList<CourseDto> courseDtos = new ArrayList<>();
        for (Course course : courses) {
            courseDtos.add(new CourseDto(course.getCourseId(), course.getAdminId(), course.getCourseName(), course.getCourseFee(), course.getCourseDescription()));
        }
        return courseDtos;
    }

    @Override
    public boolean saveCourse(CourseDto courseDto) throws SQLException, ClassNotFoundException {
        Course course = new Course(courseDto.getCourseId(),courseDto.getAdminId(),courseDto.getCourseName(),courseDto.getCourseFee(),courseDto.getCourseDescription());
        return courseDAO.save(course);
    }

    @Override
    public boolean updateCourse(CourseDto courseDto) throws SQLException, ClassNotFoundException {
        Course course = new Course(courseDto.getCourseId(),courseDto.getAdminId(),courseDto.getCourseName(),courseDto.getCourseFee(),courseDto.getCourseDescription());
        return courseDAO.update(course);
    }

    @Override
    public boolean deleteCourse(String courseId) throws SQLException, ClassNotFoundException {
        return courseDAO.delete(courseId);
    }

    @Override
    public ArrayList<String> getAllCourseId() throws SQLException, ClassNotFoundException {
        ArrayList<String> courseIds = new ArrayList<>();
        List<String> ids = courseDAO.getAllCourseId();
        courseIds.addAll(ids);

        return courseIds;
    }

    @Override
    public CourseDto searchById(String selectCourseId) throws SQLException, ClassNotFoundException {
        return courseDAO.searchById(selectCourseId);
    }


}
