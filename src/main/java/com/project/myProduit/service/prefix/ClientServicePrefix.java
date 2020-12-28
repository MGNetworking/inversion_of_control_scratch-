package com.project.myProduit.service.prefix;

import com.project.myProduit.dao.IClientData;
import com.project.myProduit.metierEntity.Client;
import com.project.myProduit.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Cette classe permet la gestion de numéro de facture avec prefix
 */
@Service
public class ClientServicePrefix implements IClientService {

    @Autowired
    private IClientData clientData;

    // numero de facture
    @Value("${service.countNumber}")
    private long countNumber ;
    @Value("${service.prefix}")
    private String prefix ;


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

}
