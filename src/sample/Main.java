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
        //StackPane root = new StackPane();
        primaryStage.setTitle("Górny Śląsk The Game");
        primaryStage.setResizable(false);
/*

        root.setPrefHeight(900);
        root.setPrefWidth(900);
        Scene scene=new Scene(root,900,900);

        //set background
        BackgroundImage background=new BackgroundImage(new Image("game_background.png",900,
                900,false,true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background1=new Background(background);
        root.setBackground(background1);

        //set rectangles from top to down corner
        Image blankImage=new Image("blank.png",100,100,false,true);
        ImageView blankImageView=new ImageView(blankImage);

        Image goldmine=new Image("goldmine.png",100,100,false,true);
        ImageView goldmineView=new ImageView(goldmine);

        Group buildings=new Group();
        buildings.setId("budynki");

        root.getChildren().addAll(buildings);

        primaryStage.setScene(scene);
        primaryStage.show();
*/

        primaryStage.setScene(new Scene(root, 900, 900));
        primaryStage.show();

        Controller controller=new Controller();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
