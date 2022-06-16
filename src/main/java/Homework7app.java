import java.util.concurrent.ThreadLocalRandom;

public class Homework7app {
    public static void main(String[] args) throws InterruptedException {

        Cats cat1 = new Cats("Ричард",40,0);
        Cats cat2 = new Cats("Рейзел",30,0);
        Cats cat3 = new Cats("Лукард",50,0);
        Cats cat4 = new Cats("Барсик",40,0);
        Cats [] cats = {cat1,cat2,cat3,cat4};
        Plate plate = new Plate(158);
        


        while (plate.getFoodCount()>0){
            for (Cats cat : cats) {
                cat.eat(plate);
                plate.printInfo();
            }
            plate.printInfo();
            Thread.sleep(100);
        }
        for (Cats cat : cats) {
            if(cat.checkAppetite()){
                System.out.println(cat.getName()+" остался голодным");
            } else System.out.println(cat.getName()+" сытый");

        }


    }
}

class Cats{
    public String getName() {
        return name;
    }

    private String name;

    public int getMaxAppetite() {
        return maxAppetite;
    }

    private int maxAppetite;

    public int getAppetite() {
        return appetite;
    }

    private int appetite;

    public Cats(String name, int maxAppetite, int appetite) {
        this.name = name;
        this.maxAppetite = maxAppetite;
        this.appetite = appetite;
    }


    public void eat(Plate plate) {
        if (checkAppetite()){
            return;
        }
       int catEatFoodCount = ThreadLocalRandom.current().nextInt(2)+3;
           if (catEatFoodCount > plate.getFoodCount()) {
               appetite+= plate.getFoodCount();
               plate.decreaseFood(plate.getFoodCount());
               System.out.println("Кот"+name+" не наелся");
               return;
           }
           plate.decreaseFood(catEatFoodCount);
           appetite+=catEatFoodCount;
           System.out.println("Кот " + name + " съел " + catEatFoodCount + " корма");

        System.out.println("Кот " + name + " наелся");
        
    }
    public boolean checkAppetite(){
        return (this.appetite>=maxAppetite);
    }
}
class Plate{

    private int foodCount;

    public int getFoodCount() {
        return foodCount;
    }

    public Plate(int foodCount){

        this.foodCount = foodCount;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Осталось еды " + foodCount;
    }

    public void decreaseFood(int catEatFoodCount){
        foodCount -=catEatFoodCount;
    }
}
