package lk.sankalpa.hms.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.sankalpa.hms.dao.SuperDao;
import lk.sankalpa.hms.dao.custom.StudentDao;
import lk.sankalpa.hms.entity.Student;
import lk.sankalpa.hms.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

  private final Session session;
    public StudentDaoImpl(Session session) {
        this.session=session;


    }


    @Override
    public Student save(Student entity, Session session) {

            session.save(entity);

        return entity;
    }

    @Override
    public Student update(Student entity ,Session session) {

                    session.update(entity);

            return entity;
    }

    @Override
    public Student search(String Id ,Session session) {


        try{

            Student student = session.find(Student.class, Id);

            return new Student(

                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getNumber(),
                    student.getBod(),
                    student.getGender());

        }catch (Exception e){

        }
return null;
    }

    @Override
    public void delete(String Id ,Session session) {


            Student load = session.load(Student.class, Id);
            session.delete(load);
    }

    @Override
    public List<Student> allData( Session session) {

        Query<Student> from_student_ = session.createQuery("From Student ");

        List<Student> list = from_student_.list();

        for (Student student:list) {

                    student.getId();
                    student.getName();
                    student.getAddress();
                    student.getNumber();
                    student.getBod();
                    student.getGender();

        }
return list;

    }
}
