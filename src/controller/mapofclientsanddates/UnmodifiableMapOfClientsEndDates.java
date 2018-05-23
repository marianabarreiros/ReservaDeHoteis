package controller.mapofclientsanddates;

import controller.simpleclientfactory.SimpleClientFactory;
import controller.singletons.ValidDates;
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

public class UnmodifiableMapOfClientsEndDates {

    SimpleClientFactory simpleClientFactory = new SimpleClientFactory();
    private Map<String, Set<LocalDate>> mapClientsAndDates = new TreeMap<>();

    public Map<String, Set<LocalDate>> createMap(List<String> listOfFileLines) {        
        ValidDates validDates = ValidDates.getInstance();
        String nameClient = null;
        String[] dates;
        int endIndex = 0;
        for(String fileLine : listOfFileLines){
            endIndex = fileLine.indexOf(":");
            nameClient = fileLine.substring(0, endIndex);
            dates = fileLine.substring(endIndex + 1).split(",");
            List<String> datesAsList = Arrays.asList(dates);
            final boolean createdClient = simpleClientFactory.creatClient(nameClient);
            final Set<LocalDate> validatedDates = validDates.returnsListOfValidatedDates(datesAsList);  
            if (createdClient && validatedDates != null) {
                mapClientsAndDates.put(simpleClientFactory.getClientType().getTypeClient(), validatedDates);
            } else {
                System.out.println("Erro ao criar usuário ou a data não é válida " + fileLine);
            }
        }
        return Collections.unmodifiableMap(mapClientsAndDates);
        }
}