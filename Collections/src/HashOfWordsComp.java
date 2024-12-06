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
                map = new HashMap<>(); // Organise en fonction d'insertion {key, value} (efficace avec une clé hashCode())
                break;
            case 1:
                map = new TreeMap<>(); // Trier dans l'ordre croissant {key, value} (recherche)
                break;
            case 2:
                map = new LinkedHashMap<>(); // Organise en fonction d'insertion {key, value} (insertions)
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
                map.put(line.hashCode(), line); // Utilise le hashCode du mot comme clé et line comme valeur
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
        // Liste retournée
        ArrayList<String> result = new ArrayList<>();

        // Initialiser l'iterator pour les mots à rechercher
        Iterator<String> wordIterator = words.iterator();

        // Lecture des mots un à un
        while (wordIterator.hasNext()) {
            // Récupère le premier mot et pointe maintenant sur le prochain mot
            String word = wordIterator.next();

            boolean found = map.containsValue(word);

            result.add(word + (found ? " YES" : " NO"));
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
        // Liste retournée
        ArrayList<String> result = new ArrayList<>();
        // Initialiser la liste HashSet des mots à trouver
        HashSet<String> valueSet = new HashSet<>();

        // Utiliser un iterator pour ajouter les valeurs du HashMap dans le HashSet
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
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
     * Recherche les mots dans les clés de la Map en utilisant un iterator sur les clés de la Map.
     *
     * @param words Liste des mots à rechercher.
     * @return Liste des mots avec "YES" ou "NO" pour indiquer leur présence.
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
            boolean found = map.containsKey(hashCode);

            result.add(word + (found ? " YES" : " NO"));
        }

        return result;
    }
}