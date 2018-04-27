/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfile;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import singletons.ReadFile;

/**
 *
 * @author Win-7
 */
public class ValidatePatternFile {
    private String StringByFileValidated = "";
    private String regex = "((([a-zA-Z]+:)?([0-9]{2})([a-zA-Z]{3})([0-9]{4})\\(([a-z]{3,4})\\)[,]?){3,})\\n?"; // https://regexr.com/
    private String stringByFile;

    public ValidatePatternFile(String StringByFile) {
        this.stringByFile = StringByFile;
    }

    public String validatePatternsFile() {
        String[] stringSplit = this.toSplit(this.removeSpaces(stringByFile));
        int size = stringSplit.length;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        for(int i = 0; i<stringSplit.length; i++){
            matcher = pattern.matcher(stringSplit[i]);
            if(matcher.matches())
                StringByFileValidated += stringSplit[i].concat("\n");
            else {
//            PEGUE A LINHA DO ARQUIVO ONDE FOI ENCONTRADO O ERRO!!!!
                System.out.println("Linha inválida! Exemplo de formato aceito: 'Rewards:99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa)'");
            }
        }
        return StringByFileValidated.substring(0, StringByFileValidated.length() - 1);
    }

    private String removeSpaces(String string) {return string.replace(" ", "").trim();}

    public String[] toSplit(String string) {
        String[] stringSplit = null;
        stringSplit = string.split("\n");
        return stringSplit;
    }
}
