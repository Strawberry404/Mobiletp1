# Documentation du Projet Android : MathQuiz 📱
## made with love By fatimaezzahrae
## Résumé du Projet
L'objectif était de créer une application Android éducative simple permettant à l'utilisateur de s'entraîner au calcul mental. L'application génère deux nombres aléatoires et demande à l'utilisateur de calculer le résultat selon l'opérateur choisi (+, -, x), ou de générer de nouveaux nombres.

---

## 1. L'Interface Utilisateur (XML)
**Fichier :** `res/layout/activity_main.xml`

Nous avons construit l'interface graphique en utilisant le **ConstraintLayout** pour positionner les éléments de manière flexible.

### Composants Clés :
* **TextViews (`nombre1`, `nombre2`) :** Pour afficher les deux opérandes aléatoires.
* **Boutons d'Opération (`btn_plus`, `btn_minus`, `btn_multiply`) :** Pour déclencher le calcul immédiat.
* **Bouton d'Action (`btn_generer`) :** Pour réinitialiser le jeu avec de nouveaux nombres.
* **TextView de Résultat (`resultat`) :** Pour afficher la réponse calculée.

### Bonnes Pratiques Appliquées :
* Utilisation des **Ressources String** (`@string/btn_plus`) au lieu de texte en dur, pour faciliter la traduction future.
* Utilisation des **Constraints** (ancres) pour éviter que les éléments ne s'empilent dans le coin supérieur gauche (0,0).

---

## 2. La Logique Applicative (Java)
**Fichier :** `MainActivity.java`

C'est ici que réside le "cerveau" de l'application. Nous avons connecté le code Java aux éléments XML via la méthode `findViewById`.

### Concepts Clés Manipulés :

#### A. Variables de Classe vs Variables Locales
Nous avons déplacé les variables `num1` et `num2` **en dehors** de la méthode `onCreate` (au niveau de la classe).
* **Pourquoi ?** Si elles étaient restées dans `onCreate`, elles auraient été "locales" et temporaires. Le bouton "Générer" n'aurait pas pu mettre à jour les valeurs utilisées par les boutons d'addition ou de soustraction (problème de portée/scope).

#### B. Gestion des Événements (`Listeners`)
Nous avons utilisé `setOnClickListener` avec des **Lambdas** (`v -> ...`) pour définir les actions :
1.  **Boutons Opérations :** Calculent le résultat immédiatement en utilisant les valeurs actuelles de `num1` et `num2`.
2.  **Bouton Générer :** Utilise la classe `Random` pour assigner de nouvelles valeurs à `num1` et `num2` et met à jour l'affichage.

#### C. Conversion de Types (Le piège du `setText`)
Nous avons appris une leçon cruciale sur l'affichage des nombres :
* **L'erreur :** `setText(10)` fait planter l'application car Android pense que `10` est un identifiant de ressource (R.id...).
* **La solution :** Toujours convertir les nombres en texte avant l'affichage :
    ```java
    // Correct
    result.setText(String.valueOf(num1 + num2));
    ```

---
