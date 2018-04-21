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

    private ReadFile rf;
    private String outra = "";
    private String regex = "((([a-zA-Z]+:)?([0-9]{2})([a-zA-Z]{3})([0-9]{4})\\(([a-z]{3,4})\\)[,]?){3,})"; // https://regexr.com/
    private String string;

    public TestPatternFile(String string) {
        this.string = string;
    }

    public String validatePatternsFile() {
        Pattern padrao = Pattern.compile(regex);
        Matcher mat = padrao.matcher(this.removeSpaces(string));
        if (mat.matches()) {
           mat.reset();
            while (mat.find()) {
                outra += (mat.group());
            }
        } else {
//            PEGUE A LINHA DO ARQUIVO ONDE FOI ENCONTRADO O ERRO
            System.out.println("Arquivo inválido! Exemplo de formato aceito: 'Rewards:99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa)'");
            System.exit(0);
        }
        return outra;
    }

    private String removeSpaces(String string) {return string.replace(" ", "").trim();}
}
