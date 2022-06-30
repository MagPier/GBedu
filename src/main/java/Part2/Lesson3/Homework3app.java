package Part2.Lesson3;

import java.util.HashMap;
import java.util.Map;

public class Homework3app {

    public static void main(String[] args) {
        String[] array = {"abc", "qwe", "asdqg", "fasf", "qghqweh", "qgqsgq", "adgadgq", "abc", "qwe", "asdqg", "fasf", "qghqweh", "qgqsgq", "adgadgq", "abc", "qwe", "asdqg", "fasf", "qghqweh", "qgqsgq", "adgadgq", "abc", "qwe"};
        Map<String, Integer> map = new HashMap<>();
        for (String s : array) {
            if (map.containsKey(s)) {
                map.put(s, (map.get(s) + 1));
            } else map.put(s, 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("Слово %s содержится %d раз %n", entry.getKey(), entry.getValue());
        }
    }


}
