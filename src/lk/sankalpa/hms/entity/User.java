package lk.sankalpa.hms.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements SuperEntity{

    @Id
    private String nic;
    private String username;
    private String password;

}
