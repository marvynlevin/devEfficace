import java.util.ArrayList;

/**
 * Classe AppList
 * <p>
 * Cette classe teste les performances de recherche de mots dans une liste.
 * Elle compare les temps de recherche pour différents nombres de mots sélectionnés
 * dans une liste complète de mots. Les tests mesurent le temps nécessaire pour vérifier
 * si un sous-ensemble de mots appartient à la liste complète.
 * </p>
 * <ul>
 *     <li>ListOfWords : une classe qui gère la liste complète de mots.</li>
 *     <li>ArrayList : la classe ArrayList de l'API Java, utilisée pour stocker les mots sélectionnés.</li>
 * </ul>
 * <pre>
 * Usage :
 * java AppList
 * </pre>
 * <p>
 * Les résultats des tests sont affichés sous forme de temps d'exécution en millisecondes.
 * </p>
 * <p>
 * Dépendances : La classe <code>ListOfWords</code> doit être définie dans le projet et doit fournir les méthodes
 * <code>randomSelect(int)</code> et <code>find(ArrayList)</code> pour la sélection et la recherche des mots.
 * </p>
 *
 * @author Marvyn Levin
 * @version 1.0
 * @date 01/12/2024
 *
 * @see ListOfWords
 */
public class AppList {
    /**
     * Méthode principale pour exécuter le programme.
     *
     * @param args Les arguments de la ligne de commande (non utilisés ici).
     * @throws Exception Si une erreur survient lors de la lecture du fichier ou des opérations sur la liste.
     */
    public static void main(String[] args) throws Exception {
        // Nombre d'éléments à sélectionner aléatoirement dans la liste des mots.
        int nbElements = 10000;

        ListOfWords lWords = new ListOfWords();

        // Sélection aléatoire de mots à partir de la liste complète.
        ArrayList<String> l = lWords.randomSelect(nbElements);

        // Décommenter pour afficher les mots sélectionnés.
//        for (String s : l) {
//             System.out.println(s);
//         }

        // Mesure du temps pour vérifier si les mots sélectionnés sont présents dans la liste complète.
        long start = System.currentTimeMillis();
        ArrayList<String> lfound = lWords.find(l);
        long end = System.currentTimeMillis();
        long timeElapsed = end - start;

        // Décommenter pour afficher les résultats.
//         for (String s : lfound) {
//             System.out.println(s);
//         }

        // Affichage du temps d'exécution.
        System.out.println("time with List " + timeElapsed + " ms");
    }
}

// EXECUTION

// ----------------------------
// 10 mots
// ----------------------------
//PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> javac *.java
//PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> java AppList
//commercial
//comparez
//usure
//Stockholm
//ÃƒÂ©nergÃƒÂ©tique
//Horn
//FranÃƒÂ§oise
//pensez
//assassinÃƒÂ©
//compÃƒÂ©titivitÃƒÂ©
//commercial YES
//comparez YES
//usure YES
//Stockholm YES
//ÃƒÂ©nergÃƒÂ©tique YES
//Horn YES
//FranÃƒÂ§oise YES
//pensez YES
//assassinÃƒÂ© YES
//compÃƒÂ©titivitÃƒÂ© YES
//time with List 9 ms

// ----------------------------
// 10.000 mots
// ----------------------------
// time with List 458 ms


// ----------------------------
// 20.000 mots
// ----------------------------
// time with List 809 ms


// ----------------------------
// 30.000 mots
// ----------------------------
//time with List 1298 ms

// ----------------------------
// 40.000 mots
// ----------------------------
//time with List 1509 ms

// ----------------------------
// 50.000 mots
// ----------------------------
//time with List 1832 ms

// ----------------------------
// 100.000 mots
// ----------------------------
//time with List 4197 ms



// ----------------------------
// RESULTATS
// ----------------------------
// La tendance des temps d'exécution est globalement linéaire par rapport au nombre de mots, ce qui indique que le
// coût de recherche dans la liste augmente proportionnellement à sa taille. Cela reflète la complexité temporelle
// O(n) d'une recherche séquentielle dans une structure de type liste.
