import java.util.*;

/**
 * La classe {@code Tree} représente un arbre générique où chaque nœud est une instance de la classe {@code Node}.
 * Elle fournit des méthodes pour ajouter des nœuds, rechercher des valeurs et afficher la structure de l'arbre.
 */
class Tree {

    /**
     * La racine de l'arbre.
     */
    public Node root;

    /**
     * Le nombre total de nœuds dans l'arbre.
     * Ce champ est facultatif, mais peut être utile pour des statistiques ou des optimisations.
     */
    public int nbNodes;

    /**
     * Constructeur par défaut de la classe {@code Tree}.
     * Initialise un arbre vide avec une racine nulle et un nombre de nœuds égal à 0.
     */
    public Tree() {
        root = null;
        nbNodes = 0;
    }

    /**
     * Ajoute un nœud à l'arbre.
     *
     * @param value La valeur a attribué au nouveau nœud.
     * @param parent Le nœud parent auquel le nouveau nœud sera ajouté. Si parent est null, le nouveau nœud devient la racine.
     * @return Le nœud nouvellement ajouté ou null si le parent n'existe pas dans l'arbre.
     */
    public Node addNode(int value, Node parent) {
        // si parent est null.
	    if (parent == null) {
            Node newNode = new Node(value); // noeud parent.
            // si root existe déja.
            if (root == null) {
                newNode.addChild(root); // ancien root devient fils de newNode.
            }
            root = newNode; // newNode devient le nœud root.
            nbNodes++;
            return newNode;
        } else if (contains(parent, root) == null) {
            Node newNode = parent.addChild(value);
            nbNodes++;
            return newNode;
        }
        return null; // parent introuvable.
    }

    /**
     * Vérifie si un nœud donné existe dans l'arbre.
     * La recherche se fait en profondeur (DFS).
     *
     * @param toSearch Le nœud à rechercher.
     * @param parent Le nœud actuel utilisé pour la recherche récursive.
     * @return Le nœud trouvé ou null si le nœud n'existe pas.
     */
    public Node contains(Node toSearch, Node parent) {
        if (parent == null) {
            return null;
        }
        if (parent == toSearch) {
            return parent; // condition d'arrêt.
        }

        for (Node child : parent.children) {
            Node found = contains(toSearch, child); // appel récursif.
            if (found != null) {
                return found; // renvoie résultat.
            }
        }

        return null; // valeur non trouvée.
    }

    /**
     * Recherche un nœud contenant une valeur donnée en utilisant une recherche en largeur (BFS).
     *
     * @param value La valeur à rechercher.
     * @param parent Le nœud de départ pour la recherche.
     * @return Le nœud contenant la valeur ou null si la valeur n'est pas trouvée.
     */
    public Node searchValueByLevel(int value, Node parent) {
        if (parent == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(parent);

        while (!queue.isEmpty()) {
            Node current = queue.poll(); // supprime et renvoie le nœud en tête de liste.
            if (current.value == value) {
                return current;
            }
            queue.addAll(current.children); // recherche depuis le fils.
        }

        return null; // valeur non trouvée.
    }

    /**
     * Recherche un nœud contenant une valeur donnée en utilisant une recherche en profondeur (DFS).
     *
     * @param value La valeur à rechercher.
     * @param parent Le nœud de départ pour la recherche.
     * @return Le nœud contenant la valeur ou null si la valeur n'est pas trouvée.
     */
    public Node searchValueByDepth(int value, Node parent) {
        if (parent == null) return null;

        if (parent.value == value) {
            return parent; // condition d'arrêt.
        }

        for (Node child : parent.children) {
            Node found = searchValueByDepth(value, child); // appel récursif.
            if (found != null) {
                return found; // renvoie résultat.
            }
        }

        return null; // valeur non trouvée.
    }

    /**
     * Recherche un nœud contenant une valeur donnée en fonction d'un type de recherche.
     *
     * @param value La valeur à rechercher.
     * @param type Le type de recherche : 1 pour DFS (profondeur), 2 pour BFS (largeur).
     * @return Le nœud contenant la valeur ou null si la valeur n'est pas trouvée.
     */
    public Node searchValue(int value, int type) {
        Node n = null;
        if (type == 1) n = searchValueByDepth(value, root);
        else if (type == 2) n = searchValueByLevel(value, root);
        return n;
    }

    /**
     * Affiche la structure de l'arbre avec une indentation en fonction du niveau des nœuds.
     */
    public void print() {
        if (root != null) {
            printNode(root,0);
        }
    }

    /**
     * Méthode récursive pour afficher un nœud et ses enfants.
     *
     * @param n Le nœud actuel à afficher.
     * @param level Le niveau d'indentation pour l'affichage.
     */
    private void printNode(Node n,int level) {
        for (int i = 0; i < 2 * level; i++) {
            System.out.print(" ");
        }
        System.out.println(n.value);
        for (Node child : n.children) {
            printNode(child, level + 1);
        }
    }

    /**
     * Affiche la structure de l'arbre en largeur (par niveau).
     * Chaque niveau est affiché avec une indentation reflétant sa profondeur.
     */
    public void printLevel() {
        if (root == null) {
            System.out.println("L'arbre est vide.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Integer> levels = new HashMap<>(); // Associe chaque nœud à son niveau.
        queue.add(root);
        levels.put(root, 0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int level = levels.get(current);

            // Indentation pour refléter le niveau actuel.
            for (int i = 0; i < 2 * level; i++) {
                System.out.print(" ");
            }
            System.out.println(current.value);

            // Ajout des enfants à la queue avec leur niveau.
            for (Node child : current.children) {
                queue.add(child);
                levels.put(child, level + 1);
            }
        }
    }
}