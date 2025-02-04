package com.example.institute1.BO;

import com.example.institute1.BO.custom.LectureBOInterface;
import com.example.institute1.DAO.DAOFactory;
import com.example.institute1.DAO.impl.LectureDAOImpl;
import com.example.institute1.dto.LectureDto;
import com.example.institute1.entity.Lecture;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LectureBOImpl implements LectureBOInterface {

    LectureDAOImpl lectureDAO = (LectureDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.LECTURE);

    @Override
    public List<LectureDto> getAllLectures() throws SQLException, ClassNotFoundException {
        ArrayList<Lecture> Lecturs = (ArrayList<Lecture>) lectureDAO.getAll();
        System.out.println(lectureDAO);
        ArrayList<LectureDto> lectureDtos = new ArrayList<>();
        for (Lecture lecture : Lecturs) {
            lectureDtos.add(new LectureDto(lecture.getLectureId(), lecture.getModuleId(), lecture.getLectureName(), lecture.getLectureEmail()));
        }
        return lectureDtos;
    }

    @Override
    public boolean saveLecture(LectureDto lectureDto) throws SQLException, ClassNotFoundException {
        Lecture lecture = new Lecture(lectureDto.getLectureId(),lectureDto.getModuleId(),lectureDto.getLectureName(),lectureDto.getLectureEmail());
        return lectureDAO.save(lecture);
    }

    @Override
    public boolean updateLecture(LectureDto lectureDto) throws SQLException, ClassNotFoundException {
        Lecture lecture = new Lecture(lectureDto.getLectureId(),lectureDto.getModuleId(),lectureDto.getLectureName(),lectureDto.getLectureEmail());
        return lectureDAO.update(lecture);
    }

    @Override
    public boolean deleteLecture(String lectureId) throws SQLException, ClassNotFoundException {
        return lectureDAO.delete(lectureId);
    }

    @Override
    public String getNextLectureID() throws SQLException, ClassNotFoundException {
        return lectureDAO.getNextLectureID();
    }
}
