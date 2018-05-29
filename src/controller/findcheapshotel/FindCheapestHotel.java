package controller.findcheapshotel;

import controller.returnclient.GetClient;
import controller.returndates.GetDates;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.hotel.Hotel;
import model.pricetable.PriceTable;
import model.quotation.Quotation;

public class FindCheapestHotel {
    private String fileLine;
    private GetClient getClient;
    private GetDates getDates;
    private Collection<LocalDate> dates = new LinkedHashSet<>();
    private Collection<Hotel> hotelList = new ArrayList<>();
    private List<Quotation> quotations = new ArrayList<>();

    public FindCheapestHotel(String fileLine, Collection<Hotel> hotelList) {
        this.fileLine = fileLine;
        this.hotelList = hotelList;
        getClient = new GetClient();
        getDates = new GetDates();
    }
    
    private double getFullValueForPeriodRequested(Hotel hotel) {
        double full = 0;
        PriceTable price = getPriceTableByClient(hotel, getClient.returnClient(fileLine));
        for (LocalDate date : getDates.returnDates(fileLine)) {
            if (date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) {
                full += price.getWeekendRate();
            } else {
                full += price.getWeekdayPrice();
            }
        }
        return full;
    }
    
    private PriceTable getPriceTableByClient(Hotel hotel, String client) {
        return hotel.getPriceTable().stream()
                .filter(p -> p.getClientType().equalsIgnoreCase(client))
                .findAny()
                .get();
    }
    
    private List<Quotation> getQuotations(){
        for(Hotel hotel : hotelList){
            double total = getFullValueForPeriodRequested(hotel);
            quotations.add(new Quotation(hotel, total));           
        }
        return quotations;
    }
    
    public String findCheapestHotel(){       
        getQuotations().sort(Comparator.comparing(Quotation::getTotal)
                            .thenComparing(Comparator.comparing(Quotation::getClassificationHotel))
        );
        return quotations.get(0).getHotel().getName();
    }
}
