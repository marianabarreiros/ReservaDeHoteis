/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.concreteclients;

import model.abstractclient.Client;

/**
 *
 * @author qt
 */
public class Regular extends Client{   
    private final String REGULAR = "Regular";
    @Override
    public String getTypeClient() {return REGULAR;}

}
