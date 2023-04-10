package lk.sankalpa.hms.controller;

import animatefx.animation.SlideInLeft;
import animatefx.animation.SlideOutRight;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.sankalpa.hms.dto.Roomdto;
import lk.sankalpa.hms.dto.Studentdto;
import lk.sankalpa.hms.service.ServiceFactory;
import lk.sankalpa.hms.service.ServiceTypes;
import lk.sankalpa.hms.service.custom.RoomService;
import lk.sankalpa.hms.service.custom.StudentService;
import lk.sankalpa.hms.util.FactoryConfigeration;
import lk.sankalpa.hms.view.tm.StudentTM;
import org.hibernate.Session;

public class DashBoardController {

    @FXML
    private AnchorPane dash_board_pane;

    @FXML
    private JFXButton btn_registers;

    @FXML
    private JFXButton btn_rooms;

    @FXML
    private JFXButton btn_room_reserve;

    @FXML
    private Pane fisrt_Pane;

    @FXML
    private JFXTextField txt_student_id;

    @FXML
    private JFXTextField txt_student_name;

    @FXML
    private JFXTextField txt_student_number;

    @FXML
    private JFXTextField txt_student_address;

    @FXML
    private JFXRadioButton R_btn_Male;

    @FXML
    private ToggleGroup R_btn;

    @FXML
    private JFXRadioButton R_btn_female;

    @FXML
    private JFXRadioButton R_btn_others;

    @FXML
    private JFXButton btn_register;

    @FXML
    private JFXDatePicker txt_student_dob;

    @FXML
    private TableView<StudentTM> tbl_student;

    @FXML
    private TableColumn<StudentTM, String> col_s_ID;

    @FXML
    private TableColumn<?, ?> col_s_Name;

    @FXML
    private TableColumn<?, ?> col_s_Address;

    @FXML
    private TableColumn<?, ?> col_s_Number;

    @FXML
    private TableColumn<?, ?> col_s_DOB;

    @FXML
    private TableColumn<?, ?> col_s_Gender;

    @FXML
    private TableColumn<?, ?> col_s_Option;

    @FXML
    private TextField txt_search_studenr;

    @FXML
    private JFXDatePicker txt_date_of_registration;

    @FXML
    private JFXTextField txt_student_room_type;

    @FXML
    private JFXTextField txt_student_romm_payed_price;

    @FXML
    private JFXCheckBox cb_later;

    @FXML
    private Pane second_pane;

    @FXML
    private JFXComboBox<?> C_box_romm_id;

    @FXML
    private JFXButton btn_new_romm;

    @FXML
    private JFXTextField txt_room_type;

    @FXML
    private JFXTextField txt_room_price;

    @FXML
    private JFXTextField txt_room_qty;

    @FXML
    private JFXButton btn_room_update;

    @FXML
    private TableView<?> tbl_room;

    @FXML
    private TableColumn<?, ?> col_room_ID;

    @FXML
    private TableColumn<?, ?> col_room_Type;

    @FXML
    private TableColumn<?, ?> col_room_Price;

    @FXML
    private TableColumn<?, ?> col_room_Qty;

    @FXML
    private TableColumn<?, ?> col_room_Option;

    @FXML
    private Label lbl_room_id;

    @FXML
    private JFXTextField txt_room_Id;

    @FXML
    private Pane thier_Pane;

    @FXML
    private Label lbl_rasavation_ID;

    @FXML
    private JFXDatePicker resavation_date;

    @FXML
    private JFXTextField txt_res_student_id;

    @FXML
    private JFXTextField txt_res_room_id;

    @FXML
    private JFXTextField txt_res_room_Type;

    @FXML
    private JFXTextField txt_do_payments;

    @FXML
    private TableView<?> tbl_Resavation;

    @FXML
    private TableColumn<?, ?> col_Res_ID;

    @FXML
    private TableColumn<?, ?> col_Res_Student_Name;

    @FXML
    private TableColumn<?, ?> col_Res_Room_Type;

    @FXML
    private TableColumn<?, ?> col_Res_Remain_Payments;

    @FXML
    private TableColumn<?, ?> col_Res_Options;

    @FXML
    private JFXTextField txt_res_room_remain_payments;

    @FXML
    private Pane forth_Pane;


    //==========================================================================================
    //==========================================================================================
    public StudentService studentService;
    public RoomService roomService;
    public void initialize(){

        studentService = ServiceFactory.getInstance().getService(ServiceTypes.STUDENT);
        roomService=ServiceFactory.getInstance().getService(ServiceTypes.ROOM);

        fisrt_Pane.setVisible(true);
        loadAllStudent();


        col_s_ID.setCellValueFactory(new PropertyValueFactory<StudentTM,String>("id"));
        col_s_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_s_Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_s_Number.setCellValueFactory(new PropertyValueFactory<>("number"));
        col_s_DOB.setCellValueFactory(new PropertyValueFactory<>("bod"));
        col_s_Gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_s_Option.setCellValueFactory(new PropertyValueFactory<>("button"));

    }



    @FXML
    void btn_register_On_Actoin(ActionEvent event) {


        if (forth_Pane.isVisible()) {
            new SlideOutRight(forth_Pane).play();
        }
        if(second_pane.isVisible()){
            new SlideOutRight(second_pane).play();
        }
        if (thier_Pane.isVisible()) {
            new SlideOutRight(thier_Pane).play();
        }
        new SlideInLeft(fisrt_Pane).play();
        fisrt_Pane.setVisible(true);
    }

    @FXML
    void btn_rooms_On_Action(ActionEvent event) {

        if (forth_Pane.isVisible()) {
            new SlideOutRight(forth_Pane).play();
        }
        if(fisrt_Pane.isVisible()){
            new SlideOutRight(fisrt_Pane).play();
        }
        if (thier_Pane.isVisible()) {
            new SlideOutRight(thier_Pane).play();
        }
        new SlideInLeft(second_pane).play();
        second_pane.setVisible(true);
    }

