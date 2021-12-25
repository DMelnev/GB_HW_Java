/**
 * @author Melnev Dmitry
 * @version 2021-12-25
 */
package lesson6;

import java.util.Random;

public class HomeWorkApp {

    static private Random rnd = new Random();

    public static void main(String[] args) {

        //create dogs
        IAnimal dogSonja = new Dog("Sonja", 23, "black", 10, 500);
        IAnimal dogKesha = new Dog("Kesha", 38, "gray", 10, 500);
        IAnimal dogPip = new Dog("Pip", 25, "russet", 10, 500);
        IAnimal dogDrug = new Dog("Drug", 3, "brown", 5, 200);
        IAnimal dogStray1 = new Dog(21, "white", 10, 500);
        IAnimal dogStray2 = new Dog(16, "dirty", 7, 300);
        //create cats
        IAnimal catPip = new Cat("Pip", 25, "russet", 200);
        IAnimal catDrug = new Cat("Drug", 3, "brown", 200);
        IAnimal catStray1 = new Cat(21, "black", 200);
        IAnimal catStray2 = new Cat(16, "dirty", 85);

        IAnimal[] pets = {dogSonja, dogKesha, dogPip, dogDrug, dogStray1, dogStray2,
                catPip, catDrug, catStray1, catStray2};

        for (IAnimal pet : pets) {
            System.out.println(pet.getClass());
            System.out.print(pet);
            System.out.print(pet.run(rnd.nextInt(700)));
            System.out.println(pet.swim(rnd.nextInt(15)));
        }

        System.out.println();
//        catPip.test(); //don't work
        Animal test = new Cat(1, "d", 1);
        test.test();//work

        System.out.println();
        System.out.println(Animal.getCounter() + " objects of superclass \"Animal\" have been created");
        System.out.println(Dog.getCounter() + " objects of class \"Dog\" have been created");
        System.out.println(Cat.getCounter() + " objects of class \"Cat\" have been created");
    }

}

/**
 * interface
 */
interface IAnimal {
    String run(int distance);

    String swim(int distance);

    String getColor();

    int getWeight();

    String getName();

    int getMaxDistanceSwim();

    int getMaxDistanceRun();

    void setMaxDistanceRun(int maxDistanceRun);

    void setMaxDistanceSwim(int maxDistanceSwim);

    void setName(String name);

    void setWeight(int weight);
}

/**
 * parent abstract class
 */
abstract class Animal implements IAnimal {
    protected String name;
    protected int weight;
    protected String color;
    protected int maxDistanceRun;
    protected int maxDistanceSwim;
    static private int counter = 0;

    Animal(String name, int weight, String color, int maxDistanceSwim, int maxDistanceRun) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = maxDistanceSwim;
        counter++;
    }

    Animal(int weight, String color, int maxDistanceSwim, int maxDistanceRun) {
        this("noName", weight, color, maxDistanceSwim, maxDistanceRun);
    }

    @Override
    public final String toString() { // запрещаем потомкам изменять toString ))
        return String.format(
                "Name: %s \nWeight: %d \nColor: %s\n",
                name, weight, color
        );
    }

    public static int getCounter() {
        return counter;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public int getMaxDistanceSwim() {
        return maxDistanceSwim;
    }

    public int getMaxDistanceRun() {
        return maxDistanceRun;
    }

    public void setMaxDistanceRun(int maxDistanceRun) {
        if (maxDistanceRun > 0)
            this.maxDistanceRun = maxDistanceRun;
    }

    public void setMaxDistanceSwim(int maxDistanceSwim) {
        if (maxDistanceSwim > 0)
            this.maxDistanceSwim = maxDistanceSwim;
    }

    public void setName(String name) {
        if (name.length() > 3)
            this.name = name;
    }

    public void setWeight(int weight) {
        if (weight > 0)
            this.weight = weight;
    }

    public void test() { //без объявления в интерфейсе
        System.out.println("Method is available");
    }

}

/**
 * child class 1
 */
class Dog extends Animal {
    private static int counter = 0;

    Dog(String name, int weight, String color, int maxDistanceSwim, int maxDistanceRun) {
        super(name, weight, color, maxDistanceSwim, maxDistanceRun);
        counter++;
    }

    Dog(int weight, String color, int maxDistanceSwim, int maxDistanceRun) {
        super(weight, color, maxDistanceSwim, maxDistanceRun);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String run(int distance) {
        if (distance <= maxDistanceRun)
            return "The dog has run " + distance + " steps\n";
        return "The dog can't run " + distance + " steps. Maximum " + maxDistanceRun + "\n";
    }

    @Override
    public String swim(int distance) {
        if (distance <= maxDistanceSwim)
            return "The dog has swum " + distance + " meters\n";
        return "The dog can't swim " + distance + " meters. Maximum " + maxDistanceSwim + "\n";
    }
}

/**
 * child class 2
 */
class Cat extends Animal {
    private static int counter = 0;

    Cat(String name, int weight, String color, int maxDistanceRun) {
        super(name, weight, color, 0, maxDistanceRun);
        counter++;
    }

    Cat(int weight, String color, int maxDistanceRun) {
        super(weight, color, 0, maxDistanceRun);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String run(int distance) {
        if (distance <= maxDistanceRun)
            return "The cat has run " + distance + " steps\n";
        return "The cat can't run " + distance + " steps. Maximum " + maxDistanceRun + "\n";
    }

    @Override
    public String swim(int distance) {
        return "Cats doesn't wanna swim.\n";
    }
}