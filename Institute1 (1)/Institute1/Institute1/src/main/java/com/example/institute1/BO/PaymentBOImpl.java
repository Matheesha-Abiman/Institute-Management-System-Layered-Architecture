package com.example.institute1.BO;

import com.example.institute1.BO.custom.PaymentBOInterface;
import com.example.institute1.DAO.DAOFactory;
import com.example.institute1.DAO.impl.PaymentDAOImpl;
import com.example.institute1.dto.PaymentDto;
import com.example.institute1.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentBOImpl implements PaymentBOInterface {

    PaymentDAOImpl paymentDAO = (PaymentDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);

    @Override
    public List<PaymentDto> getAllPayments() throws SQLException, ClassNotFoundException {
        ArrayList<Payment> payments = (ArrayList<Payment>) paymentDAO.getAll();
        List<PaymentDto> paymentDtos = new ArrayList<>();
        for (Payment payment : payments) {
            paymentDtos.add(new PaymentDto(payment.getPaymentId(),payment.getAdminId(),payment.getStudentId(),payment.getPaymentDate(),payment.getAmount()));
        }
        return paymentDtos;
    }

    @Override
    public boolean savePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException {
        Payment payment = new Payment(paymentDto.getPaymentId(),paymentDto.getAdminId(),paymentDto.getStudentId(),paymentDto.getPaymentDate(),paymentDto.getAmount());
    return paymentDAO.save(payment);
    }

    @Override
    public boolean updatePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException {
        Payment payment = new Payment(paymentDto.getPaymentId(),paymentDto.getAdminId(),paymentDto.getStudentId(),paymentDto.getPaymentDate(),paymentDto.getAmount());
    return paymentDAO.update(payment);
    }

    @Override
    public boolean deletePayment(String paymentId) throws SQLException, ClassNotFoundException {
        return paymentDAO.delete(paymentId);
    }

    @Override
    public String getNextPaymentID() throws SQLException, ClassNotFoundException {
        return paymentDAO.getNextPaymentID();
    }
}
