/**
 * @file listSimple.c
 * @brief Implémentation des fonctions de manipulation d'une liste chaînée simple.
 */

#include <stdio.h>
#include <stdlib.h>
#include "listSimple.h"

/**
 * @brief Crée une nouvelle liste.
 * @return Un pointeur vers une nouvelle liste initialisée.
 */
List* listCreate() {
    List* l = (List*)malloc(sizeof(List));
    if (l != NULL) {
        l->head = NULL;
        l->size = 0;
    }
    return l;
}

/**
 * @brief Recherche une cellule contenant une valeur spécifique.
 * @param l La liste à parcourir.
 * @param value La valeur à rechercher.
 * @return Un pointeur vers la cellule contenant la valeur, ou NULL si non trouvée.
 */
Cell* listFind(List* l, int value) {
    Cell* cell = l->head;
    while ((cell != NULL) && (cell->value != value)) {
        cell = cell->next;
    }
    return cell;
}

/**
 * @brief Trouve l'index de la première occurrence d'une valeur donnée dans la liste.
 * @param l La liste à parcourir.
 * @param value La valeur à rechercher.
 * @return L'index de la valeur si trouvée, sinon -1.
 */
int listFindId(List* l, int value) {
    Cell* cell = l->head;
    int id = 0;
    while ((cell != NULL) && (cell->value != value)) {
        cell = cell->next;
        id++;
    }
    return (cell == NULL) ? -1 : id;
}

/**
 * @brief Récupère une cellule à un index donné dans la liste.
 * @param l La liste à parcourir.
 * @param index L'index de la cellule à récupérer.
 * @return Un pointeur vers la cellule correspondante ou NULL si l'index est invalide.
 */
Cell* listGet(List* l, int index) {
    if (index < 0 || index >= l->size) { return NULL; }
    Cell* cell = l->head;
    int i = 0;
    while ((cell != NULL) && (i < index)) {
        cell = cell->next;
        i += 1;
    }
    return cell;
}

/**
 * @brief Ajoute une valeur à la fin de la liste.
 * @param l La liste où ajouter la valeur.
 * @param value La valeur à ajouter.
 * @return Un pointeur vers la nouvelle cellule ajoutée.
 */
Cell* listAppend(List* l, int value) {
    Cell* new = (Cell*)malloc(sizeof(Cell));
    new->next = NULL;
    new->value = value;
    if (l->size == 0) {
        l->head = new;
    } else {
        Cell* cell = listGet(l, l->size - 1);
        cell->next = new;
    }
    l->size += 1;
    return new;
}

/**
 * @brief Insère une valeur à un index donné dans la liste.
 * @param l La liste où insérer la valeur.
 * @param value La valeur à insérer.
 * @param index L'index où insérer la valeur.
 * @return Un pointeur vers la nouvelle cellule insérée.
 */
Cell* listInsert(List* l, int value, int index) {
    Cell* new = (Cell*)malloc(sizeof(Cell));
    new->value = value;

    if (index <= 0) {
        new->next = l->head;
        l->head = new;
    } else if (index >= l->size) {
        return listAppend(l, value);
    } else {
        Cell* cell = listGet(l, index - 1);
        new->next = cell->next;
        cell->next = new;
    }
    l->size += 1;
    return new;
}

/**
 * @brief Remplace la valeur d'une cellule à un index donné.
 * @param l La liste à modifier.
 * @param value La nouvelle valeur.
 * @param index L'index de la cellule à modifier.
 * @return Un pointeur vers la cellule modifiée, ou NULL si l'index est invalide.
 */
Cell* listReplace(List* l, int value, int index) {
    if ((index < 0) || (index >= l->size)) { return NULL; }
    Cell* cell = listGet(l, index);
    cell->value = value;
    return cell;
}

/**
 * @brief Supprime une cellule à un index donné dans la liste.
 * @param l La liste à modifier.
 * @param index L'index de la cellule à supprimer.
 * @return Un pointeur vers la cellule supprimée.
 */
Cell* listRemoveAt(List* l, int index) {
    Cell* tmp = NULL;
    if ((index < 0) || (index >= l->size)) { return NULL; }

    if (index == 0) {
        tmp = l->head;
        l->head = l->head->next;
    } else {
        Cell* cell = listGet(l, index - 1);
        tmp = cell->next;
        cell->next = tmp->next;
    }
    l->size -= 1;
    return tmp;
}

/**
 * @brief Supprime une cellule contenant une valeur spécifique dans la liste.
 * @param l La liste à modifier.
 * @param value La valeur de la cellule à supprimer.
 * @return Un pointeur vers la cellule supprimée ou NULL si la valeur n'est pas trouvée.
 *
 * Cette méthode est deprecated car elle parcours 2 fois la liste.
 */
Cell* listRemoveDeprecated(List* l, int value) {
    int index = listFindId(l, value);
    return (index == -1) ? NULL : listRemoveAt(l, index);
}

/**
 * @brief Supprime une cellule contenant une valeur spécifique dans la liste.
 * @param l La liste à modifier.
 * @param value La valeur de la cellule à supprimer.
 * @return Un pointeur vers la cellule supprimée ou NULL si la valeur n'est pas trouvée.
 */
Cell* listRemove(List* l, int value) {
    if (l->head == NULL) {
      	return NULL;
    } else {
        Cell* current = l->head;
        Cell* previous = NULL;

        while ((current != NULL) && (current->value != value)) {
          	previous = current;
          	current = current->next;
        }
        if (current == NULL) {
        	return NULL;
    	}
        if (previous != NULL) {
        	if (current == l->head) {
                l->head = current->next;
            } else {
                previous->next = current->next;
            }
        l->size--;
        return current;
        }
    }
}

/**
 * @brief Affiche toutes les valeurs de la liste.
 * @param l La liste à afficher.
 */
void listPrint(List* l) {
    Cell* cell = l->head;
    while (cell != NULL) {
        printf("%d -> ", cell->value);
        cell = cell->next;
    }
    printf("NULL\n");
}
