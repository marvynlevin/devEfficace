import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * La classe {@code HashOfWordsIterator} est un programme de test permettant de trouver des mots parmis des collections à
 * l'aide de la lib util `Iterator`.
 *
 * Ce qui nous permet de mieux moduler ce que l'on souhaite faire avec la liste.
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
        try (BufferedReader br = new BufferedReader(new FileReader("french_words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                hashMap.put(line.hashCode(), line);
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
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            Iterator<String> iterator = hashMap.values().iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                if (iterator.next().equals(word)) {
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
        HashSet<String> valueSet = new HashSet<>(hashMap.values());
        Iterator<String> setIterator = valueSet.iterator();
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            boolean found = false;
            while (setIterator.hasNext()) {
                if (setIterator.next().equals(word)) {
                    found = true;
                    break;
                }
            }
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
        ArrayList<String> result = new ArrayList<>();
        Iterator<Integer> keyIterator = hashMap.keySet().iterator();
        for (String word : words) {
            boolean found = false;
            while (keyIterator.hasNext()) {
                if (keyIterator.next().equals(word.hashCode())) {
                    found = true;
                    break;
                }
            }
            result.add(word + (found ? " YES" : " NO"));
        }
        return result;
    }
}
