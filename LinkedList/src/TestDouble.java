/**
 * Classe TestDouble
 * <p>
 * Cette classe exécute des tests pour valider les fonctionnalités de la classe {@code ListDoubleCirc},
 * une liste chaînée circulaire doublement chaînée.
 * Les tests couvrent les opérations suivantes :
 * </p>
 * <ul>
 *     <li>Ajout d'éléments (en tête, au milieu, en fin).</li>
 *     <li>Suppression d'éléments (par valeur ou par index).</li>
 *     <li>Accès à des éléments (par index).</li>
 *     <li>Recherche d'éléments (par valeur).</li>
 * </ul>
 * <p>
 * Les résultats des tests sont affichés pour vérifier le bon fonctionnement des méthodes.
 * </p>
 *
 * @version 1.0
 * @author Marvyn
 * @date 17/11/2024
 *
 * @see ListDoubleCirc
 */
public class TestDouble {
    /**
     * Méthode principale pour exécuter les tests unitaires sur la classe {@code ListDoubleCirc}.
     *
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {

        ListDoubleCirc liste = new ListDoubleCirc();

        // Tests d'insertion
        liste.append(20);      // Insertion en fin (liste vide -> insertion en tête)
        liste.insert(10, -5);  // Insertion en tête (index négatif)
        liste.insert(30, 7);   // Insertion en fin (index hors limites)
        liste.append(50);      // Ajout en fin
        liste.insert(40, 3);   // Insertion à l'index 3
        liste.print();         // Affiche la liste : 10 20 30 40 50

        // Tests de suppression
        liste.remove(12);      // Valeur non existante, ne fait rien
        liste.remove(10);      // Suppression de la valeur 10 (tête de liste)
        liste.removeAt(-2);    // Index négatif, ne fait rien
        liste.removeAt(22);    // Index hors limites, ne fait rien
        liste.removeAt(2);     // Suppression à l'index 2 (i.e. valeur 40)
        liste.print();         // Affiche la liste : 20 30 50

        // Tests d'accès par index
        CellDouble c = liste.get(-1); // Accès hors limites (index négatif) -> renvoie null
        if (c != null) {
            System.out.println("Problème avec get(-1)");
        }

        c = liste.get(99); // Accès hors limites (index trop grand) -> renvoie null
        if (c != null) {
            System.out.println("Problème avec get(99)");
        }

        c = liste.get(1); // Accès à l'index 1 (i.e. valeur 30)
        if (c == null || c.value != 30) {
            System.out.println("Problème avec get(1)");
        }

        // Tests de recherche par valeur
        c = liste.find(99); // Valeur inexistante -> renvoie null
        if (c != null) {
            System.out.println("Problème avec find(99)");
        }

        c = liste.find(20); // Recherche de la valeur 20
        if (c == null || c.value != 20) {
            System.out.println("Problème avec find(20)");
        }

        c = liste.find(50); // Recherche de la valeur 50
        if (c == null || c.value != 50) {
            System.out.println("Problème avec find(50)");
        }
    }
}

// ----------------------------
// EXECUTION
// ----------------------------
// PS C:\Users\Gamer\Desktop\devEfficace\LinkedList\src> java TestDouble
// 10 20 30 40 50
// 20 30 50
