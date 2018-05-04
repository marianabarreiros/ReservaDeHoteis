package controller.validatefaile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import controller.singletons.ReadFile;

public class ValidatePatternFile {
    private String StringByFileValidated = "";
    private String regex = "((([a-zA-Z]+:)?([0-9]{2})([a-zA-Z]{3})([0-9]{4})\\(([a-z]{3,4})\\)[,]?){3,})\\n?"; // https://regexr.com/
    private String stringByFile;

    public ValidatePatternFile(String StringByFile) {
        this.stringByFile = StringByFile;
    }

    public String validatePatternsFile() {
        String[] stringSplit = this.toSplit(this.removeSpaces(stringByFile));
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        for(int i = 0; i<stringSplit.length; i++){
            if(pattern.matcher(stringSplit[i]).matches())
                StringByFileValidated += stringSplit[i].concat("\n");
            else {
//            PEGUE A LINHA DO ARQUIVO ONDE FOI ENCONTRADO O ERRO!!!!
                System.out.println("Linha inválida! Exemplo de formato aceito: 'Rewards:99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa)'");
            }
        }
        return StringByFileValidated.substring(0, StringByFileValidated.length() - 1);
    }

    private String removeSpaces(String string) {return string.replace(" ", "").trim();}

    private String[] toSplit(String string) {
        String[] stringSplit = null;
        stringSplit = string.split("\n");
        return stringSplit;
    }
}
