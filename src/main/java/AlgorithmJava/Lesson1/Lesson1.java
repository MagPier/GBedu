package AlgorithmJava.Lesson1;

// Задание 1.1
//Приведите пример алгоритмов и структур данных из жизни.
// - Расположение нормерв в элеткронной книге;
// - Алфавитный порядок расположения;
// - Номера домов на улице;
// - Список покупок.
//------------------------------------------
// Задание 1.2
// риведите пример алгоритмов и структур данных в программировании.
// - Все виды сортировки, кроме случайного;
// - Массивы, стеки, очереди, деревья, графы, таблицы.
//-----------------------------------------


import java.util.*;

//Задание 1.3
//Напишите программный код, в котором все данные хранятся только в переменных трех типов данных: Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.
//Выведите написанные данные.
//Задание 1.4
//Дополните предыдущий код сравнением ваших данных с другой переменной, данный код должен имитировать простейший поиск перебором.
//Оцените время выполнения алгоритма с помощью базового метода System.nanoTime().
public class Lesson1 {
    int[] primitive = new int[]{6, 5, 4, 3, 2, 1};
    String[] text = new String[]{"one", "two", "thee", "four", "five", "six"};


    public static void main(String[] args) {
        long timeStart = System.nanoTime();
        Lesson1 l1 = new Lesson1();

        Employee emp1 = new Employee("Valera", 1, "PR");
        Employee emp2 = new Employee("Ivan", 2, "PR");
        Employee emp3 = new Employee("Sveta", 3, "PR");
        Employee emp4 = new Employee("Masha", 4, "IT");
        Employee emp5 = new Employee("Jenya", 5, "IT");
        Employee emp6 = new Employee("Artem", 6, "IT");
        Employee[] workers = new Employee[]{emp1, emp2, emp3, emp4, emp5, emp6};

        System.out.println("Примитивные типы:");
        System.out.println(Arrays.toString(l1.primitive));
        System.out.println("Ссылочные типы:");
        System.out.println(Arrays.toString(l1.text));
        System.out.println("Собственный тип:");
//        for (Employee worker : workers) {
//            worker.showInfo();
//        }
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getSalary() >= l1.primitive[i]) {
                System.out.println("Переменная " + i + " меньше зарплаты у");
                workers[i].showInfo();
                System.out.println();
            }

        }

        long time = ((System.nanoTime() - timeStart));
        System.out.println("Время выполнения 1 задания нс: " + time);

//        Задание 2.1
//        На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.

        long timeStart2 = System.nanoTime();
        int[] primitivePart2 = new int[]{6, 5, 4, 3, 2, 1};
        int[] copyArray = new int[6];
        copyArray = Arrays.copyOf(primitivePart2, primitivePart2.length);
        Arrays.sort(copyArray);
        int find = Arrays.binarySearch(copyArray, 4);
        System.out.println(find);
        long time2 = ((System.nanoTime() - timeStart2));
        System.out.println("Время выполнения 2.1 задания нс: " + time2);

//        Задание 2.2
//        На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
//        Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.


        int[] array = new int[400];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long timeStart3 = System.nanoTime();
        int binarySearch = Arrays.binarySearch(array, 300);
        long time3 = ((System.nanoTime() - timeStart3));
        System.out.println("Время выполнения бинарного поиска нс: " + time3);
        long timeStart4 = System.nanoTime();
        int linerSearch;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 300) {
                linerSearch = i;
            }
        }
        long time4 = ((System.nanoTime() - timeStart3));
        System.out.println("Время выполнения линейного поиска нс: " + time4);


