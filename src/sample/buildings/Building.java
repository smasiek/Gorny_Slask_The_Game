package sample.buildings;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.util.Duration;

import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.io.InputStream;

public abstract class Building extends Image implements BuildingTemplateMethod {


    public Building(String url) {
        super(url);
    }

    protected int incomePeriod;
    protected int income;
    protected int cost;
    protected int time;
    protected Label cash;

    @Override
    public void payForBuilding() {
            if (canAfford()) {
                cash.setText(String.valueOf(Integer.parseInt(cash.getText()) - cost));
            }
    }

    @Override
    public void setTimer() {
        Timeline fiveSecondsWonder = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                if (time < incomePeriod) {
                                    time++;
                                } else {
                                    payIncome();
                                    time = 1;
                                }
                            }
                        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
    }

    @Override
    public void payIncome() {
        int cashInt = Integer.parseInt(cash.getText());
        cash.setText(String.valueOf(cashInt + income));
    }

    public boolean canAfford() {
        int cashInt = Integer.parseInt(cash.getText());
        return cashInt > cost;
    }

}
