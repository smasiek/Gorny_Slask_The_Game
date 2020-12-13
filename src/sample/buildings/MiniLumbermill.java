package sample.buildings;


public class MiniLumbermill extends Building {
    public MiniLumbermill(String url) {
        super(url);
    }


    @Override
    public void setCost() {
        this.cost = 800;
    }

    @Override
    public void setIncome() {
        this.income = 300;
    }

    @Override
    public void setIncomeperiod() {
        this.incomePeriod = 60;
    }
}
