## Projet Scratch
Le but de ce projet est de permettre la compréhension des mécanismes d'inversion de contrôle et
l'injection des dépendances.

Ce projet tant a mettre en place le conteneur léger de Spring (Spring Lightweight container), 
via un fichier de configuration de type "xml" qui permettra la création des instances l'injecter 
les dépendances au démarrage de l'application.

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
    <context:property-placeholder location="application.properties"/>
    
    <context:component-scan base-package="com.project.myProduit.controller.Console"/>
    <context:component-scan base-package="com.project.myProduit.dao.postgres"/>
    <context:component-scan base-package="com.project.myProduit.service.prefix"/>

</beans>
```
### Définition
* ``<context:annotation-config />``

Permet l'activation du module de gestion par annotation. 
Ce module une fois activé permettre d'utilise les annotionne Spring de type @Autwored, @Value etc...

* ``<context:property-placeholder location="application.properties"/>``
 
Permet la valorisation des attributs,
dans le cas présent, j'utilisant le fichier application.properties. Dans ce fichier est contenu l'intialisation
des valeursdesiré. 
Cela permet d'extraire du code soucre les configurations recherche qui peuvent selon le client 
être différente.

* ``<context:component-scan base-package="com.project.myProduit.controller.Console"/>``
Permet le scan du repertoir cible afin d'intencier tout les classes qui y sont contenu.

### Annotation de propriéte : @Autowired  
Dés que la configuration par annotation est implémenter l'annotation `@autowired` peut être utilisé.
Cette annotation va créer les instances sur les objets annotées
Spring n'utilisera pas les setters si l'annotation est placer sur la propriété Il est possible d'ajouter l'annotation 
`@autowired` sur le setter, pour forcer 
Spring a passer par le setter lorsque de l'injection de dépendance.

Il existe aussi d'autre annotation qui un focntionnement similaire mais qui n'appartient pas au fonctionnement de 
Spring mais qui peuvent être utilisé :
* @Resource -> Java 
* @Inject   -> Java 66

### Annotation d'attribut : @Values
Cette annotation permet de valorisé les attributs des classes en question.
Les valeurs seront indiqué dans le fichier application.properties qui sera place a la racine 
du classPath de l'application.

### Annotation de composant 
Il existe plusieurs annotation qui permette de désigner via un scan, les composants a instanciés au demarrage de 
l'application, ces annotations pour des noms différent mais ont le même effet. Voici la list des ces composant :
* @Component
* @Controller
* @Repository
* @Service

Certain annotation  de composant permette d'indique avec plus de précisions quelle type de composant il est 
question. Leurs nom est suffisement explicte pour comprendre qu'il s'agit d'un service d'un 
controller ou d'une connection a la base de données comme **@Repository**.

Aussi pour les utilisés il faut que le scan ne trouve pas plusieurs objet appartemeent a la même hiérarchie.
C'est dire que si 2 objet on la méme interface, c'est qu'un choix d'implementation doit être fait.

Pour ce faire, il existe plusieurs solution stragique qui permette fair un selection de scan. Dans mon 
exemple j'ai choisi une solution par package.

### recapitulatif 
1.Etape 

Au demarrage de l'application Spring va scanné tout les repertoires grace au parametre du fichier applicationContext.xml
qui contient le paramétre suivant : ``<context:component-scan base-package="com.project.myProduit.controller.Console"/>``
Le tout afin de ciblé puis créer leur instances grace aux annotation 
* @Component
* @Controller
* @Repository
* @Service

 2.Etape 

Puis il va créer les instances des objets qui porte l'annotion @Autowired qui y sont contenu dans les classes

3.Etape

Aussi les annotations de type @Value permettront d'initilalisé les attributs grace au parametre contenu dans le fichier 
applicationContext.xml ``<context:property-placeholder location="application.properties"/>`` qui lui méme fait réference 
au fichier application.properties



