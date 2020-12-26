package com.project.myProduit.dao;

import com.project.myProduit.metierEntity.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientData implements IClientData {

    private static List<Client> clientList = new ArrayList<>();

    public void create(Client client){
        clientList.add(client);
        System.out.println("Ajout du client : " + client.getNumber()+ "\ndu nom de : " + client.getCustomerName() );
    }


}
