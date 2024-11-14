/**
 * Représente une liste doublement chaînée circulaire.
 * Cette liste permet de stocker des éléments dans des cellules reliées entre elles,
 * avec des pointeurs vers les cellules précédentes et suivantes. La liste est circulaire,
 * ce qui signifie que le dernier élément pointe vers le premier, et vice versa.
 */
public class ListDoubleCirc {

    /**
     * La première cellule de la liste (tête).
     */
    public CellDouble head;

    /**
     * La taille actuelle de la liste.
     */
    public int size;

    /**
     * Constructeur par défaut. Crée une liste vide.
     */
    public ListDoubleCirc() {
        head = null;
        size = 0;
    }

    /**
     * Trouve une cellule contenant la valeur spécifiée.
     *
     * @param value La valeur de la cellule à rechercher.
     * @return La cellule trouvée ou null si la valeur n'est pas présente dans la liste.
     */
    public CellDouble find(int value) {
        if (head == null) return null;

        CellDouble current = head;

        do {
            if (current.value == value) {
                return current;
            }
            current = current.next;
        } while (current != head);

        return null;
    }

    /**
     * Récupère la cellule à l'index spécifié.
     * Si l'index est invalide, retourne null.
     *
     * @param index L'index de la cellule à récupérer.
     * @return La cellule à l'index spécifié, ou null si l'index est invalide.
     */
    public CellDouble get(int index) {
        if ((index < 0) || (index >= size)) return null;  // Vérifie que l'index est valide.

        CellDouble current;
        int i;

        // Si l'index est dans la première moitié, on commence du début.
        if (index < size / 2) {
            current = head;
            i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
        } else {
            // Si l'index est dans la deuxième moitié, on commence de la fin.
            current = head.prev;
            i = size - 1;
            while (i > index) {
                current = current.prev;
                i--;
            }
        }
        return current;
    }

    /**
     * Ajoute un élément à la fin de la liste.
     * Si la liste est vide, le nouvel élément devient la tête.
     *
     * @param value La valeur à ajouter à la fin de la liste.
     * @return La cellule ajoutée à la fin de la liste.
     */
    public CellDouble append(int value) {
        if (head == null) {
            head = new CellDouble(value);
            head.next = head;  // La tête pointe vers elle-même.
            head.prev = head;  // La tête pointe vers elle-même.
            size++;
            return head;
        }

        // Si la liste n'est pas vide, on ajoute un élément à la fin.
        CellDouble append = new CellDouble(value);
        CellDouble last = head.prev;    // Dernière cellule de la liste.

        last.next = append;            // La cellule précédente pointe vers le nouvel élément.
        append.prev = last;            // Le nouvel élément pointe vers la dernière cellule.
        append.next = head;            // Le nouvel élément pointe vers la tête (circularité).
        head.prev = append;            // La tête pointe vers le nouvel élément comme dernier élément.

        size++;
        return append;
    }

    /**
     * Ajoute un élément au début de la liste.
     * Si la liste est vide, le nouvel élément devient la tête.
     *
     * @param value La valeur à ajouter au début de la liste.
     * @return La cellule ajoutée au début de la liste.
     */
    public CellDouble prepend(int value) {
        if (head == null) {
            head = new CellDouble(value);
            head.next = head;  // La tête pointe vers elle-même.
            head.prev = head;  // La tête pointe vers elle-même.
            size++;
            return head;
        }

        // Ajouter un élément avant la tête existante.
        CellDouble prepend = new CellDouble(value);
        CellDouble first = head;
        CellDouble last = first.prev;

        // Mise à jour des pointeurs de la nouvelle cellule.
        prepend.prev = last;    // La nouvelle cellule pointe vers l'ancienne dernière cellule.
        prepend.next = first;   // La nouvelle cellule pointe vers la tête.

        // Mise à jour des pointeurs de l'ancienne dernière cellule et de l'ancienne tête.
        last.next = prepend;    // L'ancienne dernière cellule pointe vers la nouvelle cellule.
        first.prev = prepend;   // L'ancienne tête pointe maintenant vers la nouvelle cellule comme précédent.

        // La tête devient la nouvelle cellule.
        head = prepend;         // La nouvelle cellule devient la tête de la liste.

        size++;
        return prepend;
    }

