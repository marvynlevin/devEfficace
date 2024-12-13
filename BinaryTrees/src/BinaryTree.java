/**
 * La classe {@code BinaryTree} représente un arbre binaire où chaque nœud est une instance de la classe {@code BinaryNode}.
 * Elle fournit des méthodes pour ajouter des nœuds, rechercher des valeurs et afficher la structure de l'arbre.
 */
class BinaryTree {

    /**
     * La racine de l'arbre.
     */
    public BinaryNode root;

    /**
     * Le nombre total de nœuds dans l'arbre.
     * Ce champ est facultatif, mais peut être utile pour des statistiques ou des optimisations.
     */
    public int nbBinaryNodes;

    /**
     * Constructeur par défaut de la classe {@code BinaryTree}.
     * Initialise un arbre vide avec une racine nulle et un nombre de nœuds égal à 0.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Ajoute un nœud à l'arbre.
     *
     * @param value La valeur du nœud à ajouter.
     */
    public void addBinaryNode(int value) {
        root = insertRecur(root, value); // Utilisation de la méthode de récursion pour ajouter le nœud
    }

    /**
     * Ajoute un nœud à l'arbre de manière récursive.
     *
     * @param n     Le nœud courant où l'insertion doit avoir lieu.
     * @param value La valeur du nœud à insérer.
     * @return Le nœud mis à jour (soit le nœud inséré, soit le nœud courant).
     */
    private BinaryNode insertRecur(BinaryNode n, int value) {
        // Si l'arbre est vide, on crée un nouveau nœud.
        if (n == null) {
            return new BinaryNode(value);
        }

        // Si la valeur est inférieure ou égale à celle du nœud courant, on insère à gauche.
        if (value <= n.value) {
            n.left = insertRecur(n.left, value);
        }
        // Si la valeur est plus grande que celle du nœud courant, on insère à droite.
        else {
            n.right = insertRecur(n.right, value);
        }
        return n;
    }

    /**
     * Recherche un nœud de l'arbre.
     *
     * @param value La valeur à rechercher.
     * @return Le nœud trouvé ou null si la valeur n'existe pas dans l'arbre.
     */
    public BinaryNode search(int value) {
        BinaryNode n = root;
        while ((n != null) && (n.value != value)) {
            if (value <= n.value) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return n; // retourne le nœud trouvé ou null si la valeur n'existe pas
    }

    /**
     * Affiche la structure de l'arbre avec une indentation en fonction du niveau des nœuds.
     */
    public void print() {
        if (root != null) {
            printBinaryNode(root);
        }
    }

    /**
     * Affiche l'arbre binaire avec une indentation en fonction des niveaux.
     *
     * @param n Le nœud actuel.
     */
    private void printBinaryNode(BinaryNode n) {
        int height = height(n);
        for (int i = 1; i <= height; i++) {
            printLevel(n, i, height);
            System.out.println();
        }
    }

    /**
     * Calcule la hauteur de l'arbre.
     *
     * @param node Le nœud courant.
     * @return La hauteur de l'arbre.
     */
    private int height(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * Affiche les nœuds à un certain niveau de l'arbre.
     *
     * @param node    Le nœud actuel.
     * @param level   Le niveau à afficher.
     * @param height  La hauteur totale de l'arbre.
     */
    private void printLevel(BinaryNode node, int level, int height) {
        if (node == null) {
            printSpaces(height - level);
            return;
        }

        if (level == 1) {
            System.out.print(node.value);
        } else {
            printLevel(node.left, level - 1, height);
            printLevel(node.right, level - 1, height);
        }
        if (level < height) {
            System.out.print(" ");
        }
    }

    /**
     * Affiche des espaces pour l'indentation afin d'aligner les nœuds.
     *
     * @param spaces Le nombre d'espaces à afficher.
     */
    private void printSpaces(int spaces) {
        for (int i = 0; i < 1; i++) {
            System.out.print(" ");
        }
    }
}