package lk.sankalpa.hms.controller;

import animatefx.animation.ZoomIn;
import animatefx.animation.ZoomOut;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.sankalpa.hms.dto.Userdto;
import lk.sankalpa.hms.service.ServiceFactory;
import lk.sankalpa.hms.service.ServiceTypes;
import lk.sankalpa.hms.service.custom.UserService;
import lk.sankalpa.hms.util.FactoryConfigeration;
import lk.sankalpa.hms.util.Navigation;
import lk.sankalpa.hms.util.Routes;
import org.hibernate.Session;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

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
    public FontAwesomeIcon txt_hide_password_icon;
    public FontAwesomeIcon txt_view_password_icon;
    public JFXTextField txt_view_password;
    public Pane create_account_pane;
    public JFXTextField txt_CA_UserName;
    public JFXTextField txt_CA_nic;
    public JFXTextField txt_CA_password;
    public JFXTextField txt_CA_conform_password;

    public UserService userService;
    public void initialize(){

        userService= ServiceFactory.getInstance().getService(ServiceTypes.USER);

       change_pw_pane.setVisible(false);




        txt_view_password_icon.setVisible(false);
        txt_view_password.setVisible(false);

        txt_password.setOnKeyReleased(event -> txt_view_password.setText(txt_password.getText()));

        txt_view_password.setOnKeyReleased(event -> txt_password.setText(txt_view_password.getText()));


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

        Session session = FactoryConfigeration.getInstance().getSession();

        List<Userdto> userdtos = userService.allUsers(session);

        for (Userdto user :userdtos) {
            if(user.getPassword().equals(txt_password.getText()) && user.getUsername().equals(txt_user_name.getText())){
            Navigation.navigate(Routes.PAGE_ONE,content_Page );

            }
        }

    }
    public void txt_NIC_On_Action(ActionEvent actionEvent) {

        Userdto userdto = userService.searchUser(txt_nic.getText());

        if(txt_nic.getText().equals(userdto.getNic())){
            txt_ch_user_name.setText(userdto.getUsername());
        }


    }

    public void txt_Conferm_Password_On_Action(ActionEvent actionEvent) {

        if(txt_new_password.getText().equals(txt_conferm_password.getText())) {

            userService.updateUser(new Userdto(
                    txt_nic.getText(),
                    txt_user_name.getText(),
                    txt_conferm_password.getText()
            ));
        }else {
            JOptionPane.showMessageDialog(null,"Password is not Confermed");
        }

    }

    public void txt_hide_password_icon_On_Action(MouseEvent mouseEvent) {

        txt_view_password.setVisible(false);
        txt_hide_password_icon.setVisible(false);
        txt_password.setVisible(true);
        txt_view_password_icon.setVisible(true);


    }

    public void txt_view_password_icon_On_Action(MouseEvent mouseEvent) {

        /*txtPassword.setVisible(f);*/
        txt_password.setVisible(false);
        txt_view_password_icon.setVisible(false);
        txt_view_password.setVisible(true);
        txt_hide_password_icon.setVisible(true);


    }

    public void save_Account_On_action(ActionEvent actionEvent) {

        if(txt_CA_password.getText().equals(txt_CA_conform_password.getText())){


            userService.saveUser(new Userdto(

                    txt_CA_UserName.getText(),
                    txt_CA_nic.getText(),
                    txt_CA_conform_password.getText()

            ));
        }else {
            JOptionPane.showMessageDialog(null,"Passwword in not Confermed");
        }
    }

    public void close_create_account_pane(MouseEvent mouseEvent) {

        new ZoomOut(create_account_pane).play();
    }

    public void lbl_create_Account_On_action(MouseEvent mouseEvent) {

        new ZoomIn(create_account_pane).play();
        create_account_pane.setVisible(true);


    }
}
