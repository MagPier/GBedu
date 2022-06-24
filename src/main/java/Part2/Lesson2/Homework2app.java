package Part2.Lesson2;

public class Homework2app {
    int arraySummary4x4 (String [][] array) throws MyArraySizeException {
        if(!check4x4ArraySize(array)){
            throw new MyArraySizeException();
        }
        int arraySum=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    arraySum+=Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e){
                    try {
                        throw new MyArrayDataException(i,j);
                    } catch (MyArrayDataException t){
                        t.printStackTrace();
                    }

                }


            }
        }
        return arraySum;
    }
    boolean check4x4ArraySize(String [][] array){
        boolean is4x4 = array.length == 4;
        for (String[] s:array){
            if (s.length != 4) {
                is4x4 = false;
                break;
            }

        }
        return is4x4;
    }

    public static void main(String[] args){
        Homework2app h2 = new Homework2app();
        String [][] array0 = new String[4][4];
        String [][] array1 = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        String [][] array2 = {{"1","r31","3","4"},{"1","fdf","3","4"},{"1","sfs","3","4"},{"1","afas","3","asfafs"}};
        String [][] array3 = {{"1","r31","3","4"},{"1","2","3","4"},{}};
//        try {
//            System.out.println(h2.arraySummary4x4(array0));
//
//        }
//        catch (MyArraySizeException e){
//            e.printStackTrace();
//            System.out.println("Введите новый массив");
//        }
//        try {
//            System.out.println(h2.arraySummary4x4(array1));
//        } catch (MyArraySizeException e) {
//            e.printStackTrace();
   //     System.out.println("Введите новый массив");
//        }
        try {
            System.out.println(h2.arraySummary4x4(array2));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Введите новый массив");
        }
//        try {
//            System.out.println(h2.arraySummary4x4(array3));
//        } catch (MyArraySizeException e) {
//            e.printStackTrace();
       // System.out.println("Введите новый массив");
//        }


    }
}
