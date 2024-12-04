import java.util.ArrayList;

/**
 * La classe {@code AppHash} est un programme de test permettant de comparer
 * les performances de recherche de mots dans une liste et dans une table de hachage.
 * Le programme utilise différentes méthodes pour vérifier si des mots aléatoires
 * sont présents dans un ensemble de mots préchargés.
 */
public class AppHash {

    /**
     * Méthode principale pour exécuter les tests de performance.
     *
     * @param args Arguments de la ligne de commande (non utilisés).
     * @throws Exception Si un problème survient lors de la lecture des fichiers de mots.
     */
    public static void main(String[] args) throws Exception {
        int nbElements = 100000;

        // Chargement des mots dans une liste et génération de mots aléatoires
        ListOfWords lWords = new ListOfWords();
        ArrayList<String> l = lWords.randomSelect(nbElements);

        // Affichage des mots générés
        for (String s : l) {
//             System.out.println(s);
        }

        // Test avec les listes de l'ancien exercice
        long start = System.currentTimeMillis();
        ArrayList<String> lfound = lWords.find(l);
        long end = System.currentTimeMillis();
        long timeElapsed = end - start;

        // Affichage des résultats pour la liste
        for (String s : lfound) {
//             System.out.println(s);
        }
        System.out.println("time with List " + timeElapsed + "ms");

        // Test des HashMap/Set key/value
//        HashOfWords hWords = new HashOfWords();
        HashOfWordsIterator hWords = new HashOfWordsIterator();

        // Test HashMap avec containsValue
        start = System.currentTimeMillis();
        lfound = hWords.findValuesList(l);
        end = System.currentTimeMillis();
        timeElapsed = end - start;
        System.out.println("time with HashMap values List " + timeElapsed + "ms");

        // Test HashMap converti en HashSet
        start = System.currentTimeMillis();
        lfound = hWords.findValuesToSet(l);
        end = System.currentTimeMillis();
        timeElapsed = end - start;
//        System.out.println("time with HashMap values converted to Set " + timeElapsed + "ms");

        // Test HashMap avec containsKey
        start = System.currentTimeMillis();
        lfound = hWords.findKeys(l);
        end = System.currentTimeMillis();
        timeElapsed = end - start;

        // Affichage des résultats pour containsKey (désactivé ici)
        // for (String s : lfound) {
        //     System.out.println(s);
        // }
//        System.out.println("time with HashMap keys " + timeElapsed + "ms");
    }
}


// EXECUTION HashOfWords FOR
// ----------------------------
// 10 mots
// ----------------------------
// PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> javac *.java
// PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> java AppHash
//prÃƒÂ©cisant
//EDF
//condamnable
//passera
//applaudir
//foin
//comprise
//annuellement
//astrakan
//mÃƒÂ©contentement
//time with List 9ms
//time with HashMap values List 8ms
//time with HashMap values converted to Set 11ms
//time with HashMap keys 5ms

// ----------------------------
// 1.000 mots
// ----------------------------
//time with List 78ms
//time with HashMap values List 302ms
//time with HashMap values converted to Set 7ms
//time with HashMap keys 1ms

// ----------------------------
// 10.000 mots
// ----------------------------
//time with List 659ms
//time with HashMap values List 2835ms
//time with HashMap values converted to Set 10ms
//time with HashMap keys 4ms

// ----------------------------
// 100.000 mots
// ----------------------------
//time with List 5435ms
//time with HashMap values List 26468ms
//time with HashMap values converted to Set 37ms
//time with HashMap keys 31ms



// EXECUTION HashOfWords ITERATOR
// ----------------------------
// 10 mots
// ----------------------------
//PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> javac *.java
//PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> java AppHash
//quantitÃƒÂ©
//Autrichienne
//foulard
//pullulation
//Morbihan
//rectifier
//contrition
//attribuer
//Frank
//cortÃƒÂ¨ge
//quantitÃƒÂ© YES
//Autrichienne YES
//foulard YES
//pullulation YES
//Morbihan YES
//rectifier YES
//contrition YES
//attribuer YES
//Frank YES
//cortÃƒÂ¨ge YES
//time with List 10ms
//time with HashMap values List 7ms

// ----------------------------
// 1.000 mots
// ----------------------------
//time with List 73ms
//time with HashMap values List 114ms

// ----------------------------
// 10.000 mots
// ----------------------------
//time with List 443ms
//time with HashMap values List 958ms

// ----------------------------
// 100.000 mots
// ----------------------------
//time with List 4182ms
//time with HashMap values List 10657ms



// ----------------------------
// RESULTATS
// ----------------------------
// POUR FOR (pour les Iterator, je n'ai pas pu faire encore de test car je n'ai pas fini de les implémenter)
// Les résultats montrent que l'utilisation des clés dans une HashMap (avec containsKey)
// est beaucoup plus rapide, avec une complexité moyenne, par rapport à la recherche
// séquentielle dans une liste (O(n)) - for.
//
// La méthode qui convertit les valeurs en HashSet donne
// également de bons résultats, bien qu'elle nécessite une étape supplémentaire (transfert des données du HashMap
// au HashSet).
//
// Pour conclure, à mesure que la taille des données augmente, les structures de hachage sont bien plus efficaces
// pour les recherches, tandis que la recherche dans une liste devient de plus en plus lente.