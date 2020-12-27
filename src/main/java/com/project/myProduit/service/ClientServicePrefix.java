package com.project.myProduit.service;

import com.project.myProduit.dao.IClientData;
import com.project.myProduit.metierEntity.Client;

/**
 * Cette classe permet la gestion de numéro de facture avec prefix
 */
public class ClientServicePrefix implements IClientService {

    // numero de facture
    private long countNumber ;
    private String prefix ;
    private IClientData clientData;

    public void createfacture(Client client) {
        client.setNumber(prefix+(++countNumber));
        clientData.create(client);
    }

    public long getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(long countNumber) {
        this.countNumber = countNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public IClientData getClientData() {
        return clientData;
    }

    public void setClientData(IClientData clientData) {
        this.clientData = clientData;
    }
}
