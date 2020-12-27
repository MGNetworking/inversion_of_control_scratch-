package com.project.myProduit;

import com.project.myProduit.controller.IController;
import com.project.myProduit.controller.IfConsole;
import com.project.myProduit.controller.IfGraphique;
import com.project.myProduit.dao.ClientDataMySQL;
import com.project.myProduit.dao.ClientDataPostgres;
import com.project.myProduit.dao.IClientData;
import com.project.myProduit.service.ClientServiceDefault;
import com.project.myProduit.service.ClientServicePrefix;
import com.project.myProduit.service.IClientService;
import sun.security.ec.point.ProjectivePoint;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

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
        Scanner scName = null;
        List<String> listClass = new ArrayList<>();


            try {
                String name ;
                File file  = new File(String.valueOf(Paths.get("resources/config.txt")));
                scName = new Scanner(file);

                while (scName.hasNext()){
                    name = scName.next();

                    listClass.add( name);
                }

            } catch (IOException io) {
                System.out.println("Error IO exception" + io.getMessage() + io.getCause().toString());

            } catch (Exception ex) {
                System.out.println("Error Exception Scanner classe :" + ex.getMessage() + ex.getCause().toString());
            }

        IController iController = null;
        IClientService iClientService = null;
        IClientData iClientData = null;
        try {
            iController = (IController) Class.forName(listClass.get(0)).
                    getDeclaredConstructor().
                    newInstance();
            iClientService = (IClientService) Class.forName(listClass.get(1)).
                    getDeclaredConstructor().
                    newInstance();
            iClientData = (IClientData) Class.forName(listClass.get(2)).
                    getDeclaredConstructor().
                    newInstance();
        } catch (ClassNotFoundException clex) {
            System.out.println(clex.getException() + clex.getMessage() + clex.getCause().toString());

        } catch (Exception ex) {
            System.out.println("Error Exception IOC :" + ex.getMessage() + ex.getCause().toString());
        }

        iController.setClientService(iClientService);
        iClientService.setClientData(iClientData);

        iController.createInterfaceControl();

    }
}
