#include <stdio.h>
#include <stdlib.h>
#include "listDouble.h"

/**
 * @brief Crée une nouvelle liste doublement chaînée.
 *
 * @return Pointeur vers la nouvelle liste créée.
 */
List* listCreate() {
    List* l = (List*)malloc(sizeof(List));
    l->head = NULL;
    l->size = 0;
    return l;
}

/**
 * @brief Recherche une cellule par sa valeur dans la liste.
 *
 * @param l Pointeur vers la liste.
 * @param value Valeur à rechercher.
 * @return Pointeur vers la cellule trouvée, ou NULL si non trouvée.
 */
Cell* listFind(List* l, int value) {
    Cell* cell = l->head;
    while (cell != NULL) {
        if (cell->value == value) {
            return cell;
        }
        cell = cell->next;
    }
    return NULL;
}

/**
 * @brief Récupère une cellule par son index dans la liste.
 *
 * @param l Pointeur vers la liste.
 * @param index Index de la cellule à récupérer.
 * @return Pointeur vers la cellule, ou NULL si l'index est invalide.
 */
Cell* listGet(List* l, int index) {
    if (index < 0 || index >= l->size) return NULL;
    Cell* cell = l->head;
    for (int i = 0; i < index; i++) {
        cell = cell->next;
    }
    return cell;
}

/**
 * @brief Ajoute une nouvelle cellule en tête de liste.
 *
 * @param l Pointeur vers la liste.
 * @param value Valeur de la nouvelle cellule.
 * @return Pointeur vers la nouvelle cellule ajoutée.
 */
Cell* listPrepend(List* l, int value) {
    Cell* newCell = (Cell*)malloc(sizeof(Cell));
    newCell->value = value;
    newCell->prev = NULL;
    newCell->next = l->head;

    if (l->head != NULL) {
        l->head->prev = newCell;
    }

    l->head = newCell;
    l->size++;
    return newCell;
}

/**
 * @brief Ajoute une nouvelle cellule en fin de liste.
 *
 * @param l Pointeur vers la liste.
 * @param value Valeur de la nouvelle cellule.
 * @return Pointeur vers la nouvelle cellule ajoutée.
 */
Cell* listAppend(List* l, int value) {
    Cell* newCell = (Cell*)malloc(sizeof(Cell));
    newCell->value = value;
    newCell->next = NULL;

    if (l->head == NULL) {
        newCell->prev = NULL;
        l->head = newCell;
    } else {
        Cell* last = l->head;
        while (last->next != NULL) {
            last = last->next;
        }
        last->next = newCell;
        newCell->prev = last;
    }

    l->size++;
    return newCell;
}

/**
 * @brief Insère une nouvelle cellule à un index spécifique.
 *
 * @param l Pointeur vers la liste.
 * @param value Valeur de la nouvelle cellule.
 * @param index Index où insérer la nouvelle cellule.
 * @return Pointeur vers la nouvelle cellule ajoutée, ou NULL si l'index est invalide.
 */
Cell* listInsert(List* l, int value, int index) {
    if (index < 0 || index > l->size) return NULL;
    if (index == 0) return listPrepend(l, value);
    if (index == l->size) return listAppend(l, value);

    Cell* newCell = (Cell*)malloc(sizeof(Cell));
    newCell->value = value;
    Cell* current = listGet(l, index);
    Cell* previous = current->prev;

    previous->next = newCell;
    newCell->prev = previous;
    newCell->next = current;
    current->prev = newCell;

    l->size++;
    return newCell;
}

/**
 * @brief Remplace la valeur d'une cellule à un index donné.
 *
 * @param l Pointeur vers la liste.
 * @param value Nouvelle valeur de la cellule.
 * @param index Index de la cellule à remplacer.
 * @return Pointeur vers la cellule modifiée, ou NULL si l'index est invalide.
 */
Cell* listReplace(List* l, int value, int index) {
    Cell* cell = listGet(l, index);
    if (cell != NULL) {
        cell->value = value;
    }
    return cell;
}

/**
 * @brief Supprime une cellule à un index donné.
 *
 * @param l Pointeur vers la liste.
 * @param index Index de la cellule à supprimer.
 * @return NULL toujours (pour compatibilité).
 */
Cell* listRemoveAt(List* l, int index) {
    if (index < 0 || index >= l->size) return NULL;
    Cell* cell = listGet(l, index);

    if (cell->prev != NULL) cell->prev->next = cell->next;
    else l->head = cell->next;

    if (cell->next != NULL) cell->next->prev = cell->prev;

    l->size--;
    free(cell);
    return NULL;
}

/**
 * @brief Supprime une cellule par sa valeur.
 *
 * @param l Pointeur vers la liste.
 * @param value Valeur de la cellule à supprimer.
 * @return NULL toujours (pour compatibilité).
 */
Cell* listRemove(List* l, int value) {
    Cell* cell = listFind(l, value);
    if (cell != NULL) {
        if (cell->prev != NULL) cell->prev->next = cell->next;
        else l->head = cell->next;

        if (cell->next != NULL) cell->next->prev = cell->prev;

        l->size--;
        free(cell);
    }
    return NULL;
}

/**
 * @brief Affiche la liste dans le format "<- 3 <-> 15 <-> 5 ->".
 *
 * @param l Pointeur vers la liste.
 */
void listPrint(List* l) {
    if (l->head == NULL) {
        printf("La liste est vide\n");
        return;
    }
    printf("<- ");
    Cell* cell = l->head;
    while (cell != NULL) {
        printf("%d", cell->value);
        if (cell->next != NULL) printf(" <-> ");
        cell = cell->next;
    }
    printf(" ->\n");
}

/**
 * @brief Libère la mémoire de la liste.
 *
 * @param l Pointeur vers la liste.
 */
void listFree(List* l) {
    while (l->size > 0) {
        listRemoveAt(l, 0);
    }
    free(l);
}
