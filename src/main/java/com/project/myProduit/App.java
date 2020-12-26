package com.project.myProduit;

import com.project.myProduit.controller.IfConsole;
import com.project.myProduit.controller.IfGraphique;
import com.project.myProduit.dao.ClientData;
import com.project.myProduit.dao.ClientDataAdvence;
import com.project.myProduit.dao.IClientData;
import com.project.myProduit.service.ClientService;
import com.project.myProduit.service.ClientServicedefault;
import com.project.myProduit.service.IClientService;

import java.util.Scanner;

/*
 * Ce Projet de type scratch donne un aprecut aperçut de la gestion des
 * dépendance faiblement coupler.
 *
 */
public class App {

    /* Au lancement de l'application, un choix est fait par l'utilisateur
     * ce choix permet de fair une sélection d'implementation.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selection interface");

        System.out.println("Enter 1 pour console");
        System.out.println("Enter 2 pour graphique");

        int choix = sc.nextInt();

        /*En fonction du choix fait par l'utilisateur,
        * Le choix console ou interface graphique sera sélectionné.
        * Les dépendance seront créer. Cela permet d'avoir un flexibilité
        * entre l'application est les besoins du client utilisateur .
         */
        if (choix == 1) {
            IfConsole ifConsole = new IfConsole();
            ClientService clientService = new ClientService();
            ClientData clientData = new ClientData();

            // ajout des dépendances
            ifConsole.setClientService(clientService);
            clientService.setClientData(clientData);

            // lancement de l'application
            ifConsole.createInterfaceControl();

        } else if (choix == 2) {
            IfGraphique ifGraphique = new IfGraphique();
            ClientServicedefault clientService = new ClientServicedefault();
            ClientDataAdvence clientDataAdvence = new ClientDataAdvence();

            // ajout des dépendances
            clientService.setClientData(clientDataAdvence);
            ifGraphique.setClientService(clientService);

            // lancement
            ifGraphique.createInterfaceControl();

        }


    }
}
