package lk.sankalpa.hms.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.sankalpa.hms.dao.custom.RoomDao;
import lk.sankalpa.hms.entity.Room;
import lk.sankalpa.hms.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoomDaoImpl implements RoomDao {

    private final Session session;

    public RoomDaoImpl(Session session) {

        this.session=session;

    }

    @Override
    public Room save(Room entity, Session session) {

        session.save(entity);
        return entity;

    }

    @Override
    public Room update(Room entity, Session session) {


        session.update(entity);
        return entity;
    }

    @Override
    public Room search(String Id, Session session) {


        Room room = session.find(Room.class, Id);

        return new Room(
        room.getRoomId(),
        room.getType(),
        room.getKeymoney(),
        room.getQyt()

        );


    }

    @Override
    public void delete(String Id, Session session) {

        Room load = session.load(Room.class, Id);

        session.delete(load);


    }

    @Override
    public List<Room> allData(Session session) {

        Query<Room> from_student_ = session.createQuery("From Room ");

        List<Room> list = from_student_.list();

        for (Room room:list) {

            room.getRoomId();
            room.getType();
            room.getKeymoney();
            room.getQyt();

        }
        return list;
    }

    @Override
    public List<String> roomIds(Session session) {

        Query select_roomId_from_room_ = session.createQuery("SELECT roomId FROM Room ");

        List list = select_roomId_from_room_.list();

        return list;



    }

}
