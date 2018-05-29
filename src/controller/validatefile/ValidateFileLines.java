package controller.validatefile;

import java.util.ArrayList;
import java.util.Collection;;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidateFileLines {
    private final String REGEX = "((([a-zA-Z]+:)?([0-9]{2})([a-zA-Z]{3})([0-9]{4})\\(([a-z]{3,4})\\)[,]?){3,})\\n?"; // https://regexr.com/
    private Collection<String> listOfValidatedFileLines;
    private Collection<String> listOfFileLines;

    public ValidateFileLines(Collection<String> listOfFileLines) {
        this.listOfFileLines = listOfFileLines;
        listOfValidatedFileLines = new ArrayList<>();            
    }
 
    public Collection<String> validateFileLinesAcrossByPattern() {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher;
        getListOfFileLinesWithoutSpaces(listOfFileLines).forEach(s -> {
            if (pattern.matcher(s).matches()) {
                listOfValidatedFileLines.add(s);
            } else{ //Qual a necessidade se não vai para lugar algum? AS LINHAS ERRADAS VEM PRIMEIRO NA SAÍDA
                System.out.println("Linha inválida! Exemplo de formato aceito: 'Rewards:99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa)'");
            }
        });
        return listOfValidatedFileLines;
    }
    
    private Collection<String> getListOfFileLinesWithoutSpaces(Collection<String> entryFile) {
        return entryFile.stream()
                .map(s -> s.replace(" ", "").trim())
                .collect(Collectors.toList());
    }
}