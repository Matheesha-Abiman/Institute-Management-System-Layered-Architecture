package com.example.institute1.DAO;

import com.example.institute1.DAO.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){
    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory
                =new DAOFactory():daoFactory;
    }

    public enum DAOTypes{
        ADMIN,LECTURE,MODULE,PARENT,PAYMENT,STAFF,STUDENT,COURSE,STUDENT_COURSE
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case ADMIN:
                return new AdminDAOImpl();
                case LECTURE:
                    return new LectureDAOImpl();
                    case MODULE:
                        return new ModuleDAOImpl();
                        case PARENT:
                            return new ParentDAOImpl();
                            case PAYMENT:
                                return new PaymentDAOImpl();
                                case STAFF:
                                    return new StaffDAOImpl();
                                    case STUDENT:
                                        return new StudentDAOImpl();
            case COURSE:
                return new CourseDAOImpl();
            case STUDENT_COURSE:
                return new Student_courseDAOImpl();

            default:
                return null;
        }
    }

}
