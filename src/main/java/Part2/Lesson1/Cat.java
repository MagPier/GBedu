package Part2.Lesson1;


import Part2.Lesson1.Interface.Participants;


public class Cat implements Participants {
    public String name;
    public int jumpLength =2;
    public int runningDistance =200;
    public boolean isOvercameObstacle =true;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void jump() {
        System.out.println(name+" прыгает");
    }

    @Override
    public void run() {
        System.out.println(name+" бежит");
    }
}
