package com.example.institute1.DAO.blueprint;

import com.example.institute1.DAO.CrudDAO;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AdminDAOInterface extends CrudDAO<Admin> {
    public String getNextAdminID() throws SQLException, ClassNotFoundException;

}
