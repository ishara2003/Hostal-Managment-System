package lk.sankalpa.hms.dto;

import lk.sankalpa.hms.entity.Room;
import lk.sankalpa.hms.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservationdto {


    private String res_id;
    private LocalDate date;
    private String status;
    private Studentdto student;
    private Roomdto room;



}
