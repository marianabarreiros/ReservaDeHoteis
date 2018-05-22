package controller.findcheapshotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.hotel.Hotel;
import model.quotation.Quotation;
import teste.PriceTable;

public class FindCheapestHotel {
    private Map<String, Set<LocalDate>> mapOfClientsEndDates;
    private List<Hotel> hotelList = new ArrayList<>();
    private List<Quotation> quotations = new ArrayList<>();

    public FindCheapestHotel(Map<String, Set<LocalDate>> mapOfClientsEndDates, List<Hotel> hotelList) {
        this.mapOfClientsEndDates = mapOfClientsEndDates;
        this.hotelList = hotelList;
    }
    
    private String getClient(){
        return mapOfClientsEndDates.entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
                
    }   

//    private List<Set<LocalDate>> getDates() {
//        return mapOfClientsEndDates.entrySet()
//                .stream()
//                .map(Map.Entry::getValue)
//                .collect(Collectors.toList());
//    }
    
    private double getFullValue(Hotel hotel){
        double full = 0;
        PriceTable price = getPriceByClient(hotel, getClient());       
            for(Map.Entry<String, Set<LocalDate>> map : mapOfClientsEndDates.entrySet()){
                for(LocalDate date : map.getValue()){
                    if(date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7){
                        full += price.getWeekendRates();
                    }else{
                        full += price.getWeekdayPrices();}
            }
        }
    return full;
}
    
    private PriceTable getPriceByClient(Hotel hotel, String cliente) {
        return hotel.getPriceTable().stream()
                .filter(p -> p.getClient().equalsIgnoreCase(cliente))
                .findAny()
                .get();
    }
    
//    public String findCheapestHotel(){
//        for(int i=0; i<hotelList.size(); i++){
//            double total = getFullValue(hotelList.get(i));
//            quotations.add(new Quotation(hotelList.get(i), total));
//        }
//        java.util.Optional<Quotation> quotation = quotations.stream()
//                .sorted(Comparator.comparing(Quotation::getTotal).reversed());
//                        
//        
//        return quotation.get().getHotel().getName();
//    }
}