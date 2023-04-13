package lk.sankalpa.hms.service.custom.impl;

import lk.sankalpa.hms.dao.DaoFactory;
import lk.sankalpa.hms.dao.DaoTypes;
import lk.sankalpa.hms.dao.custom.StudentDao;
import lk.sankalpa.hms.dto.Studentdto;
import lk.sankalpa.hms.entity.Student;
import lk.sankalpa.hms.service.Converter;
import lk.sankalpa.hms.service.custom.StudentService;
import lk.sankalpa.hms.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {


    private  Session session;
    private  StudentDao studentDao;
    private  Converter converter;

    public StudentServiceImpl(){


        studentDao= DaoFactory.getInstance().getDAO(session,DaoTypes.STUDENT);
        converter=new Converter();
    }

    @Override
    public Studentdto saveStudent(Studentdto studentdto) {

        Session session1 = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session1.beginTransaction();
        try{

        studentDao.save(converter.toStudent(studentdto), session1);
        transaction.commit();
        session1.close();
        }catch (Exception e){
            transaction.rollback();
        }

        return studentdto;

    }

    @Override
    public Studentdto updateStudent( Studentdto studentdto) {

        Session session1 = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session1.beginTransaction();

        try{
        studentDao.update(converter.toStudent(studentdto),session1);
        transaction.commit();
        session1.close();

        }catch (Exception e){
            transaction.rollback();
        }

        return studentdto;


    }

    @Override
    public Studentdto searchStudent( String Id) {

        Session session1 = FactoryConfigeration.getInstance().getSession();

        Student search = studentDao.search(Id, session1);
        session1.close();
        return converter.fromStudent(search);

    }

    @Override
    public void deleteStudent( String Id) {

        studentDao.delete(Id,session);

    }

    @Override
    public List<Studentdto> allStudents(Session session) {

        return studentDao.allData(session).stream().map(ss ->
                converter.fromStudent(ss)).collect(Collectors.toList());

    }
}
