package lk.sankalpa.hms.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

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

}
