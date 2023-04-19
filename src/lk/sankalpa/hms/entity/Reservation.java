package lk.sankalpa.hms.entity;

import lk.sankalpa.hms.dto.Roomdto;
import lk.sankalpa.hms.dto.Studentdto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation implements SuperEntity {

    @Id
    private String res_id;
    private LocalDate date;
    private String status;
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;


}

