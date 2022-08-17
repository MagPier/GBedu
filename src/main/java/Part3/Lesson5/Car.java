package Part3.Lesson5;

import lombok.SneakyThrows;

import static Part3.Lesson5.MainClass.start;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "�������� #" + CARS_COUNT;
    }

    @SneakyThrows
    @Override
    public void run() {
        try {
            System.out.println(this.name + " ���������");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " �����");


        } catch (Exception e) {
            e.printStackTrace();
        }
        start.countDown();
        start.await();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }
}
