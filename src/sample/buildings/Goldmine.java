package sample.buildings;

import javafx.scene.control.Label;

public class Goldmine extends Building {
    public Goldmine(String url) {
        super(url);
    }

    @Override
    public void build(Label cash) {
        this.cost=5000;
        this.income=1000;
        this.incomePeriod=60;
        this.time=1;
        this.cash=cash;

        payForBuilding();
        setTimer();
    }
}
