package sample.buildings;


public class LoggersHut extends Building {
    public LoggersHut(String url) {
        super(url);
    }

    @Override
    public void setCost() {
        this.cost = 1500;
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
