package com.example.institute1.BO.custom;

import com.example.institute1.BO.SuperBO;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.dto.AdminDto;

import java.sql.SQLException;
import java.util.List;

public interface AdminBOInterface extends SuperBO {
    public List<AdminDto> getAllAdmins() throws SQLException, ClassNotFoundException;

    public  boolean saveAdmin(AdminDto adminDto) throws SQLException, ClassNotFoundException;

    public  boolean updateAdmin(AdminDto adminDto) throws SQLException, ClassNotFoundException;

    public boolean deleteAdmin(String adminId) throws SQLException, ClassNotFoundException;

    public String getNextAdminID() throws SQLException, ClassNotFoundException;
}


