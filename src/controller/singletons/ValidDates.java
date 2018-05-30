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

public class ValidDates {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
    private static ValidDates datesValidationInstance;
    private Set<String> dates;
    private Set<LocalDate> validatedDates;
    private AtomicBoolean isValid = new AtomicBoolean(Boolean.TRUE);

    private ValidDates() {
    }

    public static ValidDates getInstance() {
        if (datesValidationInstance == null) {
            datesValidationInstance = new ValidDates();
        }
        return datesValidationInstance;
    }

    public Set<LocalDate> returnsListOfValidatedDates(List<String> dates) {
        validatedDates = new LinkedHashSet<>();
        this.dates = getDatesWithoutDaysOfWeek(dates);
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

    private Set<String> getDatesWithoutDaysOfWeek(List<String> dates) {
        Set<String> datesWithoutDayOfWeek = dates.stream()
                .map(date -> date.substring(0, 9).toLowerCase())
                .collect(Collectors.toSet());
        return datesWithoutDayOfWeek;
    }
}
