/**
 * La classe {@code BinaryNode} représente un nœud dans un arbre binaire.
 * Chaque nœud contient une valeur entière et a des références vers ses nœuds enfants gauche et droit.
 */
class BinaryNode {

    /**
     * Le nœud enfant à gauche du nœud actuel.
     * Il peut être nul si le nœud n'a pas d'enfant gauche.
     */
    BinaryNode left;

    /**
     * Le nœud enfant à droite du nœud actuel.
     * Il peut être nul si le nœud n'a pas d'enfant droit.
     */
    BinaryNode right;

    /**
     * La valeur stockée dans le nœud.
     * Il s'agit de l'entier représentant la donnée de ce nœud.
     */
    int value;

    /**
     * Constructeur de la classe {@code BinaryNode}.
     * Crée un nœud avec la valeur spécifiée et initialise les enfants gauche et droit à {@code null}.
     *
     * @param value La valeur à attribuer au nœud.
     */
    public BinaryNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
