package Part2.Lesson1;

public class Wall extends Obstacle{
    public Wall(int obstacleSize) {

        super(obstacleSize);
        System.out.println("Высота стены:"+obstacleSize);
    }
}
