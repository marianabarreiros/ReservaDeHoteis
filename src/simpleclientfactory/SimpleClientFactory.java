/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclientfactory;

import concreteclients.Regular;
import concreteclients.Rewards;
import core.Client;

/**
 *
 * @author Win-7
 */
public class SimpleClientFactory {
    private Client client = null;

    public Client getClient() {return client;}
    
    public boolean creatClient(String client){
        switch(client.toLowerCase()){
            case "regular":
                this.client = new Regular();
                return true;
            case "rewards":
                this.client = new Rewards(); 
                return true;
            default: 
                return false;
        }       
    }
}

