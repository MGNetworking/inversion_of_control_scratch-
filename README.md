## Projet Scratch
Le but de ce projet est de permettre la compréhension des mécanismes d'inversion de contrôle et
l'injection des dépendances en java avec le Framework Spring.

Pour mettre en place le conteneur léger de Spring (Spring Lightweight container), un fichier de 
configuration de type "xml" va permettre la création des instances et d'injecter les dépendances 
au démarrage de l'application.

On appelle ce mécanisme l'inversion de contrôle. Dans le répertoire « resources », vous allez trouver 
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

Cette bibliothèque via le fichier applicationContext.xml, permet de charger les classes ciblés 
puis de gardés en mémoire tous les composant instancier pendant la durée de l'application.
Ces composants sont gardé sous la forme de graphe (structure de données) pour matérialiser les 
dépendances entre les composants

#### Exemple de configuration par anotation :
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

    <bean class="com.project.myProduit.service.ClientServicePrefix">
        <property name="countNumber" value="0"/>
        <property name="prefix" value="__NBC__"/>
    </bean>

    <bean class="com.project.myProduit.controller.Console">
    </bean>

    <bean class="com.project.myProduit.dao.ClientDataPostgres"/>

</beans>
```
### NB
Spring n'utilise pas les setters si l'annotation est placer sur la propriété 
Il est possible d'ajouter l'annotation autowired sur le setter, pour forcer 
Spring a passer par le setter lorsque de l'injection de dépendance.


