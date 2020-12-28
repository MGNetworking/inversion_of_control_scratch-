package com.project.myProduit.controller.graphique;

import com.project.myProduit.controller.IController;
import com.project.myProduit.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Cette permet le controle de l'application avec un navigateur
 */
@Controller
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
