/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import singletons.ReadFile;

/**
 *
 * @author Win-7
 */
public class TestPatternFile {
    ReadFile rf;
    String outra = "";
    String regex = "([a-zA-Z]+:)?([0-9]{2})([a-zA-Z]{3})([0-9]{4})\\(([a-zA-Z]{3,4})\\)[,]?";
    String string;

    public TestPatternFile(String string) {
        this.string = string;
    }
 
    public String validatePatternsFile(){
        this.beginsAndEnd();
        Pattern padrao = Pattern.compile(regex);
        Matcher mat = padrao.matcher(string);
        while(mat.find()){
            //não funciona
            if(string.matches(regex)){
                outra+=(mat.group());
            }
            else{
                System.out.println("Arquivo inválido! Exemplo de formato aceito: 'Rewards:26Mar2009(thur),27Mar2009(fri),28Mar2009(sat),28Mar2009(sat),28Mar2009(sat)'");
                break;
            }                   
        }
        return outra;
    }
    
    private boolean beginsAndEnd(){
        this.removeSpaces(string);
        if(string.matches("^[a-zA-Z].*") && string.matches(".*[)]$"))
            return true;
        else{
            System.out.println("A string não começa com letra e termina com o caracter ´)´. Favor corrigir!");
            System.exit(0);
            return false;
        }
    }
    
    private String removeSpaces(String string){
        string.replace(" ", "").trim();
        return string;
    }
}
