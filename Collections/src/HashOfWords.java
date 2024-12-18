import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * La classe {@code HashOfWords} est un programme de test permettant de trouver des mots parmis des collections à
 * l'aide de boucles `for`.
 *
 * Ce qui nous constraint fortement car on ne peut pas intéragir avec la liste à part l'itérer.
 */
public class HashOfWords {
    private HashMap<Integer, String> hashMap;

    /**
     * Constructeur par défaut.
     * Initialise la table de hachage avec les mots du fichier `french_words.txt`.
     * @throws IOException si le fichier ne peut pas être lu.
     */
    public HashOfWords() throws IOException {
        hashMap = new HashMap<>();
        // On essaie de récuperer les mots dans le file french_words.txt
        try (BufferedReader br = new BufferedReader(new FileReader("french_words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Ajoutez un couple {clé, valeur}
                hashMap.put(line.hashCode(), line);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Recherche les mots dans la liste en utilisant la méthode `containsValue` de `HashMap`.
     * @param words Liste des mots à rechercher.
     * @return Une liste des mots suivis de " YES" ou " NO".
     */
    public ArrayList<String> findValuesList(ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            if (hashMap.containsValue(word)) {
                result.add(word + " YES");
            } else {
                result.add(word + " NO");
            }
        }
        return result;
    }

    /**
     * Recherche les mots dans la liste en utilisant une conversion des valeurs de `HashMap` en `HashSet`.
     * @param words Liste des mots à rechercher.
     * @return Une liste des mots suivis de " YES" ou " NO".
     */
    public ArrayList<String> findValuesToSet(ArrayList<String> words) {
        // Transfert des valeurs dans un HashSet
        HashSet<String> valueSet = new HashSet<>(hashMap.values());
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            if (valueSet.contains(word)) {
                result.add(word + " YES");
            } else {
                result.add(word + " NO");
            }
        }
        return result;
    }

    /**
     * Recherche les mots dans la liste en utilisant la méthode `containsKey` de `HashMap`.
     * @param words Liste des mots à rechercher.
     * @return Une liste des mots suivis de " YES" ou " NO".
     */
    public ArrayList<String> findKeys(ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            if (hashMap.containsKey(word.hashCode())) {
                result.add(word + " YES");
            } else {
                result.add(word + " NO");
            }
        }
        return result;
    }
}
