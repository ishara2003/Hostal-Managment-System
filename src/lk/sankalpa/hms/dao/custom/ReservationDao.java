package lk.sankalpa.hms.dao.custom;

import lk.sankalpa.hms.dao.CrudDao;
import lk.sankalpa.hms.entity.Reservation;
import org.hibernate.Session;

public interface ReservationDao extends CrudDao<Reservation,String> {

    public String lastId(Session session);

}
