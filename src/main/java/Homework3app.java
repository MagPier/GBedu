public class Homework3app {
    public static void main(String[] args) {

        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int array[] = {1, 0, 1, 1, 0, 0, 0, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
            System.out.print(array[i]);
        }
        System.out.println();
        System.out.println("-----------------------");

        //2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;

        int[] array2 = new int[100];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }
        for (int a : array2) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("-----------------------");

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int array3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] = array3[i] * 2;
            }
            System.out.print(array3[i] + " ");
        }
        System.out.println();
        System.out.println("-----------------------");

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
        // заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
        // Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];

        int array4[][] = new int[5][5];
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4.length; j++) {
                if (i == j || i + j == array4.length - 1) {
                    array4[i][j] = 1;
                }
                System.out.print(array4[i][j]);
            }
            System.out.println();

        }

        System.out.println("-----------------------");

        //5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;

        int[] array5= createArray(5,10);
        for (int a:array5){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("-----------------------");


        //6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

        int array6[] = {3, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int arrayMax=array6[0];
        int arrayMin=array6[0];
        for (int i = 1; i < array6.length; i++) {
            if (array6[i]>arrayMax){
                arrayMax=array6[i];
            }
            if (array6[i]<arrayMin){
                arrayMin=array6[i];
            }
        }
        System.out.println("Max : " +arrayMax);
        System.out.println("Min : " +arrayMin);
        System.out.println("-----------------------");

        //7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        int array7[] = {10, 3,5,8};
        System.out.println(checkValue(array7));
        System.out.println("-----------------------");

        //8.*** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        //        // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        //        // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        //        // При каком n в какую сторону сдвиг можете выбирать  сами.
        int array8[] = shiftNCount(-2,array7);
        for (int a:array8){
            System.out.print(a+" ");
        }
    }

    static int[] createArray(int len, int initialValue){
        int [] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i]=initialValue;
        }
        return array;
    }
    static boolean checkValue (int[] array){
        int sumLeft=0;
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        for (int i = 0; i < array.length; i++) {
            sumLeft+=array[i];
            if (sumLeft==sum/2 && sum%2 ==0){
                return true;
            }

        }
        return false;
    }
    static int[] shiftLeft( int[] array){
        int temp;
        temp = array[0];
        for (int i = 0; i < array.length; i++) {
            if(i!= array.length-1) {
                array[i] = array[i + 1];
            }
        }
        array[array.length-1]=temp;
        return array;
    }
    static int[] shiftRight( int[] array){
        int temp;
        temp = array[array.length-1];
        for (int i = array.length-1; i >0; i--) {
            if(i!= 0) {
                array[i] = array[i - 1];
            }
        }
        array[0]=temp;
        return array;
    }
    static int[] shiftNCount (int n, int [] array) {
        int newN = n% array.length;
        if (newN > 0) {
            for (int i = 0; i < n; i++) {
                array = shiftRight(array);
            }
        }
        if (newN < 0) {
            for (int i = 0; i < (n*-1); i++) {
                array = shiftLeft(array);
            }
        }
        return array;
    }

}

