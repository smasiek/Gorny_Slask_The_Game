package sample.buildings;


public class Goldmine extends Building {
    public Goldmine(String url) {
        super(url);
    }


    @Override
    public void setCost() {
        this.cost = 5000;
    }

    @Override
    public void setIncome() {
        this.income = 1000;
    }

    @Override
    public void setIncomeperiod() {
        this.incomePeriod = 60;
    }
}
