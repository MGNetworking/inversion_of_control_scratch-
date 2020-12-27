## Projet Scratch
Le but de ce projet est de permettre la compréhension des mécanismes d'inversion de contrôle et
l'injection des dépendance en java avec le Framework Spring.

Pour mettre en place le conteneur leger de spring (Spring Lightweight container), un fichier de 
configuration de type "xml" va permettre la création des instances et d'injecter les dépendances 
au démarrage de l'application.

On appelle ce mécanisme l'inversion de contrôle. Dans le repertoire resources, vous allez trouver 
le fichier "applicationContext.xml" qui permet de créer au démarrage de l'application la création 
puis l'injection des composant.

Pour utilisé cette configuration il faut importer la dépendance suivant :

```xml
<dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.2.8.RELEASE</version>
</dependency>
```

Cette bibliothéque via le fichier applicationContext.xml, permet de charger les classes ciblés 
puis de gardés en mémoire tout les composant instancier pendant la durée de l'application.
Ces composants sont gardé sous la forme de graphe (structure de données) pour matérialisé les 
dépendances entre les composants

#### Exemple de configuration :
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd">


    <bean id="ID_servicePrefix" class="com.project.myProduit.service.ClientServiceDefault">
        <property name="clientData" ref="ID_postgres"/>
    </bean>

    <bean id="ID_console" class="com.project.myProduit.controller.IfConsole">
        <property name="clientService" ref="ID_servicePrefix"/>
    </bean>
    
    <bean id="ID_postgres" class="com.project.myProduit.dao.ClientDataPostgres"/>

</beans>
```

