# APIGestionArticle 📦

Une API REST construite avec **Spring Boot** pour gérer un inventaire d'articles. Ce projet permet d'effectuer des opérations CRUD (Création, Lecture, Mise à jour, Suppression) sur des articles via une base de données MySQL.

## 🚀 Fonctionnalités

* **Lister les articles** : Récupérer tous les articles enregistrés.
* **Détails d'un article** : Consulter un article spécifique par son ID.
* **Gestion de l'inventaire** : Ajouter de nouveaux articles ou modifier ceux existants.
* **Suppression** : Retirer des articles de la base de données.
* **Format de réponse standardisé** : Toutes les réponses sont encapsulées dans un objet `ResponseCode` pour une meilleure gestion des erreurs et des messages côté client.

## 🛠️ Technologies utilisées

* **Java 17** 
* **Spring Boot 3**
* **Spring Data JPA** / Hibernate
* **MySQL**
* **Maven**

---

## ⚙️ Configuration du projet

Pour faire fonctionner ce projet localement, vous devez configurer vos accès à la base de données. Par mesure de sécurité, le fichier de configuration n'est pas inclus dans le dépôt.

### 1. Création du dossier Resources

Si le dossier n'existe pas, créez la structure suivante dans votre projet :
`src/main/resources/`

### 2. Configuration de `application.properties`

Créez un fichier nommé `application.properties` dans le dossier `src/main/resources/` et collez-y la configuration suivante en remplaçant les valeurs par vos identifiants locaux :

```properties
spring.application.name=APIGestionArticle

# Paramètres de la base de données
# Remplacez 'url_bdd_mysql' par l'url de votre base (ex: jdbc:mysql://localhost:3306/votre_db)
spring.datasource.url=url_bdd_mysql
spring.datasource.username=Nom_User_BDD
spring.datasource.password=MDP_BDD

# Stratégie de génération des tables
# Décommentez la ligne ci-dessous lors du premier lancement pour créer les tables automatiquement
# spring.jpa.hibernate.ddl-auto=update

# Logs SQL (utile pour le développement)
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

```

---

## 🚦 Utilisation (Endpoints)

| Méthode | Endpoint       | Description                                                                              |
| --- |----------------|------------------------------------------------------------------------------------------|
| **GET** | `/getAll`      | Récupère la liste de tous les articles.                                                  |
| **GET** | `/getId/{id}`  | Récupère un article par son ID.                                                          |
| **POST** | `/save`        | Crée un nouvel article. Ou le modifier si son ID est inclus dans le corps de la requête. |
| **DELETE** | `/delete/{id}` | Supprime un article par son ID.                                                          |

### Exemple de réponse JSON :

```json
{
  "code": "202",
  "message": "getAll request successfully achieved",
  "data": [
    {
      "id": 1,
      "nom": "Ordinateur Portable"
    }
  ]
}

```

---

## 📦 Installation et Lancement

1. **Cloner le projet** :
```bash
git clone https://github.com/TheotimALBERTEAU/APIGestionArticle.git

```


2. **Configurer la BDD** : Suivre l'étape "Configuration du projet" ci-dessus.
3. **Compiler et lancer** :
```bash
mvn spring-boot:run

```



---

## 👤 Auteur

**Théotim ALBERTEAU** - [GitHub](https://www.google.com/search?q=https://github.com/TheotimALBERTEAU)