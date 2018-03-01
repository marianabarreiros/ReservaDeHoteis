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
        switch(month){
            case "Mar":
                value = Month.MARCH.getValue();
                break;
        }
        return value;
    }
}
