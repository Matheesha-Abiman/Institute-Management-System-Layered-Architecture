package com.example.institute1.DAO.impl;

import com.example.institute1.DAO.blueprint.PaymentDAOInterface;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.dto.PaymentDto;
import com.example.institute1.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAOInterface {
    @Override
    public List<Payment> getAll() throws SQLException, ClassNotFoundException {
        List<Payment> payments = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Payment");
        while (resultSet.next()) {
            payments.add(new Payment(
                    resultSet.getString("payment_id"),
                    resultSet.getString("admin_id"),
                    resultSet.getString("student_id"),
                    resultSet.getDate("payment_date").toLocalDate(),
                    resultSet.getDouble("amount")
            ));
        }
        return payments;
    }

    @Override
    public boolean save(Payment paymentDto) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("INSERT INTO Payment (payment_id, admin_id, student_id, payment_date, amount) VALUES (?, ?, ?, ?, ?)",
                paymentDto.getPaymentId(), paymentDto.getAdminId(), paymentDto.getStudentId(), paymentDto.getPaymentDate(), paymentDto.getAmount());
        if(result){
            System.out.println("payment saved");
        }else{
            System.out.println("payment not saved");
        }
        return result;
    }

    @Override
    public boolean update(Payment paymentDto) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("UPDATE Payment SET admin_id = ?, student_id = ?, payment_date = ?, amount = ? WHERE payment_id = ?",
                paymentDto.getAdminId(), paymentDto.getStudentId(), paymentDto.getPaymentDate(), paymentDto.getAmount(), paymentDto.getPaymentId());
        if(result){
            System.out.println("payment updated");
        }else {
            System.out.println("payment not updated");
        }
        return result;
    }

    @Override
    public boolean delete(String paymentId) throws SQLException, ClassNotFoundException {
        boolean result =CrudUtil.execute("DELETE FROM Payment WHERE payment_id = ?", paymentId);
        if (result){
            System.out.println("payment deleted");
        }else{
            System.out.println("payment not deleted");
        }
        return result;
    }

    @Override
    public String getNextPaymentID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT payment_id FROM Payment ORDER BY payment_id DESC LIMIT 1");
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            int nextIndex = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("P%03d", nextIndex);
        }
        return "P001";
    }
}
