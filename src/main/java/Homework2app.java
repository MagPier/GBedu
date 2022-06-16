public class Homework2app {
    public static void main(String[] args) {
        System.out.println(compareNumbers(10, 10));
        definitionSign(10);
        printString("Привет", 3);
        System.out.println(reverseSign(-5));
        System.out.println(definitionYear(1700));

    }

    static boolean compareNumbers(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    static void definitionSign(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " положительное");
        } else System.out.println("Число " + a + " отрицательное");
    }

    static boolean reverseSign(int a) {
        return a < 0;
    }

    static void printString(String s, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(s);
        }
    }

    static boolean definitionYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return year % 400 == 0;

    }
}
