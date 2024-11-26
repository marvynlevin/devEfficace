/**
 * La classe {@code Cell} représente un élément d'une liste chaînée simple.
 * Chaque cellule contient une valeur entière {@code value} et une référence vers la cellule suivante {@code next}.
 * Elle est utilisée comme élément de base dans la structure de données {@code ListSimple}.
 */
public class Cell {

    /**
     * La valeur stockée dans la cellule.
     * C'est un entier que chaque cellule de la liste va contenir.
     */
    public int value;

    /**
     * La référence vers la cellule suivante dans la liste.
     * Si cette cellule est la dernière de la liste, {@code next} vaut {@code null}.
     */
    public Cell next;

    /**
     * Constructeur de la classe {@code Cell}.
     * Initialise une nouvelle cellule avec une valeur donnée et référence {@code null} pour la cellule suivante.
     *
     * @param value La valeur à attribuer à cette cellule.
     */
    public Cell(int value) {
        this.value = value;  // Assigne la valeur donnée à la cellule.
        next = null;         // La cellule ne pointe pas vers une autre cellule, elle est donc isolée.
    }
}

// Pour générer la JavaDoc au format HTML
//& "C:\Program Files\Java\jdk-17\bin\javadoc.exe" -d docs -encoding UTF-8 -docencoding UTF-8 -charset UTF-8 "CellDouble.java"

