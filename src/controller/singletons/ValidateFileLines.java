/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.singletons;

import model.abstractclient.Client;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import controller.simpleclientfactory.SimpleClientFactory;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author qt
 */
public class ValidateFileLines {

    private static ValidateFileLines validateFileLinesInstance;
    SimpleClientFactory simpleClientFactory = new SimpleClientFactory();
    private Map<String, Set<LocalDate>> mapClientsEndDates = new TreeMap<>();

    private ValidateFileLines() {
    }

    public static ValidateFileLines getInstance() {
        if (validateFileLinesInstance == null) {
            validateFileLinesInstance = new ValidateFileLines();
        }
        return validateFileLinesInstance;
    }

    public Map<String, Set<LocalDate>> parseFileLines(String string) {
        String[] stringSplit = string.split("\n");
        ValidatesDates fd = ValidatesDates.getInstance();
        String client = null;
        String dates = null;
        int endIndex = 0;
        for (int i = 0; i < stringSplit.length; i++) {
            endIndex = stringSplit[i].indexOf(":");
            client = stringSplit[i].substring(0, endIndex);
            dates = stringSplit[i].substring(endIndex + 1);
            final boolean clienteCriado = simpleClientFactory.creatClient(client);
            final Set<LocalDate> datasValidas = fd.validatesDates(dates);
            if (clienteCriado && datasValidas != null) {
                mapClientsEndDates.put(simpleClientFactory.getClient().getTypeClient(), datasValidas);
            } else {
                System.out.println("Mensagem de erro ao criar usuário ou a data não é válida, na linha: " + (i + 1));
            }
        }
        return mapClientsEndDates;
    }

}
