package com.project.myProduit.service;

import com.project.myProduit.dao.IClientData;
import com.project.myProduit.metierEntity.Client;

/**
 * Cette classe permet la gestion de numéro de facture avec prefix
 */
public class ClientServicePrefix implements IClientService {

    // numero de facture
    private static long countNumber = 0L;
    private final static String prefix = "__NBC_";
    private IClientData clientData;

    public void createfacture(Client client) {
        client.setNumber(prefix+(++countNumber));
        clientData.create(client);
    }

    public IClientData getClientData() {
        return clientData;
    }

    public void setClientData(IClientData clientData) {
        this.clientData = clientData;
    }
}
