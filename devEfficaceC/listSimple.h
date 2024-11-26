#ifndef LISTSIMPLE_H
#define LISTSIMPLE_H

/**
 * @brief Représente un nœud (cellule) de la liste simplement chaînée.
 */
typedef struct cell {
    int value;              /**< Valeur de la cellule */
    struct cell* next;      /**< Pointeur vers la cellule suivante */
} Cell;

/**
 * @brief Représente une liste simplement chaînée.
 */
typedef struct list {
    Cell* head;             /**< Pointeur vers la tête de la liste */
    int size;               /**< Taille de la liste (nombre de cellules) */
} List;

/**
 * @brief Crée une nouvelle liste vide.
 * 
 * @return Pointeur vers la nouvelle liste créée.
 */
List* listCreate();

/**
 * @brief Trouve un élément par sa valeur.
 * 
 * @param l Pointeur vers la liste.
 * @param value Valeur de l'élément à trouver.
 * @return Pointeur vers la cellule trouvée, ou NULL si elle n'existe pas.
 */
Cell* listFind(List* l, int value);

/**
 * @brief Trouve l'indice d'un élément par sa valeur.
 * 
 * @param l Pointeur vers la liste.
 * @param value Valeur de l'élément à trouver.
 * @return Indice de la cellule si elle est trouvée, -1 sinon.
 */
int listFindId(List* l, int value);

/**
 * @brief Obtenir une cellule par son index.
 * 
 * @param l Pointeur vers la liste.
 * @param index Index de l'élément à obtenir.
 * @return Pointeur vers la cellule, ou NULL si l'index est invalide.
 */
Cell* listGet(List* l, int index);

/**
 * @brief Ajoute un élément à la fin de la liste.
 * 
 * @param l Pointeur vers la liste.
 * @param value Valeur de l'élément à ajouter.
 * @return Pointeur vers la cellule ajoutée.
 */
Cell* listAppend(List* l, int value);

/**
 * @brief Insère un élément à un index spécifique.
 * 
 * @param l Pointeur vers la liste.
 * @param value Valeur de l'élément à insérer.
 * @param index Index où insérer l'élément.
 * @return Pointeur vers la cellule insérée, ou NULL si l'insertion a échoué.
 */
Cell* listInsert(List* l, int value, int index);

/**
 * @brief Remplace la valeur d'une cellule par un index donné.
 * 
 * @param l Pointeur vers la liste.
 * @param value Nouvelle valeur de l'élément.
 * @param index Index de l'élément à remplacer.
 * @return Pointeur vers la cellule remplacée, ou NULL si l'index est invalide.
 */
Cell* listReplace(List* l, int value, int index);

/**
 * @brief Supprime un élément par son index.
 * 
 * @param l Pointeur vers la liste.
 * @param index Index de l'élément à supprimer.
 * @return Pointeur vers la cellule supprimée, ou NULL si l'index est invalide.
 */
Cell* listRemoveAt(List* l, int index);

/**
 * @brief Supprime la première occurrence d'un élément par sa valeur.
 * 
 * @param l Pointeur vers la liste.
 * @param value Valeur de l'élément à supprimer.
 * @return Pointeur vers la cellule supprimée, ou NULL si elle n'est pas trouvée.
 */
Cell* listRemove(List* l, int value);

/**
 * @brief Affiche tous les éléments de la liste.
 * 
 * @param l Pointeur vers la liste.
 */
void listPrint(List* l);

#endif
