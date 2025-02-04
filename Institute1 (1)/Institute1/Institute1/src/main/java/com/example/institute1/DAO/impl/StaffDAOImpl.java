package com.example.institute1.DAO.impl;

import com.example.institute1.DAO.blueprint.StaffDAOInterface;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.dto.StaffDto;
import com.example.institute1.entity.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl implements StaffDAOInterface {
    @Override
    public List<Staff> getAll() throws SQLException, ClassNotFoundException {
        List<Staff> staffList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Staff");
        while (resultSet.next()) {
            staffList.add(new Staff(
                    resultSet.getString("staff_id"),
                    resultSet.getString("admin_id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("description"),
                    resultSet.getDouble("salary")
            ));
        }
        return staffList;
    }

    @Override
    public boolean save(Staff staffDto) throws SQLException, ClassNotFoundException {
       boolean result=CrudUtil.execute("INSERT INTO Staff (staff_id, admin_id, name, email, description, salary) VALUES (?, ?, ?, ?, ?, ?)",
               staffDto.getStaffId(), staffDto.getAdminId(), staffDto.getStaffName(), staffDto.getEmail(), staffDto.getDescription(), staffDto.getSalary());
        if(result){
            System.out.println("staff updated");
        }else {
            System.out.println("staff not updated");
        }
        return result;
    }

    @Override
    public boolean update(Staff staffDto) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("UPDATE Staff SET admin_id = ?, name = ?, email = ?, description = ?, salary = ? WHERE staff_id = ?",
                staffDto.getAdminId(), staffDto.getStaffName(), staffDto.getEmail(), staffDto.getDescription(), staffDto.getSalary(), staffDto.getStaffId());
        if (result){
            System.out.println("staff deleted");
        }else{
            System.out.println("staff not deleted");
        }
        return result;
    }

    @Override
    public boolean delete(String staffId) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("DELETE FROM Staff WHERE staff_id = ?", staffId);
        if (result){
            System.out.println("staff deleted");
        }else{
            System.out.println("staff not deleted");
        }
        return result;
    }

    @Override
    public String getNextStaffID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT staff_id FROM Staff ORDER BY staff_id DESC LIMIT 1");
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            int nextIndex = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("S%03d", nextIndex);
        }
        return "S001";
    }
}
