import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Appinitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void initialize(){

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("lk/sankalpa/hms/view/Dash_Board.fxml"))));
       // primaryStage.getIcons().add(new Image("lk/sankalpa/assets/css/5.png"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }
}

