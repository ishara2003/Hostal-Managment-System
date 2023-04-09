package lk.sankalpa.hms.controller;

import animatefx.animation.ZoomIn;
import animatefx.animation.ZoomOut;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.sankalpa.hms.util.Navigation;
import lk.sankalpa.hms.util.Routes;

import java.io.IOException;

public class Login_Controller {



    public AnchorPane main_01;
    public JFXButton close_btn;
    public AnchorPane content_Page;
    public JFXButton btn_login;
    public JFXButton btn_fogot_password;
    public JFXTextField txt_user_name;
    public JFXPasswordField txt_password;
    public Pane change_pw_pane;
    public JFXTextField txt_nic;
    public JFXTextField txt_ch_user_name;
    public JFXTextField txt_new_password;
    public JFXTextField txt_conferm_password;

    public void initialize(){

       change_pw_pane.setVisible(false);

    }
    String un="Ishara";
    String pw="Ishara75";

    public void close_On_Acion(ActionEvent actionEvent) {

        Platform.exit();

    }
    public void btn_fogot_password_On_Action(ActionEvent actionEvent) {

        new ZoomIn(change_pw_pane).play();
        change_pw_pane.setVisible(true);

    }
    public void close_pane(MouseEvent mouseEvent) {

        new ZoomOut(change_pw_pane).play();

    }
    public void btm_Login_On_Action(ActionEvent actionEvent) throws IOException {

    if(txt_user_name.getText().equals(un)||txt_password.getText().equals(pw)){

        Navigation.navigate(Routes.PAGE_ONE,content_Page );
    }

    }
    public void password_On_Action(ActionEvent actionEvent) throws IOException {

        if(txt_user_name.getText().equals(un)||txt_password.getText().equals(pw)){

            Navigation.navigate(Routes.PAGE_ONE,content_Page );
        }

    }
    public void txt_NIC_On_Action(ActionEvent actionEvent) {



    }

    public void txt_Conferm_Password_On_Action(ActionEvent actionEvent) {



    }
}
