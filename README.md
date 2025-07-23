# rentals-api

**rentals-api** est une application backend développée avec Spring Boot. Elle fournit une API REST permettant de gérer un système de location de maisons. Cette API peut être utilisée comme socle pour une application web ou mobile dédiée à la réservation et la gestion de logements.

---

## Technologies utilisées

- Java
- Spring Boot
- Maven
- MySQL

---

## Installation

Assurez-vous d’avoir les outils suivants installés sur votre machine :

- Java 17 (ou version compatible)
- Maven
- MySQL

### Étapes d’installation

1. Clonez ce dépôt :
   ```bash
   git clone git@github.com:ton-utilisateur/rentals-api.git
   cd rentals-api

2. Péparez la base de donnée
Dans MySQL, créez une nouvelle base de donnée et éxecutez le sprict "SQLscript.sql" se trouvant à la racine du projet.
Une fois le script éxécuté, dans le fichier application.properties, renseignez l'url, l'username et le password de votre BDD


## URL de swagger 

   http://localhost:3001/api/swagger-ui/index.html
