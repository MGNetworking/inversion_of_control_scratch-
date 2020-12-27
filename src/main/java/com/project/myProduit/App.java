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
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.security.ec.point.ProjectivePoint;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/*
 * Projet scratch
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        IController iController = context.getBean(IController.class);

        iController.createInterfaceControl();

    }
}
