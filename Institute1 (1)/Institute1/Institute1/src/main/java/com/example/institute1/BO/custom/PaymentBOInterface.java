package com.example.institute1.BO.custom;

import com.example.institute1.BO.SuperBO;
import com.example.institute1.dto.PaymentDto;

import java.sql.SQLException;
import java.util.List;

public interface PaymentBOInterface extends SuperBO {
    public List<PaymentDto> getAllPayments() throws SQLException, ClassNotFoundException;

    public boolean savePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException;

    public boolean updatePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException;

    public boolean deletePayment(String paymentId) throws SQLException, ClassNotFoundException;

    public String getNextPaymentID() throws SQLException, ClassNotFoundException;
}
