package Part3.Lesson5;

import java.util.concurrent.Semaphore;

import static Part3.Lesson5.MainClass.CARS_COUNT;
import static Part3.Lesson5.MainClass.tunnel;


public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "������� " + length + " ������";
    }
    @Override
    public void go(Car c) {
        try {
            try {

                System.out.println(c.getName() + " ��������� � �����(����): " + description);
                tunnel.acquire(1);
                System.out.println(c.getName() + " ����� ����: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                tunnel.release();
                System.out.println(c.getName() + " �������� ����: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
