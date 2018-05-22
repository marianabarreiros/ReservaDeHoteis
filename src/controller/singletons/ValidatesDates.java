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

public class ValidatesDates {

    private static ValidatesDates formatDatesInstance;
    private Set<String> dates;
    private Set<LocalDate> formatDates;

    private ValidatesDates() {
    }

    public static ValidatesDates getInstance() {
        if (formatDatesInstance == null) {
            formatDatesInstance = new ValidatesDates();
        }
        return formatDatesInstance;
    }

    public Set<LocalDate> validatesDates(List<String> dates) {
        formatDates = new LinkedHashSet<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
        AtomicBoolean isValido = new AtomicBoolean(Boolean.TRUE);
        this.dates = ignoreDaysOfWeek(toSplitDates(dates));
        this.dates.forEach(date -> {
            try {
                LocalDate localDate = LocalDate.parse(date, formatter);
                formatDates.add(localDate);
            } catch (DateTimeParseException e) {
                isValido.set((Boolean.FALSE));
            }
        });
        return isValido.get() ? formatDates : null;
    }
    
    private Set<String> ignoreDaysOfWeek(Set<String> dates) {
        Set<String> datesWithoutWeek = dates.stream()
                .map(date -> date.substring(0, 9).toLowerCase())
                .collect(Collectors.toSet());
        return datesWithoutWeek;       
    }
    
    private Set<String> toSplitDates(List<String> dates) {
        String text = parseListToString(dates);
        String[] datesSplit = null;
        datesSplit = text.split(",");
        return this.dates = new LinkedHashSet(Arrays.asList(datesSplit));
    }
    
    private String parseListToString(List<String> dates){
        String text = "";
        for(String s : dates){
            text += s + ",";
        }
        return text.substring(0, text.length()-1);
    }
}
