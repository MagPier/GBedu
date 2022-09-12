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


import java.util.Arrays;

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

        System.out.println("Примитивные тыпы:");
        System.out.println(Arrays.toString(l1.primitive));
        System.out.println("Ссылочные типы:");
        System.out.println(Arrays.toString(l1.text));
        System.out.println("Собственный тип:");
//        for (Employee worker : workers) {
//            worker.showInfo();
//        }
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getSalary()>=l1.primitive[i]){
                System.out.println("Переменная " +i+" меньше зарплаты у");
                workers[i].showInfo();
                System.out.println();
            }

        }

        long time = ((System.nanoTime() - timeStart));
        System.out.println("Время выполнения нс: "+ time);


    }


}
