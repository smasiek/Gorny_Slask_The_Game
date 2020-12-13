package sample.buildings;

import javafx.scene.control.Label;

public class LoggersHut extends Building {
    public LoggersHut(String url) {
        super(url);
    }

    @Override
    public void build(Label cash) {
        this.cost=1500;
        this.income=300;
        this.incomePeriod=60;
        this.time=1;
        this.cash=cash;

        payForBuilding();
        setTimer();
    }
}
