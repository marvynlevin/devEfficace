import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe TestPerf
 *
 * Cette classe effectue une série de tests de performance sur différentes structures de listes.
 * Les tests comparent les performances des opérations d'insertion (début, milieu, fin)
 * pour plusieurs implémentations de listes :
 *
 * - ListSimple : une liste simplement chaînée.
 * - ListDoubleCirc : une liste doublement chaînée circulaire.
 * - LinkedList : la classe LinkedList de l'API Java.
 * - ArrayList : la classe ArrayList de l'API Java.
 *
 * L'utilisateur doit fournir un argument en ligne de commande spécifiant le nombre 
 * de cellules à insérer dans les listes pour les tests.
 *
 * Usage : `java TestPerf nb_cell`
 *
 * Les résultats des tests sont affichés sous forme de temps d'exécution en secondes.
 *
 * Dépendances : Les classes ListSimple et ListDoubleCirc doivent être définies dans le projet.
 *
 * Auteur : Marvyn Levin
 * Version : 1.0
 * Date : 26/11/2024
 */
class TestPerf {

    /**
     * Point d'entrée principal du programme.
     * Effectue les tests de performance sur les différentes listes.
     *
     * @param args Tableau contenant un seul argument :
     *             - args[0] : le nombre de cellules à insérer dans les listes.
     *             Si aucun argument n'est fourni ou si l'argument est invalide, 
     *             le programme affiche un message d'erreur et se termine.
     */
    public static void main(String[] args) {
        // Initialisation des listes à tester
        ListSimple myListSimple = new ListSimple();      // Liste simplement chaînée
        ListDoubleCirc myListDouble = new ListDoubleCirc(); // Liste doublement chaînée circulaire
        List<Integer> arrayList = new ArrayList<Integer>(); // ArrayList de l'API Java
        List<Integer> linkedList = new LinkedList<Integer>(); // LinkedList de l'API Java

        // Vérification des arguments
        if (args.length != 1) {
            System.err.println("usage: java TestPerf nb_cell");
            System.exit(1);
        }
        int nbCell = Integer.parseInt(args[0]);

        // Tests de performance pour ListSimple
        testListSimple(myListSimple, nbCell);

        // Tests de performance pour ListDoubleCirc
        testListDouble(myListDouble, nbCell);

        // Tests de performance pour LinkedList de l'API Java
        testLinkedList(linkedList, nbCell);

        // Tests de performance pour ArrayList de l'API Java
        testArrayList(arrayList, nbCell);
    }

    /**
     * Teste les performances des opérations d'insertion sur une liste simplement chaînée.
     *
     * @param myListSimple L'instance de ListSimple à tester.
     * @param nbCell Le nombre de cellules à insérer.
     */
    private static void testListSimple(ListSimple myListSimple, int nbCell) {
        System.out.print("liste simple : insertion début ... ");
        long time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            myListSimple.insert(i + 1, 0);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");

        myListSimple = new ListSimple();
        System.out.print("liste simple : insertion milieu ... ");
        time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            myListSimple.insert(i + 1, i / 2);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");

        myListSimple = new ListSimple();
        System.out.print("liste simple : insertion fin ... ");
        time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            myListSimple.append(i + 1);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");
    }

    /**
     * Teste les performances des opérations d'insertion sur une liste doublement chaînée circulaire.
     *
     * @param myListDouble L'instance de ListDoubleCirc à tester.
     * @param nbCell Le nombre de cellules à insérer.
     */
    private static void testListDouble(ListDoubleCirc myListDouble, int nbCell) {
        System.out.print("liste double : insertion début ... ");
        long time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            myListDouble.prepend(i + 1);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");

        myListDouble = new ListDoubleCirc();
        System.out.print("liste double : insertion milieu ... ");
        time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            myListDouble.insert(i + 1, i / 2);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");

        myListDouble = new ListDoubleCirc();
        System.out.print("liste double : insertion fin ... ");
        time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            myListDouble.append(i + 1);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");
    }