//        Задание 2.3
//
//        Создайте массив размером 400 элементов.
//                Выполните сортировку с помощью метода sort().
//                Оцените сортировку с помощью базового класса System.nanoTime().
        int[] array2 = new int[400];
        Random rnd = new Random();
        for (int i = 1; i < array2.length; i++) {
            int j = rnd.nextInt(i);
            array2[i] = j;
        }
        long timeStart5 = System.nanoTime();
        int[] array3 = Arrays.copyOf(array2, array2.length);
        int[] array4 = Arrays.copyOf(array2, array2.length);
        int[] array5 = Arrays.copyOf(array2, array2.length);
        Arrays.sort(array3);
        // System.out.println(Arrays.toString(array3));
        long time5 = ((System.nanoTime() - timeStart5));
        System.out.println("Время выполнения Сортировки нс: " + time5);
//        Задание 2.4
//        На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
//        Оцените сортировку с помощью базового класса System.nanoTime().
        long timeStart6 = System.nanoTime();

        for (int i = 0; i < array2.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array2[j - 1] > array2[j]) {
                    int tmp = array2[j - 1];
                    array2[j - 1] = array2[j];
                    array2[j] = tmp;
                }
            }
        }
        // System.out.println(Arrays.toString(array2));
        long time6 = ((System.nanoTime() - timeStart6));
        System.out.println("Время выполнения пузырьковой Сортировки нс: " + time6);
// Сортировка методом Arrays.sort быстрее ~ в 4 раза при 400 элементах.


//        Задание 2.5
//        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
//                Оцените сортировку с помощью базового класса System.nanoTime().
//                Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
        long timeStart7 = System.nanoTime();

        for (int i = 0; i < array4.length; i++) {
            int pos = i;
            int min = array4[i];

            for (int j = i + 1; j < array4.length; j++) {
                if (array4[j] < min) {
                    pos = j;
                    min = array4[j];
                }
            }
            array4[pos] = array4[i];
            array4[i] = min;
        }
        //   System.out.println(Arrays.toString(array4));
        long time7 = ((System.nanoTime() - timeStart7));
        System.out.println("Время выполнения Сортировки методом выбора нс: " + time7);

        // веремя сортировки методом выбора в 1.7 раза меньше, чем пузырьковым методом при 400 элементах.

//        Задание 2.6
//        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
//                Оцените сортировку с помощью базового класса System.nanoTime().
//                Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.
        long timeStart8 = System.nanoTime();
        for (int left = 0; left < array5.length; left++) {
            int value = array5[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array5[i]) {
                    array5[i + 1] = array5[i];
                } else {
                    break;
                }
            }
            array5[i + 1] = value;
        }
        //  System.out.println(Arrays.toString(array5));
        long time8 = ((System.nanoTime() - timeStart8));
        System.out.println("Время выполнения Сортировки методом вставки нс: " + time8);
        // время выполнения сортировки методов вставки в 2 раза меньше чем сортивкой методом выбоара

//        Задание 3.1
//        На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
//                Оцените время выполнения преобразования.
        long timeStart9 = System.nanoTime();
        LinkedList list = new LinkedList();
        for (int i : array5) {
            list.add(i);

        }
        System.out.println();
        long time9 = ((System.nanoTime() - timeStart9));
        System.out.println("Время выполнения заполнения списка нс: " + time9);

//    Задание 3.4
//На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
//Реализуйте список заполненный объектами из вашего класса из задания 1.3

        DoublyLinkedList<Employee> dlink = new DoublyLinkedList();
        for (Employee emp:workers){
            dlink.add(emp,1);
        }

//        Задание 3.5
//        Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
//                Оцените время выполнения операций с помощью базового метода System.nanoTime()
//
      Iterator iter = list.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}



class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    public static <T> LinkedList<T> newEmptyList() {
        return new LinkedList<T>();
    }

    protected LinkedList() {
        head = null;
        tail = null;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> currentNode;

        public ListIterator(Node<T> head) {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (currentNode == null) {
                throw new NoSuchElementException();
            }
            T value = currentNode.getValue();
            currentNode = currentNode.getNext();
            return value;
        }

        @Override
        public void remove() {
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(head);
    }
}
class Node<T> {
    private final T value;
    private Node next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
