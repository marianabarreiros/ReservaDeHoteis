/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import clients.Regular;
import clients.Reward;
import hotel.Hotel;
import interfaces.Client;
import java.time.LocalDate;
import java.util.Set;
import singletons.FormatDates;

/**
 *
 * @author qt
 */
public class RunApp {
    public static void main(String[] Args){
        Hotel Lakewood = new Hotel('3', 110, 90, 80, 80);
        Hotel Bridgewood = new Hotel('4', 160, 60, 110, 50);
        Hotel Ridgewood = new Hotel('5', 220, 150, 100, 40);
        
        Client Regular = new Regular();
        Client Reward = new Reward();
        
        FormatDates fd = FormatDates.getInstance();
        Set<LocalDate> fds = fd.formatToDates("Regular:17Mar2009(Mon),18Mar2009(Tue),19Mar2009(Wed)");
        System.out.println(fds);
        
              
//        System.out.println("A classificação e valores do Hotel Lakewood são, respectivamente "+ Lakewood.getClassification() + ", R$" + Lakewood.getValueDayOfWeekRegular()
//                           + ", R$" + Lakewood.getValueDayOfWeekendRegular()+ ", R$"+ Lakewood.getValueDayOfWeekReward()+ ", R$" + Lakewood.getValueDayOfWeekendReward()+ ".");
        
    }
}