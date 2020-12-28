package com.project.myProduit.service.defaut;

import com.project.myProduit.dao.IClientData;
import com.project.myProduit.metierEntity.Client;
import com.project.myProduit.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Cette permet la gestion de la creation des facture sans prefix
 */
@Service
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
