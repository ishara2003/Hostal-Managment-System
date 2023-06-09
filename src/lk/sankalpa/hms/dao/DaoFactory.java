package lk.sankalpa.hms.dao;

import lk.sankalpa.hms.dao.custom.impl.ReservationDaoImpl;
import lk.sankalpa.hms.dao.custom.impl.RoomDaoImpl;
import lk.sankalpa.hms.dao.custom.impl.StudentDaoImpl;
import lk.sankalpa.hms.dao.custom.impl.UserDaoImpl;
import org.hibernate.Session;

public class DaoFactory {

    private static DaoFactory daoFactory ;
    private DaoFactory() {
    }

    public static DaoFactory getInstance(){

        return daoFactory==null?(daoFactory=new DaoFactory()):daoFactory;
    }

    public <T extends SuperDao>T getDAO(Session session, DaoTypes daoType){

        switch (daoType){

            case STUDENT:return (T) new StudentDaoImpl(session);

            case ROOM:return (T)new RoomDaoImpl(session);

            case RESERVATION:return (T)new  ReservationDaoImpl(session);

            case USER:return (T) new UserDaoImpl(session);

            default:return null;
        }

    }

}
