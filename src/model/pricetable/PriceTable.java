package teste;

public class PriceTable {
    private String client;
    private double weekdayPrices;
    private double weekendRates;

    public PriceTable(String client, double weekdayPrices, double weekendRates) {
        this.client = client;
        this.weekdayPrices = weekdayPrices;
        this.weekendRates = weekendRates;
    }

    public String getClient() {
        return client;
    }

    public double getWeekdayPrices() {
        return weekdayPrices;
    }

    public double getWeekendRates() {
        return weekendRates;
    }

    public void setWeekdayPrices(double weekdayPrices) {
        this.weekdayPrices = weekdayPrices;
    }

    public void setWeekendRates(double weekendRates) {
        this.weekendRates = weekendRates;
    }  
}
