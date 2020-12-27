package com.project.myProduit;

import com.project.myProduit.controller.IController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
