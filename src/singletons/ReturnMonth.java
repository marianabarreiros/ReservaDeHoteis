/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

import java.time.Month;

/**
 *
 * @author Win-7
 */
public class ReturnMonth {
    int value;
    public int getValue(String month){
        month = month.toLowerCase();
        switch(month){
            case "jan":
                value = Month.JANUARY.getValue();
                break;
            case "feb":
                value = Month.FEBRUARY.getValue();
                break;
            case "mar":
                value = Month.MARCH.getValue();
                break;
            case "apr":
                value = Month.APRIL.getValue();
                break;
            case "may":
                value = Month.MAY.getValue();
                break;
            case "jun":
                value = Month.JUNE.getValue();
                break;
            case "jul":
                value = Month.JULY.getValue();
                break;
            case "aug":
                value = Month.AUGUST.getValue();
                break;
            case "sep":
                value = Month.SEPTEMBER.getValue();
                break;
            case "oct":
                value = Month.OCTOBER.getValue();
                break;
            case "nov":
                value = Month.NOVEMBER.getValue();
                break;
            case "dec":
                value = Month.DECEMBER.getValue();
                break;
        }
        return value;
    }
}