    /**
     * Teste les performances des opérations d'insertion sur une LinkedList de l'API Java.
     *
     * @param linkedList L'instance de LinkedList à tester.
     * @param nbCell Le nombre de cellules à insérer.
     */
    private static void testLinkedList(List<Integer> linkedList, int nbCell) {
        System.out.print("linked list de l'API java : insertion début ... ");
        long time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            linkedList.add(0, i + 1);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");

        linkedList = new LinkedList<>();
        System.out.print("linked list de l'API java : insertion milieu ... ");
        time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            linkedList.add(i / 2, i + 1);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");

        linkedList = new LinkedList<>();
        System.out.print("linked list de l'API java : insertion fin ... ");
        time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            linkedList.add(linkedList.size(), i + 1);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");
    }

    /**
     * Teste les performances des opérations d'insertion sur une ArrayList de l'API Java.
     *
     * @param arrayList L'instance de ArrayList à tester.
     * @param nbCell Le nombre de cellules à insérer.
     */
    private static void testArrayList(List<Integer> arrayList, int nbCell) {
        System.out.print("array list de l'API java : insertion début ... ");
        long time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            arrayList.add(0, i + 1);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");

        arrayList = new ArrayList<>();
        System.out.print("array list de l'API java : insertion milieu ... ");
        time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            arrayList.add(i / 2, i + 1);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");

        arrayList = new ArrayList<>();
        System.out.print("array list de l'API java : insertion fin ... ");
        time = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < nbCell; i++) {
            arrayList.add(i + 1);
        }
        time = Calendar.getInstance().getTimeInMillis() - time;
        System.out.println((time / 1000.0) + "s");
    }
}

// ----------------------------
// 100 insertions
// ----------------------------
//PS C:\Users\Gamer\Desktop\devEfficace\TestPerf\src> javac *.java
//PS C:\Users\Gamer\Desktop\devEfficace\TestPerf\src> java TestPerf 100
//liste simple : insertion dÃ©but ... 0.015s
//liste simple : insertion milieu ... 0.001s
//liste simple : insertion fin ... 0.0s
//liste double : insertion dÃ©but ... 0.001s
//liste double : insertion milieu ... 0.0s
//liste double : insertion fin ... 0.0s
//linked list de l'API java : insertion dÃ©but ... 0.0s
//linked list de l'API java : insertion milieu ... 0.0s
//linked list de l'API java : insertion fin ... 0.0s
//array list de l'API java : insertion dÃ©but ... 0.001s
//array list de l'API java : insertion milieu ... 0.0s
//array list de l'API java : insertion fin ... 0.0s


// ----------------------------
// 10.000 insertions
// ----------------------------
//liste simple : insertion dÃ©but ... 0.016s
//liste simple : insertion milieu ... 0.045s
//liste simple : insertion fin ... 0.086s
//liste double : insertion dÃ©but ... 0.002s
//liste double : insertion milieu ... 0.047s
//liste double : insertion fin ... 0.0s
//linked list de l'API java : insertion dÃ©but ... 0.001s
//linked list de l'API java : insertion milieu ... 0.05s
//linked list de l'API java : insertion fin ... 0.002s
//array list de l'API java : insertion dÃ©but ... 0.004s
//array list de l'API java : insertion milieu ... 0.002s
//array list de l'API java : insertion fin ... 0.001s


// ----------------------------
// 100.000 insertions
// ----------------------------
//liste simple : insertion dÃ©but ... 0.02s
//liste simple : insertion milieu ... 3.823s
//liste simple : insertion fin ... 7.457s
//liste double : insertion dÃ©but ... 0.005s
//liste double : insertion milieu ... 3.76s
//liste double : insertion fin ... 0.004s
//linked list de l'API java : insertion dÃ©but ... 0.008s
//linked list de l'API java : insertion milieu ... 4.326s
//linked list de l'API java : insertion fin ... 0.005s
//array list de l'API java : insertion dÃ©but ... 0.273s
//array list de l'API java : insertion milieu ... 0.149s
//array list de l'API java : insertion fin ... 0.004s


// Les tests montrent que les listes chaînées restent performantes même avec un grand nombre d'insertions, mais
// les listes doublement chaînées ont une meilleure efficacité pour l'insertion en fin de liste.
//
// Tandis que les ArrayList quant-à elles ralentissent, surtout pour les insertions au milieu.