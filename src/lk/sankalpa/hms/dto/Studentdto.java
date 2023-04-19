package lk.sankalpa.hms.dto;


import lk.sankalpa.hms.entity.Reservation;
import lk.sankalpa.hms.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Studentdto implements SuperEntity {
    private String id;
    private String name;
    private String address;
    private String number;
    private LocalDate bod;
    private String gender;
    private List<Reservation> list=new ArrayList<>();

    public Studentdto(String id, String name, String address, String number, LocalDate bod) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.bod = bod;
    }

    public Studentdto(String id) {
        this.id = id;
    }

    public Studentdto(String id, String name, String address, String number, LocalDate bod, String gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.bod = bod;
        this.gender = gender;
    }

    public Studentdto(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
