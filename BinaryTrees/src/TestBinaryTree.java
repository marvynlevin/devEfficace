/**
 * Classe TestBinaryTree
 * <p>
 * La classe <code>TestBinaryTree</code> permet de tester l'implémentation d'un arbre binaire (de type <code>BinaryTree</code>)
 * à travers différentes opérations, telles que l'ajout de nœuds, la recherche de nœuds, et l'affichage de l'arbre.
 * Elle simule la création d'un arbre binaire avec des valeurs spécifiques et teste les méthodes d'ajout, de recherche,
 * ainsi que l'affichage de l'arbre.
 * </p>
 *
 * <p>
 * Ce programme permet de vérifier le bon fonctionnement des méthodes de la classe <code>BinaryTree</code>,
 * comme la méthode <code>addBinaryNode</code>, qui permet d'ajouter des nœuds à l'arbre,
 * et la méthode <code>search</code>, qui permet de rechercher une valeur dans l'arbre.
 * </p>
 *
 * <p>
 * Les étapes de test incluent la création d'un arbre avec des nœuds ayant des valeurs spécifiques,
 * l'ajout d'enfants à ces nœuds, l'affichage de l'arbre, ainsi que des tests de recherche pour valider que
 * les méthodes fonctionnent correctement. Des messages d'erreur sont affichés si une recherche échoue.
 * </p>
 *
 * <p>
 * Ce programme constitue une base pour tester les fonctionnalités d'un arbre binaire en Java, et peut être
 * étendu pour intégrer d'autres types d'opérations sur des arbres (par exemple, suppression de nœuds).
 * </p>
 *
 * @author Marvyn Levin
 * @version 1.0
 * @date 12/12/2024
 */
public class TestBinaryTree {

    public static void main(String[] args) {

        // Créer un arbre binaire
        BinaryTree tree = new BinaryTree();

        // Ajouter des nœuds
        tree.addBinaryNode(20); // Racine
        tree.addBinaryNode(10);
        tree.addBinaryNode(30);
        tree.addBinaryNode(5);
        tree.addBinaryNode(15);
        tree.addBinaryNode(25);
        tree.addBinaryNode(35);
        tree.addBinaryNode(36);
        tree.addBinaryNode(37);
        tree.addBinaryNode(38);
        tree.addBinaryNode(34);


        // Afficher l'arbre binaire
        System.out.println("Affichage de l'arbre binaire :");
        tree.print();

        // Recherche de nœuds
        BinaryNode foundNode = tree.search(15); // Recherche de la valeur 15
        if (foundNode != null && foundNode.value == 15) {
            System.out.println("Recherche réussie pour la valeur 15.");
        } else {
            System.out.println("Échec recherche de la valeur 15.");
        }

        foundNode = tree.search(5); // Recherche de la valeur 5
        if (foundNode != null && foundNode.value == 5) {
            System.out.println("Recherche réussie pour la valeur 5.");
        } else {
            System.out.println("Échec recherche de la valeur 5.");
        }

        foundNode = tree.search(25); // Recherche de la valeur 25
        if (foundNode != null && foundNode.value == 25) {
            System.out.println("Recherche réussie pour la valeur 25.");
        } else {
            System.out.println("Échec recherche de la valeur 25.");
        }

        // Recherche d'une valeur non existante
        foundNode = tree.search(40); // Recherche d'une valeur inexistante
        if (foundNode == null) {
            System.out.println("Recherche échouée pour la valeur 40, comme attendu.");
        } else {
            System.out.println("Échec recherche de la valeur 40.");
        }
    }
}



// ----------------------------
// EXECUTION
// ----------------------------
// PS C:\Users\Gamer\Desktop\devEfficace\BinaryTrees\src> javac *.java
// PS C:\Users\Gamer\Desktop\devEfficace\BinaryTrees\src> java TestBinaryTree
// Affichage de l'arbre binaire :
// 20
// 10 30
// 5 15  25 35
//           34 36
//               37
//                38
// Recherche réussie pour la valeur 15.
// Recherche réussie pour la valeur 5.
// Recherche réussie pour la valeur 25.
// Recherche a échoué pour la valeur 40, comme attendu.

