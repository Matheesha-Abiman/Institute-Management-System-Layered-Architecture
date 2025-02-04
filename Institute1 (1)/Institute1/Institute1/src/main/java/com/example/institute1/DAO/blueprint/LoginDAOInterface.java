package com.example.institute1.DAO.blueprint;

import com.example.institute1.DAO.CrudDAO;
import com.example.institute1.entity.Admin;

public interface LoginDAOInterface extends CrudDAO<Admin> {
    Admin getAdminByEmail(String email) throws Exception;
}
