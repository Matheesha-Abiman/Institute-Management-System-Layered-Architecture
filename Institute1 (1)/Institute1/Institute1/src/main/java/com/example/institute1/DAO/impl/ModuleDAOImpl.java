package com.example.institute1.DAO.impl;

import com.example.institute1.DAO.blueprint.ModuleDAOInterface;
import com.example.institute1.crud.CrudUtil;
import com.example.institute1.dto.ModuleDto;
import com.example.institute1.entity.Module;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModuleDAOImpl implements ModuleDAOInterface {

    @Override
    public List<Module> getAll() throws SQLException, ClassNotFoundException {
        List<Module> modules = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Module");
        while (resultSet.next()) {
            modules.add(new Module(
                    resultSet.getString("module_id"),
                    resultSet.getString("course_id"),
                    resultSet.getString("module_name")
            ));
        }
        return modules;
    }

    @Override
    public boolean save(Module moduleDto) throws SQLException, ClassNotFoundException {
        boolean result =CrudUtil.execute("INSERT INTO Module (module_id, course_id, module_name) VALUES (?, ?, ?)",
                moduleDto.getModuleId(), moduleDto.getCourseId(), moduleDto.getModuleName());
        if(result){
            System.out.println("module saved");
        }else{
            System.out.println("module not saved");
        }
        return result;
    }

    @Override
    public boolean update(Module moduleDto) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("UPDATE Module SET course_id = ?, module_name = ? WHERE module_id = ?",
                moduleDto.getCourseId(), moduleDto.getModuleName(), moduleDto.getModuleId());
        if(result){
            System.out.println("module updated");
        }else {
            System.out.println("module not updated");
        }
        return result;
    }

    @Override
    public boolean delete(String moduleId) throws SQLException, ClassNotFoundException {
        boolean result = CrudUtil.execute("DELETE FROM Module WHERE module_id = ?", moduleId);
        if (result){
            System.out.println("module deleted");
        }else{
            System.out.println("module not deleted");
        }
        return result;
    }

    @Override
    public String getNextModuleID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT module_id FROM Module ORDER BY module_id DESC LIMIT 1");
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            int nextIndex = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("M%03d", nextIndex);
        }
        return "M001";
    }
}
