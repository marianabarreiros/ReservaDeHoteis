package core;

import com.sun.javafx.collections.UnmodifiableObservableMap;
import controller.findcheapshotel.FindCheapestHotel;
import controller.mapofclientsanddates.UnmodifiableMapOfClientsEndDates;
import controller.singletons.FileReading;
import controller.validatefile.ValidateFileLines;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import model.hotel.Hotel;
import teste.PriceTable;

public class RunApp {

    public static void main(String[] args){   
        FileReading fileReading = FileReading.getInstance();
        ValidateFileLines validateFileLines;
        Map<String, Set<LocalDate>> mapClientsAndDates = new TreeMap<>();
        try {
            UnmodifiableMapOfClientsEndDates mapOfClientsAndDates = new UnmodifiableMapOfClientsEndDates();
            validateFileLines = new ValidateFileLines(fileReading.getFilledLinesListInFile()); 
            mapClientsAndDates = mapOfClientsAndDates.createMap(validateFileLines.validateFileLinesAcrossByPattern());
        } catch (Exception e) {
        }
        
        //        Criação dos hoteis
        Hotel lakewood = new Hotel("Lakewod", '2');
        
//        Criação das tabelas de preço
        PriceTable priceTableRegular = new PriceTable("Regular", 100, 80);
        PriceTable priceTableRewards = new PriceTable("Rewards", 100, 80);
        
//        Adicionando tabelas dinamicamente
        lakewood.addPriceTableDynamically(priceTableRegular);
        lakewood.addPriceTableDynamically(priceTableRewards);
        
        List<Hotel> hotelList = Arrays.asList(lakewood);   
        
//        FindCheapestHotel findCheapsHotel = new FindCheapestHotel((Map<String, Set<LocalDate>>) map, hotelList);
//        System.out.println(findCheapsHotel.getFullValue(lakewood));
        
        
        for(Map.Entry<String, Set<LocalDate>> mp : mapClientsAndDates.entrySet()){
            FindCheapestHotel findCheapsHotel = new FindCheapestHotel(mp, hotelList);  
            System.out.println(findCheapsHotel.findCheapestHotel());
        }
    }
}

