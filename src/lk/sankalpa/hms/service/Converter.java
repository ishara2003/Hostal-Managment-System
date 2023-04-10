package lk.sankalpa.hms.service;

import lk.sankalpa.hms.dto.Roomdto;
import lk.sankalpa.hms.dto.Studentdto;
import lk.sankalpa.hms.entity.Room;
import lk.sankalpa.hms.entity.Student;

public class Converter {

    public Studentdto fromStudent(Student student){

        return new Studentdto(student.getId(), student.getName(), student.getAddress(), student.getNumber(), student.getBod(), student.getGender());

    }

    public Student toStudent(Studentdto studentdto){

        return new Student(studentdto.getId(), studentdto.getName(), studentdto.getAddress(), studentdto.getNumber(), studentdto.getBod(), studentdto.getGender());

    }

    public Room toRoom(Roomdto roomdto){
        return new Room(roomdto.getRoomId(), roomdto.getType(), roomdto.getKeymoney(), roomdto.getQyt());
    }

    public Roomdto fromRoom(Room room){
        return  new Roomdto(room.getRoomId(), room.getType(), room.getKeymoney(), room.getQyt());
    }


}
