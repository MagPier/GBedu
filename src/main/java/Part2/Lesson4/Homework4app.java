package Part2.Lesson4;

public class Homework4app {
    static final int size = 100000000;
    static final int h = size / 2;
    float[] arr1 = new float[size];
    float[] arr2 = new float[size];

    void arrayFill (){

        for (int i = 0; i < size; i++) {
            arr1[i]=1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        System.out.println(System.currentTimeMillis()-a +" время заполнения без потоков");

    }

    void arrayFillWithThread () throws InterruptedException {

        for (int i = 0; i < size; i++) {
            arr2[i]=1;
        }
        long a = System.currentTimeMillis();
        float[] temp1 = new float[h];
        float[] temp2 = new float[h];
        System.arraycopy(arr2, 0, temp1, 0, h);
        System.arraycopy(arr2, 0, temp2, 0, h);
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < h; i++) {
                temp1[i] = (float)(temp1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 0; i < h; i++) {
                temp2[i] = (float)(temp2[i] * Math.sin(0.2f + (i+h) / 5) * Math.cos(0.2f + (i+h) / 5) * Math.cos(0.4f + (i+h) / 2));
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.arraycopy(temp1, 0, arr2, 0, h);
        System.arraycopy(temp2, 0, arr2, h, h);
        System.out.println(System.currentTimeMillis()-a +" время заполнения c потоками");


    }


    public static void main(String[] args) throws InterruptedException {
        Homework4app app = new Homework4app();
        app.arrayFillWithThread();
        app.arrayFill();
    }

}