    /**
     * Insère un élément à l'index spécifié.
     * Si l'index est invalide ou si la liste est vide, retourne null.
     *
     * @param value La valeur à insérer.
     * @param index L'index où insérer la valeur.
     * @return La cellule insérée, ou null si l'index est invalide.
     */
    public CellDouble insert(int value, int index) {
        if (index < 0) return prepend(value);
        if (index >= size) return append(value);

        // Si la liste est vide, insère le premier élément.
        if (head == null) {
            head = new CellDouble(value);
            head.next = head;  // La tête pointe vers elle-même.
            head.prev = head;  // La tête pointe vers elle-même.
            size++;
            return head;
        }

        // Cas général pour insertion à un autre indice.
        if (index == size) {  // Cas d'insertion à la fin.
            return append(value);
        }

        // Chercher la cellule à insérer avant.
        CellDouble previous = get(index - 1);  // Trouver la cellule avant l'insertion.
        CellDouble next = previous.next;       // La cellule qui suit.

        // Créer la nouvelle cellule à insérer.
        CellDouble insert = new CellDouble(value);

        // Mettre à jour les pointeurs.
        insert.prev = previous;   // La nouvelle cellule pointe vers la cellule précédente.
        insert.next = next;       // La nouvelle cellule pointe vers la cellule suivante.

        // Mettre à jour les pointeurs des cellules voisines.
        previous.next = insert;   // La cellule précédente pointe vers la nouvelle cellule.
        next.prev = insert;       // La cellule suivante pointe vers la nouvelle cellule.

        size++;
        return insert;
    }

    /**
     * Remplace la valeur d'une cellule à un index spécifié.
     * Si l'index est invalide, retourne null.
     *
     * @param value La nouvelle valeur à insérer.
     * @param index L'index de la cellule à remplacer.
     * @return La cellule modifiée ou null si l'index est invalide.
     */
    public CellDouble replace(int value, int index) {
        // Vérifie si l'index est valide. Si l'index est hors limites, retourne null.
        if (index < 0 || index > size) return null;

        // Récupère la cellule à l'index spécifié.
        CellDouble replace = get(index);

        // Remplace la valeur de la cellule.
        replace.value = value;

        // Retourne la cellule modifiée.
        return replace;
    }

    /**
     * Supprime l'élément à l'index spécifié de la liste.
     *
     * @param index L'index de l'élément à supprimer.
     * @return La cellule supprimée ou null si l'index est invalide.
     */
    public CellDouble removeAt(int index) {
        // Vérifie si l'index est valide. Si l'index est en dehors des limites, retourne null.
        if (index < 0 || index >= size) return null;

        // Récupère la cellule à supprimer à l'index spécifié.
        CellDouble toRemove = get(index);
        CellDouble previous = toRemove.prev;  // Cellule avant celle à supprimer.
        CellDouble next = toRemove.next;      // Cellule après celle à supprimer.

        // Mise à jour des pointeurs pour les cellules voisines :
        previous.next = next;   // La cellule précédente pointe vers la cellule suivante.
        next.prev = previous;   // La cellule suivante pointe vers la cellule précédente.

        // Si la cellule à supprimer est la tête, il faut mettre à jour la tête.
        if (toRemove == head) {
            head = next;  // La tête devient la cellule suivante.
        }

        // La taille de la liste est réduite après la suppression de l'élément.
        size--;

        // Retourne la cellule supprimée pour éventuellement utiliser sa valeur ou d'autres informations.
        return toRemove;
    }

    /**
     * Supprime la première cellule contenant la valeur spécifiée.
     * Si la cellule n'est pas trouvée, retourne null.
     *
     * @param value La valeur de la cellule à supprimer.
     * @return La cellule supprimée, ou null si la valeur n'est pas présente dans la liste.
     */
    public CellDouble remove(int value) {
        // Recherche de la cellule contenant la valeur à supprimer.
        CellDouble toRemove = find(value);

        // Si la cellule n'est pas trouvée, on retourne null.
        if (toRemove == null) return null;

        // On appelle removeAt() pour supprimer cette cellule, mais on doit d'abord connaître son index.
        int index = 0;
        CellDouble current = head;

        // Parcours de la liste pour trouver l'index de la cellule à supprimer.
        while (current != toRemove) {
            current = current.next;
            index++;  // Incrémentation de l'index à chaque itération.
        }

        // Appel de la méthode removeAt pour effectuer la suppression à l'index trouvé.
        return removeAt(index);
    }

    /**
     * Affiche la liste sous forme de chaîne de caractères.
     * Si la liste est vide, retourne un message indiquant que la liste est vide.
     *
     * @return La représentation sous forme de chaîne de caractères de la liste.
     */
    public void print() {
        if (head == null) {
            System.out.println("La liste est vide");
            return;
        }

        CellDouble current = head;
        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

}
