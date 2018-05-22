package teste;

public class PriceTable {
    private String clientType;
    private double weekdayPrice;
    private double weekendRate;

    public PriceTable(String clientType, double weekdayPrice, double weekendRate) {
        this.clientType = clientType;
        this.weekdayPrice = weekdayPrice;
        this.weekendRate = weekendRate;
    }

    public String getClientType() {return clientType;}

    public double getWeekdayPrice() {return weekdayPrice;}

    public double getWeekendRate() {return weekendRate;}

    public void setWeekdayPrice(double weekdayPrice) {this.weekdayPrice = weekdayPrice;}

    public void setWeekendRate(double weekendRate) {this.weekendRate = weekendRate;}  
}
