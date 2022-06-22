package Part2.Lesson1;


import Part2.Lesson1.Interface.Participants;


public class Robot implements Participants {
    public String name;
    public int jumpLength =50;
    public int runningDistance =5000;
    public boolean isOvercameObstacle =true;

    public Robot(String name) {
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
