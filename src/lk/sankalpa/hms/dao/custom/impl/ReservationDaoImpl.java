package lk.sankalpa.hms.dao.custom.impl;

import lk.sankalpa.hms.dao.custom.ReservationDao;
import lk.sankalpa.hms.entity.Reservation;
import lk.sankalpa.hms.entity.Room;
import lk.sankalpa.hms.entity.SuperEntity;
import lk.sankalpa.hms.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    private final Session session;
    public ReservationDaoImpl(Session session) {
        this.session=session;
    }

    @Override
    public Reservation save(Reservation entity, Session session) {



        session.save(entity);

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

        session.delete(Id);

    }

    @Override
    public List<Reservation> allData(Session session) {
        Query<Reservation> from_reservation_ = session.createQuery("From Reservation ");

        List<Reservation> list = from_reservation_.list();

        for (Reservation reservation:list) {

            reservation.getRes_id();
            reservation.getDate();
            reservation.getStatus();
            reservation.getStudent();
            reservation.getRoom();

        }
        return list;
    }

    @Override
    public String lastId(Session session) {
        List<Reservation> rooms;

            Query query = session.createQuery("FROM Reservation ORDER BY  res_id DESC ");
            rooms=query.list();
            return rooms.get(0).getRes_id();


    }

}
