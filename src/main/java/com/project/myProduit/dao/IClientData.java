package com.project.myProduit.dao;

import com.project.myProduit.metierEntity.Client;

public interface IClientData {

    void create(Client client);
    boolean insert(Client client);
    boolean update(Client client);
    boolean delete(Client client);
}
