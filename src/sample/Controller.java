package sample;


import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.MementoPattern.Caretaker;
import sample.MementoPattern.Originator;
import sample.buildings.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Main window
    public ArrayList<ImageView> buildings = new ArrayList<>();
    public ImageView building_1;
    public ImageView building_2;
    public ImageView building_3;
    public ImageView building_4;
    public ImageView building_5;
    public ImageView building_6;
    public ImageView building_7;
    public ImageView building_8;
    public ImageView building_9;

    //Choose building dialog
    public ImageView quarry;
    public ImageView miniLumbermill;
    public ImageView house;
    public ImageView lumbermill;
    public ImageView goldmine;
    public ImageView mint;

    public Label cash;

    //Error dialog
    public Label errorText;
    public Button errorButton;

    private Caretaker caretaker;
    private Originator originator;

    //2nd lvl buildings
    private boolean conditionsMet = false;

    public void build1() {
        handlePlusClick(1);
    }

    public void build2() {
        handlePlusClick(2);
    }

    public void build3() {
        handlePlusClick(3);
    }

    public void build4() {
        handlePlusClick(4);
    }

    public void build5() {
        handlePlusClick(5);
    }

    public void build6() {
        handlePlusClick(6);
    }

    public void build7() {
        handlePlusClick(7);
    }

    public void build8() {
        handlePlusClick(8);
    }

    public void build9() {
        handlePlusClick(9);
    }

    public void handlePlusClick(int buildingNumber) {
        if (buildings.get(buildingNumber - 1).getImage() instanceof Building) {
            errorDialog("Niy idzie sam już budować!");
        } else {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("dialog.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Co wybudować?");

                //TODO It's possible to set cost labels using cost.getText(), now it's hard coded

                quarry = (ImageView) root.lookup("#quarry");
                quarry.setOnMouseClicked(event -> {
                    Quarry quarry = new Quarry("/resources/quarry.png");
                    quarry.build(cash);
                    buildingConstruction(quarry, buildingNumber, dialogStage);
                });

                miniLumbermill = (ImageView) root.lookup("#miniLumbermill");
                miniLumbermill.setOnMouseClicked(event -> {
                    MiniLumbermill miniLumbermill = new MiniLumbermill("/resources/mini_lumbermill.png");
                    miniLumbermill.build(cash);
                    buildingConstruction(miniLumbermill, buildingNumber, dialogStage);
                });


                house = (ImageView) root.lookup("#house");
                house.setOnMouseClicked(event -> {
                    LoggersHut loggersHut = new LoggersHut("/resources/loggers_hut.png");
                    loggersHut.build(cash);
                    buildingConstruction(loggersHut, buildingNumber, dialogStage);
                });


                lumbermill = (ImageView) root.lookup("#lumbermill");
                lumbermill.setOnMouseClicked(event -> {
                    if (conditionsMet) {
                        Lumbermill lumbermill = new Lumbermill("/resources/lumbermill.png");
                        lumbermill.build(cash);
                        buildingConstruction(lumbermill, buildingNumber, dialogStage);
                    } else {
                        errorDialog("Budōnek dostympny po kupiyniu Kamieniołomu, Mini Tartaka i Chałpy siōngŏrza");
                    }
                });

                goldmine = (ImageView) root.lookup("#goldmine");
                goldmine.setOnMouseClicked(event -> {
                    if (conditionsMet) {
                        Goldmine goldmine = new Goldmine("/resources/goldmine.png");
                        goldmine.build(cash);
                        buildingConstruction(goldmine, buildingNumber, dialogStage);

                    } else {
                        errorDialog("Budōnek dostympny po kupiyniu Kamieniołomu, Mini Tartaka i Chałpy siōngŏrza");
                    }
                });

                mint = (ImageView) root.lookup("#mint");
                mint.setOnMouseClicked(event -> {
                    if (conditionsMet) {
                        Mint mint = new Mint("/resources/mint.png");
                        mint.build(cash);
                        buildingConstruction(mint, buildingNumber, dialogStage);
                    } else {
                        errorDialog("Budōnek dostympny po kupiyniu Kamieniołomu, Mini Tartaka i Chałpy siōngŏrza");
                    }
                });

                if (!conditionsMet) {
                    lumbermill.setOpacity(0.5);
                    goldmine.setOpacity(0.5);
                    mint.setOpacity(0.5);
                }

                dialogStage.setScene(new Scene(root, 800, 800));
                dialogStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        buildings.add(building_1);
        buildings.add(building_2);
        buildings.add(building_3);
        buildings.add(building_4);
        buildings.add(building_5);
        buildings.add(building_6);
        buildings.add(building_7);
        buildings.add(building_8);
        buildings.add(building_9);
        originator=new Originator();
        caretaker=new Caretaker();
    }

    public void buildingConstruction(Building image, int buildingNumber, Stage dialogStage) {
        if (image.canAfford()) {
            for (int i = 0; i < buildings.size(); i++) {
                if ((buildingNumber - 1) == i) {
                    buildings.get(i).setImage(image);
                    buildings.get(i).setOpacity(1);
                    dialogStage.close();
                    originator.set(image);
                    caretaker.addMemento(originator.storeInMemento());
                    conditionsMet=originator.areConditionsMet(caretaker.getMementos());
                }
            }
        } else {
            errorDialog("Budynek za drogi!");
        }
    }

    public void errorDialog(String errorMessage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("error_dialog.fxml"));

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Błōnd");

            Label text = (Label) root.lookup("#errorText");
            text.setText(errorMessage);

            Button button = (Button) root.lookup("#errorButton");
            button.setOnAction((EventHandler) event -> dialogStage.close());

            dialogStage.setScene(new Scene(root, 400, 200));
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean areConditionsMet() {
        boolean[] conditions = new boolean[]{false, false, false};

        for (ImageView building : buildings) {
            Image buildingImage = building.getImage();
            if (buildingImage instanceof Quarry) {
                conditions[0] = true;
            }
            if (buildingImage instanceof MiniLumbermill) {
                conditions[1] = true;
            }
            if (buildingImage instanceof LoggersHut) {
                conditions[2] = true;
            }
        }

        for (boolean condition : conditions) {
            if (!condition) return false;
        }
        return true;
    }

}
