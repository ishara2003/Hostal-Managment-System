package lk.sankalpa.hms.service.custom.impl;

import lk.sankalpa.hms.dao.DaoFactory;
import lk.sankalpa.hms.dao.DaoTypes;
import lk.sankalpa.hms.dao.custom.UserDao;
import lk.sankalpa.hms.dto.Userdto;
import lk.sankalpa.hms.entity.User;
import lk.sankalpa.hms.service.Converter;
import lk.sankalpa.hms.service.custom.UserService;
import lk.sankalpa.hms.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private Converter converter;
    private UserDao userDao;
    private Session session;

    public UserServiceImpl() {

    userDao= DaoFactory.getInstance().getDAO(session, DaoTypes.USER);
    converter=new Converter();

    }

    @Override
    public Userdto saveUser(Userdto userdto) {

        Session session = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{

            userDao.save(converter.toUser(userdto),session);
            transaction.commit();
            session.close();

        }catch (Exception e){

            transaction.rollback();

        }

        return userdto;

    }

    @Override
    public Userdto searchUser(String NIC) {

        Session session1 = FactoryConfigeration.getInstance().getSession();

        User search = userDao.search(NIC, session1);

        Userdto userdto = converter.fromUser(search);

        return userdto;

    }

    @Override
    public List<Userdto> allUsers(Session session) {

        return userDao.allData(session).stream().map(ss ->
                converter.fromUser(ss)).collect(Collectors.toList());

    }

    @Override
    public Userdto updateUser(Userdto userdto) {

        Session session1 = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session1.beginTransaction();

        try{
            userDao.update(converter.toUser(userdto),session1);
            transaction.commit();
            session1.close();

        }catch (Exception e){
            transaction.rollback();
        }

        return userdto;

    }
}
