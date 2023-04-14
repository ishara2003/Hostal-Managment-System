package lk.sankalpa.hms.view.tm;

import javafx.scene.control.Button;
import lk.sankalpa.hms.dto.Roomdto;
import lk.sankalpa.hms.dto.Studentdto;

import java.time.LocalDate;

public class ReservationTM {

    private String res_id;
    private LocalDate date;
    private String status;
    private String student;
    private String room;
    private Button button;

    public ReservationTM(String res_id, LocalDate date, String status, String student, String room, Button button) {
        this.res_id = res_id;
        this.date = date;
        this.status = status;
        this.student = student;
        this.room = room;
        this.button = button;
    }
}
