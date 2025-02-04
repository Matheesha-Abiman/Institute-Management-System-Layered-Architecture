package com.example.institute1.DAO.blueprint;

import com.example.institute1.DAO.CrudDAO;
import com.example.institute1.entity.Module;

import java.sql.SQLException;

public interface ModuleDAOInterface extends CrudDAO<Module> {
    public String getNextModuleID() throws SQLException, ClassNotFoundException;
}
