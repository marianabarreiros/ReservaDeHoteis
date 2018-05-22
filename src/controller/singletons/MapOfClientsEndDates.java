package controller.singletons;

import controller.simpleclientfactory.SimpleClientFactory;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

public class MapOfClientsEndDates {

    private static MapOfClientsEndDates createMapOfClientsEndDates;
    SimpleClientFactory simpleClientFactory = new SimpleClientFactory();
    private Map<String, Set<LocalDate>> mapClientsEndDates = new TreeMap<>();

    private MapOfClientsEndDates() {
    }

    public static MapOfClientsEndDates getInstance() {
        if (createMapOfClientsEndDates == null) {
            createMapOfClientsEndDates = new MapOfClientsEndDates();
        }
        return createMapOfClientsEndDates;
    }
    
    public Map<String, Set<LocalDate>> createMapOfClientsEndDates(List<String> string) {        
        ValidatesDates fd = ValidatesDates.getInstance();
        String client = null;
        String[] dates;
        int endIndex = 0;
        for(String s : string){
            endIndex = s.indexOf(":");
            client = s.substring(0, endIndex);
            dates = s.substring(endIndex + 1).split(",");
            List<String> datesAsList = Arrays.asList(dates);
            final boolean clienteCriado = simpleClientFactory.creatClient(client);
            final Set<LocalDate> datasValidas = fd.validatesDates(datesAsList);  
            if (clienteCriado && datasValidas != null) {
                mapClientsEndDates.put(simpleClientFactory.getClient().getTypeClient(), datasValidas);
            } else {
                System.out.println("Erro ao criar usuário ou a data não é válida " + s);
            }
        }
        return Collections.unmodifiableMap(mapClientsEndDates);
        }
}

//    PARA TER UM MÉTODO COM A RESPONSABILIDADE DE APENAS VALIDAR A LINHA
//    public boolean validateLine(String line) {        
//        boolean value =  false;
//        ValidatesDates fd = ValidatesDates.getInstance();
//        int endIndex = line.indexOf(":");
//        String client = line.substring(0, endIndex);
//        String[] dates = line.substring(endIndex + 1).split(",");
//        List<String> datesAsList = Arrays.asList(dates);
//        final boolean clienteCriado = simpleClientFactory.creatClient(client);
//        final Set<LocalDate> datasValidas = fd.validatesDates(datesAsList);
//        if (clienteCriado && datasValidas != null) 
//            value = true;
//        else
//            value = false;
//       return value;   
//    }
//    
//    public String getValidatedClient(String line){
//        int endIndex = line.indexOf(":");
//        String client = line.substring(0, endIndex);
//        simpleClientFactory.creatClient(client);
//        return simpleClientFactory.getClient().getTypeClient();
//    }
//    
//    public Set<LocalDate> getValidatedDates(String line){
//        int endIndex = line.indexOf(":");
//        ValidatesDates fd = ValidatesDates.getInstance();
//        String[] dates = line.substring(endIndex + 1).split(",");
//        List<String> datesAsList = Arrays.asList(dates);
//        return fd.validatesDates(datesAsList);
//    }
//}