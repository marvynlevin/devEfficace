import java.util.ArrayList;

/**
 * La classe {@code AppComp} est le point d'entrée du programme qui effectue des recherches dans une liste de mots.
 * Elle mesure les temps d'exécution pour trois structures de données différentes (List, HashMap, TreeMap, LinkedHashMap)
 * et compare les performances des différentes approches pour trouver des mots dans une collection.
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
        int nbElements = 1000000;

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

        // Recherche des mots dans la liste en utilisant la méthode find() de ListOfWords
        ArrayList<String> lfound = lWords.find(l);

        // Arrête la mesure du temps
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
            System.out.println("time with HashMap values List " + timeElapsed + "ms");

            // Mesure le temps d'exécution pour rechercher des mots dans les valeurs converties en HashSet
            start = System.currentTimeMillis();
            lfound = hWords.findValuesToSet(l);
            end = System.currentTimeMillis();
            timeElapsed = end - start;
            System.out.println("time with HashMap values converted to Set " + timeElapsed + "ms");

            // Mesure le temps d'exécution pour rechercher des mots dans les clés de la Map
            start = System.currentTimeMillis();
            lfound = hWords.findKeys(l);
            end = System.currentTimeMillis();
            timeElapsed = end - start;
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
//time with HashMap keys 27ms
//        TreeMap
//time with HashMap values List 10384ms
//time with HashMap values converted to Set 15ms
//time with HashMap keys 44ms
//        LinkedHashMap
//time with HashMap values List 4843ms
//time with HashMap values converted to Set 33ms
//time with HashMap keys 50ms


// ----------------------------
// 1.000.000 mots
// ----------------------------
//time with List 58612ms
//        HashMap
//time with HashMap values List 181876ms
//time with HashMap values converted to Set 252ms
//time with HashMap keys 175ms
//        TreeMap
//time with HashMap values List 837329ms
//time with HashMap values converted to Set 446ms
//time with HashMap keys 442ms
//        LinkedHashMap
//time with HashMap values List 68423ms
//time with HashMap values converted to Set 160ms
//time with HashMap keys 270ms

// Les tests ont montré que pour de grandes collections de mots, les structures de données basées sur
// des Map sont plus performantes que les listes :
//
// Le HashMap est la solution la plus rapide, surtout pour les recherches par clés.
//
// Le LinkedHashMap offre des performances similaires mais avec un léger
// surcoût dû à l'ordre d'insertion.
//
// Le TreeMap est plus lent en raison de la gestion de l'ordre, bien qu'il
// soit utile lorsqu'un tri est nécessaire (pas ici).
//
// Enfin, l'ArrayList montre des performances dégradées pour les grandes
// collections, ce qui en fait une option moins efficace pour des recherches fréquentes.
