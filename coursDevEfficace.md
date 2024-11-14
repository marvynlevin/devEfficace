# Cours Developpement Efficace

En Java, on a une classe Cellule `Cell.java` qui représente une Cellule pour notre Liste

```bash
[1, null] -> [2, null] -> [3, null] -> |///
```

```java
// class Cell.java
public class Cell {
    public int value;
    public Cell next;
    public Cell(int value) {
        this.value = value;
        next = null;
    }
}
```

```java
// class List.java
public class List {
    public Cell head;
    public int size;
    public List() {
        head = null;
        size = 0;
    }
    // Reste du code ci-dessous
}
```

Maintenant on souhaite renvoyer une cellule par la méthode `public Cell find (int value) {}`.

```java
public Cell find (int value) {
    Cell c = head;
    while ((c != null) && (c.value != value)) {
        c = c.next;
    }
    return c;
}
```

Maintenant on souhaite renvoyer la valeur d'une cellule par la méthode `public Cell get (int index) {}`.

```java
public Cell get (int index) {
    Cell c = head;
    int i = 0;
    while ((c != null) && (i < index)) {
        c = c.next;
        i += 1;
    }
}
```

On souhaite ajouter une valeur a la liste par la méthode `public Cell append (int value) {}`.

```java
public Cell append (int value) {
    Cell c = null;
    Cell newCell = new Cell (value);
    if (size == 0) {
        head = newCell;
    } else {
        c = get(size - 1);
        c.next = newCell;
    }
    size += 1;
    return newCell;
}
```

On souhaite ajouter une valeur à un index précis par la méthode `public Cell insert (int value, int index) {}`.

```java
public Cell insert (int value, int index) {
    Cell c = null;
    Cell newCell = new Cell(value);
    if (index > size) { index = size; }
    if (size == 0) { head = newCell; }
    else if (index == 0) {
        newCell.next = head;
        head = newCell;
    } else {
        c = get(index-1);
        newCell.next = c.next;
        c.next = newCell;
    }
    size += 1;
    return newCell;
}
```

On souhaite maintenant remplacer une valeur par la méthode `public Cell replace (int replace, int index) {}`.

```java
public Cell replace (int value, int index) {
    if ((index<0) && (index >= size)) return null;
    Cell c = get(index);
    c.value = value;
    return c;
}
```


