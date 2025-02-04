package com.example.institute1.BO;

import com.example.institute1.BO.custom.ModuleBOInterface;
import com.example.institute1.DAO.DAOFactory;
import com.example.institute1.DAO.impl.ModuleDAOImpl;
import com.example.institute1.dto.ModuleDto;
import com.example.institute1.entity.Admin;
import com.example.institute1.entity.Module;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModuleBOImpl implements ModuleBOInterface {

    ModuleDAOImpl moduleDAO = (ModuleDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MODULE);

    @Override
    public List<ModuleDto> getAllModules() throws SQLException, ClassNotFoundException {
        List<Module> modules = moduleDAO.getAll(); // No cast needed
        List<ModuleDto> moduleDtos = new ArrayList<>();

        for (Module module : modules) {
            moduleDtos.add(new ModuleDto(module.getModuleId(),module.getCourseId(),module.getModuleName()));
        }
        return moduleDtos;
    }

    @Override
    public boolean saveModule(ModuleDto moduleDto) throws SQLException, ClassNotFoundException {
        Module module = new Module(moduleDto.getModuleId(),moduleDto.getCourseId(),moduleDto.getModuleName());
        return moduleDAO.save(module);
    }

    @Override
    public boolean updateModule(ModuleDto moduleDto) throws SQLException, ClassNotFoundException {
        Module module = new Module(moduleDto.getModuleId(),moduleDto.getCourseId(),moduleDto.getModuleName());
        return moduleDAO.update(module);
    }

    @Override
    public boolean deleteModule(String moduleId) throws SQLException, ClassNotFoundException {
        return moduleDAO.delete(moduleId);
    }

    @Override
    public String getNextModuleID() throws SQLException, ClassNotFoundException {
        return moduleDAO.getNextModuleID();
    }
}
