/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.singletons;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author Win-7
 */
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
        final String FILE = "HotelReservation" + File.separator + "HotelReservation.txt"; 
        try (Stream<String> stream = Files.lines(Paths.get(getClass().getClassLoader().getResource(FILE).toURI()))){
            stream.forEach(s -> stringsByFile.append(s + "\n"));
        } catch (Exception e) {
            System.out.println("Erro na tentiva de leitura do arquivo. Verifique se o caminho está correto: " + e.getMessage());               
        }
        return stringsByFile.toString();
    }
}
