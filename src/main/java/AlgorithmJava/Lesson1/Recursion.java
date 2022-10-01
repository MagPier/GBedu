package AlgorithmJava.Lesson1;

public class Recursion {
//    Задание 5.1
//    Приведите пример использования рекурсии.
//  - Вычисление числа "е" математически.
//    Задание 5.2
//    Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.

    public static int commonRecursion(int n){
        if (n>1000){
            return n;
        }
        System.out.println(n);
        return commonRecursion(n+1);
    }
    public static int infinitRecursion(int n){
        return infinitRecursion(n+1);
    }

//    Задание 5.3
//    Приведите пример изображающий стек вызова и стек вызова с рекурсией.
// - выполнение кода процессором с исполнением инструкций
// - стек вызова с рекурсией на приммере вычесления факториала, пока функция не достигнет единицы.

//    Задание 5.4
//    Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
//    Оцените два алгоритма с помощью базового метода System.nanoTime().

    public static int commonCycle (int n){
        for (int i = 0; n < 1000; n++) {


        }
        return n;
    }
//    Задание 5.5
//    Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
//    Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным двоичным поиском.

    public static int recursionBinarySearch(int[] arr,int key,int low,int high) {

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        int middle = (low + high) / 2;
        if (arr[middle] > key) {

            return recursionBinarySearch(arr, key, low, middle - 1);
        } else if (arr[middle] < key) {

            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }
    }
//    Задание 5.6
//    На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
//    Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().
    public static int [] mergeArray(int [] arrayA, int [] arrayB) {

        int[] arrayC =new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayA.length) {
                arrayC[i] = arrayB[i - positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[i - positionA];
                positionA++;
            } else if (arrayA[i - positionA] < arrayB[i - positionB]) {
                arrayC[i] = arrayA[i - positionA];
                positionB++;
            } else {
                arrayC[i] = arrayB[i - positionB];
                positionA++;
            }
        }
        return arrayC;
    }



    public static void main(String[] args) {
        long timeStart1 = System.nanoTime();
        System.out.println(commonRecursion(1));
        long time1 = ((System.nanoTime() - timeStart1));
        System.out.println("Время выполнения рекурсии нс: " + time1);
        long timeStart2 = System.nanoTime();
        System.out.println(commonCycle(1));
        long time2 = ((System.nanoTime() - timeStart2));
        System.out.println("Время выполнения цикла нс: " + time2);

    }
}
