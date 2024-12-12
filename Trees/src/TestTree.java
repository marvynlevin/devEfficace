/**
 * Classe TestTree
 * <p>
 * La classe <code>TestTree</code> permet de tester l'implémentation d'un arbre (de type <code>Tree</code>)
 * à travers différentes opérations, telles que l'ajout de nœuds, la recherche de nœuds, et l'affichage de l'arbre.
 * Elle simule la création d'un arbre avec des valeurs spécifiques et teste les méthodes d'ajout, de recherche en profondeur et en largeur,
 * ainsi que la recherche de nœuds spécifiques.
 * </p>
 *
 * <p>
 * Ce programme permet de vérifier le bon fonctionnement des méthodes de la classe <code>Tree</code>,
 * comme la méthode <code>addNode</code>, qui permet d'ajouter des nœuds à l'arbre,
 * la méthode <code>contains</code>, qui vérifie si un nœud existe dans l'arbre,
 * et les méthodes <code>searchValue</code> pour effectuer une recherche en profondeur et en largeur.
 * </p>
 *
 * <p>
 * Les étapes de test incluent la création d'un arbre avec des nœuds ayant des valeurs spécifiques,
 * l'ajout d'enfants à ces nœuds, l'affichage de l'arbre, ainsi que des tests de recherche pour valider que
 * les méthodes fonctionnent correctement. Des messages d'erreur sont affichés si une recherche échoue.
 * </p>
 *
 * <p>
 * Ce programme constitue une base pour tester les fonctionnalités d'un arbre en Java, et peut être
 * étendu pour intégrer d'autres types d'opérations sur des arbres (par exemple, suppression de nœuds).
 * </p>
 *
 * @author Marvyn Levin
 * @version 1.0
 * @date 12/12/2024
 */
public class TestTree {

    public static void main(String[] args) {

        Tree tree = new Tree();

        Node root = tree.addNode(20, null); // création racine
        root = tree.addNode(10, null); // test remplacement racine
        Node n1 = tree.addNode(21, root);
        n1.addChild(30);
        Node n2 = n1.addChild(31);
        Node n3 = n1.addChild(32);
        n2.addChild(40);
        n2 = n2.addChild(41);
        n3.addChild(45);
        n3.addChild(46);
        Node n4 = n3.addChild(47);
        n4.addChild(50);
        n4 = n4.addChild(51);

        tree.print();

        Node s = tree.contains(n3, root);
        if (s != n3) {
            System.out.println("échec recherche du noeud contenant 32");
        }
        s = tree.contains(n2, root);
        if (s != n2) {
            System.out.println("échec recherche du noeud contenant 41");
        }
        s = tree.contains(n4, root);
        if (s != n4) {
            System.out.println("échec recherche du noeud contenant 51");
        }

        s = tree.searchValue(45, 1); // recherche en profondeur
        if (s.value != 45) {
            System.out.println("échec recherche valeur 45");
        }
        s = tree.searchValue(50, 2); // recherche en largeur
        if (s.value != 50) {
            System.out.println("échec recherche valeur 50");
        }
        s = tree.searchValue(60, 1); // recherche en profondeur
        if (s != null) { // si on trouve quelque chose = pas normal
            System.out.println("échec recherche valeur 60");
        }
    }
}



// ----------------------------
// EXECUTION
// ----------------------------
// PS C:\Users\Gamer\Desktop\devEfficace\Trees\src> javac *.java
// PS C:\Users\Gamer\Desktop\devEfficace\Trees\src> java TestTree
// 10
//   21
//     30
//     31
//       40
//       41
//     32
//       45
//       46
//       47
//         50
//         51
