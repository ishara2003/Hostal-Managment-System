package lk.sankalpa.hms.dto;


import lk.sankalpa.hms.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

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

    public Studentdto(String id, String name, String address, String number, LocalDate bod) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.bod = bod;
    }
}