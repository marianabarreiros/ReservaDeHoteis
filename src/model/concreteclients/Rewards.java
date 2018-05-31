package model.concreteclients;

import model.abstractclient.Client;

public class Rewards extends Client {

    private final String REWARDS = "Rewards";

    @Override
    public String getTypeClient() {
        return REWARDS;
    }
}
