package sample.buildings;


public class Lumbermill extends Building {
    public Lumbermill(String url) {
        super(url);
    }

    @Override
    public void setCost() {
        this.cost = 3000;
    }

    @Override
    public void setIncome() {
        this.income = 500;
    }

    @Override
    public void setIncomeperiod() {
        this.incomePeriod = 60;
    }
}
