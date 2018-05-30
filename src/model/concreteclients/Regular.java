package model.concreteclients;

import model.abstractclient.Client;

public class Regular extends Client {

    private final String REGULAR = "Regular";

    @Override
    public String getTypeClient() {
        return REGULAR;
    }

}
