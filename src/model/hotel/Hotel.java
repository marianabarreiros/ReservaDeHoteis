package model.hotel;

import java.util.ArrayList;
import java.util.List;
import teste.PriceTable;

public class Hotel {
  private String name;
  private char classification;
  private List<PriceTable> priceTable;

    public Hotel(String name, char classification) {
        this.name = name;
        this.classification = classification;
        priceTable = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public char getClassification() {
        return classification;
    }

    public List<PriceTable> getPriceTable() {
        return priceTable;
    }
    
    private boolean thereIsClient(PriceTable table){
        return priceTable.stream()
                .filter(p -> p.getClient().equalsIgnoreCase(table.getClient()))
                .findAny()
                .isPresent();
    }
    
    public void addPriceTableDynamically(PriceTable table){        
        if(!thereIsClient(table)){
            priceTable.add(table);
        }else
            System.out.println("Esse Cliente já foi adicionado ao hotel"); 
    }
}
