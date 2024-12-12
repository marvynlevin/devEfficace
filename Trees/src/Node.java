/**
 * La classe {@code Node} représente un nœud dans une structure d'arbre.
 * Chaque nœud contient une valeur entière {@code value} et une liste de nœuds enfants {@code children}.
 * Elle est utilisée comme composant de base pour construire des structures hiérarchiques.
 */
import java.util.*;

class Node {

    /**
     * La liste des enfants du nœud courant.
     * Chaque enfant est représenté par une instance de la classe {@code Node}.
     */
    public List<Node> children;

    /**
     * La valeur entière associée au nœud courant.
     */
    public int value;

    /**
     * Constructeur de la classe {@code Node}.
     * Initialise un nœud avec une valeur donnée et une liste vide pour ses enfants.
     *
     * @param value La valeur à attribuer à ce nœud.
     */
    public Node(int value) {
        this.value = value; // Attribue la valeur spécifiée au nœud.
        children = new ArrayList<Node>(); // Initialise une liste vide pour les enfants.
    }

    /**
     * Ajoute un nouvel enfant avec une valeur spécifiée au nœud courant.
     *
     * @param value La valeur du nouvel enfant.
     * @return Le nœud enfant nouvellement créé.
     */
    public Node addChild(int value) {
        Node newNode = new Node(value);
        this.children.add(newNode); // Ajoute le nouvel enfant à la liste des enfants.
        return newNode;
    }

    /**
     * Ajoute un nœud existant comme enfant au nœud courant.
     *
     * @param n Le nœud à ajouter comme enfant. Si {@code n} est {@code null}, aucune action n'est effectuée.
     */
    public void addChild(Node n) {
        if (n != null) {
            this.children.add(n); // Ajoute le nœud spécifié à la liste des enfants.
        }
    }

    /**
     * Récupère l'enfant situé à un index donné dans la liste des enfants.
     *
     * @param index L'index de l'enfant à récupérer.
     * @return Le nœud enfant à l'index spécifié, ou {@code null} si l'index est invalide.
     */
    public Node getChild(int index) {
        if (index < 0 || index >= this.children.size()) {
            return null; // Retourne null si l'index est hors limites.
        }
        return this.children.get(index); // Retourne l'enfant à l'index spécifié.
    }
}

// ----------------------------
// Pour générer la JavaDoc au format HTML
// ----------------------------
// & "C:\Program Files\Java\jdk-17\bin\javadoc.exe" -d docs -encoding UTF-8 -docencoding UTF-8 -charset UTF-8 "Node.java"