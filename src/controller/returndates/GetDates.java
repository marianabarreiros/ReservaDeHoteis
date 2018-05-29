package controller.returndates;

import controller.singletons.ValidDates;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class GetDates {
    private ValidDates validDates = ValidDates.getInstance();
    Set<LocalDate> validatedDates;
    
    public Collection<LocalDate> returnDates(String fileLine){
        return validDates.returnsListOfValidatedDates(convertingStringToList(fileLine));
    } 
    
    private List<String> convertingStringToList(String fileLine){
        int endIndex = fileLine.indexOf(":");
        return Arrays.asList(fileLine.substring(endIndex + 1).split(","));
    }
}
