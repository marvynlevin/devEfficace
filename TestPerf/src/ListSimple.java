/**
 * La classe {@code ListSimple} implémente une liste chaînée simple.
 * Elle permet de gérer une liste de cellules (chaînées entre elles), où chaque cellule contient une valeur.
 * Les opérations de base comme l'ajout, l'insertion, la suppression, la recherche, et la modification d'éléments
 * sont supportées.
 */
public class ListSimple {

    public Cell head;   // Tête de la liste, qui pointe vers la première cellule.
    public int size;    // Taille de la liste, c'est-à-dire le nombre de cellules dans la liste.

    /**
     * Constructeur de la classe {@code ListSimple}.
     * Initialise une liste vide (tête = {@code null}, taille = 0).
     */
    public ListSimple() {
        head = null;
        size = 0;
    }

    /**
     * Recherche une cellule contenant la valeur spécifiée.
     *
     * @param value La valeur de la cellule à rechercher.
     * @return La cellule contenant la valeur, ou {@code null} si la valeur n'est pas trouvée.
     */
    public Cell find(int value) {
        Cell c = head;  // On commence à la tête de la liste.
        // On parcourt la liste jusqu'à ce qu'on trouve la cellule contenant la valeur ou qu'on atteigne la fin de la liste.
        while ((c != null) && (c.value != value)) {
            c = c.next;  // Avance à la cellule suivante.
        }
        return c;  // Retourne la cellule trouvée ou {@code null} si non trouvée.
    }

    /**
     * Recherche l'index de la cellule contenant la valeur spécifiée.
     * Si la valeur n'est pas trouvée, retourne {@code -1}.
     *
     * @param value La valeur de la cellule à rechercher.
     * @return L'index de la cellule contenant la valeur, ou {@code -1} si la valeur n'est pas trouvée.
     */
    public int findId(int value) {
        Cell c = head;  // On commence à la tête de la liste.
        // On parcourt la liste jusqu'à ce qu'on trouve la cellule contenant la valeur ou qu'on atteigne la fin de la liste.
        int i = 0;
        while ((c != null) && (c.value != value)) {
            c = c.next;  // Avance à la cellule suivante.
            i++;
        }
        return (c == null) ? -1 : i;  // Retourne -1 si l'élément n'est pas trouvé.
    }

    /**
     * Récupère la cellule à un index spécifique dans la liste.
     *
     * @param index L'index de la cellule à récupérer.
     * @return La cellule à l'index spécifié, ou {@code null} si l'index est invalide (en dehors des limites de la liste).
     */
    public Cell get(int index) {
        if ((index < 0) || (index >= size)) return null;  // Vérifie que l'index est valide.
        Cell c = head;  // On commence à la tête de la liste.
        int i = 0;  // Compteur pour suivre l'index actuel dans la liste.
        // On parcourt la liste jusqu'à atteindre l'index spécifié.
        while ((c != null) && (i < index)) {
            c = c.next;  // Avance à la cellule suivante.
            i += 1;      // Incrémente l'index.
        }
        return c;  // Retourne la cellule trouvée ou {@code null} si l'index est invalide.
    }

    /**
     * Ajoute une nouvelle cellule à la fin de la liste.
     *
     * @param value La valeur de la nouvelle cellule.
     * @return La nouvelle cellule ajoutée.
     */
    public Cell append(int value) {
        Cell c = null;  // Variable temporaire pour la cellule existante.
        Cell newCell = new Cell(value);  // Crée la nouvelle cellule avec la valeur donnée.

        // Si la liste est vide (taille == 0), la nouvelle cellule devient la tête.
        if (size == 0) {
            head = newCell;
        } else {
            // Si la liste n'est pas vide, on obtient la dernière cellule (à l'index {@code size-1}).
            c = get(size - 1);
            c.next = newCell;  // La dernière cellule pointe maintenant vers la nouvelle cellule.
        }

        size++;  // Incrémente la taille de la liste.
        return newCell;  // Retourne la nouvelle cellule ajoutée.
    }

    /**
     * Insère une nouvelle cellule à un index spécifique dans la liste.
     * Si l'index est 0, la cellule est insérée en tête de liste.
     *
     * @param value La valeur de la nouvelle cellule.
     * @param index L'index où la cellule doit être insérée.
     * @return La nouvelle cellule insérée.
     */
    public Cell insert(int value, int index) {
        Cell newCell = new Cell(value);  // Crée la nouvelle cellule avec la valeur donnée.

        // Si l'index est 0, la nouvelle cellule devient la première de la liste.
        if (index <= 0) {
            newCell.next = head;  // La nouvelle cellule pointe vers l'ancienne tête.
            head = newCell;       // La tête devient la nouvelle cellule.
        }
        // Si l'index est supérieur ou égal à la taille, insérer à la fin
        else if (index >= size) {
            return append(value);
        }
        // Si l'index est supérieur à 0, on trouve la cellule juste avant celle où on veut insérer.
        else {
            Cell c = get(index - 1);
            newCell.next = c.next;  // La nouvelle cellule pointe vers la cellule qui suit celle à l'index.
            c.next = newCell;       // La cellule précédente pointe vers la nouvelle cellule.
        }

        size++;  // Incrémente la taille de la liste.
        return newCell;  // Retourne la nouvelle cellule insérée.
    }

