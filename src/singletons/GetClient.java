/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

import clients.Regular;
import clients.Reward;
import interfaces.Client;

/**
 *
 * @author Win-7
 */
public class GetClient {
    public Client getClient(StringBuilder entrada){
        Client client = null;
        switch(entrada.substring(0, 6)){
            case "Regular":
                client = new Regular();
                break;
            case "Reward":
                client = new Reward();
                break;
        }
        return client;
    }
}
