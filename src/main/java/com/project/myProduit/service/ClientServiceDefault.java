package com.project.myProduit.service;

import com.project.myProduit.dao.IClientData;
import com.project.myProduit.metierEntity.Client;

/**
 * Cette permet la gestion de la creation des facture sans prefix
 */
public class ClientServiceDefault implements IClientService {

    // numero de facture
    private static long countNumber = 0L;
    private IClientData clientData;

    public void createfacture(Client client) {
        client.setNumber(String.valueOf(++countNumber));
        clientData.create(client);
    }

    public IClientData getClientData() {
        return clientData;
    }

    public void setClientData(IClientData clientData) {
        this.clientData = clientData;
    }
}
