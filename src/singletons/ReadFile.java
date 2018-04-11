/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

import java.io.File;
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
        StringBuilder str = new StringBuilder();
        String fileName = File.separator + "Users" + File.separator + "Win-7" + File.separator + "Desktop" + File.separator + "HotelReservation.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))){
            stream.forEach(s -> str.append(s + "\r\n"));
        } catch (Exception e) {
            System.out.println("Erro na tentiva de leitura do arquivo. Verifique se o caminho está correto: " + e.getMessage());
                    
        }
        return str.toString();
    }
}
