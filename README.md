# 📝 Application de Gestion de Tâches (To-Do List) 📅

Bienvenue dans mon projet Android de gestion de tâches (To-Do List), développé dans le cadre de mon projet scolaire. Cette application permet de créer, afficher, marquer comme complétées, et supprimer des tâches, tout en assurant la persistance des données à l'aide de SQLite.

## 📂 Structure du Projet
- **MainActivity** : Activité principale affichant la liste des tâches.
- **AddTaskActivity** : Activité dédiée à l'ajout de nouvelles tâches.
- **Task** : Classe modèle représentant une tâche avec ses attributs (`id`, `description`, et `completed`).
- **TaskAdapter** : Adaptateur pour afficher les tâches dans le `RecyclerView`.
- **TaskDatabaseHelper** : Classe gérant la base de données SQLite (`tasks.db`).

## 📋 Fonctionnalités
1. **Ajouter des tâches** : Ajoutez une tâche avec une description.
2. **Afficher la liste des tâches** : Affiche toutes les tâches dans un `RecyclerView`.
3. **Marquer une tâche comme accomplie** : Utilisez la case à cocher pour indiquer qu'une tâche est complétée.
4. **Supprimer une tâche** : Supprimez une tâche de la liste et de la base de données.
5. **Persistance des données** : Les tâches sont sauvegardées localement à l'aide de SQLite.

## 🛠️ Technologies Utilisées
- **Java** : Langage de programmation principal.
- **Android Studio** : Environnement de développement.
- **SQLite** : Base de données locale pour la persistance des tâches.
- **XML** : Pour la conception des interfaces utilisateur.

## 🎨 Interface Utilisateur
- **activity_main.xml** : Layout pour la liste principale des tâches.
- **activity_add_task.xml** : Layout pour l'ajout d'une nouvelle tâche.
- **task_item.xml** : Layout pour chaque élément de la liste (`RecyclerView`).

## 🚀 Démarrage Rapide
### Prérequis
- Android Studio 4.0 ou supérieur
- SDK Android API 30 ou supérieur

### Étapes pour Exécuter le Projet
1. Clonez le dépôt : `git clone https://github.com/votre-utilisateur/todolist.git`.
2. Ouvrez le projet dans Android Studio.
3. Synchronisez Gradle.
4. Lancez l'émulateur Android ou connectez un appareil physique.
5. Compilez et exécutez l'application !

## 📜 Cahier des Charges
L'application a été conçue en respectant les critères suivants :

- **Ajouter des tâches** avec une description.
- **Afficher la liste** des tâches à l'aide d'un `RecyclerView`.
- **Marquer les tâches comme complétées** ou **supprimer** celles-ci.
- **Sauvegarder les données localement** avec une base de données SQLite.
- Utilisation de **modèles de données** pour structurer les informations.
- Utilisation de **DAO** (Data Access Object) pour les opérations CRUD.
- Respect des **Intent** pour la navigation entre les activités.

## 📈 Améliorations Possibles
- Ajouter une gestion des catégories de tâches.
- Implémenter des notifications pour rappeler les tâches importantes.
- Ajouter un tri par priorité.
- Synchroniser avec une base de données distante (Firebase, etc.).

## 👨‍💻 Auteur
- **Nom** : Delahaye
- **Contact** : Thierry
- **GitHub** :  https://github.com/titidlh/

## 📝 License
Ce projet est sous licence MIT. Consultez le fichier LICENSE pour plus de détails.
