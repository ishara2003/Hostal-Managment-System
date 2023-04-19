package lk.sankalpa.hms.dto;

import lk.sankalpa.hms.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Roomdto {

    private String roomId;
    private String type;
    private double keymoney;
    private int qyt;
    private List<Reservation> list=new ArrayList<>();

    public Roomdto(String roomId, String type, double keymoney, int qyt) {
        this.roomId = roomId;
        this.type = type;
        this.keymoney = keymoney;
        this.qyt = qyt;
    }

    public Roomdto(String roomId) {
        this.roomId = roomId;
    }

    public Roomdto(String roomId, String type) {
        this.roomId = roomId;
        this.type = type;
    }
}