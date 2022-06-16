public class Homework6app {
    public static int dogCounter = 0;
    public static int catCounter = 0;
    public static int animalCounter = 0;

    public static void main(String[] args) {
        Animal animal1 = new Animal("Burenka");
        Animal animal2 = new Animal("Jiraf");
        Cat cat1 = new Cat("Barsik");
        Cat cat2 = new Cat("Tapok");
        Cat cat3 = new Cat("Timka");
        Dog dog1 = new Dog("Lerych");
        animal1.run(100);
        animal2.swim(40);
        cat1.run(199);
        cat2.run(400);
        cat3.swim(100);
        dog1.run(400);
        dog1.run(600);
        dog1.swim(9);
        System.out.printf("Животных: %d, котов: %d, собак: %d", animalCounter,catCounter,dogCounter);
    }
}

class Animal {
    public Animal(String name) {
        this.name = name;
        Homework6app.animalCounter++;
    }

    protected String name;

    void run(int distance) {
        System.out.println(name + " пробежал " + distance + " метров");
    }

    void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " метров");
    }


}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
        Homework6app.dogCounter++;
    }

    void run(int distance) {
        if (distance < 500) {
            super.run(distance);
        } else System.out.println("Пес устанет");
    }

    void swim(int distance) {
        if (distance < 10) {
            super.swim(distance);
        } else System.out.println(this.name + " так далеко не уплывет");
    }

}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
        Homework6app.catCounter++;
    }

    void swim(int distance) {
        System.out.println("Коты не плавают");
    }

    void run(int distance) {
        if (distance < 200) {
            super.run(distance);
        } else System.out.println("Кот устанет");
    }

}

