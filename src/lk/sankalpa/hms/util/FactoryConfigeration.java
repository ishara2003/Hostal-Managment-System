package lk.sankalpa.hms.util;

import lk.sankalpa.hms.entity.Reservation;
import lk.sankalpa.hms.entity.Room;
import lk.sankalpa.hms.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfigeration {
    public static FactoryConfigeration factoryConfigeration;
    private SessionFactory session;
    private FactoryConfigeration(){
        Configuration configuration = new Configuration().addAnnotatedClass(Student.class).addAnnotatedClass(Room.class).addAnnotatedClass(Reservation.class);
         session=configuration.buildSessionFactory();


    }

    public static FactoryConfigeration getInstance(){
        return (factoryConfigeration ==null )? factoryConfigeration = new FactoryConfigeration() : factoryConfigeration;

    }

    public Session getSession (){
        return session.openSession();
    }

}
