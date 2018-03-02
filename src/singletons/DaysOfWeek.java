/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author Win-7
 */
public class DaysOfWeek {
    private static DaysOfWeek daysOfWeekInstance;
    private DayOfWeek day;
    
    private DaysOfWeek(){
    }
    
    public static DaysOfWeek getInstance(){
        if(daysOfWeekInstance == null)
            daysOfWeekInstance = new DaysOfWeek();
        return daysOfWeekInstance;
    }
    
    public int getValue(LocalDate date){
        return date.getDayOfWeek().getValue();
    }   
}
