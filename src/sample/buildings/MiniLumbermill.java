package sample.buildings;

import javafx.scene.control.Label;

public class MiniLumbermill extends Building {
    public MiniLumbermill(String url) {
        super(url);
    }

    @Override
    public void build(Label cash) {
        this.cost=800;
        this.income=300;
        this.incomePeriod=60;
        this.time=1;
        this.cash=cash;

        payForBuilding();
        setTimer();
    }
}
