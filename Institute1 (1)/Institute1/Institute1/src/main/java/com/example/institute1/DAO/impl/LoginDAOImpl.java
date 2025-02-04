package com.example.institute1.DAO.impl;

import com.example.institute1.DAO.blueprint.LoginDAOInterface;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginDAOImpl implements LoginDAOInterface {

    private static final String AES_KEY = "your_secret_key";

    @Override
    public Admin getAdminByEmail(String email) throws Exception {
        ResultSet rs = CrudUtil.execute(
                "SELECT admin_id, name, email, CAST(AES_DECRYPT(password, ?) AS CHAR) AS decryptedPassword FROM Admin WHERE email = ?",
                AES_KEY, email
        );

        if (rs.next()) {
            return new Admin(
                    rs.getString("admin_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("decryptedPassword") // Decrypted password
            );
        }
        return null;
    }

    @Override
    public List<Admin> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public boolean save(Admin adminDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Admin adminDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String adminId) throws SQLException, ClassNotFoundException {
        return false;
    }
}
