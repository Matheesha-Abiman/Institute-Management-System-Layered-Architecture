package com.example.institute1.BO;

import com.example.institute1.BO.custom.LoginBOInterface;
import com.example.institute1.DAO.blueprint.LoginDAOInterface;
import com.example.institute1.DAO.impl.LoginDAOImpl;
import com.example.institute1.entity.Admin;

public class LoginBOImpl implements LoginBOInterface {

    private final LoginDAOInterface loginDAO = new LoginDAOImpl();

    @Override
    public Admin validateLogin(String email, String password) throws Exception {
        Admin admin = loginDAO.getAdminByEmail(email);
        if (admin != null && admin.getAdminPassword().equals(password)) {
            return admin;
        }
        return null;
    }
}
