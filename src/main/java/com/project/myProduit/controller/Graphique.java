package com.project.myProduit.controller;

import com.project.myProduit.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Cette permet le controle de l'application avec un navigateur
 */
public class Graphique implements IController {

    @Autowired
    IClientService clientService ;

    public void createInterfaceControl(){
        //
        System.out.println("interface graphique activer, page web pas d'implentation");
    }

    public IClientService getClientService() {
        return clientService;
    }


}
