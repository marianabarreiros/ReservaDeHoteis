package controller.findcheapshotel;

import controller.simpleclientfactory.SimpleClientFactory;
import controller.singletons.ValidDates;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.hotel.Hotel;
import model.pricetable.PriceTable;
import model.quotation.Quotation;

public class FindCheapestHotel {
    private String fileLine;
    private Set<LocalDate> dates = new LinkedHashSet<>();
    private List<Hotel> hotelList = new ArrayList<>();
    private List<Quotation> quotations = new ArrayList<>();
    private SimpleClientFactory simpleClientFactory = new SimpleClientFactory();
    private ValidDates validatedDates;

    public FindCheapestHotel(String fileLine, List<Hotel> hotelList) {
        this.fileLine = fileLine;
        this.hotelList = hotelList;
        validatedDates = ValidDates.getInstance();
    }
    
//    private String getClient(){
//        int endIndex = fileLine.indexOf(":");
//        String nameClient = fileLine.substring(0, endIndex);
//        final boolean createdClient = simpleClientFactory.creatClient(nameClient);
//        if(createdClient)
//            return simpleClientFactory.getClientType().getTypeClient();
//         
//    }  

//    private List<Set<LocalDate>> getDates() {
//        return mapOfClientsEndDates.entrySet()
//                .stream()
//                .map(Map.Entry::getValue)
//                .collect(Collectors.toList());
//    }
    
//    private double getFullValueForPeriodRequested(Hotel hotel){
//        double full = 0;
//        PriceTable price = getPriceTableByClient(hotel, getClient());       
//            for(Map.Entry<String, Set<LocalDate>> map : mapOfClientsEndDates.entrySet()){
//                for(LocalDate date : map.getValue()){
//                    if(date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7){
//                        full += price.getWeekendRate();
//                    }else{
//                        full += price.getWeekdayPrice();}
//            }
//        }
//    return full;
//}
    
    private PriceTable getPriceTableByClient(Hotel hotel, String client) {
        return hotel.getPriceTable().stream()
                .filter(p -> p.getClientType().equalsIgnoreCase(client))
                .findAny()
                .get();
    }
    
//    public List<Quotation> findCheapestHotel(){
//        for(int i=0; i<hotelList.size(); i++){
//            double total = getFullValueForPeriodRequested(hotelList.get(i));
//            quotations.add(new Quotation(hotelList.get(i), total));
//        }
//        return quotations.stream()
//                .sorted(Comparator.comparing(Quotation::getTotal))
//                .collect(Collectors.toList());
//
//    }
}
