package com.example.institute1.DAO.blueprint;

import com.example.institute1.DAO.CrudDAO;
import com.example.institute1.entity.Payment;

import java.sql.SQLException;

public interface PaymentDAOInterface extends CrudDAO<Payment> {
    public String getNextPaymentID() throws SQLException, ClassNotFoundException;
}
