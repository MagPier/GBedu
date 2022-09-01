package Part3.Lesson6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(Arrays.toString(method1(new int[]{1, 2, 5, 3, 4, 5, 6, 7})));
        System.out.println(Arrays.toString(method1(new int[]{1, 2, 5, 3, 4, 5, 6, 4})));
        System.out.println((method2(new int[]{1,1,1,1,1,1,1})));

    }

    public static int[] method1(int[] array) {
        int last4 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                last4 = i + 1;
            }
        }
        if (last4 == 0) {
            throw new RuntimeException("Нет четверок");
        }
        return (last4 != array.length) ? (Arrays.copyOfRange(array, last4, array.length)) : null;
    }

    public static boolean method2(int[] array) {
        boolean is1exist = false;
        boolean is4exist = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                is1exist = true;
            }
            if (array[i] == 4) {
                is4exist = true;
            }
        }
        return is1exist && is4exist;
    }

}
