package com.example.institute1.DAO.impl;

import com.example.institute1.DAO.blueprint.ForgotDAOInterface;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ForgotDAOImpl implements ForgotDAOInterface {

    @Override
    public boolean isEmailRegistered(String email) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT email FROM Admin WHERE email = ?", email);
        return resultSet.next();

    }

    @Override
    public List<Admin> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public boolean save(Admin adminDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Admin adminDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String adminId) throws SQLException, ClassNotFoundException {
        return false;
    }
}
