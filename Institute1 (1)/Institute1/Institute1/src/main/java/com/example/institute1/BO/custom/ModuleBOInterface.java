package com.example.institute1.BO.custom;

import com.example.institute1.BO.SuperBO;
import com.example.institute1.dto.ModuleDto;

import java.sql.SQLException;
import java.util.List;

public interface ModuleBOInterface extends SuperBO {
    public List<ModuleDto> getAllModules() throws SQLException, ClassNotFoundException;

    public boolean saveModule(ModuleDto moduleDto) throws SQLException, ClassNotFoundException;

    public boolean updateModule(ModuleDto moduleDto) throws SQLException, ClassNotFoundException;

    public boolean deleteModule(String moduleId) throws SQLException, ClassNotFoundException;

    public String getNextModuleID() throws SQLException, ClassNotFoundException;
}
