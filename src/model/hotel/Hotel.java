package model.hotel;

import java.util.ArrayList;
import java.util.List;
import model.pricetable.PriceTable;

public class Hotel {
  private String name;
  private char classification;
  private List<PriceTable> priceTable;

    public Hotel(String name, char classification) {
        this.name = name;
        this.classification = classification;
        priceTable = new ArrayList<>();
    }

    public String getName() {return name;}
    
    public char getClassification() {return classification;}

    public List<PriceTable> getPriceTable() {return priceTable;}
    
    private boolean thereIsClient(PriceTable priceTable){
        return this.priceTable.stream()
                .filter(p -> p.getClientType().equalsIgnoreCase(priceTable.getClientType()))
                .findAny()
                .isPresent();
    }
    
    public void addPriceTableDynamically(PriceTable priceTable){        
        if(!thereIsClient(priceTable)){
            this.priceTable.add(priceTable);
        }else
            System.out.println("Esse Cliente já foi adicionado ao hotel"); 
    }
}
