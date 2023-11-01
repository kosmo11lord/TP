package task;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class Thesaurus {
    private final Map<String, LinkedHashSet<String>> thesaurus = new TreeMap<>();

    public void add(String term, LinkedHashSet<String> synonyms) {
        for (var temp : thesaurus.values()) {
            for (var synonym : synonyms) {
                if (temp.contains(synonym)) {
                    System.out.println("Данный синоним уже присутствует у другого слова: " + term);
                    return;
                }
            }

        }
        if (thesaurus.containsKey(term)) {
            thesaurus.get(term).addAll(synonyms);
        } else {
            thesaurus.put(term, synonyms);
        }
    }

    public LinkedHashSet<String> get(String term) {
        if (thesaurus.containsKey(term)) {
            return thesaurus.get(term);
        } else {
            return new LinkedHashSet<String>(Arrays.asList("Искомое слово не найдено"));
        }
    }

    public void show() {
        System.out.println(thesaurus.entrySet());
    }
}
