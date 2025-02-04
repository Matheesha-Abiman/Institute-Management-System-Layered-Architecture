package com.example.institute1.DAO.blueprint;

import com.example.institute1.DAO.CrudDAO;
import com.example.institute1.entity.Parent;

import java.sql.SQLException;

public interface ParentDAOInterface extends CrudDAO<Parent> {
    public String getNextParentID() throws SQLException, ClassNotFoundException;
}
