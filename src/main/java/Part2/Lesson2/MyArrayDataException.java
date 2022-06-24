package Part2.Lesson2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i,int j) {
        super("Ошибка с элементом в строке="+(i+1)+" столбце="+(j+1));
    }
}
