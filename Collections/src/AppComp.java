import java.util.ArrayList;

/**
 * Classe AppComp
 * <p>
 * Cette classe compare les performances de recherche de mots dans différentes structures de données :
 * <ul>
 *     <li>List (via ListOfWords).</li>
 *     <li>HashMap, TreeMap, et LinkedHashMap (HashOfWordsComp).</li>
 * </ul>
 * Elle mesure les temps d'exécution pour chaque approche afin de déterminer leur efficacité.
 * </p>
 * <pre>
 * Usage :
 * java AppComp
 * </pre>
 * <p>
 * Les résultats des tests sont affichés en millisecondes.
 * </p>
 *
 * @author Marvyn
 * @version 1.0
 * @date 04/12/2024
 *
 * @see ListOfWords
 * @see HashOfWordsComp
 */
public class AppComp {
    /**
     * Le point d'entrée principal du programme.
     * Cette méthode sélectionne un certain nombre de mots aléatoires, puis teste les performances de recherche dans une List et
     * trois types de Map : HashMap, TreeMap, et LinkedHashMap.
     *
     * @param args Paramètres en ligne de commande (non utilisés ici).
     * @throws Exception Si une exception se produit lors de l'exécution du programme.
     */
    public static void main(String[] args) throws Exception {

        // Nombre d'éléments à sélectionner aléatoirement dans le fichier de mots
        int nbElements = 10000;
        // Crée une instance de la classe ListOfWords pour récupérer une liste de mots
        ListOfWords lWords = new ListOfWords();
        // Sélectionne un certain nombre de mots aléatoires dans la liste de mots
        ArrayList<String> l = lWords.randomSelect(nbElements);

        // Affiche les mots sélectionnés
//         for(String s : l){
//         System.out.println(s);
//         }

        // Démarre la mesure du temps d'exécution pour la recherche dans la liste
        long start = System.currentTimeMillis();
        ArrayList<String> lfound = lWords.find(l);
        long end = System.currentTimeMillis();
        long timeElapsed = end - start;

        // Affiche les résultats de la recherche
//         for(String s : lfound){
//             System.out.println(s);
//         }

        // Affiche le temps d'exécution pour la recherche dans la liste
        System.out.println("time with List " + timeElapsed + "ms");

        // Boucle qui effectue des tests sur trois types de Map : HashMap, TreeMap, LinkedHashMap
        for (int i = 0; i < 3; i++) {

            // Crée une instance de HashOfWordsComp en fonction du type de Map sélectionné
            HashOfWordsComp hWords = new HashOfWordsComp(i);

            // Affiche le type de Map en cours de test
            switch(i) {
                case 0:
                    System.out.println("HashMap");
                    break;
                case 1:
                    System.out.println("TreeMap");
                    break;
                case 2:
                    System.out.println("LinkedHashMap");
                    break;
            }

            // Mesure le temps d'exécution pour rechercher des mots dans les valeurs de la Map en utilisant un iterator
            start = System.currentTimeMillis();
            lfound = hWords.findValuesList(l);
            end = System.currentTimeMillis();
            timeElapsed = end - start;

            // Affichage des résultats pour containsValue (désactivé ici)
            // for (String s : lfound) {
            //     System.out.println(s);
            // }
            System.out.println("time with HashMap values List " + timeElapsed + "ms");

            // Mesure le temps d'exécution pour rechercher des mots dans les valeurs converties en HashSet
            start = System.currentTimeMillis();
            lfound = hWords.findValuesToSet(l);
            end = System.currentTimeMillis();
            timeElapsed = end - start;

            // Affichage des résultats pour contains (désactivé ici)
            // for (String s : lfound) {
            //     System.out.println(s);
            // }
            System.out.println("time with HashMap values converted to Set " + timeElapsed + "ms");

            // Mesure le temps d'exécution pour rechercher des mots dans les clés de la Map
            start = System.currentTimeMillis();
            lfound = hWords.findKeys(l);
            end = System.currentTimeMillis();
            timeElapsed = end - start;

            // Affichage des résultats pour containsKey (désactivé ici)
            // for (String s : lfound) {
            //     System.out.println(s);
            // }

            System.out.println("time with HashMap keys " + timeElapsed + "ms");
        }
    }
}



// EXECUTION HashOfWords ITERATOR
// ----------------------------
// 10 mots
// ----------------------------
//PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> javac *.java
//PS C:\Users\Gamer\Desktop\devEfficace\Collections\src> java AppComp
//transformÃƒÂ©es
//concÃƒÂ©der
//arsenic
//dÃƒÂ©rivÃƒÂ©
//chiffon
//accumulation
//crÃƒÂ©ent
//clivage
//Sihanouk
//ceinturon
//transformÃƒÂ©es YES
//concÃƒÂ©der YES
//arsenic YES
//dÃƒÂ©rivÃƒÂ© YES
//chiffon YES
//accumulation YES
//crÃƒÂ©ent YES
//clivage YES
//Sihanouk YES
//ceinturon YES
//time with List 12ms
//        HashMap
//time with HashMap values List 17ms
//time with HashMap values converted to Set 8ms
//time with HashMap keys 0ms
//        TreeMap
//time with HashMap values List 19ms
//time with HashMap values converted to Set 9ms
//time with HashMap keys 0ms
//        LinkedHashMap
//time with HashMap values List 4ms
//time with HashMap values converted to Set 8ms
//time with HashMap keys 0ms

// ----------------------------
// 100.000 mots
// ----------------------------
//time with List 5066ms
//HashMap
//time with HashMap values List 20364ms
//time with HashMap values converted to Set 42ms
//time with HashMap keys 27ms (second)
//        TreeMap
//time with HashMap values List 10384ms
//time with HashMap values converted to Set 15ms (first)
//time with HashMap keys 44ms
//        LinkedHashMap
//time with HashMap values List 4843ms
//time with HashMap values converted to Set 33ms (third)
//time with HashMap keys 50ms



// ----------------------------
// RESULTATS
// ----------------------------
//Les tests montrent que les Map sont plus performantes que l'ArrayList pour les grandes collections.
//
//HashMap : Très rapide, grâce à sa gestion optimisée des hachages.
//LinkedHashMap : Très performant, mais un léger surcoût dû à l'ordre d'insertion.
//TreeMap : Très performant, malgré son tri automatique des éléments.
//ArrayList : Moins efficace, surtout pour de grandes collections.
