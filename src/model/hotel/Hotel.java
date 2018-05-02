/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hotel;

/**
 *
 * @author qt
 */
public class Hotel {
    private char classification;
    private double valueDayOfWeekRegular;
    private double valueDayOfWeekendRegular;
    private double valueDayOfWeekReward;
    private double valueDayOfWeekendReward;
    
    public Hotel(char classification, double valueDayOfWeekRegular, double valueDayOfWeekendRegular, double valueDayOfWeekReward, double valueDayOfWeekendReward){
        this.classification = classification;
        this.valueDayOfWeekRegular = valueDayOfWeekRegular;
        this.valueDayOfWeekendRegular = valueDayOfWeekendRegular;
        this.valueDayOfWeekReward = valueDayOfWeekReward;
        this.valueDayOfWeekendReward = valueDayOfWeekendReward;    
    }
    
    public char getClassification() {return classification;}
    public double getValueDayOfWeekRegular() {return valueDayOfWeekRegular;}
    public double getValueDayOfWeekendRegular() {return valueDayOfWeekendRegular;}
    public double getValueDayOfWeekReward() {return valueDayOfWeekReward;}
    public double getValueDayOfWeekendReward() {return valueDayOfWeekendReward;}  
}
