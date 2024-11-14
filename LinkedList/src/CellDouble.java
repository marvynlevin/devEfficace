/**
 * La classe {@code CellDouble} représente une cellule d'une liste chaînée doublement chaînée.
 * Chaque cellule contient une valeur entière et des pointeurs vers la cellule précédente et la cellule suivante.
 *
 * <p>Elle est généralement utilisée dans des structures de données comme les listes doublement chaînées,
 * où l'accès aux éléments peut se faire dans les deux directions (avant et arrière).</p>
 *
 * @version 1.0
 */
public class CellDouble {

    /**
     * La valeur contenue dans cette cellule. 
     */
    public int value;

    /**
     * Référence vers la cellule précédente dans la liste.
     * {@code null} si cette cellule est la première de la liste.
     */
    public CellDouble prev;

    /**
     * Référence vers la cellule suivante dans la liste.
     * {@code null} si cette cellule est la dernière de la liste.
     */
    public CellDouble next;

    /**
     * Constructeur de la classe {@code CellDouble}.
     * Initialise une nouvelle cellule avec une valeur spécifiée et des pointeurs 
     * {@code prev} et {@code next} initialisés à {@code null}.
     *
     * @param value La valeur entière à stocker dans la cellule.
     */
    public CellDouble(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

// Pour générer la JavaDoc au format HTML
//& "C:\Program Files\Java\jdk-17\bin\javadoc.exe" -d docs -encoding UTF-8 -docencoding UTF-8 -charset UTF-8 "CellDouble.java"
