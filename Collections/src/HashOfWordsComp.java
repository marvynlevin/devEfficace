import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * La classe {@code HashOfWordsComp} permet de gérer différents types de Map et de rechercher des mots à l'aide
 * d'itérateurs sur les valeurs, les clés ou en convertissant les valeurs en HashSet.
 */
public class HashOfWordsComp {
    private Map<Integer, String> map;

    /**
     * Constructeur pour initialiser la Map selon le type spécifié (0 pour HashMap, 1 pour TreeMap, 2 pour LinkedHashMap).
     *
     * @param mapType Le type de Map à utiliser (0=HashMap, 1=TreeMap, 2=LinkedHashMap).
     * @throws IOException Si le fichier french_words.txt ne peut pas être lu.
     */
    public HashOfWordsComp(int mapType) throws IOException {
        // Initialisation de la Map selon le type choisi
        switch (mapType) {
            case 0:
                map = new HashMap<>();
                break;
            case 1:
                map = new TreeMap<>();
                break;
            case 2:
                map = new LinkedHashMap<>();
                break;
            default:
                throw new IllegalArgumentException("Type de map invalide: " + mapType);
        }
        loadWords();
    }

    /**
     * Charge les mots depuis le fichier `french_words.txt` dans la Map.
     * Utilise hashCode comme clé.
     *
     * @throws IOException Si une erreur se produit lors de la lecture du fichier.
     */
    private void loadWords() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("french_words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                map.put(line.hashCode(), line); // Utilise le hashCode du mot comme clé
            }
        }
    }

    /**
     * Recherche les mots dans les valeurs de la Map en utilisant containsValue avec un iterator.
     *
     * @param words Liste des mots à rechercher.
     * @return Liste des mots avec "YES" ou "NO" pour indiquer leur présence.
     */
    public ArrayList<String> findValuesList(ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        Iterator<String> wordIterator = words.iterator();
        while (wordIterator.hasNext()) {
            String word = wordIterator.next();
            result.add(word + (map.containsValue(word) ? " YES" : " NO"));
        }
        return result;
    }

    /**
     * Recherche les mots dans les valeurs de la Map après les avoir converties en un HashSet, avec un iterator.
     *
     * @param words Liste des mots à rechercher.
     * @return Liste des mots avec "YES" ou "NO" pour indiquer leur présence.
     */
    public ArrayList<String> findValuesToSet(ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> valueSet = new HashSet<>();
        // Utilisation d'un iterator pour ajouter les valeurs de la Map dans un HashSet
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            valueSet.add(entry.getValue());
        }

        Iterator<String> wordIterator = words.iterator();
        while (wordIterator.hasNext()) {
            String word = wordIterator.next();
            result.add(word + (valueSet.contains(word) ? " YES" : " NO"));
        }
        return result;
    }

    /**
     * Recherche les mots dans les clés de la Map en utilisant un iterator sur les clés de la Map.
     *
     * @param words Liste des mots à rechercher.
     * @return Liste des mots avec "YES" ou "NO" pour indiquer leur présence.
     */
    public ArrayList<String> findKeys(ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        Iterator<String> wordIterator = words.iterator();
        while (wordIterator.hasNext()) {
            String word = wordIterator.next();
            int hashCode = word.hashCode();
            result.add(word + (map.containsKey(hashCode) ? " YES" : " NO"));
        }
        return result;
    }
}