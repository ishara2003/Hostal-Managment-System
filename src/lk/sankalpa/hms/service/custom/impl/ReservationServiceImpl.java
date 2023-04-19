package lk.sankalpa.hms.service.custom.impl;

import lk.sankalpa.hms.dao.DaoFactory;
import lk.sankalpa.hms.dao.DaoTypes;
import lk.sankalpa.hms.dao.custom.ReservationDao;
import lk.sankalpa.hms.dto.Reservationdto;
import lk.sankalpa.hms.entity.Reservation;
import lk.sankalpa.hms.service.Converter;
import lk.sankalpa.hms.service.custom.ReservationService;
import lk.sankalpa.hms.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationServiceImpl implements ReservationService {

    private Converter converter;
    private ReservationDao reservationDao;
    private Session session;

    public ReservationServiceImpl() {

        reservationDao= DaoFactory.getInstance().getDAO(session, DaoTypes.RESERVATION);
        converter=new Converter();

    }

    @Override
    public Reservationdto addReservation(Reservationdto reservationdto) {

        Session session= FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{

            reservationDao.save(converter.toReservation(reservationdto),session);
            transaction.commit();
            session.close();
        }catch (Exception e){
            transaction.rollback();
        }
return reservationdto;

    }

    @Override
    public List<Reservationdto> allReservatines(Session session) {

       return reservationDao.allData(session).stream().map(reservation ->
                converter.fromReservation(reservation)).collect(Collectors.toList());


    }

    @Override
    public void deleteReservation(String Id) {

        Session session1 = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session1.beginTransaction();

        try {
            reservationDao.delete(Id,session1);
            transaction.commit();
            session1.close();
        }catch (Exception e){
            transaction.rollback();
        }


    }

    @Override
    public Reservationdto byId(String Id) {

        Reservation reservation = reservationDao.byId(Id);

        Reservationdto reservationdto = converter.fromReservation(reservation);

        return reservationdto;

    }

    @Override
    public List<Reservationdto> resById(String Id, Session session) {


        return reservationDao.resById(Id,session).stream().map(reservation ->
                converter.fromReservation(reservation)).collect(Collectors.toList());

    }

    @Override
    public Reservationdto updateReservation(Reservationdto reservationdto) {
        Session session1 = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session1.beginTransaction();

        try{

            reservationDao.update(converter.toReservation(reservationdto),session1);
            transaction.commit();
            session1.close();

        }catch (Exception e){
            transaction.rollback();
        }

        return reservationdto;

    }
}
