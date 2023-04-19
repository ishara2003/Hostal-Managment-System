package lk.sankalpa.hms.dao.custom;

import lk.sankalpa.hms.dao.CrudDao;
import lk.sankalpa.hms.entity.Reservation;
import org.hibernate.Session;

import java.util.List;

public interface ReservationDao extends CrudDao<Reservation,String> {

    public String lastId(Session session);

    public Reservation byId( String Id);

    List<Reservation> resById(String Id,Session session);

}
