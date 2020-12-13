package sample.buildings;

import javafx.scene.control.Label;

public class Quarry extends Building {
    public Quarry(String url) {
        super(url);
    }

    @Override
    public void build(Label cash) {
        this.cost=500;
        this.income=200;
        this.incomePeriod=60;
        this.time=1;
        this.cash=cash;

        payForBuilding();
        setTimer();
    }
}
