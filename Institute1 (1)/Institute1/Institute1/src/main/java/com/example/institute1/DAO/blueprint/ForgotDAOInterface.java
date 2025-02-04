package com.example.institute1.DAO.blueprint;

import com.example.institute1.DAO.CrudDAO;
import com.example.institute1.entity.Admin;

public interface ForgotDAOInterface extends CrudDAO<Admin> {
    boolean isEmailRegistered(String email) throws Exception;
}
