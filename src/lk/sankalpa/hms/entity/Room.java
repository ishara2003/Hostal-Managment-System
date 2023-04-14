package lk.sankalpa.hms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room implements SuperEntity {
@Id
    private String roomId;
    private String type;
    private double keymoney;
    private int qyt;
    @OneToMany(mappedBy = "room", targetEntity = Reservation.class)
    List<Reservation> reservationList = new ArrayList<>();

    public Room(String roomId, String type, double keymoney, int qyt) {
        this.roomId = roomId;
        this.type = type;
        this.keymoney = keymoney;
        this.qyt = qyt;
    }

    public Room(String roomId) {
        this.roomId = roomId;
    }
}
