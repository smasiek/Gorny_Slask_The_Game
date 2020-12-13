package sample.buildings;


public class Quarry extends Building {
    public Quarry(String url) {
        super(url);
    }

    @Override
    public void setCost() {
        this.cost = 500;
    }

    @Override
    public void setIncome() {
        this.income = 200;
    }

    @Override
    public void setIncomeperiod() {
        this.incomePeriod = 60;
    }
}
