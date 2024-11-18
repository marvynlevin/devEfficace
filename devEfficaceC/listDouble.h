#ifndef LISTDOUBLE_H
#define LISTDOUBLE_H

/**
 * @file listDouble.h
 * @brief Déclaration des structures et des fonctions pour une liste doublement chaînée.
 */

/**
 * @struct cell
 * @brief Représente une cellule de la liste doublement chaînée.
 *
 * @var cell::value
 * Valeur entière stockée dans la cellule.
 * @var cell::next
 * Pointeur vers la cellule suivante dans la liste.
 * @var cell::prev
 * Pointeur vers la cellule précédente dans la liste.
 */
typedef struct cell {
    int value;           /**< Valeur de la cellule */
    struct cell* next;   /**< Pointeur vers la cellule suivante */
    struct cell* prev;   /**< Pointeur vers la cellule précédente */
} Cell;

/**
 * @struct list
 * @brief Représente une liste doublement chaînée.
 *
 * @var list::head
 * Pointeur vers la première cellule de la liste.
 * @var list::size
 * Taille de la liste (nombre d'éléments).
 */
typedef struct list {
    Cell* head;   /**< Pointeur vers la tête de la liste */
    int size;     /**< Taille de la liste */
} List;

/**
 * @brief Crée une nouvelle liste doublement chaînée.
 *
 * @return Pointeur vers la nouvelle liste.
 */
List* listCreate();

/**
 * @brief Recherche une cellule contenant une valeur donnée.
 *
 * @param l Pointeur vers la liste.
 * @param value Valeur à rechercher.
 * @return Pointeur vers la cellule trouvée ou NULL si non trouvée.
 */
Cell* listFind(List* l, int value);

/**
 * @brief Obtient une cellule par son index.
 *
 * @param l Pointeur vers la liste.
 * @param index Index de la cellule à obtenir.
 * @return Pointeur vers la cellule ou NULL si l'index est invalide.
 */
Cell* listGet(List* l, int index);

/**
 * @brief Ajoute une valeur en tête de la liste.
 *
 * @param l Pointeur vers la liste.
 * @param value Valeur à ajouter.
 * @return Pointeur vers la nouvelle cellule.
 */
Cell* listPrepend(List* l, int value);

/**
 * @brief Ajoute une valeur en fin de la liste.
 *
 * @param l Pointeur vers la liste.
 * @param value Valeur à ajouter.
 * @return Pointeur vers la nouvelle cellule.
 */
Cell* listAppend(List* l, int value);

/**
 * @brief Insère une valeur à un index donné.
 *
 * @param l Pointeur vers la liste.
 * @param value Valeur à insérer.
 * @param index Index où insérer la valeur.
 * @return Pointeur vers la nouvelle cellule ou NULL si l'index est invalide.
 */
Cell* listInsert(List* l, int value, int index);

/**
 * @brief Remplace la valeur d'une cellule à un index donné.
 *
 * @param l Pointeur vers la liste.
 * @param value Nouvelle valeur à définir.
 * @param index Index de la cellule à remplacer.
 * @return Pointeur vers la cellule modifiée ou NULL si l'index est invalide.
 */
Cell* listReplace(List* l, int value, int index);

/**
 * @brief Supprime une cellule par son index.
 *
 * @param l Pointeur vers la liste.
 * @param index Index de la cellule à supprimer.
 * @return Pointeur vers la cellule suivante ou NULL si l'index est invalide.
 */
Cell* listRemoveAt(List* l, int index);

/**
 * @brief Supprime la première cellule contenant une valeur donnée.
 *
 * @param l Pointeur vers la liste.
 * @param value Valeur à supprimer.
 * @return Pointeur vers la cellule suivante ou NULL si la valeur n'est pas trouvée.
 */
Cell* listRemove(List* l, int value);

/**
 * @brief Affiche la liste dans le format "<- valeur1 <-> valeur2 ->".
 *
 * @param l Pointeur vers la liste.
 */
void listPrint(List* l);

/**
 * @brief Libère la mémoire de la liste et de toutes ses cellules.
 *
 * @param l Pointeur vers la liste.
 */
void listFree(List* l);

#endif
