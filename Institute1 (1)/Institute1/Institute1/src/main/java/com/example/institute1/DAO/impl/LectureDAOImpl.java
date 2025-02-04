package com.example.institute1.DAO.impl;

import com.example.institute1.DAO.blueprint.LectureDAOInterface;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.entity.Lecture;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LectureDAOImpl implements LectureDAOInterface {
    @Override
    public List<Lecture> getAll() throws SQLException, ClassNotFoundException {
        List<Lecture> lectures = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM Lecture");
        while (rs.next()) {
            lectures.add(new Lecture(
                    rs.getString("lecture_id"),
                    rs.getString("module_id"),
                    rs.getString("name"),
                    rs.getString("email")
            ));
        }
        return lectures;
    }

    @Override
    public boolean save(Lecture lectureDto) throws SQLException, ClassNotFoundException {
       boolean result = CrudUtil.execute("INSERT INTO Lecture (lecture_id, module_id, name, email) VALUES (?, ?, ?, ?)",
               lectureDto.getLectureId(), lectureDto.getModuleId(), lectureDto.getLectureName(), lectureDto.getLectureEmail());
       if (result) {
           System.out.println("Lecture saved");
       }else {
           System.out.println("Lecture not saved");
       }
       return result;
    }

    @Override
    public boolean update(Lecture lectureDto) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("UPDATE Lecture SET module_id = ?, name = ?, email = ? WHERE lecture_id = ?",
                lectureDto.getModuleId(), lectureDto.getLectureName(), lectureDto.getLectureEmail(), lectureDto.getLectureId());
        if (result) {
            System.out.println("Lecture updated");
        }else {
            System.out.println("Lecture not updated");
        }
        return result;
    }

    @Override
    public boolean delete(String lectureId) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("DELETE FROM Lecture WHERE lecture_id = ?", lectureId);
        if (result) {
            System.out.println("Lecture deleted");
        }else {
            System.out.println("Lecture not deleted");
        }
        return result;
    }

    @Override
    public String getNextLectureID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT lecture_id FROM Lecture ORDER BY lecture_id DESC LIMIT 1");
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            int nextIndex = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("L%03d", nextIndex);
        }
        return "L001";
    }
}
