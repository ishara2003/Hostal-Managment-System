package lk.sankalpa.hms.view.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor

public class StudentTM {



        private String id;
        private String name;
        private String address;
        private String number;
        private LocalDate dob;
        private String gender;
        private Button button;



}
