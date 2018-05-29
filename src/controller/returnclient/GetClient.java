package controller.returnclient;

import controller.simpleclientfactory.SimpleClientFactory;

public class GetClient {
    private SimpleClientFactory simpleClientFactory = new SimpleClientFactory();
    
    public String returnClient(String fileLine){
        simpleClientFactory.creatClient(getNameClient(fileLine));
            return simpleClientFactory.getClientType().getTypeClient(); 
    }
    
    private String getNameClient(String fileLine){
        int endIndex = fileLine.indexOf(":");
        String nameClient = fileLine.substring(0, endIndex);
        return nameClient;
    }
}
