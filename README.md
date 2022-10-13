# TP Maven-JUnit
L'objet de cet exercice est de réaliser une classe `ChaineCryptee` qui permettra de chiffrer/déchiffrer une chaîne de caractères (**composée de lettres majuscules et d'espace**).
Le chiffrement utilise une méthode par décalage.
La valeur du décalage représente la clé de chiffrement.
Par exemple, une clé de valeur trois transformera un `'A'` en `'D'`.

La classe `ChaineCryptee` disposera
* des attributs pour la chaîne *en clair* et le décalage,
* un constructeur pour initialiser les instances à partir d'une chaîne en clair et du décalage,
* la méthode `String decrypte()` qui retourne la chaîne en clair,
* la méthode `String crypte()` qui retourne la chaîne chiffrée,
Vous pourrez utilisez pour cela la [méthode `decaleCaractere`](https://gist.github.com/hal91190/4f3a0941e652e82a5e1c572834d97827),
* la possibilité d'initialiser une instance à partir d'une chaîne cryptée et d'un décalage.
Pour éviter l'ambiguïté au niveau du constructeur, vous utiliserez le [modèle de conception Fabrication](http://fr.wikipedia.org/wiki/Fabrique_%28patron_de_conception%29#Autres_avantages_et_variantes).
Pour cela,
    * créez les méthodes de classe `ChaineCryptee deCryptee(String, int)` et `ChaineCryptee deEnClair(String, int)`,
    * rendez le constructeur privé.
La création des instances se fait maintenant à l'aide des deux méthodes de classe.

De plus, le projet sera géré avec [Maven](https://maven.apache.org/) et vous utiliserez une approche pilotée par les tests pour la réalisation, i.e. écrivez toujours un test avant le code et pensez au refactoring.
Le framework de tests devra être [JUnit 4](https://junit.org/junit4/) (ou [5](https://junit.org/junit5/) si vous préférez).
Vous rédigerez votre code source en respectant les [conventions de codage](https://google.github.io/styleguide/javaguide.html) du guide de stype _Google_.
Enfin, la prise en compte des contraintes se fera par de la gestion d’erreurs et des exceptions.

Il pourra éventuellement être nécessaire de [configurer le proxy](http://maven.apache.org/guides/mini/guide-proxies.html) (http://wwwcache.uvsq.fr:3128) pour accéder au dépôt Maven.

À chaque étape, validez vos modifications avec `git` et si nécessaire, exécutez le cycle maven adapté pour vérifier vos manipulations.

1.  Quelles conventions utilise Maven pour l’arborescence des répertoires ?
    > Le détail de l'arborescence maven est disponible en ligne ([Introduction to the Standard Directory Layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)).
    > 
    > En particulier
    > * src/ contient les sources du projet
    > * src/main/java les sources en Java
    > * src/test/java les sources des tests en Java
    > * target/ ce qui est produit par maven
1.  Examinez le projet Maven ainsi que le fichier de description et répondez aux questions suivantes :
    1.  Dans quel répertoire se trouvent les fichiers sources du projet ? Les sources des tests ?
        > * src/main/java les sources en Java
        > * src/test/java les sources des tests en Java
    1. Quelles sont les coordonnées du projet ?
        > cf. [Guide to naming conventions on groupId, artifactId, and version](https://maven.apache.org/guides/mini/guide-naming-conventions.html) 
        ```
        <groupId>fr.uvsq.cprog</groupId>
        <artifactId>mvnjunit</artifactId>
        <version>1.0-SNAPSHOT</version>
        ```
    1. À quoi sert la propriété `project.build.sourceEncoding` ?
        > à préciser l'encodage des fichiers sources (cf. [Specifying a character encoding scheme](https://maven.apache.org/plugins/maven-resources-plugin/examples/encoding.html))
    1. Quelles versions des sources et de la JVM sont utilisés ?
        > Les sources sont en version 7, la JVM cible également (cf. [Setting the `-source` and `-target` of the Java Compiler](https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html) et [Setting the --release of the Java Compiler](https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-release.html)).
        ```
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
        ```
    1. Quelle version de JUnit est configurée ? À quoi sert la balise `scope` ?
        > JUnit 4.11, `scope` précise dans quel contexte utiliser cette dépendance (pour les tests ici) (cf. [Introduction to the Dependency Mechanism](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html))
        ```
        <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>4.11</version>
          <scope>test</scope>
        </dependency>
        ```
    1. À quoi sert la section `pluginManagement` ?
        > à fixer la version des différents plugins utilisés (cf. [Introduction to the Dependency Mechanism](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html))
1.  Modifiez la configuration du projet de la façon suivante :
    1.  fixez la version des sources et des .class pour utiliser la version 17 de Java
    1.  utilisez la dernière version stable de JUnit 4 (cf. [MVNRepository](https://mvnrepository.com/))
1.  Ajoutez un fichier `.gitignore` adapté aux projets Maven (cf. [A collection of .gitignore templates](https://github.com/github/gitignore)) et ajoutez-y les fichiers et répertoires de votre IDE.
1.  Quelle commande Maven permet de :
    1.  créer un `jar` du projet ?
        > mvn package
    1. lancer les tests ?
        > mvn test
    1. supprimer tous les fichiers issus de la compilation ?
        > mvn clean
1.  Ajoutez une classe `ChaineCryptee` et une classe `ChaineCrypteeTest` dans les répertoires et packages appropriés.
    Supprimez les classes d'exemple `App` et `AppTest`.
1.  Énumérez une liste de cas de tests à réaliser en n'oubliant pas les cas d'erreur.
    > * Initialisation avec une chaîne et un décalage (✅)
    > * Initialisation avec une chaîne `null` et un décalage (✅)
    > * Initialisation avec une chaîne `""` et un décalage (✅)
    > * retourner la chaîne en clair (✅)
    > * retourner la chaîne chiffrée (✅)
    > * Initialisation à partir d'une chaîne cryptée et d'un décalage (plus les cas `null` et `""`)
1.  Pour chaque cas de test,
    1. écrivez le test JUnit correspondant dans la classe de test,
    1. vérifiez qu’il échoue,
    1. implémentez la fonctionnalité dans la classe,
    1. vérifiez que le test passe,
    1. appliquez un étape de refactoring sur les tests et la classe si nécessaire.
1.  Comment se comporte votre classe si la chaîne passée au constructeur est `null` ?
Vous pouvez utiliser le débogueur pour identifier le problème (s'il y a un problème) au niveau de `crypte`.
    > RÉPONDRE ICI
    1. ajoutez un test pour prendre en compte la chaîne `null`,
    1. si nécessaire, modifiez la classe pour faire passer le test
1. Changez la représentation interne de la classe : seule la chaîne cryptée est stockée (plus la chaîne en clair).
    * effectuez les modifications nécessaires sans changer l'interface de la classe (les tests ne seront donc pas impactés).
1.  Modifiez le POM pour intégrer la vérification des conventions de codage avec [`checkstyle`](http://maven.apache.org/plugins/maven-checkstyle-plugin/) en utilisant les conventions _Google_.
1.  Ajoutez une méthode `main` qui démontre quelques fonctionnalités de la classe, puis modifiez le POM pour que le jar généré soit exécutable (cf. [Apache Maven JAR Plugin](https://maven.apache.org/plugins/maven-jar-plugin/index.html))
1.  Modifiez la méthode `main` pour que les différents affichages se fassent à l'aide de la bibliothèque de logging [`SLF4J`](http://www.slf4j.org/)
1. En utilisant le plugin [assembly](https://maven.apache.org/plugins/maven-assembly-plugin/) (ou le plugin [shade](https://maven.apache.org/plugins/maven-shade-plugin/)), générez une archive du projet contenant ses dépendances (uber-jar)
