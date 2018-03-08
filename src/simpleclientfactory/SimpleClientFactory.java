/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclientfactory;

import concreteclients.Regular;
import concreteclients.Reward;
import interfaces.Client;

/**
 *
 * @author Win-7
 */
public class SimpleClientFactory {
    public Client creatClient(StringBuilder enter){
        Client client = null;
        switch(enter.substring(0, 6).toLowerCase()){
            case "regular":
                client = new Regular();
                break;
            case "reward":
                client = new Reward();
                break;
        }
        return client;
    }
}

