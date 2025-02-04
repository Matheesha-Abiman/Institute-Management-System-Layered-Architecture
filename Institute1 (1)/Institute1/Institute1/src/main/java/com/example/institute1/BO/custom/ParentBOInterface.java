package com.example.institute1.BO.custom;

import com.example.institute1.BO.SuperBO;
import com.example.institute1.dto.ParentDto;

import java.sql.SQLException;
import java.util.List;

public interface ParentBOInterface extends SuperBO {
    public List<ParentDto> getAllParents() throws SQLException, ClassNotFoundException;

    public boolean saveParent(ParentDto parentDto) throws SQLException, ClassNotFoundException;

    public boolean updateParent(ParentDto parentDto) throws SQLException, ClassNotFoundException;

    public boolean deleteParent(String parentId) throws SQLException, ClassNotFoundException;

    public String getNextParentID() throws SQLException, ClassNotFoundException;

}
