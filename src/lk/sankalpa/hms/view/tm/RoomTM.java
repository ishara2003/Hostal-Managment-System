package lk.sankalpa.hms.view.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomTM {

    private String roomId;
    private String type;
    private double keymoney;
    private int qyt;
    private Button button;

}
