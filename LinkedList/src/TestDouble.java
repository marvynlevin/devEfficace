/**
 * La classe {@code TestDouble} contient une méthode {@code main} pour tester les fonctionnalités
 * de la classe {@code ListDoubleCirc}, qui représente une liste chaînée circulaire doublement chaînée.
 *
 * <p>Elle permet de vérifier les différentes opérations telles que l'insertion, la suppression,
 * l'accès et la recherche dans une liste doublement chaînée circulaire.</p>
 *
 * @version 1.0
 */
public class TestDouble {

    /**
     * Méthode principale de test pour la classe {@code ListDoubleCirc}.
     * Elle effectue divers tests sur les méthodes de la liste chaînée circulaire :
     * <ul>
     *   <li>Insertion en tête, à la fin, et à des positions spécifiques</li>
     *   <li>Suppression par valeur et par index</li>
     *   <li>Accès à une cellule par index</li>
     *   <li>Recherche d'une cellule par valeur</li>
     * </ul>
     *
     * <p>Les résultats des tests sont affichés dans la console et vérifient que
     * les opérations sont correctes.</p>
     *
     * @param args Arguments de la ligne de commande (non utilisés).
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
