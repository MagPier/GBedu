package Part2.Lesson1;

import Part2.Lesson1.Interface.Participants;

public class main {
    public static void main(String[] args) {
        Robot robot1 = new Robot("Bender");
        Robot robot2 = new Robot("Walli");
        Cat cat1 = new Cat("Barsik");
        Cat cat2 = new Cat("Timka");
        Human human1 = new Human("Igor");
        Human human2 = new Human("Masha");
        Road road1 = new Road(100);
        Wall wall1 = new Wall(1);
        Road road2 = new Road(300);
        Wall wall2 = new Wall(11);
        Road road3 = new Road(2000);
        Wall wall3 = new Wall(9);
        Obstacle obst[] = {road1, wall1, road2, wall2, road3, wall3};
        Participants participant[] = {robot1, robot2, cat1, cat2, human1, human2};
        for (Participants p : participant) {
            for (Obstacle o : obst) {
                checkDistance(p,o);
            }
        }
    }
   static void checkDistance(Participants p,Obstacle obstacle){
        if(p instanceof Cat && ((Cat) p).isOvercameObstacle ){
            if (obstacle instanceof Road){
                if (((Cat) p).runningDistance>obstacle.obstacleSize){
                    System.out.println(((Cat) p).name+" прошел по дороге "+obstacle.obstacleSize+" м");
                } else {
                    ((Cat) p).isOvercameObstacle = false;
                    System.out.println(((Cat) p).name+" не смог преодолеть препятствие");
                }
            }
            if (obstacle instanceof Wall){
                if (((Cat) p).jumpLength>obstacle.obstacleSize){
                    System.out.println(((Cat) p).name+" перепрыгнул "+obstacle.obstacleSize+" м");
                } else {
                    ((Cat) p).isOvercameObstacle = false;
                    System.out.println(((Cat) p).name+" не смог преодолеть препятствие");
                }

            }
        }
        if(p instanceof Human && ((Human) p).isOvercameObstacle ){
            if (obstacle instanceof Road){
                if (((Human) p).runningDistance>obstacle.obstacleSize){
                    System.out.println(((Human) p).name+" прошел по дороге "+obstacle.obstacleSize+" м");
                } else {
                    ((Human) p).isOvercameObstacle = false;
                    System.out.println(((Human) p).name+" не смог преодолеть препятствие");
                }
            }
            if (obstacle instanceof Wall){
                if (((Human) p).jumpLength>obstacle.obstacleSize){
                    System.out.println(((Human) p).name+" перепрыгнул "+obstacle.obstacleSize+" м");
                } else {
                    ((Human) p).isOvercameObstacle = false;
                    System.out.println(((Human) p).name+" не смог преодолеть препятствие");
                }

            }
        }
        if(p instanceof Robot && ((Robot) p).isOvercameObstacle ){
            if (obstacle instanceof Road){
                if (((Robot) p).runningDistance>obstacle.obstacleSize){
                    System.out.println(((Robot) p).name+" прошел по дороге "+obstacle.obstacleSize+" м");
                } else {
                    ((Robot) p).isOvercameObstacle = false;
                    System.out.println(((Robot) p).name+" не смог преодолеть препятствие");
                }
            }
            if (obstacle instanceof Wall){
                if (((Robot) p).jumpLength>obstacle.obstacleSize){
                    System.out.println(((Robot) p).name+" перепрыгнул "+obstacle.obstacleSize+" м");
                } else {
                    ((Robot) p).isOvercameObstacle = false;
                    System.out.println(((Robot) p).name+" не смог преодолеть препятствие");
                }

            }
        }
    }

}

