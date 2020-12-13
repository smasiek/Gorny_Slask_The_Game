package sample.buildings;

import javafx.scene.control.Label;

public class Lumbermill extends Building {
    public Lumbermill(String url) {
        super(url);
    }

    @Override
    public void build(Label cash) {
        this.cost=3000;
        this.income=500;
        this.incomePeriod=60;
        this.time=1;
        this.cash=cash;

        payForBuilding();
        setTimer();
    }
}
