import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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
        // Initialiser la liste french_word.txt
        Iterator<String> wordIterator = words.iterator();

        // Lecture des mots un à un
        while (wordIterator.hasNext()) {
            // Récupère le premier mot et pointe maintenant sur le prochain mot
            String word = wordIterator.next();
            // Initialiser la liste des mots à found
            Iterator<String> iterator = hashMap.values().iterator();
            boolean found = false;

            // True si encore des mots, false sinon, et ainsi ensuite on retourne si YES ou NOT found
            while (iterator.hasNext()) {
                // Récupère le premier mot à trouver et pointe ensuite vers le prochain
                String wordHasFound = iterator.next();
                // Check si les mots à trouver se trouvent ou non dans les mots du file french_words.txt
                if (wordHasFound.equals(word)) {
                    found = true;
                    break;
                }
            }
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
        // Transfert des valeurs dans un HashSet
        valueSet.addAll(hashMap.values());
        // Initialiser la liste french_word.txt
        Iterator<String> wordIterator = words.iterator();

        // TODO
        while (wordIterator.hasNext()) {
            String word = wordIterator.next();
            Iterator<String> iterator = hashMap.values().iterator();
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
        // Initialiser la liste french_word.txt
        Iterator<String> wordIterator = words.iterator();

        // TODO

        return result;
    }
}
