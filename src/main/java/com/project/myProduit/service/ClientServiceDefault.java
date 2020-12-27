package com.project.myProduit.service;

import com.project.myProduit.dao.IClientData;
import com.project.myProduit.metierEntity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Cette permet la gestion de la creation des facture sans prefix
 */
public class ClientServiceDefault implements IClientService {

    @Autowired
    private IClientData clientData;

    // numero de facture
    @Value("${service.countNumber}")
    private long countNumber ;

    public void createfacture(Client client) {
        client.setNumber(String.valueOf(++countNumber));
        clientData.create(client);
    }

    public long getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(long countNumber) {
        this.countNumber = countNumber;
    }

    public IClientData getClientData() {
        return clientData;
    }

}
