package Part3.Lesson5;

import java.util.concurrent.BrokenBarrierException;


public class Road extends Stage {
    volatile boolean isFinish =false;
    public Road(int length) {
        this.length = length;
        this.description = "ƒорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            MainClass.road.await();
            System.out.println(c.getName() + " закончил этап: " + description);
            if(this.length ==40 && !isFinish){
                isFinish=true;
                System.out.println(c.getName()+" Win");

            }
            if (this.length ==40)   {
                MainClass.finish.countDown();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
