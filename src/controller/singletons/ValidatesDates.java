/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.singletons;

import static java.lang.System.exit;
import static java.lang.reflect.Array.set;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author qt
 */
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

    public Set<LocalDate> validatesDates(String dates) {
        formatDates = new LinkedHashSet<>();
        this.dates = this.ignoreDaysOfWeek(dates);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
        AtomicBoolean isValido = new AtomicBoolean(Boolean.TRUE);
        this.dates.forEach(date -> {
            try {
                LocalDate localDate = LocalDate.parse(date, formatter);
                formatDates.add(localDate);
//               TENTAR COLOCAR A LINHA DO ARQUIVO E O ÍNDICE1!!!
            } catch (DateTimeParseException e) {
                isValido.set((Boolean.FALSE));
            }
        });
        return isValido.get() ? formatDates : null;
    }

    private Set<String> ignoreDaysOfWeek(String datesAsString) {
        this.dates = this.toSplitDates(datesAsString);
        Set<String> newDates = new LinkedHashSet<>();
        this.dates.forEach(date -> {
            newDates.add(date.substring(0, 9).trim().toLowerCase());
        });
        return newDates;
    }

    private Set<String> toSplitDates(String dates) {
        String[] datesSplit = null;
        datesSplit = dates.split(",");
        this.dates = new LinkedHashSet(Arrays.asList(datesSplit));
        return this.dates;
    }
}
