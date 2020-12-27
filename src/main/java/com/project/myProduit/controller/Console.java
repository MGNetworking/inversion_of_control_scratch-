package com.project.myProduit.controller;

import com.project.myProduit.metierEntity.Client;
import com.project.myProduit.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 * Cette classe permet le controle de l'application avec
 * la console
 */
public class Console implements IController {

    @Autowired
    IClientService clientService ;

    public void createInterfaceControl() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Spring Excercie");
        System.out.println("----------------");

        System.out.println("entre le nom de votre client");

        String userEntry = sc.nextLine();
        Client client = new Client(userEntry);
        clientService.createfacture(client);

    }

    public IClientService getClientService() {
        return clientService;
    }


}
