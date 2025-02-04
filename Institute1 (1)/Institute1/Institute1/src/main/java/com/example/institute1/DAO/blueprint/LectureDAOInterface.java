package com.example.institute1.DAO.blueprint;

import com.example.institute1.DAO.CrudDAO;
import com.example.institute1.entity.Lecture;

import java.sql.SQLException;

public interface LectureDAOInterface extends CrudDAO<Lecture> {
    public String getNextLectureID() throws SQLException, ClassNotFoundException;
}
