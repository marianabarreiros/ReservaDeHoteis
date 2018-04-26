/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author qt
 */
public class ValidateFileLines {
    private static ValidateFileLines validateFileLinesInstance;
    private Map dictionary = new LinkedHashMap();

    private ValidateFileLines() {}
    
    public ValidateFileLines getInstance(){
        if(validateFileLinesInstance == null)
            validateFileLinesInstance = new ValidateFileLines();
        return validateFileLinesInstance;
    }
    
}
