package lk.sankalpa.hms.service;

import lk.sankalpa.hms.dto.Reservationdto;
import lk.sankalpa.hms.dto.Roomdto;
import lk.sankalpa.hms.dto.Studentdto;
import lk.sankalpa.hms.dto.Userdto;
import lk.sankalpa.hms.entity.Reservation;
import lk.sankalpa.hms.entity.Room;
import lk.sankalpa.hms.entity.Student;
import lk.sankalpa.hms.entity.User;

public class Converter {

    public Studentdto fromStudent(Student student){

        return new Studentdto(student.getId(), student.getName(), student.getAddress(), student.getNumber(), student.getBod(), student.getGender());

    }

    public Student toStudent(Studentdto studentdto){

        return new Student(studentdto.getId(),
                studentdto.getName(),
                studentdto.getAddress(),
                studentdto.getNumber(),
                studentdto.getBod(),
                studentdto.getGender());

    }

    public Room toRoom(Roomdto roomdto){
        return new Room(roomdto.getRoomId(), roomdto.getType(), roomdto.getKeymoney(), roomdto.getQyt());
    }

    public Roomdto fromRoom(Room room){
        return  new Roomdto(room.getRoomId(), room.getType(), room.getKeymoney(), room.getQyt());
    }

    public Reservation toReservation(Reservationdto reservationdto){
        return new Reservation(reservationdto.getRes_id(),
                reservationdto.getDate(),
                reservationdto.getStatus(),
               toStudent(reservationdto.getStudent()),
              toRoom(reservationdto.getRoom()));
    }

    public Reservationdto fromReservation (Reservation reservation){

        return new Reservationdto(reservation.getRes_id(),
                reservation.getDate(),
                reservation.getStatus(),
                new Studentdto(reservation.getStudent().getId(),reservation.getStudent().getName()),
                new Roomdto(reservation.getRoom().getRoomId(),reservation.getRoom().getType()));

    }

    public Userdto fromUser(User user){

        return new Userdto(user.getUsername(),user.getNic(), user.getPassword());

    }

    public User toUser(Userdto userdto){

        return new User(userdto.getNic(), userdto.getUsername(),userdto.getPassword());

    }



}
