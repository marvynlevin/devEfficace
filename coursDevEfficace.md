# Cours Developpement Efficace

## Introduction aux Listes simples en Java

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

## Les Collections en Java

- **Set** : ensemble d'objets non indicé, sans doublons
- **List** : ensemble d'objets non indicé, éventuellement avec doublons
- **Map** : ensemble associatif d'objets, non indicé, chaque objet étant associé à une clé
    - Une clé est unique dans **Map** mais plusieurs clés peuvent être associées à un même objet.
- **Queue** : ensemble d'objets, non indicé avec un schéma d'accès de type FIFO/LIFO
    - **FIFO** : First In First out
    - **LIFO** : Last In First Out

Les piles sont souvent utilisés en programmation.

En **réalité**, Set, List, Map et Queue sont des interfaces.

En **pratique**, on utilise les implémentations HashSet, ArrayList, HashMap, ArrayDeque.
Ces collections sont génériques : 
```java
// On ne peut pas écrire cela
Set <int> set = new HashMap<int>();

// On écrit plutôt cela
Set <Integer> set = new HashMap<Integer>();
Set <Integer> set = new HashMap<>();

// ------------------
// Methodes communes
// ------------------
// int size();
// void clear();
// boolean istemply();
```

**HashSet:**
- **boolean add(E e)**: ajoute l'élement e de la classe E. Si E n'est pas de la classe (même classe) indiquée par constructeur, erreur compil. Renvoie vrai si l'insertion a lieu.
- **boolean remove(Object o)**: enlève o s'il existe et renvoie true, sinon false, pas d'erreur de compil si o n'est pas de la même classe.
- **boolean contains(Object o)**: 

Exemple :

```java
public class A {}
public class B extends A {}

Set<A> set = new HashSet<>();

set.add(new A());
set.add(new A());
set.add(new B());

set.add(new Date()); // Cette ligne provoque erreur compil car Date pas enfant de A
```

**ArrayList:**
- **boolean add(E e)**: ajoute en fin de liste.
- **void add(int index, E e)**: insertion en index. Si index < 0 ou index > taille liste, ne fait rien et lève une exception.
- **E get(int index)** : retourne l'élément à l'index spécifié.
- **int indexOf(Object o)** : retourne l'index de la première occurrence de l'élément o, ou -1 si l'élément n'est pas trouvé.
- **E remove(int index)** : supprime et retourne l'élément à l'index spécifié.

Exemple :

```java
import java.util.ArrayList;

public class A {}
public class B extends A {}

List<A> list = new ArrayList<>();
A a1 = new A();
A a2 = new A();
Date d = new Date();

list.add(a1);
list.add(a2);
list.add(d);
list.add(15, a1); // Erreur d'éxecution

A aa = null;
aa = list.get(0); // aa référence le même objet que a1
aa = list.remove(1); // aa référence le même objet que a2
int pos = list.indexOf(a1); // Ok, renvoie 0
pos = list.indexOf(d); // Ok, renvoie -1
```




