/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclientfactory;

import concreteclients.Regular;
import concreteclients.Reward;
import core.Client;

/**
 *
 * @author Win-7
 */
public class SimpleClientFactory {
    public Client creatClient(String client) throws Exception{
        Client client1 = null;
        switch(client){
                case "regular":
                    client1 = new Regular();
                    break;
                case "reward":
                    client1 = new Reward(); 
                    break;
                default: 
                    throw new Exception("Cliente não existe");
        
//        LANÇAR EXCEÇÃO PARA CLIENTE NÃO EXISTE
        return client1;
    }
}

