/**
 * La classe {@code TestSimple} contient des tests unitaires pour vérifier les fonctionnalités de la classe {@code ListSimple}.
 *
 * Cette classe de test exécute des scénarios courants tels que l'ajout, l'insertion, la suppression et la recherche d'éléments
 * dans une liste chaînée simple. Les résultats de chaque opération sont imprimés pour valider le comportement attendu des méthodes.
 */
public class TestSimple {

    /**
     * Méthode principale pour exécuter les tests unitaires sur la classe {@code ListSimple}.
     *
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {

        // Création d'une nouvelle liste chaînée simple
        ListSimple liste = new ListSimple();

        // Test de l'ajout en fin de liste
        liste.append(20);  // Ajoute la valeur 20 (la liste est vide, donc insertion en tête)

        // Test de l'insertion en tête (index négatif)
        liste.insert(10, -5);  // Insère la valeur 10 à l'index -5, équivalent à une insertion en tête

        // Test de l'insertion en fin (index supérieur à la taille)
        liste.insert(30, 7);  // Insère la valeur 30 à l'index 7 (en dehors des limites), donc ajout à la fin

        // Test de l'ajout en fin
        liste.append(50);  // Ajoute la valeur 50 à la fin de la liste

        // Test de l'insertion au milieu de la liste
        liste.insert(40, 3);  // Insère la valeur 40 à l'index 3

        // Affichage de la liste après les ajouts et insertions
        liste.print();  // Doit afficher : 10 -> 20 -> 30 -> 40 -> 50 -> null

        // Test de suppression d'une valeur inexistante
        liste.remove(12);  // Ne doit rien faire car la valeur 12 n'est pas présente

        // Test de suppression de la tête
        liste.remove(10);  // Enlève la valeur 10 (qui est la tête de la liste)

        // Test de suppression à un index invalide (négatif)
        liste.removeAt(-2);  // Ne doit rien faire car l'index est négatif

        // Test de suppression à un index invalide (hors des limites)
        liste.removeAt(22);  // Ne doit rien faire car l'index est supérieur à la taille

        // Test de suppression d'un élément à un index valide
        liste.removeAt(2);  // Enlève la valeur à l'index 2 (i.e., la valeur 40)

        // Affichage de la liste après les suppressions
        liste.print();  // Doit afficher : 20 -> 30 -> 50 -> null

        // Test d'accès à une cellule avec un index invalide (négatif)
        Cell c = liste.get(-1);  // Devrait renvoyer null car l'index est invalide
        if (c != null) {
            System.out.println("Problème avec la méthode get() pour un index négatif");
        }

        // Test d'accès à une cellule avec un index invalide (hors des limites)
        c = liste.get(99);  // Devrait renvoyer null car l'index est hors des limites
        if (c != null) {
            System.out.println("Problème avec la méthode get() pour un index hors des limites");
        }

        // Test de recherche d'une valeur inexistante
        c = liste.find(99);  // Devrait renvoyer null car la valeur 99 n'est pas présente dans la liste
        if (c != null) {
            System.out.println("Problème avec la méthode find() pour une valeur inexistante");
        }

        // Test de recherche d'une valeur existante (20)
        c = liste.find(20);
        if (c == null || c.value != 20) {
            System.out.println("Problème avec la méthode find() pour la valeur 20");
        }

        // Test de recherche d'une valeur existante (50)
        c = liste.find(50);
        if (c == null || c.value != 50) {
            System.out.println("Problème avec la méthode find() pour la valeur 50");
        }
    }
}
