package lk.sankalpa.hms.dao.custom.impl;

import lk.sankalpa.hms.dao.custom.ReservationDao;
import lk.sankalpa.hms.entity.Reservation;
import lk.sankalpa.hms.entity.SuperEntity;
import lk.sankalpa.hms.util.FactoryConfigeration;
import org.hibernate.Session;

import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    @Override
    public Reservation save(Reservation entity, Session session) {

        Session session1 = FactoryConfigeration.getInstance().getSession();

        session1.save(entity);

        return entity;

    }

    @Override
    public Reservation update(Reservation entity, Session session) {
        return null;
    }

    @Override
    public Reservation search(String Id, Session session) {
        return null;
    }

    @Override
    public void delete(String Id, Session session) {

    }

    @Override
    public List allData(Session session) {
        return null;
    }
}
