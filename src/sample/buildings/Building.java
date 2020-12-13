package sample.buildings;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.util.Duration;

public abstract class Building extends Image implements BuildingTemplateMethod {


    public Building(String url) {
        super(url);
    }

    protected int incomePeriod;
    protected int income;
    protected int cost;
    protected int time;
    protected Label cash;

    public void build(Label cash){

        setCost();
        setIncome();
        setIncomeperiod();

        this.cash=cash;

        setTimer();
        payForBuilding();
    }

    public void payForBuilding() {
            if (canAfford()) {
                cash.setText(String.valueOf(Integer.parseInt(cash.getText()) - cost));
            }
    }


    public void setTimer() {
        Timeline incomePeriodExecutor = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        event -> {
                            if (time < incomePeriod) {
                                time++;
                            } else {
                                payIncome();
                                time = 1;
                            }
                        }));
        incomePeriodExecutor.setCycleCount(Timeline.INDEFINITE);
        incomePeriodExecutor.play();
    }


    public void payIncome() {
        int cashInt = Integer.parseInt(cash.getText());
        cash.setText(String.valueOf(cashInt + income));
    }

    public boolean canAfford() {
        int cashInt = Integer.parseInt(cash.getText());
        return cashInt > cost;
    }

}
