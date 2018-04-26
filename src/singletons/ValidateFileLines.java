/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

import core.Client;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import simpleclientfactory.SimpleClientFactory;

/**
 *
 * @author qt
 */
public class ValidateFileLines {
    private static ValidateFileLines validateFileLinesInstance;
    SimpleClientFactory simpleClientFactory = new SimpleClientFactory();
    private Map<Client, LinkedHashSet<LocalDate>> mapClientsEndDates = new LinkedHashMap();

    private ValidateFileLines() {}
    
    public static ValidateFileLines getInstance(){
        if(validateFileLinesInstance == null)
            validateFileLinesInstance = new ValidateFileLines();
        return validateFileLinesInstance;
    }
    
    public LinkedHashMap<Client, LinkedHashSet<LocalDate>> validateFileLines(String string){
        String[] stringSplit = string.split("\n");
        for(int i = 0; i< stringSplit.length; i++){
            int endIndex = stringSplit[i].indexOf(":");
            String client = stringSplit[i].substring(0, endIndex);
            String dates = stringSplit[i].substring(endIndex+1);
//            VALIDE O CLIENTE E AS DATAS. SE OS 2 FOREM VÁLIDOS INCLUA NO DICIONÁRIO E ENVIE O MAP. FALTA PEGAR AS DATAS
            if(simpleClientFactory.creatClient(client))
                mapClientsEndDates.put(simpleClientFactory.getClient(), );                              
            else
                continue;
        }
    return (LinkedHashMap<Client, LinkedHashSet<LocalDate>>) mapClientsEndDates;
            
    }
}
