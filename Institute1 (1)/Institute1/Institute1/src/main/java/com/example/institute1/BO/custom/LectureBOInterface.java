package com.example.institute1.BO.custom;

import com.example.institute1.BO.SuperBO;
import com.example.institute1.dto.LectureDto;

import java.sql.SQLException;
import java.util.List;

public interface LectureBOInterface extends SuperBO {
    public List<LectureDto> getAllLectures() throws SQLException, ClassNotFoundException;

    public boolean saveLecture(LectureDto lectureDto) throws SQLException, ClassNotFoundException;

    public boolean updateLecture(LectureDto lectureDto) throws SQLException, ClassNotFoundException;

    public boolean deleteLecture(String lectureId) throws SQLException, ClassNotFoundException;

    public String getNextLectureID() throws SQLException, ClassNotFoundException;

}
