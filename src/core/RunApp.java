package core;

import controller.singletons.ReadFile;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class RunApp {

    public static void main(String[] args) throws URISyntaxException, IOException {
        
//        ReadFile readFile = new ReadFile();
//        Map<String, Set<LocalDate>> map = new TreeMap();
//       
//        
//            ValidatesFile validateFile = new ValidatesFile(readFile.getListaDeEntradas());
//            CreateMapOfClientsEndDates createMapOfClientsEndDates = CreateMapOfClientsEndDates.getInstance();
//            map = createMapOfClientsEndDates.createMap(validateFile.validatePatternsFile());
//                
////        Criação dos hoteis
//        Hotel lakewood = new Hotel("Lakewwod", '2');
//        
////        Criação das tabelas de preço
//        PriceTable pt = new PriceTable("Regular", 100, 80);
//        PriceTable pt2 = new PriceTable("Especial", 100, 80);
//        
////        Adicionando tabelas dinamicamente
//        lakewood.addPriceTableDynamically(pt);
//        lakewood.addPriceTableDynamically(pt2);
//        
//        List<Hotel> hotelList = Arrays.asList(lakewood);   
//        
////        FindCheapestHotel findCheapsHotel = new FindCheapestHotel((Map<String, Set<LocalDate>>) map, hotelList);
////        System.out.println(findCheapsHotel.getFullValue(lakewood));
//        
//        
//        for(Map.Entry<String, Set<LocalDate>> mp : map.entrySet()){
//            FindCheapestHotel findCheapsHotel = new FindCheapestHotel((Map<String, Set<LocalDate>>) mp, hotelList);  
//            System.out.println();
//        }
    }
}

