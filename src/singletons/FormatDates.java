/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

import static java.lang.System.exit;
import static java.lang.reflect.Array.set;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author qt
 */
public class FormatDates {
    private static FormatDates formatDatesInstance;
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
    public Set<LocalDate> formatToDates(String dates){
       this.dates = this.ignoreDaysOfWeek(dates);
//       for(String date : this.dates){
       this.dates.forEach(date ->{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dMMMuuuu");
            try {
               LocalDate localDate = LocalDate.parse(date,formatter);
               formatDates.add(localDate);
//               TENTAR COLOCAR A LINHA DO ARQUIVO E O ÍNDICE1!!!
           } catch (DateTimeParseException e) {
                System.out.println("A Data " + date + ", " + " não é uma data válida. Favor, corrigir!");
                exit(0);
           }  
       });
//       não enviar nada caso a data seja inválida
       return formatDates;
       
    }
    
    private Set<String> ignoreDaysOfWeek(String datesAsString){
        this.dates = this.toSplitDates(datesAsString);
        Set<String> newDates = new LinkedHashSet<String>();
//        for(String date : this.dates){
        this.dates.forEach(date ->{;
           newDates.add(date.substring(0, 9).trim());
        });
        return newDates;           
    }
    
    private Set<String> toSplitDates(String dates){
        datesAsString = this.getDates(dates);
        this.dates = new LinkedHashSet(Arrays.asList(datesAsString.split(",")));
        return this.dates; 
    }
    
    private String getDates(String dates){
        this.datesAsString = dates.trim().replace(" ", "").substring(8, 52).toLowerCase();
        return this.datesAsString;
    }    
}
