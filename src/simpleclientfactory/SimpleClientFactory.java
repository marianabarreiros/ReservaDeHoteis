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
    public Client creatClient(String enter){
        Client client = null;
        try {
            switch(enter.substring(0, 7).toLowerCase()){
                case "regular":
                    client = new Regular();
                    break;
                case "reward":
                    client = new Reward();
                    break;
            }
        } 
        catch (NullPointerException e) {
            System.out.println("Cliente " +client+ " não existe. Verifique seu arquivo!");
        }
//        LANÇAR EXCEÇÃO PARA CLIENTE NÃO EXISTE
        return client;
    }
}

