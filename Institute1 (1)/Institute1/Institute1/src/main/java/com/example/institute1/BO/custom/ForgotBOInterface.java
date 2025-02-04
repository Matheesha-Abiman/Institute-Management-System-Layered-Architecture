package com.example.institute1.BO.custom;

import com.example.institute1.BO.SuperBO;

public interface ForgotBOInterface extends SuperBO {
    boolean isEmailRegistered(String email) throws Exception;
}
