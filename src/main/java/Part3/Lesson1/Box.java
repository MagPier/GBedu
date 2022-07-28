package Part3.Lesson1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> list = new ArrayList<T>();

    public List<T> getList() {
        return list;
    }

    void add(T obj) {
        list.add(obj);
    }

    void move(Box<T> box) {
        box.getList().addAll(list);
        this.list.clear();
    }

    void info() {
        if (list.isEmpty()) {
            System.out.println("Коробка пуста");

        } else {
            System.out.println("В коробке находятся " + list.get(0).getClass().toString().split("\\.")[2] + " в количестве: " + list.size()+" шт");
        }
    }

    float getWeight() {
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.size() * list.get(0).getWeight();
        }
    }

    boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();

    }


}
