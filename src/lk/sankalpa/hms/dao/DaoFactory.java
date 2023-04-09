package lk.sankalpa.hms.dao;

import lk.sankalpa.hms.dao.custom.impl.StudentDaoImpl;
import org.hibernate.Session;

import java.sql.Connection;

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

            default:return null;
        }

    }

}
