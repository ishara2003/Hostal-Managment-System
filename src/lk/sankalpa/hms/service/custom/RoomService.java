package lk.sankalpa.hms.service.custom;

import lk.sankalpa.hms.dto.Roomdto;
import lk.sankalpa.hms.service.SuperService;
import org.hibernate.Session;

import java.util.List;

public interface RoomService extends SuperService {

    Roomdto saveRoom(Roomdto roomdto);
    Roomdto updateRoom(Roomdto roomdto);
    void deleteRoom(String id);

    List<Roomdto> allRooms(Session session);

    Roomdto searchRoom(String Id);

    List<String>roomIDs(Session session);

    Roomdto byId(String Id);



}
