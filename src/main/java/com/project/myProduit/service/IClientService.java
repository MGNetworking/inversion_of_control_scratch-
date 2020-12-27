package com.project.myProduit.service;

import com.project.myProduit.dao.IClientData;
import com.project.myProduit.metierEntity.Client;

public interface IClientService {

    void createfacture(Client client);
    void setClientData(IClientData clientData);
}
