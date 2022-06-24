package Part2.Lesson2;

public class MyArraySizeException extends NumberFormatException {
    public MyArraySizeException() {
        super("Массив не 4х4");
    }
}
