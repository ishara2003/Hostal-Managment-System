package lk.sankalpa.hms.dao.custom.impl;

import lk.sankalpa.hms.dao.custom.UserDao;
import lk.sankalpa.hms.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImpl implements UserDao {
private Session session;

    public UserDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public User save(User entity, Session session) {

        session.save(entity);
        return entity;

    }

    @Override
    public User update(User entity, Session session) {

        session.update(entity);
        return entity;

    }

    @Override
    public User search(String Id, Session session) {

        User user = session.find(User.class, Id);

        return new User(user.getNic(), user.getUsername(), user.getPassword());

    }

    @Override
    public void delete(String Id, Session session) {

    }

    @Override
    public List<User> allData(Session session) {


        Query from_user_ = session.createQuery("FROM User ");
        List<User> list = from_user_.list();

        for (User user : list) {

            user.getNic();
            user.getUsername();
            user.getPassword();

        }
return list;

    }
}