    @FXML
    void btn_room_reserve_On_Action(ActionEvent event) {


        if (forth_Pane.isVisible()) {
            new SlideOutRight(forth_Pane).play();
        }
        if(second_pane.isVisible()){
            new SlideOutRight(second_pane).play();
        }
        if (fisrt_Pane.isVisible()) {
            new SlideOutRight(fisrt_Pane).play();
        }
        new SlideInLeft(thier_Pane).play();
        thier_Pane.setVisible(true);

    }


    private  void loadAllStudent(){

        Session session = FactoryConfigeration.getInstance().getSession();


        ObservableList<StudentTM> objects = FXCollections.observableArrayList();


        for (Studentdto ss: studentService.allStudents(session)) {
            Button button1 = new Button("Delete");
            StudentTM studentTM = new StudentTM(ss.getId(),
                    ss.getName(),
                    ss.getAddress(),
                    ss.getNumber(),
                    ss.getBod(),
                    ss.getGender(),
                    button1);

            button1.setOnAction(event -> {
                tbl_student.getItems().removeAll(tbl_student.getSelectionModel().getSelectedItem());

                studentService.deleteStudent(studentTM.getId());

            });


            objects.add(studentTM);
            tbl_student.setItems(objects);

        }
    }


    @FXML
    void btn_Fore(ActionEvent event) {



//        if(thier_Pane.isVisible()){
//            new SlideOutRight(thier_Pane).play();
//        }
//        if (second_pane.isVisible()) {
//            new SlideOutRight(second_pane).play();
//        }
//        if (fisrt_Pane.isVisible()) {
//            new SlideOutRight(fisrt_Pane).play();
//        }
//        new SlideInLeft(forth_Pane).play();
//        forth_Pane.setVisible(true);

    }

    public void search_On_Action(ActionEvent actionEvent) {

        btn_register.setText("Update");

        Studentdto studentdto = studentService.searchStudent( txt_search_studenr.getText());

        if(studentdto.getGender().equals(R_btn_Male.getText())){

            txt_student_id.setText(studentdto.getId());
            txt_student_name.setText(studentdto.getName());
            txt_student_address.setText(studentdto.getAddress());
            txt_student_number.setText(studentdto.getNumber());
            txt_student_dob.setValue(studentdto.getBod());
            R_btn_Male.setSelected(true);

        }


         if(studentdto.getGender().equals(R_btn_female.getText())){

            txt_student_id.setText(studentdto.getId());
            txt_student_name.setText(studentdto.getName());
            txt_student_address.setText(studentdto.getAddress());
            txt_student_number.setText(studentdto.getNumber());
            txt_student_dob.setValue(studentdto.getBod());
            R_btn_female.setSelected(true);

        }


         if(studentdto.getGender().equals(R_btn_others.getText())){

            txt_student_id.setText(studentdto.getId());
            txt_student_name.setText(studentdto.getName());
            txt_student_address.setText(studentdto.getAddress());
            txt_student_number.setText(studentdto.getNumber());
            txt_student_dob.setValue(studentdto.getBod());
            R_btn_others.setSelected(true);

        }

    }

    public void btn_Student_register_On_Actoin(ActionEvent actionEvent) {


        if(btn_register.getText().equals("Register")) {

            if (R_btn_Male.isSelected()) {

                Studentdto studentdto = studentService.saveStudent( new Studentdto(

                        txt_student_id.getText(),
                        txt_student_name.getText(),
                        txt_student_address.getText(),
                        txt_student_number.getText(),
                        txt_student_dob.getValue(),
                        R_btn_Male.getText()));

            }



            if (R_btn_female.isSelected()) {

                Studentdto studentdto = studentService.saveStudent( new Studentdto(

                        txt_student_id.getText(),
                        txt_student_name.getText(),
                        txt_student_address.getText(),
                        txt_student_number.getText(),
                        txt_student_dob.getValue()));
//                        R_btn_female.getText()));

            }


            if (R_btn_others.isSelected()) {

                Studentdto studentdto = studentService.saveStudent( new Studentdto(

                        txt_student_id.getText(),
                        txt_student_name.getText(),
                        txt_student_address.getText(),
                        txt_student_number.getText(),
                        txt_student_dob.getValue()));
//                        R_btn_others.getText()));

            }





            }
        if (btn_register.getText().equals("Update")) {

            studentService.updateStudent( new Studentdto(

                    txt_student_id.getText(),
                    txt_student_name.getText(),
                    txt_student_address.getText(),
                    txt_student_number.getText(),
                    txt_student_dob.getValue()));
                    //R_btn_Male.getText()));

        }

loadAllStudent();
    }

    public void change_btn_On_Action(MouseEvent mouseEvent) {

        btn_register.setText("Register");

    }
    //==========================================================================================
    //==========================================================================================



    @FXML
    void C_box_romm_id_On_Action(ActionEvent event) {

    }


    @FXML
    void btn_New_Room_On_Action(ActionEvent event) {


    }

    @FXML
    void btn_Room_Update_On_Action(ActionEvent event) {
        roomService.saveRoom(new Roomdto(
                txt_room_Id.getText(),
                txt_room_type.getText(),
                Double.parseDouble(txt_room_price.getText()),
                Integer.parseInt(txt_room_qty.getText())
        ));
        System.out.println("Sdfsdfsdf");
    }



    @FXML
    void icon_Search_Student_By_ID(MouseEvent event) {




    }

    @FXML
    void txt_Res_Student_Id_On_Action(ActionEvent event) {

    }

}
