package lk.sankalpa.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userdto {

    private String username;
    private String nic;
    private String password;


    public Userdto(String nic, String password) {
        this.nic = nic;
        this.password = password;
    }
}
