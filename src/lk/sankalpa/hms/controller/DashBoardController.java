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
import javafx.scene.paint.Paint;
import lk.sankalpa.hms.dto.Reservationdto;
import lk.sankalpa.hms.dto.Roomdto;
import lk.sankalpa.hms.dto.Studentdto;
import lk.sankalpa.hms.entity.Reservation;
import lk.sankalpa.hms.service.ServiceFactory;
import lk.sankalpa.hms.service.ServiceTypes;
import lk.sankalpa.hms.service.custom.ReservationService;
import lk.sankalpa.hms.service.custom.RoomService;
import lk.sankalpa.hms.service.custom.StudentService;
import lk.sankalpa.hms.util.FactoryConfigeration;
import lk.sankalpa.hms.view.tm.ReservationTM;
import lk.sankalpa.hms.view.tm.RoomTM;
import lk.sankalpa.hms.view.tm.StudentTM;
import org.hibernate.Session;

import javax.swing.*;
import java.util.List;
import java.util.regex.Pattern;

public class DashBoardController {

    public TableColumn<Object, Object> col_Res_Date;
    public JFXComboBox<String> C_box_romm_id1;
    public JFXRadioButton R_btn_done;
    public ToggleGroup Payments;
    public JFXRadioButton R_btn_later;
    public JFXTextField Res_ID;
    public RadioButton Reservation_Payments_done;
    public JFXButton btn_next;
    public JFXTextField txt_res_student_name;
    public JFXButton btn_reservation;
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
    private JFXComboBox<String> C_box_romm_id;

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
    private TableView<RoomTM> tbl_room;

    @FXML
    private TableColumn<RoomTM, String> col_room_ID;

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
    private TableView<ReservationTM> tbl_Resavation;

