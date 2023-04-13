package lk.sankalpa.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Roomdto {

    private String roomId;
    private String type;
    private double keymoney;
    private int qyt;

}