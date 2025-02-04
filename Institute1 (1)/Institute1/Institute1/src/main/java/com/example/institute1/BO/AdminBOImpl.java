package com.example.institute1.BO;

import com.example.institute1.BO.custom.AdminBOInterface;
import com.example.institute1.DAO.DAOFactory;
import com.example.institute1.DAO.impl.AdminDAOImpl;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.dto.AdminDto;
import com.example.institute1.entity.Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminBOImpl implements AdminBOInterface {

    AdminDAOImpl adminDAO = (AdminDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ADMIN);

    @Override
    public List<AdminDto> getAllAdmins() throws SQLException, ClassNotFoundException {
        ArrayList<Admin> admins = (ArrayList<Admin>) adminDAO.getAll();
        ArrayList<AdminDto> adminDtos = new ArrayList<>();
        for (Admin admin : admins) {
            adminDtos.add(new AdminDto(admin.getAdminId(), admin.getAdminName(), admin.getAdminEmail(), admin.getAdminPassword()));
        }
        return adminDtos;
    }

    @Override
    public  boolean saveAdmin(AdminDto adminDto) throws SQLException, ClassNotFoundException {
        Admin admin = new Admin(adminDto.getAdminId(), adminDto.getAdminName(), adminDto.getAdminEmail(), adminDto.getAdminPassword());
    return adminDAO.save(admin);
    }

    public  boolean updateAdmin(AdminDto adminDto) throws SQLException, ClassNotFoundException{
        Admin admin = new Admin(adminDto.getAdminId(), adminDto.getAdminName(), adminDto.getAdminEmail(), adminDto.getAdminPassword());
        return adminDAO.update(admin);
    }

    @Override
    public boolean deleteAdmin(String adminId) throws SQLException, ClassNotFoundException {
        return adminDAO.delete(adminId);
    }

    @Override
    public String getNextAdminID() throws SQLException, ClassNotFoundException {
        return adminDAO.getNextAdminID();
    }

}
