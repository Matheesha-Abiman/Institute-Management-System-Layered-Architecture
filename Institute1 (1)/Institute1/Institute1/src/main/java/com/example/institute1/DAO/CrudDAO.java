package com.example.institute1.DAO;

import com.example.institute1.crud.CrudUtil;
import com.example.institute1.dto.AdminDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO{
    public List<T> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(T adminDto) throws SQLException, ClassNotFoundException;

    public boolean update(T adminDto) throws SQLException, ClassNotFoundException;

    public boolean delete(String adminId) throws SQLException, ClassNotFoundException;

}
