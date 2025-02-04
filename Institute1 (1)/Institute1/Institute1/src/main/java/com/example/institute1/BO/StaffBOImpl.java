package com.example.institute1.BO;

import com.example.institute1.BO.custom.StaffBOInterface;
import com.example.institute1.DAO.DAOFactory;
import com.example.institute1.DAO.impl.StaffDAOImpl;
import com.example.institute1.dto.StaffDto;
import com.example.institute1.entity.Staff;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffBOImpl implements StaffBOInterface {

    StaffDAOImpl staffDAO = (StaffDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STAFF);

    @Override
    public List<StaffDto> getAllStaff() throws SQLException, ClassNotFoundException {
        ArrayList<Staff> staffDtos = (ArrayList<Staff>) staffDAO.getAll();
        ArrayList<StaffDto> staffDtos1 = new ArrayList<>();
        for (Staff staff : staffDtos) {
            staffDtos1.add(new StaffDto(staff.getStaffId(),staff.getAdminId(),staff.getStaffName(),staff.getEmail(),staff.getDescription(),staff.getSalary()));
        }
        return staffDtos1;
    }

    @Override
    public boolean saveStaff(StaffDto staffDto) throws SQLException, ClassNotFoundException {
        Staff staff = new Staff(staffDto.getStaffId(),staffDto.getAdminId(),staffDto.getStaffName(),staffDto.getEmail(),staffDto.getDescription(),staffDto.getSalary());
    return staffDAO.save(staff);
    }

    @Override
    public boolean updateStaff(StaffDto staffDto) throws SQLException, ClassNotFoundException {
        Staff staff = new Staff(staffDto.getStaffId(),staffDto.getAdminId(),staffDto.getStaffName(),staffDto.getEmail(),staffDto.getDescription(),staffDto.getSalary());
    return staffDAO.update(staff);
    }

    @Override
    public boolean deleteStaff(String staffId) throws SQLException, ClassNotFoundException {
        return staffDAO.delete(staffId);
    }

    @Override
    public String getNextStaffID() throws SQLException, ClassNotFoundException {
        return staffDAO.getNextStaffID();
    }
}
