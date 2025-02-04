package com.example.institute1.BO.custom;

import com.example.institute1.BO.SuperBO;
import com.example.institute1.entity.Admin;

public interface LoginBOInterface extends SuperBO {
    Admin validateLogin(String email, String password) throws Exception;
}