    /**
     * Remplace la valeur d'une cellule à un index spécifique dans la liste.
     *
     * @param value La nouvelle valeur à attribuer à la cellule.
     * @param index L'index de la cellule à remplacer.
     * @return La cellule modifiée.
     */
    public Cell replace(int value, int index) {
        if ((index < 0) || (index >= size)) return null;  // Vérifie que l'index est valide.

        Cell c = get(index);  // Récupère la cellule à l'index spécifié.
        c.value = value;      // Remplace la valeur de la cellule.

        return c;  // Retourne la cellule modifiée.
    }

    /**
     * Supprime la cellule à un index spécifique dans la liste.
     * Si l'index est 0, la première cellule est supprimée. Sinon, la cellule à l'index est supprimée
     * et la cellule précédente est mise à jour pour pointer vers la cellule suivante.
     *
     * @param index L'index de la cellule à supprimer.
     * @return La cellule supprimée, ou {@code null} si l'index est invalide.
     */
    public Cell removeAt(int index) {
        if ((index < 0) || (index >= size)) return null;  // Vérifie que l'index est valide.

        // Si l'index est 0, on supprime la première cellule.
        if (index == 0) {
            Cell c = head;       // La cellule à supprimer.
            head = head.next;    // La tête de la liste devient la cellule suivante.
            size--;              // Réduit la taille de la liste.
            return c;            // Retourne la cellule supprimée.
        }

        // Si l'index est supérieur à 0, on trouve la cellule précédente.
        Cell c = get(index - 1);  // Récupère la cellule avant celle à supprimer.
        Cell delete = c.next;     // La cellule à supprimer est après la cellule précédente.
        c.next = delete.next;     // La cellule précédente va maintenant pointer sur la cellule après la supprimée.
        size--;                   // Réduit la taille de la liste.

        return delete;            // Retourne la cellule supprimée.
    }

    /**
     * Supprime la cellule contenant la valeur spécifiée.
     * Utilise {@code findId} pour obtenir l'index de la cellule à supprimer,
     * puis appelle {@code removeAt} pour effectuer la suppression.
     * Retourne {@code null} si la valeur n'est pas trouvée.
     *
     * Fonction deprecated car elle fait 2 parcours de liste.
     *
     * @param value La valeur de la cellule à supprimer.
     * @return La cellule supprimée, ou {@code null} si la valeur n'est pas trouvée.
     */
    public Cell removeDeprecated(int value) {
        int index = findId(value);  // Recherche de l'index de la cellule avec la valeur donnée.
        // Vérifie si l'élément n'a pas été trouvé.
        if (index == -1) return null;   // Si la valeur n'est pas trouvée, on retourne null.
        else return removeAt(index);    // Si trouvé, on supprime la cellule à l'index trouvé.
    }

    /**
     * Supprime la cellule contenant la valeur spécifiée.
     * Utilise une boucle pour obtenir l'index de la cellule à supprimer,
     * puis trouve la cellule à supprimer pour effectuer la suppression.
     * Retourne {@code null} si la valeur n'est pas trouvée.
     *
     * @param value La valeur de la cellule à supprimer.
     * @return La cellule supprimée, ou {@code null} si la valeur n'est pas trouvée.
     */
    public Cell remove(int value) {
        if (head == null) return null;

        Cell current = head; // Cellule courante.
        Cell previous = null; // Cellule précédente.

        // Recherche de la cellule contenant la valeur.
        while ((current != null) && (current.value != value)) {
            previous = current; // Previous devient current.
            current = current.next; // Avance dans la liste.
        }

        // Si la valeur a été trouvée (current n'est pas null).
        if (current != null) {
            // Si c'est la tête de la liste.
            if (current == head) {
                head = current.next; // La tête devient l'élément suivant.
                // Sinon, relie la cellule précédente à la suivante.
            } else {
                previous.next = current.next; // La cellule avant pointe après celle supprimée.
            }
            size--;
            return current;
        }

        return null;
    }

    /**
     * Affiche toutes les valeurs des cellules de la liste dans l'ordre.
     * Format : [valeur1 -> valeur2 -> valeur3 -> ... -> null]
     */
    public void print() {
        Cell c = head; // Commence à la tête de liste.

        if (head == null) {
            System.out.println("La liste est vide.");
            return;
        }
        while (c != null) {
            System.out.print(c.value + "->");
            c = c.next;
        }
        System.out.println("null");
    }
}

// Pour générer la JavaDoc au format HTML
//& "C:\Program Files\Java\jdk-17\bin\javadoc.exe" -d docs -encoding UTF-8 -docencoding UTF-8 -charset UTF-8 "CellDouble.java"

