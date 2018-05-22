package controller.singletons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class DatesValidation {

    private static DatesValidation datesValidationInstance;
    private Set<String> dates;
    private Set<LocalDate> validatedDates;

    private DatesValidation() {
    }

    public static DatesValidation getInstance() {
        if (datesValidationInstance == null) {
            datesValidationInstance = new DatesValidation();
        }
        return datesValidationInstance;
    }

    public Set<LocalDate> returnsListOfValidatedDates(List<String> dates) {
        validatedDates = new LinkedHashSet<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
        AtomicBoolean isValid = new AtomicBoolean(Boolean.TRUE);
        this.dates = getDatesWithoutDaysOfWeek(toSeparateDateByComma(dates));
        this.dates.forEach(date -> {
            try {
                LocalDate localDate = LocalDate.parse(date, formatter);
                validatedDates.add(localDate);
            } catch (DateTimeParseException e) {
                isValid.set((Boolean.FALSE));
            }
        });
        return isValid.get() ? validatedDates : null;
    }
    
    private Set<String> toSeparateDateByComma(List<String> dates) {
        String text = ConvertingListToStringSeparatingDataWithComma(dates);
        String[] datesSeparatedByCommas = null;
        datesSeparatedByCommas = text.split(",");
        return this.dates = new LinkedHashSet(Arrays.asList(datesSeparatedByCommas));
    }
    
    private String ConvertingListToStringSeparatingDataWithComma(List<String> dates){
        String text = "";
        for(String date : dates){
            text += date + ",";
        }
        return text.substring(0, text.length()-1);
    }
    
    private Set<String> getDatesWithoutDaysOfWeek(Set<String> dates) {
        Set<String> datesWithoutDayOfWeek = dates.stream()
                .map(date -> date.substring(0, 9).toLowerCase())
                .collect(Collectors.toSet());
        return datesWithoutDayOfWeek;       
    }   
}
