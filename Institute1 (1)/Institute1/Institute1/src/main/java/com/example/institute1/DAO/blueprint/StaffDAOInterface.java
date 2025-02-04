package com.example.institute1.DAO.blueprint;

import com.example.institute1.DAO.CrudDAO;
import com.example.institute1.entity.Staff;

import java.sql.SQLException;

public interface StaffDAOInterface extends CrudDAO<Staff> {
    public String getNextStaffID() throws SQLException, ClassNotFoundException;
}
