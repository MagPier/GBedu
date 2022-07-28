package Part3.Lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson1 {
    public static void main(String[] args) {

        // Задача 1. Написать метод, который меняет два элемента массива местами.
        // (массив может быть любого ссылочного типа);
      String[] array = {"adsad","124","vsdf","fhhsfh"};
       //Object[] array = {"adsad","124","vsdf","fhhsfh"};

        System.out.println(Arrays.toString(array));
        swapElement(array,1,3);
        System.out.println(Arrays.toString(array));

        //Задача 2. Написать метод, который преобразует массив в ArrayList
        List<String> list = convertArrayToList(array);
        System.out.println(list);

        //Задача 3. Коробки с фруктами


        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 4; i++) {
            orangeBox1.add(new Orange());
        }
        for (int i = 0; i < 3; i++) {
            appleBox.add(new Apple());
        }
        orangeBox1.info();
        appleBox.info();
        orangeBox2.info();
        orangeBox1.move(orangeBox2);
        orangeBox2.info();
        System.out.println("Вес коробки 1 с апельсинами  "+orangeBox1.getWeight());
        System.out.println("Вес коробки 2 с апельсинами  "+orangeBox2.getWeight());
        System.out.println("Вес коробки с апельсинами  "+appleBox.getWeight());
        System.out.println("Вес коробки с яблоками больше чем у коробки с апельсинами? : "+orangeBox2.compare(appleBox));






    }
    private static <T> void swapElement (T[] array, int index1,int index2){
        T temp = array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }

    private static <E> List<E> convertArrayToList(E[] array){
        return Arrays.asList(array);
    }


}
