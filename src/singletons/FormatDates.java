/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

import static java.lang.reflect.Array.set;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author qt
 */
public class FormatDates {
    private static FormatDates formatDatesInstance;
//    private static LocalDate[] formatDates;
    private String datesAsString;
    private Set<String> dates = new LinkedHashSet<>();
    private Set<LocalDate> formatDates = new LinkedHashSet<>();
    
    
    private FormatDates(){     
    }
    
    public static FormatDates getInstance(){
        if(formatDatesInstance == null)
            formatDatesInstance =  new FormatDates();
        return formatDatesInstance;
    }
    
//    CONSIDERE QUE NÃO OCORRERÁ ERROS VINDOS DO ARQUIVO...

    
    public Set<String> ignoreDaysOfWeek(String datesAsString){
        this.dates = this.toSplitDates(datesAsString);
        Set<String> newDates = new LinkedHashSet<String>();
        for(String date : this.dates){
           newDates.add(date.substring(0, 9).trim());
        }
        return newDates;           
    }
    
    public Set<String> toSplitDates(String dates){
        datesAsString = this.getDates(dates);
        this.dates = new LinkedHashSet(Arrays.asList(datesAsString.split(",")));
        return this.dates; 
    }
    public String getDates(String dates){
        this.datesAsString = dates.trim().replace(" ", "").substring(8, 52);
        return this.datesAsString;
    }
    
    
}
