/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

import core.Client;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author qt
 */
public class ValidateFileLines {
    private static ValidateFileLines validateFileLinesInstance;
    private Map dictionary = new LinkedHashMap();

    private ValidateFileLines() {}
    
    public static ValidateFileLines getInstance(){
        if(validateFileLinesInstance == null)
            validateFileLinesInstance = new ValidateFileLines();
        return validateFileLinesInstance;
    }
    
    public String validateFileLines(String string){
        String[] stringSplit = string.split("\n");
        for(int i = 0; i< stringSplit.length; i++){
            int endIndex = stringSplit[i].indexOf(":");
            String client = stringSplit[i].substring(0, endIndex);
            String dates = stringSplit[i].substring(endIndex+1);
//            VALIDE O CLIENTE E AS DATAS. SE OS 2 FOREM VÁLIDOS INCLUA NO DICIONÁRIO E ENVIE O MAP.
//            if()
            
        }
        return string;
    }
}
