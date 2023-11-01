package task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {
        String[] words = {"Tree", "Grass", "Sun", "Ocean", "Tree", "Tree", "Sun", "Rock", "Grass", "Sun"};
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, wordMap.get(word) + 1);
            }
        }
        System.out.println(wordMap.keySet());
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        Thesaurus thesaurus = new Thesaurus();
        thesaurus.add("apple", new LinkedHashSet<>(Arrays.asList("red", "fruit")));
        thesaurus.add("pear", new LinkedHashSet<>(Arrays.asList("green", "fruit")));
        thesaurus.add("berries", new LinkedHashSet<>(Arrays.asList("yellow", "fruit")));
        thesaurus.add("bike", new LinkedHashSet<>(Arrays.asList("2 wheels", "transport")));
        thesaurus.add("house", new LinkedHashSet<>(Arrays.asList("place")));
        thesaurus.show();
        System.out.println(thesaurus.get("bike"));
        System.out.println(thesaurus.get("fly"));

//        ArrayList list = new ArrayList<>(Arrays.asList("Tree","Grass","Sun","Ocean","Tree","Tree","Sun","Rock","Grass","Sun"));
//        Map<String,String> map = new HashMap<>();
//        LinkedHashSet<>();
//        Set<String> set = new TreeSet<>();
//
//        set.add("aaaa");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String o = iterator.next();
//            if ()
//        }
//        Iterator<String> iterator1 = set.iterator();
    }
}
