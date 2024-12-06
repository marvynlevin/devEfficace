import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * La classe {@code HashOfWordsIterator} est un programme de test permettant de trouver des mots parmi des collections à
 * l'aide de la lib util `Iterator`.
 */
public class HashOfWordsIterator {
    private HashMap<Integer, String> hashMap;

    /**
     * Constructeur par défaut.
     * Initialise la table de hachage avec les mots du fichier `french_words.txt`.
     * @throws IOException si le fichier ne peut pas être lu.
     */
    public HashOfWordsIterator() throws IOException {
        hashMap = new HashMap<>();
        // On essaie de récuperer les mots dans le file french_words.txt
        try (BufferedReader br = new BufferedReader(new FileReader("french_words.txt"))) {
            String line;
//            int key = 0;
            // Lecture ligne par ligne
            while ((line = br.readLine()) != null) {
                // Ajoutez un couple {clé, valeur}
//                hashMap.put(key, line);
                hashMap.put(line.hashCode(), line);
//                key++;
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Recherche les mots dans la liste en utilisant un parcours avec un iterator sur les valeurs de `HashMap`.
     *
     * @param words Liste des mots à rechercher.
     * @return Une liste des mots suivis de "YES" ou "NO".
     */
    public ArrayList<String> findValuesList(ArrayList<String> words) {
        // Liste retournée
        ArrayList<String> result = new ArrayList<>();

        // Initialiser l'iterator pour les mots à rechercher
        Iterator<String> wordIterator = words.iterator();

        // Lecture des mots un à un
        while (wordIterator.hasNext()) {
            // Récupère le premier mot et pointe maintenant sur le prochain mot
            String word = wordIterator.next();

            boolean found = hashMap.containsValue(word);

            result.add(word + (found ? " YES" : " NO"));
        }

        return result;
    }


    /**
     * Recherche les mots dans la liste en convertissant les valeurs de `HashMap` en un `HashSet`.
     *
     * @param words Liste des mots à rechercher.
     * @return Une liste des mots suivis de "YES" ou "NO".
     */
    public ArrayList<String> findValuesToSet(ArrayList<String> words) {
        // Liste retournée
        ArrayList<String> result = new ArrayList<>();
        // Initialiser la liste HashSet des mots à trouver
        HashSet<String> valueSet = new HashSet<>();

//        HashSet des valeurs : [Toto, Titi, Tata]
//        HashSet des clés : [1, 2, 3]
//        HashSet des entrées : [1=Toto, 2=Titi, 3=Tata]

        // Utiliser un iterator pour ajouter les valeurs du HashMap dans le HashSet
        Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            // Récupérer la prochaine entrée (clé-valeur)
            Map.Entry<Integer, String> entry = iterator.next();
            // Ajouter la valeur de chaque entrée
            valueSet.add(entry.getValue());
        }

        // Initialiser l'iterator pour les mots à rechercher
        Iterator<String> wordIterator = words.iterator();
        // Parcours de la liste des mots à rechercher
        while (wordIterator.hasNext()) {
            String word = wordIterator.next();
            boolean found = valueSet.contains(word);
            result.add(word + (found ? " YES" : " NO"));
        }

        return result;
    }

    /**
     * Recherche les mots dans la liste en utilisant un iterator pour parcourir les clés de `HashMap`.
     *
     * @param words Liste des mots à rechercher.
     * @return Une liste des mots suivis de "YES" ou "NO".
     */
    public ArrayList<String> findKeys(ArrayList<String> words) {
        // Liste retournée
        ArrayList<String> result = new ArrayList<>();

        // Initialiser un iterator pour la liste des mots
        Iterator<String> wordIterator = words.iterator();

        // Parcours des mots un à un
        while (wordIterator.hasNext()) {
            String word = wordIterator.next();

            // Calculer la valeur hachée du mot
            int hashCode = word.hashCode();

            boolean found = hashMap.containsKey(hashCode);

            result.add(word + (found ? " YES" : " NO"));
        }

        return result;
    }
}
