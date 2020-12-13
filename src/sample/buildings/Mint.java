package sample.buildings;

import javafx.scene.control.Label;


public class Mint extends Building {
    public Mint(String url) {
        super(url);
    }

    @Override
    public void build( Label cash) {
        this.cost=10000;
        this.income=3000;
        this.incomePeriod=60;
        this.time=1;
        this.cash=cash;

        payForBuilding();
        setTimer();
    }

}
