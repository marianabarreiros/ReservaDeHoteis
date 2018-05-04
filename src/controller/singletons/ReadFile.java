package controller.singletons;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile {
    private static ReadFile readFileInstance;

    private ReadFile() {
    }
    
    public static ReadFile getInstance(){
        if(readFileInstance == null)
            readFileInstance =  new ReadFile();
        return readFileInstance;
    }
    
    public String readFile(){
        StringBuilder stringsByFile = new StringBuilder();
        final String FILE = "HotelReservation" + File.separator + "HotelReservation.txt"; //MUDAR PARA O NOME DO PACOTE
        try (Stream<String> stream = Files.lines(Paths.get(getClass().getClassLoader().getResource(FILE).toURI()))){
            stream.forEach(s -> stringsByFile.append(s + "\n"));
        } catch (Exception e) {
            System.out.println("Erro na tentiva de leitura do arquivo. Verifique se o caminho está correto: " + e.getMessage());               
        }
        return stringsByFile.toString();
    }
}
