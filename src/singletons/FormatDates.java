/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

/**
 *
 * @author qt
 */
public class FormatDates {
    private static FormatDates formatDatesInstance;
//    private ;
    
    private FormatDates(){     
    }
    
    public FormatDates getInstance(){
        if(formatDatesInstance == null)
            formatDatesInstance =  new FormatDates();
        return formatDatesInstance;
    }
    
    
}
