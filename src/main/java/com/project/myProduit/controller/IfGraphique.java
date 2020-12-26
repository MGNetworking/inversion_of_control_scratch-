package com.project.myProduit.controller;

import com.project.myProduit.service.IClientService;

public class IfGraphique {

    IClientService clientService ;

    public void createInterfaceControl(){
        //
        System.out.println("interface graphique activer, ici page web en fonction");
    }

    public IClientService getClientService() {
        return clientService;
    }

    public void setClientService(IClientService clientService) {
        this.clientService = clientService;
    }
}
