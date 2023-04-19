package lk.sankalpa.hms.dao.custom;

import lk.sankalpa.hms.dao.CrudDao;
import lk.sankalpa.hms.entity.Room;
import org.hibernate.Session;

import java.util.List;

public interface RoomDao extends CrudDao<Room , String> {

    List<String> roomIds(Session session);

    Room byId(String Id,Session session);


}
