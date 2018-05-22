package controller.simpleclientfactory;

import model.concreteclients.Regular;
import model.concreteclients.Rewards;
import model.abstractclient.Client;

public class SimpleClientFactory {
    private Client clientType = null;

    public Client getClientType() {return clientType;}
    
    public boolean creatClient(String client){
        switch(client.toLowerCase()){
            case "regular":
                this.clientType = new Regular();
                return true;
            case "rewards":
                this.clientType = new Rewards(); 
                return true;
            default: 
                return false;
        }       
    }
}

