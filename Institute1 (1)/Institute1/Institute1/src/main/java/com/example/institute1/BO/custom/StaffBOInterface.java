package com.example.institute1.BO.custom;

import com.example.institute1.BO.SuperBO;
import com.example.institute1.dto.StaffDto;

import java.sql.SQLException;
import java.util.List;

public interface StaffBOInterface extends SuperBO {
    public List<StaffDto> getAllStaff() throws SQLException, ClassNotFoundException;

    public boolean saveStaff(StaffDto staffDto) throws SQLException, ClassNotFoundException;

    public boolean updateStaff(StaffDto staffDto) throws SQLException, ClassNotFoundException;

    public boolean deleteStaff(String staffId) throws SQLException, ClassNotFoundException;

    public String getNextStaffID() throws SQLException, ClassNotFoundException;
}
