package sample.buildings;


public class Mint extends Building {
    public Mint(String url) {
        super(url);
    }


    @Override
    public void setCost() {
        this.cost = 10000;
    }

    @Override
    public void setIncome() {
        this.income = 3000;
    }

    @Override
    public void setIncomeperiod() {
        this.incomePeriod = 60;
    }


}
