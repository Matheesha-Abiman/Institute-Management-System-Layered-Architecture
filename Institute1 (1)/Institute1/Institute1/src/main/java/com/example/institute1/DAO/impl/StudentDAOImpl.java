package com.example.institute1.DAO.impl;

import com.example.institute1.DAO.blueprint.StudentDAOInterface;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.db.DBConnection;
import com.example.institute1.dto.StudentDto;
import com.example.institute1.entity.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAOInterface {
    @Override
    public List<Student> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student");
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(new Student(
                    resultSet.getString("student_id"),
                    resultSet.getString("admin_id"),
                    resultSet.getString("parent_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getDate("dob")
            ));
        }
        return students;
    }

    @Override
    public boolean save(Student studentDto) throws SQLException, ClassNotFoundException {
      return false;
    }

    @Override
    public boolean update(Student studentDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String adminId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        boolean transactionSuccessful = false;

        try {
            connection.setAutoCommit(false);

            boolean isCourseDeleted = CrudUtil.execute("DELETE FROM Student_course WHERE student_id = ?", adminId);

            if (!isCourseDeleted) {
                connection.rollback();
                return false;
            }

            boolean isStudentDeleted = CrudUtil.execute("DELETE FROM Student WHERE student_id = ?", adminId);

            if (!isStudentDeleted) {
                connection.rollback();
                return false;
            }

            connection.commit();
            transactionSuccessful = true;
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return transactionSuccessful;
    }

    @Override
    public boolean saveStudent(Student studentEntity, String courseId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        boolean transactionSuccessful = false;

        try {
            connection.setAutoCommit(false);

            boolean isStudentSaved = CrudUtil.execute("INSERT INTO Student VALUES(?,?,?,?,?,?)",
                    studentEntity.getStudentId(),
                    studentEntity.getAdminId(),
                    studentEntity.getParentId(),
                    studentEntity.getName(),
                    studentEntity.getAddress(),
                    studentEntity.getDob()
            );

            if (!isStudentSaved) {
                connection.rollback();
                return false;
            }

            boolean isStudentCourseSaved = CrudUtil.execute("INSERT INTO Student_course VALUES(?,?)",
                    studentEntity.getStudentId(),
                    courseId
            );

            if (!isStudentCourseSaved) {
                connection.rollback();
                return false;
            }

            connection.commit();
            transactionSuccessful = true;
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return transactionSuccessful;
    }

    @Override
    public boolean updateStudentWithCourse(Student studentDto, String newCourseId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        boolean transactionSuccessful = false;

        try {
            connection.setAutoCommit(false);

            boolean isStudentUpdated = CrudUtil.execute(
                    "UPDATE Student SET admin_id = ?, parent_id = ?, name = ?, address = ?, dob = ? WHERE student_id = ?",
                    studentDto.getAdminId(),
                    studentDto.getParentId(),
                    studentDto.getName(),
                    studentDto.getAddress(),
                    studentDto.getDob(),
                    studentDto.getStudentId()
            );

            if (!isStudentUpdated) {
                connection.rollback();
                return false;
            }

            boolean isCourseUpdated = CrudUtil.execute(
                    "UPDATE Student_course SET course_id = ? WHERE student_id = ?",
                    newCourseId,
                    studentDto.getStudentId()
            );

            if (!isCourseUpdated) {
                connection.rollback();
                return false;
            }

            connection.commit();
            transactionSuccessful = true;
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return transactionSuccessful;
    }


    @Override
    public String getCourseId(String courseName) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT course_id FROM Course WHERE name = ?", courseName);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public String getNextStudentID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT student_id FROM Student ORDER BY student_id DESC LIMIT 1");
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String subString = lastId.substring(1);
            int lastIdIndex = Integer.parseInt(subString);
            int nextIndex = lastIdIndex + 1;
            return String.format("S%03d", nextIndex);
        }
        return "S001";
    }
}
