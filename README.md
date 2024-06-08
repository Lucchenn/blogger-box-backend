Ce projet constitue le backend de l'application Blogger Box. Il est responsable de la gestion des données, de la sécurité et des API nécessaires pour interagir avec le frontend.

Fonctionnalités :
   Gestion des articles de blog:
    - Création, lecture, mise à jour et suppression d'articles
    - Filtrage des articles par catégories et tags
  Gestion des catégories:
    - Création, lecture, mise à jour et suppression de catégories
  API RESTful pour l'interaction avec le frontend

Technologies Utilisées
    Langage: Java
    Framework: Spring Boot
    Base de données: PostgreSQL

Endpoints API :
    GET /v1/posts : Récupération de tous les articles
    GET /v1/posts/{id} : Récupération d'un article par ID
    POST /v1/posts : Création d'un nouvel article
    PUT /v1/posts/{id} : Mise à jour d'un article
    DELETE /v1/posts/{id} : Suppression d'un article
    GET /v1/categories : Récupération de toutes les catégories
    GET /v1/categories/{id} : Récupération d'une catégorie par ID
    POST /v1/categories : Création d'une nouvelle catégorie
    PUT /v1/categories/{id} : Mise à jour d'une catégorie
    DELETE /v1/categories/{id} : Suppression d'une catégorie
