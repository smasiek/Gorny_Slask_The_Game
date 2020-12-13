package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main_window.fxml"));
        primaryStage.setTitle("Wiyrchni Śląsk The Game");
        primaryStage.setResizable(false);

        primaryStage.setScene(new Scene(root, 900, 900));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
