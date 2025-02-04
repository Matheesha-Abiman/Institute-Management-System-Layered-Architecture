package com.example.institute1.DAO.impl;

import com.example.institute1.DAO.blueprint.AdminDAOInterface;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAOInterface {

    @Override
    public List<Admin> getAll() throws SQLException, ClassNotFoundException {
        List<Admin> admins = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT admin_id, name, email, password FROM Admin");
        while (resultSet.next()) {
            admins.add(new Admin(
                    resultSet.getString("admin_id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            ));
        }
        return admins;
    }

    @Override
    public boolean save(Admin adminDto) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("INSERT INTO Admin (admin_id, name, email, password) VALUES (?, ?, ?, AES_ENCRYPT(?, 'your_secret_key'))",adminDto.getAdminId(),adminDto.getAdminName(),adminDto.getAdminEmail(),adminDto.getAdminPassword());
        if(result){
            System.out.println("Admin saved");
        }else{
            System.out.println("Admin not saved");
        }
        return result;
    }

    @Override
    public boolean update(Admin adminDto) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("UPDATE Admin SET name = ?, email = ?, password = AES_ENCRYPT(?, 'your_secret_key') WHERE admin_id = ?",adminDto.getAdminName(),adminDto.getAdminEmail(),adminDto.getAdminPassword(),adminDto.getAdminId());
        if(result){
            System.out.println("Admin updated");
        }else {
            System.out.println("Admin not updated");
        }
        return result;
    }

    @Override
    public boolean delete(String adminId) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("DELETE FROM Admin WHERE admin_id = ?",adminId);
        if (result){
            System.out.println("Admin deleted");
        }else{
            System.out.println("Admin not deleted");
        }
        return result;
    }

    @Override
    public String getNextAdminID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT admin_id FROM Admin ORDER BY admin_id DESC LIMIT 1");
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            int nextIndex = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("A%03d", nextIndex);
        }
        return "A001";
    }
}
