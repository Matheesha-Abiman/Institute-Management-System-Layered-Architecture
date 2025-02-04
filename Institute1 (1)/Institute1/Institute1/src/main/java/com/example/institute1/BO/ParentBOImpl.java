package com.example.institute1.BO;

import com.example.institute1.BO.custom.ParentBOInterface;
import com.example.institute1.DAO.DAOFactory;
import com.example.institute1.DAO.impl.ParentDAOImpl;
import com.example.institute1.dto.ParentDto;
import com.example.institute1.entity.Parent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParentBOImpl implements ParentBOInterface {

    ParentDAOImpl parentDAO = (ParentDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PARENT);

    @Override
    public List<ParentDto> getAllParents() throws SQLException, ClassNotFoundException {
        ArrayList<Parent> parents = (ArrayList<Parent>) parentDAO.getAll();
        ArrayList<ParentDto> parentDtos = new ArrayList<>();
        for (Parent parent : parents) {
            parentDtos.add(new ParentDto(parent.getParentId(),parent.getAdminId(),parent.getParentName(),parent.getParentEmail()));
        }
        return parentDtos;
    }

    @Override
    public boolean saveParent(ParentDto parentDto) throws SQLException, ClassNotFoundException {
        Parent parent = new Parent(parentDto.getParentId(),parentDto.getAdminId(),parentDto.getParentName(),parentDto.getParentEmail());
        return parentDAO.save(parent);
    }

    @Override
    public boolean updateParent(ParentDto parentDto) throws SQLException, ClassNotFoundException {
        Parent parent = new Parent(parentDto.getParentId(),parentDto.getAdminId(),parentDto.getParentName(),parentDto.getParentEmail());
        return parentDAO.update(parent);
    }

    @Override
    public boolean deleteParent(String parentId) throws SQLException, ClassNotFoundException {
        return parentDAO.delete(parentId);
    }

    @Override
    public String getNextParentID() throws SQLException, ClassNotFoundException {
        return parentDAO.getNextParentID();
    }
}
