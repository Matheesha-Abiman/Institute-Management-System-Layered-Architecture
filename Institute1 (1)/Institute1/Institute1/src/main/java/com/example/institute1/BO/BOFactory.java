package com.example.institute1.BO;
import com.example.institute1.BO.SuperBO;

import com.example.institute1.DAO.impl.AdminDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory=
                new BOFactory():boFactory;

    }
    public enum BOTypes{
        ADMINBO,LECTUREBO,STUDENTBO,COURSEBO,MODULEBO,PARENTBO,PAYMENTBO,STAFFBO,STUDENT_COURSEBO
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case ADMINBO:
                return new AdminBOImpl();
            case LECTUREBO:
                return new LectureBOImpl();
                case STUDENTBO: return new StudentBOImpl();
            case COURSEBO:
                return new CourseBOImpl();
            case MODULEBO:
                return new ModuleBOImpl();
                case PARENTBO:
                    return new ParentBOImpl();
                    case PAYMENTBO:
                        return new PaymentBOImpl();
            case STAFFBO:
                return new StaffBOImpl();
                case STUDENT_COURSEBO:
                    return new Student_courseBOImpl();

            default:
                return null;
        }
    }
}
