/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hotel;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author qt
 */
public class Hotel {

    private char classification;
    /**
     * Map de Tipo Cliente
     */
    private Map<String, Map<String, Double>> valores;

    public Hotel(char classification) {
        this.classification = classification;
        this.valores = new HashMap<>();
    }

    public char getClassification() {
        return classification;
    }

    /**
     * "Regular", "DayOfWeek", 150
     * "Regular", "DayOfWeekend", 300
     * "Rewards", "DayOfWeek", 250
     * "Rewards", "DayOfWeekend", 500
     */
    public boolean addValueByDayAndClientType(String tipoClient, String dayOfWeek, Double value) {
        boolean inserido = Boolean.FALSE;

        if (valores.containsKey(tipoClient)) {
            Map<String, Double> diasCliente = valores.get(tipoClient);
            if (!diasCliente.containsKey(dayOfWeek)) {
                diasCliente.put(dayOfWeek, value);
                inserido = Boolean.TRUE;
            }
        } else {
            HashMap<String, Double> valoresPorData = new HashMap<>();
            valoresPorData.put(dayOfWeek, value);

            valores.put(tipoClient, valoresPorData);
            inserido = Boolean.TRUE;
        }
        return inserido;
    }

    public boolean verifyDayByClientType(String tipoClient, String dayOfWeek) {
        if (valores.containsKey(tipoClient)) {
            Map<String, Double> diasCliente = valores.get(tipoClient);
            if (diasCliente.containsKey(dayOfWeek)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public Double getValueByDayAndClientType(String tipoClient, String dayOfWeek) {
        if (valores.containsKey(tipoClient)) {
            Map<String, Double> diasCliente = valores.get(tipoClient);
            if (diasCliente.containsKey(dayOfWeek)) {
                return diasCliente.get(dayOfWeek);
            }
        }
        return null;
    }

}
