package lk.sankalpa.hms.service.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.sankalpa.hms.dao.DaoFactory;
import lk.sankalpa.hms.dao.DaoTypes;
import lk.sankalpa.hms.dao.custom.RoomDao;
import lk.sankalpa.hms.dto.Roomdto;
import lk.sankalpa.hms.entity.Room;
import lk.sankalpa.hms.service.Converter;
import lk.sankalpa.hms.service.custom.RoomService;
import lk.sankalpa.hms.util.FactoryConfigeration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class RoomServiceImpl implements RoomService {

    private Converter converter;
    private RoomDao roomDao;
    private Session session;

    public RoomServiceImpl() {
        roomDao= DaoFactory.getInstance().getDAO(session, DaoTypes.ROOM);
        converter=new Converter();
    }

    @Override
    public Roomdto saveRoom(Roomdto roomdto) {

        Session session = FactoryConfigeration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {
        roomDao.save(converter.toRoom(roomdto),session);
            transaction.commit();
            JOptionPane.showMessageDialog(null,"Room Added","", JOptionPane.INFORMATION_MESSAGE);
            session.close();
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,"Room not Added","", JOptionPane.INFORMATION_MESSAGE);
            transaction.rollback();
        }


return null;

    }

    @Override
    public Roomdto updateRoom(Roomdto roomdto) {
        Session session1 = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session1.beginTransaction();

        try {

            roomDao.update(converter.toRoom(roomdto), session1);
            transaction.commit();
            JOptionPane.showMessageDialog(null,"Room Updated","", JOptionPane.INFORMATION_MESSAGE);
            session1.close();
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,"Room Not Updated","", JOptionPane.INFORMATION_MESSAGE);
            transaction.rollback();
        }
        return roomdto;
    }

    @Override
    public void deleteRoom(String id) {

        Session session1 = FactoryConfigeration.getInstance().getSession();
        Transaction transaction = session1.beginTransaction();

        try {
            roomDao.delete(id,session1);
            transaction.commit();
            session1.close();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    @Override
    public List<Roomdto> addRoomes(Session session) {

        return roomDao.allData(session).stream().map(ss ->
                converter.fromRoom(ss)).collect(Collectors.toList());


    }

    @Override
    public Roomdto searchRoom(String Id) {

        Session session1 = FactoryConfigeration.getInstance().getSession();

        Room search = roomDao.search(Id, session1);

        return converter.fromRoom(search);

    }

    @Override
    public List<String> roomIDs(Session session) {

        return roomDao.roomIds(session);

    }
}
