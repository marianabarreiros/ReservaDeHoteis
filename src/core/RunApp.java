/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import concreteclients.Regular;
import concreteclients.Reward;
import hotel.Hotel;
import java.time.LocalDate;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import simpleclientfactory.SimpleClientFactory;
import singletons.FormatDates;

/**
 *
 * @author qt
 */
public class RunApp {
    public static void main(String[] Args){
//        VERIFICAR SE POSSO COLOCAR UM BUILDER
//        VERIFICAR SE É POSSÍVEL FAZER UM FIFUNCTION
        Hotel lakewood = new Hotel('3', 110, 90, 80, 80);
        Hotel bridgewood = new Hotel('4', 160, 60, 110, 50);
        Hotel ridgewood = new Hotel('5', 220, 150, 100, 40);
        
//        SimpleClientFactory scf = new SimpleClientFactory();
//        Client client = null;
//        try {
//            client = scf.creatClient("Regulam: 17Mar2009(Mon), 18Mar2009(Tue), 19Mar2009(Wed)");
//        } catch (Exception ex) {
//            Logger.getLogger(RunApp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(client);
        
//        Client regular = new Regular();
//        Client reward = new Reward();
        
        FormatDates fd = FormatDates.getInstance();
        Set<LocalDate> fds = fd.formatToDates("Regular: 17Mar2009(Mon), 18Mar2009(Tue), 19Mar2009(Wed)");
        System.out.println(fds);
//        fds.forEach(System.out::println);
        
        
        
        
              
//        System.out.println("A classificação e valores do Hotel Lakewood são, respectivamente "+ Lakewood.getClassification() + ", R$" + Lakewood.getValueDayOfWeekRegular()
//                           + ", R$" + Lakewood.getValueDayOfWeekendRegular()+ ", R$"+ Lakewood.getValueDayOfWeekReward()+ ", R$" + Lakewood.getValueDayOfWeekendReward()+ ".");
        
    }
}
