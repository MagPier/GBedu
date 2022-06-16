import java.util.Random;
import java.util.Scanner;

public class Homework4app {
    private static int SIZE=3;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'x';
    private static final char DOT_AI = 'o';
    private static final String HEADER_FIRST_SYMBOL = "♥";
    private static final String SPACE_MAP = " ";
    private static int winStrike=3;

    private static char[][] map = new char[SIZE][SIZE];
    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();
    private static int turnsCount = 0;
    private static int lastRow;
    private static int lastColumn;


    public static void main(String[] args) {
        do {
            System.out.println("Start");
            init();
            initMap();
            printMap();
            playGame();
        } while (isContinueGame());
        endGame();

    }

    private static void endGame() {
        in.close();
        System.out.println("Выход");

    }

    private static boolean isContinueGame() {
        System.out.println("Вы хотите продолжить? Y\\N");
        if( in.next().equals("Y")){
            return true;

        }
        return false;



    }

    private static void init() {
//        System.out.println("Введите размер поля");
//        SIZE = in.nextInt();
//        System.out.println("Введите победную серию");
//        winStrike = in.nextInt();
        turnsCount=0;
        initMap();
    }


    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapBody();
    }

    private static void printMapBody() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }

        }

    }

    private static void humanTurn() {
        System.out.println("Ход человека");

        int rowNumber;
        int columnNumber;

        while (true) {
            System.out.println("Введите координату строки: ");
            rowNumber = in.nextInt() - 1;

            System.out.println("Введите координату столбца ");
            columnNumber = in.nextInt() - 1;

            if (isCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.printf("Ячейка с координатами %d:%d уже занята%n%n", rowNumber + 1, columnNumber + 1);

        }

        map[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;
        lastRow =rowNumber;
        lastColumn = columnNumber;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return map[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static void aiTurn() {
        System.out.println("Ход AI");

        int rowNumber;
        int columnNumber;
        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, columnNumber));

        map[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;
        lastRow =rowNumber;
        lastColumn = columnNumber;

    }

    private static boolean checkEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("вы победили");
                return true;

            } else if (symbol == DOT_AI) {
                System.out.println("вы были близки");
                return true;
            }
        }
        if (checkDraw()) {
            System.out.println("Ничья");
            return true;

        }

        return false;
    }

    private static boolean checkDraw() {

        return turnsCount >= SIZE * SIZE;
    }

    private static boolean checkWin(char symbol) {
        int winSymbolCounter=0;
        for (int i = 0; i <SIZE; i++) {
            if (map[lastRow][i]==symbol){
                winSymbolCounter++;
                if(winSymbolCounter ==winStrike){
                    return true;
                }
            } else winSymbolCounter=0;
        }
        for (int i = 0; i < SIZE; i++) {

            if (map[i][lastColumn]==symbol){
                winSymbolCounter++;
                if(winSymbolCounter ==winStrike){
                    return true;
                }
            } else winSymbolCounter=0;
        }
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i]==symbol){
                winSymbolCounter++;
                if(winSymbolCounter ==winStrike){
                    return true;
                }
            } else winSymbolCounter=0;
        }
        for (int i = 0; i < SIZE; i++) {
            if (map[i][2-i]==symbol){
                winSymbolCounter++;
                if(winSymbolCounter ==winStrike){
                    return true;
                }
            } else winSymbolCounter=0;
        }


        return false;
    }
}
