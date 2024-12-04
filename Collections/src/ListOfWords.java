import java.io.*;
import java.util.*;

/**
 * La classe {@code ListOfWord} représentant une liste de mots avec des fonctionnalités pour la sélection aléatoire
 * et la recherche de mots.
 */
public class ListOfWords {
    private ArrayList<String> wordsList;

    /**
     * Constructeur qui initialise la liste des mots en chargeant un fichier texte contenant
     * les mots français.
     */
    public ListOfWords() {
        // Liste qui stock les mots de french_words.txt
        wordsList = new ArrayList<>();
        try {
            // Lecture du fichier contenant les mots français
            BufferedReader br = new BufferedReader(new FileReader("french_words.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                wordsList.add(line.trim()); // Ajoute chaque mot dans la liste sans espace/saut de ligne/tab
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    /**
     * Sélectionne aléatoirement un certain nombre de mots dans la liste.
     *
     * @param nbElements le nombre de mots à sélectionner.
     * @return une {@code ArrayList<String>} contenant les mots sélectionnés aléatoirement.
     */
    public ArrayList<String> randomSelect(int nbElements) {
        // Liste avec les mots a trouver dans la liste de french_words.txt
        ArrayList<String> selectedWords = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < nbElements; i++) {
            // Sélectionne un index aléatoire parmis la liste de mots francais
            int randomIndex = random.nextInt(wordsList.size());
            // Ajout dans selectedWords un mot avec son index
            selectedWords.add(wordsList.get(randomIndex));
        }
        return selectedWords;
    }

    /**
     * Vérifie si les mots d'une liste donnée sont présents dans la liste principale des mots.
     *
     * @param inputWords une liste de mots à chercher.
     * @return une {@code ArrayList<String>} contenant chaque mot suivi de " YES" (si trouvé)
     * ou " NO" (si absent).
     */
    public ArrayList<String> find(ArrayList<String> inputWords) {
        ArrayList<String> foundWords = new ArrayList<>();
        // Each word in inputWords à found
        for (String word : inputWords) {
            // Utilisation de contains pour chercher au sein de la liste
            if (wordsList.contains(word)) {
                foundWords.add(word + " YES");
            } else {
                foundWords.add(word + " NO");
            }
        }
        return foundWords;
    }
}