    @FXML
    private TableColumn<ReservationTM, String> col_Res_ID;

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
    public ReservationService reservationService;
    //==========================================================================================
    //==========================================================================================
    private Pattern idPattern;
    private Pattern namePattern;
    private Pattern numberPattern;
    private Pattern addressPattern;
    public void initialize(){

        studentService = ServiceFactory.getInstance().getService(ServiceTypes.STUDENT);
        roomService=ServiceFactory.getInstance().getService(ServiceTypes.ROOM);
        reservationService=ServiceFactory.getInstance().getService(ServiceTypes.RESERVATION);

        fisrt_Pane.setVisible(true);
        loadAllStudent();
        loadAllRooms();
        loadAllIDs();
        LoadIDSOnRegistration();
        loadAllReservations();

        col_s_ID.setCellValueFactory(new PropertyValueFactory<StudentTM,String>("id"));
        col_s_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_s_Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_s_Number.setCellValueFactory(new PropertyValueFactory<>("number"));
        col_s_DOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        col_s_Gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_s_Option.setCellValueFactory(new PropertyValueFactory<>("button"));


        col_room_ID.setCellValueFactory(new PropertyValueFactory<RoomTM,String>("roomId"));
        col_room_Type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_room_Price.setCellValueFactory(new PropertyValueFactory<>("keymoney"));
        col_room_Qty.setCellValueFactory(new PropertyValueFactory<>("qyt"));
        col_room_Option.setCellValueFactory(new PropertyValueFactory<>("button"));


        col_Res_ID.setCellValueFactory(new PropertyValueFactory<ReservationTM,String>("res_id"));
        col_Res_Student_Name.setCellValueFactory(new PropertyValueFactory<>("student"));
        col_Res_Room_Type.setCellValueFactory(new PropertyValueFactory<>("room"));
        col_Res_Remain_Payments.setCellValueFactory(new PropertyValueFactory<>("status"));
        col_Res_Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_Res_Options.setCellValueFactory(new PropertyValueFactory<>("button"));


        idPattern=Pattern.compile("^[A-Z0-9]{2,}$");

        namePattern=Pattern.compile("^[A-Za-z]{4,}$");

        numberPattern=Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");

        addressPattern= Pattern.compile("^[A-Za-z]{2,}$");


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

    public void loadAllRooms(){

        Session session = FactoryConfigeration.getInstance().getSession();


        ObservableList<RoomTM> objects = FXCollections.observableArrayList();


        for (Roomdto ss: roomService.allRooms(session)) {
            Button button1 = new Button("Delete");

            RoomTM roomTM = new RoomTM(
                    ss.getRoomId(),
                    ss.getType(),
                    ss.getKeymoney(),
                    ss.getQyt(),
                    button1);

            button1.setOnAction(event -> {
                tbl_room.getItems().removeAll(tbl_room.getSelectionModel().getSelectedItem());

                roomService.deleteRoom(roomTM.getRoomId());

            });


            objects.add(roomTM);
            tbl_room.setItems(objects);

        }

    }

        ObservableList<ReservationTM> objects = FXCollections.observableArrayList();
    public void loadAllReservations(){
        Session session = FactoryConfigeration.getInstance().getSession();

        objects.clear();

        for (Reservationdto reservationdto :reservationService.allReservatines(session)){

            Button button = new Button("Delete");

            ReservationTM reservationTM = new ReservationTM(
                    reservationdto.getRes_id(),
                    reservationdto.getDate(),
                    reservationdto.getStatus(),
                    reservationdto.getStudent().getId(),
                    reservationdto.getRoom().getRoomId(),
                    button);

            button.setOnAction(event -> {
                tbl_Resavation.getItems().removeAll(tbl_Resavation.getSelectionModel().getSelectedItem());

                    reservationService.deleteReservation(reservationTM.getRes_id());

        });
            objects.add(reservationTM);
            tbl_Resavation.setItems(objects);

    }
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

            boolean matches = idPattern.matcher(txt_student_id.getText()).matches();
            boolean matches1 = namePattern.matcher(txt_student_name.getText()).matches();
            boolean matches2 = numberPattern.matcher(txt_student_number.getText()).matches();
            boolean matches3 = addressPattern.matcher(txt_student_address.getText()).matches();

            if(matches){

                txt_student_id.setFocusColor(Paint.valueOf("Blue"));

                if(matches1){

                    txt_student_name.setFocusColor(Paint.valueOf("Blue"));

                    if(matches2){

                        txt_student_number.setFocusColor(Paint.valueOf("Blue"));

                        if(matches3){

                            txt_student_address.setFocusColor(Paint.valueOf("Blue"));

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

               studentService.saveStudent( new Studentdto(

                        txt_student_id.getText(),
                        txt_student_name.getText(),
                        txt_student_address.getText(),
                        txt_student_number.getText(),
                        txt_student_dob.getValue(),
                        R_btn_female.getText()));

            }


            if (R_btn_others.isSelected()) {

             studentService.saveStudent( new Studentdto(

                        txt_student_id.getText(),
                        txt_student_name.getText(),
                        txt_student_address.getText(),
                        txt_student_number.getText(),
                        txt_student_dob.getValue(),
                        R_btn_others.getText()));

            }
                        }else {
                            txt_student_address.setFocusColor(Paint.valueOf("Red"));
                            txt_student_address.requestFocus();
                        }

                    }else {
                        txt_student_number.setFocusColor(Paint.valueOf("Red"));
                        txt_student_number.requestFocus();
                    }

                }else {
                    txt_student_name.setFocusColor(Paint.valueOf("Red"));
                    txt_student_name.requestFocus();
                }

            }else {
                txt_student_id.setFocusColor(Paint.valueOf("Red"));
                txt_student_id.requestFocus();
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

        resavation_date.setValue(txt_date_of_registration.getValue());
        btn_next.setVisible(true);

loadAllStudent();
    }

    public void change_btn_On_Action(MouseEvent mouseEvent) {

        btn_register.setText("Register");

    }
    //==========================================================================================
    //==========================================================================================






    @FXML
    void btn_New_Room_On_Action(ActionEvent event) {

        btn_room_update.setText("Add");

    }

    @FXML
    void btn_Room_Update_On_Action(ActionEvent event) {

        if (btn_room_update.getText().equals("Add")) {

            roomService.saveRoom(new Roomdto(
                    txt_room_Id.getText(),
                    txt_room_type.getText(),
                    Double.parseDouble(txt_room_price.getText()),
                    Integer.parseInt(txt_room_qty.getText())
            ));
            loadAllRooms();
            loadAllIDs();

            txt_room_Id.clear();
                    txt_room_type.clear();
            txt_room_price.clear();
                    txt_room_qty.clear();


        }

        if(btn_room_update.getText().equals("Update")){

            roomService.updateRoom(new Roomdto(
                    txt_room_Id.getText(),
                    txt_room_type.getText(),
                   Double.parseDouble( txt_room_price.getText()),
                   Integer.parseInt( txt_room_qty.getText())
            ));

        }

    }

    @FXML
    void icon_Search_Student_By_ID(MouseEvent event) {

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

    @FXML
    void txt_Res_Student_Id_On_Action(ActionEvent event) {

        Session session = FactoryConfigeration.getInstance().getSession();

        List<Reservationdto> reservationdtos = reservationService.resById(txt_res_student_id.getText(), session);

        for(Reservationdto reservation:reservationdtos){

            txt_res_room_remain_payments.setText(reservation.getStatus());
            txt_res_room_id.setText(reservation.getRoom().getRoomId());
            txt_res_student_name.setText(reservation.getStudent().getName());
            txt_res_room_Type.setText(reservation.getRoom().getType());
            resavation_date.setValue(reservation.getDate());


        }


        btn_reservation.setText("Update");


    }

    public void C_box_romm_id_On_Action2(ActionEvent actionEvent) {

        Roomdto roomdto = roomService.searchRoom(C_box_romm_id1.getSelectionModel().getSelectedItem());

        txt_student_room_type.setText(roomdto.getType());


    }
    @FXML
    void C_box_romm_id_On_Action(ActionEvent event) {


        Roomdto roomdto = roomService.searchRoom(C_box_romm_id.getSelectionModel().getSelectedItem());

        txt_room_Id.setText(roomdto.getRoomId());
                txt_room_type.setText(roomdto.getType());
        txt_room_price.setText(String.valueOf(roomdto.getKeymoney()));
                txt_room_qty.setText(String.valueOf(roomdto.getQyt()));


    }

    public void loadAllIDs(){
        Session session = FactoryConfigeration.getInstance().getSession();

        ObservableList<String> observableList = FXCollections.observableArrayList(roomService.roomIDs(session));

        C_box_romm_id.setItems(observableList);
        C_box_romm_id1.setItems(observableList);

    }
    public void LoadIDSOnRegistration(){
        Session session = FactoryConfigeration.getInstance().getSession();

        ObservableList<String> observableList = FXCollections.observableArrayList(roomService.roomIDs(session));

        C_box_romm_id1.setItems(observableList);
    }

    public boolean iLoveYou(){

        for(ReservationTM tm:objects){
            if(txt_student_id.getText().equals(tm.getStudent())){

                JOptionPane.showMessageDialog(null, "Student Alrady have a Room", "Missing Data", JOptionPane.WARNING_MESSAGE);

                return false;
            }
        }
        return true;
    }

    public void Reservation_Save_On_Action(ActionEvent actionEvent) {



//    if(iLoveYou()){
//
//
//
//
//            if (txt_student_id.getText().equals("")) {
//                JOptionPane.showMessageDialog(null, "Student Id and Room Type CAN NOT BE NULL", "Missing Data", JOptionPane.WARNING_MESSAGE);
//
//            } else {
//
//                Studentdto student = new Studentdto();
//                student.setId(txt_student_id.getText());
//
//                Studentdto studentdto = studentService.byStudentId(txt_student_id.getText());
//
//                Roomdto roomdto = roomService.byId(C_box_romm_id1.getValue());
//
//                Roomdto room = new Roomdto();
//                room.setRoomId(C_box_romm_id1.getValue());
//
//
//                if(!Res_ID.getText().equals("")|| resavation_date.getValue().equals("")){
//
//
//                if (R_btn_done.isSelected()) {
//
//                    reservationService.addReservation(new Reservationdto(
//
//
//                            Res_ID.getText(),
//                            resavation_date.getValue(),
//                            R_btn_done.getText(),
//                            studentdto,
//                            roomdto));
//
//                }
//
//
//                if (R_btn_later.isSelected()) {
//
//                    reservationService.addReservation(new Reservationdto(
//
//
//                            Res_ID.getText(),
//                            resavation_date.getValue(),
//                            R_btn_later.getText(),
//                            studentdto,
//                            roomdto));
//
//                }
//
//                loadAllReservations();
//
//        }else {
//                    JOptionPane.showMessageDialog(null,"Fill the request details");
//                }
//      }
//    }

        if(btn_reservation.getText().equals("Update")){
            System.out.println("SEx");

            if(Reservation_Payments_done.isSelected()) {

                reservationService.updateReservation(new Reservationdto(

                        Reservation_Payments_done.getText()

                ));
            }
            loadAllReservations();
        }


   }
        public void btn_next_On_Action (ActionEvent actionEvent){

            btn_room_reserve_On_Action(actionEvent);

        }
    }
