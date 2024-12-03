import java.util.ArrayList;

/**
 * Classe principale pour tester les performances de recherche de mots dans une liste.
 * <p>
 * Cette application utilise une instance de {@link ListOfWords} pour charger une liste
 * de mots depuis un fichier et mesurer le temps nécessaire pour vérifier si un sous-ensemble
 * de mots appartient à la liste complète.
 * </p>
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
        int nbElements = 10;

        ListOfWords lWords = new ListOfWords();

        // Sélection aléatoire de mots à partir de la liste complète.
        ArrayList<String> l = lWords.randomSelect(nbElements);

        // Décommenter pour afficher les mots sélectionnés.
//        System.out.println("ADD :");
//        for (String s : l) {
//             System.out.println(s);
//         }

        // Mesure du temps pour vérifier si les mots sélectionnés sont présents dans la liste complète.
        long start = System.currentTimeMillis();
        ArrayList<String> lfound = lWords.find(l);
        long end = System.currentTimeMillis();
        long timeElapsed = end - start;

        // Décommenter pour afficher les résultats.
//        System.out.println("RESULTS :");
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
// PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> javac *.java
// PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> java AppList
// andorrans
// ressemble
// Laurent
// rapiditÃƒÂ©
// andelysienne
// chronologique
// mono-
// ÃƒÂ©tatique
// espÃƒÂ¨ces
// durant

// andorrans yes
// ressemble yes
// Laurent yes
// rapiditÃƒÂ© yes
// andelysienne yes
// chronologique yes
// mono- yes
// ÃƒÂ©tatique yes
// espÃƒÂ¨ces yes
// durant yes
// time with List 7 ms

// ----------------------------
// 10.000 mots
// ----------------------------
// PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> javac *.java
// PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> java AppList
// time with List 458 ms


// ----------------------------
// 20.000 mots
// ----------------------------
// PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> javac *.java
// PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> java AppList
// time with List 809 ms
