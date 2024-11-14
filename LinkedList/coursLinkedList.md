# Cours : Concept d'une Liste Doublement Chaînée Circulaire
- **Doublement chaînée** : Chaque cellule a une référence vers la cellule précédente (**prev**) et la cellule suivante (**next**).
- **Circulaire** : La cellule de tête pointe vers la dernière cellule via **prev**, et la dernière cellule pointe vers la tête via **next**.
- **Pas de null** : Les attributs **prev** et **next** ne sont jamais `null`. Même pour une liste d'une seule cellule, **prev** et **next** pointent vers la cellule elle-même.

- Pour ouvrir la documentation, vous pouvez taper dans le terminal :
   - **Windows** : `start ./docs/allclasses-index.html`
   - **macOS/Linux** : `open ./docs/allclasses-index.html`
   - **Navigateur (Windows)** : `file:///C:/Users/Gamer/Desktop/devEfficace/LinkedList/docs/allclasses-index.html`


### Schéma :

```
+---------+    next    +---------+    next    +---------+
|  Cell 1 | ---------> |  Cell 2 | ---------> |  Cell 3 |
| (head)  | <--------- |         | <--------- |         |
+---------+    prev    +---------+    prev    +---------+
   ^                                                     |
   |                                                     |
   |                     prev                            |
   +-----------------------------------------------------+
                         next
```

#### Pour une seule cellule (initialisation) :
```
+---------+
|  Cell 1 |
| (head)  |
+---------+
| prev -->| (référence à elle-même)
| next -->| (référence à elle-même)
+---------+
```

#### Liste avec plusieurs cellules :
- Si on insère des cellules successivement, disons **Cell 1**, **Cell 2**, et **Cell 3** :
    - **Cell 1** :
        - `prev` et `next` pointent vers elle-même.
    - **Cell 2** ajoutée :
        - **Cell 1** : `next` pointe vers **Cell 2**, et `prev` pointe vers **Cell 2**.
        - **Cell 2** : `next` pointe vers **Cell 1**, et `prev` pointe vers **Cell 1**.
    - **Cell 3** ajoutée :
        - **Cell 1** : `prev` pointe vers **Cell 3** et `next` pointe vers **Cell 2**.
        - **Cell 2** : `prev` pointe vers **Cell 1** et `next` pointe vers **Cell 3**.
        - **Cell 3** : `prev` pointe vers **Cell 2** et `next` pointe vers **Cell 1**.

### Représentation pour trois cellules :
```
        +---------+    next    +---------+    next    +---------+
        |  Cell 1 | ---------> |  Cell 2 | ---------> |  Cell 3 |
   ^    | (head)  | <--------- |         | <--------- |         |
   |    +---------+    prev    +---------+    prev    +---------+
   |                          ^                       |
   |                          |                       |
   +--------------------------+-----------------------+
       prev (Cell 3)        next (head)
```

### Observations :
- Dans cette structure, parcourir la liste en suivant les **next** renvoie à la tête après avoir atteint la dernière cellule.
- Inversement, suivre les **prev** permet de parcourir la liste dans l'ordre inverse.
- Pour une cellule unique, `prev` et `next` référencent la cellule elle-même, maintenant ainsi la propriété circulaire.

Cela permet des opérations de parcours et d'insertion efficaces aux deux extrémités sans avoir à gérer de `null`, simplifiant l'implémentation de certaines opérations par rapport à une liste classique.