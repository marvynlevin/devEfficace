#include <stdio.h>
#include "listSimple.h"

/**
 * @brief Programme principal pour tester les fonctionnalités de la liste simplement chaînée.
 *
 * @param argc Nombre d'arguments passés au programme (non utilisé).
 * @param argv Tableau des arguments passés au programme (non utilisé).
 * @return int Code de retour (0 pour succès).
 */
int main(int argc, char** argv) {
    // Déclaration et initialisation de la liste
    List* l;
    l = listCreate();

    // Ajout d'éléments à la liste
    listAppend(l, 3);       // Ajoute 3 à la fin de la liste
    listAppend(l, 5);       // Ajoute 5 à la fin de la liste
    listAppend(l, 1);       // Ajoute 1 à la fin de la liste
    listInsert(l, 15, 1);   // Insère 15 à l'index 1
    listInsert(l, 5, 10);   // Insère 5 à l'index 10 (hors limites, ne devrait pas fonctionner)

    // Affiche la liste
    printf("Liste après insertion :\n");
    listPrint(l);           // Affiche : 3 -> 15 -> 5 -> 1 -> NULL

    // Suppression d'éléments
    listRemoveAt(l, 2);     // Supprime l'élément à l'index 2 (le 5)
    listRemove(l, 3);       // Supprime l'élément avec la valeur 3 (tête)
    listRemove(l, 5);       // Supprime l'élément avec la valeur 5 (fin)
    listRemove(l, 33);      // Essaye de supprimer une valeur non existante (33)

    // Affiche la liste après suppression
    printf("Liste après suppression :\n");
    listPrint(l);           // Affiche : 15 -> 1 -> NULL

    // Libération de la mémoire
//    listFree(l);
    return 0;
}

// EXECUTION

// marvyn@Marvyn:~/but/but2/s3/devEfficaceC$ gcc listSimple.c testList.c -o testlist
// marvyn@Marvyn:~/but/but2/s3/devEfficaceC$ echo $?
// 0

// marvyn@Marvyn:~/but/but2/s3/devEfficaceC$ ./testlist
// Liste après insertion :
// 3 -> 15 -> 5 -> 1 -> 5 -> NULL
// Liste après suppression :
// 15 -> 1 -> NULL


