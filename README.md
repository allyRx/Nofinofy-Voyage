
# 🌍 NofiNofyVoyage(Projet en cours)

Une API RESTful développée avec Spring Boot permettant aux utilisateurs de gérer une liste personnalisée de lieux à visiter, de les marquer comme visités, d'ajouter des notes, et de suivre leurs objectifs de voyage.

---

## ✨ Fonctionnalités

- 🔐 Authentification avec JWT
- 👥 Gestion des utilisateurs avec rôles (USER / ADMIN)
- 📝 CRUD complet sur les lieux à visiter
- ⭐ Marquer les lieux comme visités avec notes et évaluations
- 📊 Statistiques de profil utilisateur
- 🧾 Documentation interactive avec Swagger
- 🛡️ Gestion des erreurs structurée

---

## 🧰 Technologies utilisées

- Java 17
- Spring Boot
- Spring Web
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger (Springdoc)
- Maven

---

## 🧱 Schéma de la base de données

### Table `users`

| Champ       | Type         | Contraintes                           |
|-------------|--------------|---------------------------------------|
| id          | SERIAL       | Clé primaire                          |
| username    | VARCHAR(50)  | Unique, non null                      |
| email       | VARCHAR(100) | Unique, non null                      |
| password    | VARCHAR(255) | Non null                              |
| role        | VARCHAR(20)  | Par défaut : "USER"                   |
| created_at  | TIMESTAMP    | Valeur par défaut : CURRENT_TIMESTAMP |

### Table `places`

| Champ      | Type         | Contraintes                                     |
|------------|--------------|-------------------------------------------------|
| id         | SERIAL       | Clé primaire                                    |
| name       | VARCHAR(100) | Non null                                        |
| country    | VARCHAR(100) | Non null                                        |
| city       | VARCHAR(100) | Optionnel                                       |
| note       | TEXT         | Optionnel                                       |
| visited    | BOOLEAN      | Par défaut : false                              |
| rating     | INTEGER      | Entre 0 et 5 (optionnel)                        |
| user_id    | INTEGER      | Clé étrangère vers `users(id)`                 |
| created_at | TIMESTAMP    | Par défaut : CURRENT_TIMESTAMP                  |

---

## ⚙️ Configuration

### 1. Cloner le projet

```bash
git clone https://github.com/ton-utilisateur/travel-bucket-api.git
cd travel-bucket-api
```

### 2. Créer la base PostgreSQL

```sql
CREATE DATABASE travel_db;
```

### 3. Configurer `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/travel_db
spring.datasource.username=postgres
spring.datasource.password=ton_mot_de_passe
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🚀 Lancer le projet

```bash
./mvnw spring-boot:run
```

API disponible sur :  
`http://localhost:8080/api`

---

## 🔐 Authentification

### 🔸 Inscription

`POST /api/auth/register`  
Body :
```json
{
  "username": "john",
  "email": "john@example.com",
  "password": "secret"
}
```

### 🔸 Connexion

`POST /api/auth/login`  
Body :
```json
{
  "email": "john@example.com",
  "password": "secret"
}
```

🔑 Tu recevras un token JWT à inclure dans l'en-tête :

```
Authorization: Bearer your.jwt.token
```

---

## 📚 Documentation Swagger

Disponible à :  
`http://localhost:8080/swagger-ui.html`

---

## 🛠️ Idées d'amélioration

- Intégration d'une carte (OpenStreetMap, Google Maps)
- Ajout de photos par lieu
- Partage public de profils d'utilisateurs
- Confirmation de compte par email

---

## 👨‍💻 Auteur

Projet réalisé par **[Albert]**  
📧 Contact : **[herindrainyall2003@gmail.com]**

---

## 📄 Licence

Ce projet est sous licence **MIT**.
