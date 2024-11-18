#include <stdio.h>
#include "listDouble.h"

/**
 * @brief Fonction principale pour tester les fonctionnalités de la liste doublement chaînée.
 *
 * @param argc Nombre d'arguments passés en ligne de commande.
 * @param argv Tableau des arguments passés en ligne de commande.
 * @return int Code de retour du programme (0 si tout est OK).
 */
int main(int argc, char** argv) {

    // Déclaration de la liste
    List* l;

    // Création de la liste
    l = listCreate();

    // Ajout de valeurs à la fin de la liste
    listAppend(l, 3);   /**< Ajoute la valeur 3 à la fin. */
    listAppend(l, 5);   /**< Ajoute la valeur 5 à la fin. */
    listAppend(l, 1);   /**< Ajoute la valeur 1 à la fin. */

    // Insertion de valeurs à des index spécifiques
    listInsert(l, 15, 1);   /**< Insère la valeur 15 à l'index 1. */
    listInsert(l, 5, 10);   /**< Tentative d'insertion à un index supérieur à la taille de la liste (opération ignorée). */

    // Affichage de la liste actuelle
    printf("Liste après insertions :\n");
    listPrint(l);   /**< Affiche la liste : "<- 3 <-> 15 <-> 5 <-> 1 ->" */

    // Suppression d'éléments
    listRemoveAt(l, 2); /**< Supprime l'élément à l'index 2 (valeur 5). */
    listRemove(l, 3);   /**< Supprime l'élément ayant la valeur 3 (tête de liste). */
    listRemove(l, 5);   /**< Supprime l'élément ayant la valeur 5 (fin de liste). */
    listRemove(l, 33);  /**< Tentative de suppression d'un élément non existant (valeur 33). */

    // Affichage de la liste après les suppressions
    printf("Liste après suppressions :\n");
    listPrint(l);   /**< Affiche la liste après les suppressions. */

    // Libération de la mémoire
    listFree(l);
    return 0;
}

// EXECUTION

// marvyn@Marvyn:~/but/but2/s3/devEfficaceC$ gcc listDouble.c testListDouble.c -o testdouble
// marvyn@Marvyn:~/but/but2/s3/devEfficaceC$ echo $?
// 0

// marvyn@Marvyn:~/but/but2/s3/devEfficaceC$ ./testdouble
// <- 3 <-> 15 <-> 5 <-> 1 ->
// <- 15 <-> 1 ->

