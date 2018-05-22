package controller.singletons;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidatesFile {
    private final String REGEX = "((([a-zA-Z]+:)?([0-9]{2})([a-zA-Z]{3})([0-9]{4})\\(([a-z]{3,4})\\)[,]?){3,})\\n?"; // https://regexr.com/
    private List<String> entryFileValidated;
    private List<String> entryFile;

    public ValidatesFile(List<String> entryFile) {
        this.entryFile = entryFile;
        entryFileValidated = new ArrayList<>();            
    }
 
    public List<String> validatePatternsFile() {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher;
        removeSpaces(entryFile).forEach(s -> {
            if (pattern.matcher(s).matches()) {
                entryFileValidated.add(s);
            } else{ //Qual a necessidade se não vai para lugar algum? AS LINHAS ERRADAS VEM PRIMEIRO NA SAÍDA
                System.out.println("Linha inválida! Exemplo de formato aceito: 'Rewards:99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa)'");
            }
        });
        return entryFileValidated;
    }
    
    private List<String> removeSpaces(List<String> entryFile) {
        return entryFile.stream()
                .map(s -> s.replace(" ", "").trim())
                .collect(Collectors.toList());
    }
}



