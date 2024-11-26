/**
 * @file testperf.c
 * @brief Ce programme effectue des tests de performance pour l'insertion d'éléments
 * dans des listes doublement chaînées circulaires. Il mesure le temps d'exécution de
 * trois types d'insertion : début, milieu, et fin dans une liste doublement chaînée.
 * Il utilise la fonction `gettimeofday` pour mesurer le temps écoulé pendant chaque opération.
 * Ce programme est conçu pour tester les performances sur différentes tailles de liste.
 *
 * @author Marvyn
 * @date Novembre 2024
 * @version 1.0
 *
 * @return 0 Si l'exécution se termine correctement.
 * @param argc Le nombre d'arguments passés en ligne de commande.
 * @param argv Les arguments de la ligne de commande.
 */

#include <stdio.h>
#include <stdlib.h>
#include "listDouble.h"  /**< Inclusion du fichier d'entête pour les listes doublement chaînées */
#include <sys/time.h>    /**< Inclusion pour utiliser la fonction gettimeofday() */
#include <time.h>
#include <math.h>
#include <string.h>

/**
 * @define CLOCK_S
 * @brief Définit l'option pour mesurer le temps en secondes.
 */
#define CLOCK_S 0

/**
 * @define CLOCK_MS
 * @brief Définit l'option pour mesurer le temps en millisecondes.
 */
#define CLOCK_MS 1

/**
 * @define CLOCK_US
 * @brief Définit l'option pour mesurer le temps en microsecondes.
 */
#define CLOCK_US 2

/**
 * @brief Fonction qui mesure le temps écoulé en fonction du mode (secondes, millisecondes, microsecondes).
 *
 * Cette fonction utilise `gettimeofday` pour obtenir l'heure actuelle du système
 * et calcule le temps écoulé depuis l'origine en fonction du mode de mesure choisi.
 *
 * @param mode Le mode de mesure du temps :
 *             - CLOCK_S pour secondes
 *             - CLOCK_MS pour millisecondes
 *             - CLOCK_US pour microsecondes
 *
 * @return Le temps écoulé, exprimé en fonction du mode sélectionné (en secondes, millisecondes ou microsecondes).
 */
double dclock(int mode) {
    double time;
    struct timeval t;

    gettimeofday(&t,NULL);  /**< Récupère l'heure actuelle du système */

    if (mode == CLOCK_US) {
        time = 1.0e6 * (double)t.tv_sec + (double)t.tv_usec;
    }
    else if (mode == CLOCK_MS) {
        time = 1.0e3 * (double)t.tv_sec + 1.0e-3 * (double)t.tv_usec;
    }
    else if (mode == CLOCK_S) {
        time = (double)t.tv_sec + 1.0e-6 * (double)t.tv_usec;
    }

    return(time); /**< Retourne le temps mesuré */
}

/**
 * @brief Fonction principale du programme qui exécute les tests de performance.
 *
 * Cette fonction mesure le temps nécessaire pour insérer des éléments dans des listes
 * doublement chaînées circulaires en utilisant trois types d'insertion :
 * - Insertion au début
 * - Insertion au milieu
 * - Insertion à la fin
 *
 * Le programme prend un argument en ligne de commande qui définit le nombre d'éléments
 * à insérer dans chaque liste.
 *
 * @param argc Le nombre d'arguments passés à la ligne de commande.
 * @param argv Les arguments de la ligne de commande. Le premier argument doit être un entier
 *             représentant le nombre de cellules à insérer dans les listes.
 *
 * @return 0 Si l'exécution se termine sans erreur.
 */
int main(int argc, char** argv) {

    // Vérification du nombre d'arguments
    if( argc != 2) {
        fprintf(stderr,"usage : testperf nb_cell\n");
        exit(1);  /**< Si le nombre d'arguments est incorrect, afficher un message d'erreur et quitter. */
    }

    int nbCell = atoi(argv[1]);  /**< Conversion de l'argument en un entier pour le nombre de cellules */

    List* l1;  /**< Liste doublement chaînée circulaire pour le test d'insertion au début */
    List* l2;  /**< Liste doublement chaînée circulaire pour le test d'insertion au milieu */
    List* l3;  /**< Liste doublement chaînée circulaire pour le test d'insertion à la fin */
    int i;
    l1 = listCreate();  /**< Création d'une nouvelle liste vide */
    l2 = listCreate();  /**< Création d'une nouvelle liste vide */
    l3 = listCreate();  /**< Création d'une nouvelle liste vide */

    // Test pour l'insertion au début dans une liste doublement chaînée
    printf("Liste doublement chaînée circulaire, insertion début ...");
    double t = dclock(CLOCK_S);  /**< Démarre le chronomètre */
    for(i=0; i<nbCell; i++) {
        listPrepend(l1, i+1);  /**< Insère un élément au début de la liste */
    }
    t = dclock(CLOCK_S) - t;  /**< Mesure le temps écoulé */
    printf("%fs\n", t);  /**< Affiche le temps d'exécution */

    // Test pour l'insertion au milieu dans une liste doublement chaînée
    printf("Liste doublement chaînée circulaire, insertion milieu ...");
    t = dclock(CLOCK_S);
    for(i=0; i<nbCell; i++) {
        listInsert(l2, i+1, i/2);  /**< Insère un élément dans le milieu de la liste */
    }
    t = dclock(CLOCK_S) - t;
    printf("%fs\n", t);

    // Test pour l'insertion à la fin dans une liste doublement chaînée
    printf("Liste doublement chaînée circulaire, insertion fin ...");
    t = dclock(CLOCK_S);
    for(i=0; i<nbCell; i++) {
        listAppend(l3, i+1);  /**< Insère un élément à la fin de la liste */
    }
    t = dclock(CLOCK_S) - t;
    printf("%fs\n", t);

    return 0;  /**< Retourne 0 pour indiquer que l'exécution s'est bien déroulée */
}

// EXECUTION

// marvyn@Marvyn:~/but/but2/s3/devEfficaceC$ gcc testperf.c listDouble.c -o testperf
// marvyn@Marvyn:~/but/but2/s3/devEfficaceC$ echo $?
// 0

// marvyn@Marvyn:~/but/but2/s3/devEfficaceC$ ./testperf 1000
// liste doublement chaînée circulaire, insertion début ...0.000024s
// liste doublement chaînée circulaire, insertion milieu ...0.000397s
// liste doublement chaînée circulaire, insertion fin ...0.000739s
// marvyn@Marvyn:~/but/but2/s3/devEfficaceC$ ./testperf 10000
// liste doublement chaînée circulaire, insertion début ...0.000241s
// liste doublement chaînée circulaire, insertion milieu ...0.039594s
// liste doublement chaînée circulaire, insertion fin ...0.078524s
// marvyn@Marvyn:~/but/but2/s3/devEfficaceC$ ./testperf 100000
// liste doublement chaînée circulaire, insertion début ...0.002452s
// liste doublement chaînée circulaire, insertion milieu ...4.452641s
// liste doublement chaînée circulaire, insertion fin ...7.473951s

// On remarque alors que les temps d'éxecution sont clairement inféireur à ceux vu en Java.
