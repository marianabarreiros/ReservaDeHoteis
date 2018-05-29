package model.quotation;

import model.hotel.Hotel;

public class Quotation {
    private Hotel hotel;
    private double total;

    public Quotation(Hotel hotel, double total) {
        this.hotel = hotel;
        this.total = total;
    }

    public Hotel getHotel() {return hotel;}
    
    public double getTotal() {return total;}
    
    public double getClassificationHotel(){return hotel.getClassification();}
}