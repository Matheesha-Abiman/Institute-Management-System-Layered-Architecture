package com.example.institute1.DAO.impl;

import com.example.institute1.DAO.blueprint.ParentDAOInterface;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.dto.ParentDto;
import com.example.institute1.entity.Parent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParentDAOImpl implements ParentDAOInterface {
    @Override
    public List<Parent> getAll() throws SQLException, ClassNotFoundException {
        List<Parent> parents = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Parent");
        while (resultSet.next()) {
            parents.add(new Parent(
                    resultSet.getString("parent_id"),
                    resultSet.getString("admin_id"),
                    resultSet.getString("name"),
                    resultSet.getString("email")
            ));
        }
        return parents;
    }

    @Override
    public boolean save(Parent parentDto) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("INSERT INTO Parent (parent_id, admin_id, name, email) VALUES (?, ?, ?, ?)",
                parentDto.getParentId(), parentDto.getAdminId(), parentDto.getParentName(), parentDto.getParentEmail());
        if(result){
            System.out.println("parent saved");
        }else{
            System.out.println("parent not saved");
        }
        return result;
    }

    @Override
    public boolean update(Parent parentDto) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("UPDATE Parent SET admin_id = ?, name = ?, email = ? WHERE parent_id = ?",
                parentDto.getAdminId(), parentDto.getParentName(), parentDto.getParentEmail(), parentDto.getParentId());
        if(result){
            System.out.println("parent updated");
        }else {
            System.out.println("parent not updated");
        }
        return result;
    }

    @Override
    public boolean delete(String parentId) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("DELETE FROM Parent WHERE parent_id = ?", parentId);
        if (result){
            System.out.println("parent deleted");
        }else{
            System.out.println("parent not deleted");
        }
        return result;
    }

    @Override
    public String getNextParentID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT parent_id FROM Parent ORDER BY parent_id DESC LIMIT 1");
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            int nextIndex = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("P%03d", nextIndex);
        }
        return "P001";
    }
}
