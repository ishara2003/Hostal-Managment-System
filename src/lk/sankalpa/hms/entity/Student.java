package lk.sankalpa.hms.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student implements SuperEntity{

    @Id
    private String id;
    private String name;
    private String address;
    private String number;
    private LocalDate bod;
    private String gender;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<Reservation> reservationList = new ArrayList<>();

    public Student(String id, String name, String address, String number, LocalDate bod, String gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.bod = bod;
        this.gender = gender;
    }

    public Student(String id) {
        this.id = id;
    }
}
