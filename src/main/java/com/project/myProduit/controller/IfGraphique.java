package com.project.myProduit.controller;

import com.project.myProduit.service.IClientService;

/**
 * Cette permet le controle de l'application avec un navigateur
 */
public class IfGraphique implements IController {

    IClientService clientService ;

    public void createInterfaceControl(){
        //
        System.out.println("interface graphique activer, page web pas d'implentation");
    }

    public IClientService getClientService() {
        return clientService;
    }

    public void setClientService(IClientService clientService) {
        this.clientService = clientService;
    }
}
