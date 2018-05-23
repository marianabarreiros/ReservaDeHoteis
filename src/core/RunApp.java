package core;

import controller.mapofclientsanddates.UnmodifiableMapOfClientsEndDates;
import controller.singletons.FileReading;
import controller.validatefile.ValidateFileLines;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.hotel.Hotel;
import teste.PriceTable;

public class RunApp {

    public static void main(String[] args){   
        FileReading fileReading = FileReading.getInstance();
        ValidateFileLines validateFileLines;
        UnmodifiableMapOfClientsEndDates mapOfClientsAndDates = new UnmodifiableMapOfClientsEndDates();;
        try {
            validateFileLines = new ValidateFileLines(fileReading.getFilledLinesListInFile()); 
            mapOfClientsAndDates.createMap(validateFileLines.validateFileLinesAcrossByPattern());
        } catch (Exception e) {
        }
        
        //        Criação dos hoteis
        Hotel lakewood = new Hotel("Lakewwod", '2');
        
//        Criação das tabelas de preço
        PriceTable pt = new PriceTable("Regular", 100, 80);
        PriceTable pt2 = new PriceTable("Especial", 100, 80);
        
//        Adicionando tabelas dinamicamente
        lakewood.addPriceTableDynamically(pt);
        lakewood.addPriceTableDynamically(pt2);
        
        List<Hotel> hotelList = Arrays.asList(lakewood);   
        
//        FindCheapestHotel findCheapsHotel = new FindCheapestHotel((Map<String, Set<LocalDate>>) map, hotelList);
//        System.out.println(findCheapsHotel.getFullValue(lakewood));
        
        
//        for(Map.Entry<String, Set<LocalDate>> mp : map.entrySet()){
//            FindCheapestHotel findCheapsHotel = new FindCheapestHotel((Map<String, Set<LocalDate>>) mp, hotelList);  
//            System.out.println();
//        }
    }
}

