package Part2.Lesson1;


import Part2.Lesson1.Interface.Participants;


public class Human implements Participants {
    public String name;
    public int jumpLength =10;
    public int runningDistance =1000;
    public boolean isOvercameObstacle =true;

    public Human(String name) {
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
