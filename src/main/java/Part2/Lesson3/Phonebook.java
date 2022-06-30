package Part2.Lesson3;

import java.util.HashMap;
import java.util.Map;


public class Phonebook {
    private Map<String, String> phonebook = new HashMap<>();

    public static void main(String[] args) {
        Phonebook pB = new Phonebook();
        pB.add("Сергей", 103);
        pB.add("Сергей", 10344645);
        pB.add("Сергей", 1031231);
        pB.add("Володя", 312);
        pB.add("Володя", 4611);
        pB.add("Женя", 205);

        System.out.println(pB.phonebook);
        pB.get("Сергей");
    }

    void add(String name, Integer number) {
        if (phonebook.containsKey(name)) {
            phonebook.put(name, (phonebook.get(name) + ", " + number));
        } else phonebook.put(name, number.toString());
    }

    void get(String name) {
        System.out.println("Номер " + name + " " + phonebook.get(name));
    }

}
