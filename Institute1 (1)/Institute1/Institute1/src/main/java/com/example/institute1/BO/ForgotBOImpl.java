package com.example.institute1.BO;

import com.example.institute1.BO.custom.ForgotBOInterface;
import com.example.institute1.DAO.impl.ForgotDAOImpl;

public class ForgotBOImpl implements ForgotBOInterface {

    private final ForgotDAOImpl forgotDAO = new ForgotDAOImpl();

    @Override
    public boolean isEmailRegistered(String email) throws Exception {
        return forgotDAO.isEmailRegistered(email);
    }
}
