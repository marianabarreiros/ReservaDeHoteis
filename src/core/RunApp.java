package core;

import controller.mapofclientsanddates.UnmodifiableMapOfClientsEndDates;
import controller.singletons.FileReading;
import controller.validatefile.ValidateFileLines;

public class RunApp {

    public static void main(String[] args){   
        FileReading fileReading = FileReading.getInstance();
        ValidateFileLines validateFileLines;
        UnmodifiableMapOfClientsEndDates mapOfClientsAndDates = new UnmodifiableMapOfClientsEndDates();;
        try {
            validateFileLines = new ValidateFileLines(fileReading.getFilledLinesListInFile()); 
            System.out.println(mapOfClientsAndDates.createMap(validateFileLines.validateFileLinesAcrossByPattern()));            
        } catch (Exception e) {
        }
    }
}

