package core;

import com.sun.javafx.collections.UnmodifiableObservableMap;
import controller.findcheapshotel.FindCheapestHotel;
import controller.mapofclientsanddates.UnmodifiableMapOfClientsEndDates;
import controller.singletons.FileReading;
import controller.validatefile.ValidateFileLines;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import model.hotel.Hotel;
import model.pricetable.PriceTable;

public class RunApp {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Hotel> listaHoteis = loadHotels();
        FileReading fileReading = FileReading.getInstance();
        ValidateFileLines validateFileLines = new ValidateFileLines(fileReading.getFilledLinesListInFile());
        validateFileLines.validateFileLinesAcrossByPattern(); 
        
        for(String fileLine : validateFileLines.validateFileLinesAcrossByPattern()){
            FindCheapestHotel findCheapestHotel = new FindCheapestHotel(fileLine, listaHoteis);
            findCheapestHotel.findCheapestHotel();
        }
    }

    public static List<Hotel> loadHotels() {
//        Criação dos hoteis
        Hotel lakewood = new Hotel("Lakewood", '3');
        Hotel bridgewood = new Hotel("Bridgewood", '4');
        Hotel ridgewood = new Hotel("Ridgewood", '5');

//        Criação das tabelas de preço
        PriceTable lakewoodRegular = new PriceTable("Regular", 110, 90);
        PriceTable lakewoodRewards = new PriceTable("Rewards", 80, 80);
        PriceTable bridgewoodRegular = new PriceTable("Regular", 160, 60);
        PriceTable bridgewoodRewards = new PriceTable("Rewards", 110, 50);
        PriceTable ridgewoodRegular = new PriceTable("Regular", 220, 150);
        PriceTable ridgewoodRewards = new PriceTable("Rewards", 100, 40);
        
//        Adicionando tabelas dinamicamente
        lakewood.addPriceTableDynamically(lakewoodRegular);
        lakewood.addPriceTableDynamically(lakewoodRewards);
        bridgewood.addPriceTableDynamically(bridgewoodRegular);
        bridgewood.addPriceTableDynamically(bridgewoodRewards);
        ridgewood.addPriceTableDynamically(ridgewoodRegular);
        ridgewood.addPriceTableDynamically(ridgewoodRewards);

        List<Hotel> hotelList = Arrays.asList(lakewood, bridgewood, ridgewood);
        return hotelList;
    }
}

