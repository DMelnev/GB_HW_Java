/**
 * @author Melnev Dmitry
 * @version 2021-12-25
 */
package lesson6;

public class HomeWorkApp {
    public static void main(String[] args) {
        //dogs
        IAnimal dogSonja = new Dog("Sonja", 23, "black", 12, 120);
        IAnimal dogKesha = new Dog("Kesha", 38, "gray", 50, 50);
        IAnimal dogPip = new Dog("Pip", 25, "russet", 13, 110);
        IAnimal dogDrug = new Dog("Drug", 3, "brown", 5, 25);
        IAnimal dogStray1 = new Dog(21, "white", 10, 132);
        IAnimal dogStray2 = new Dog(16, "dirty", 7, 85);
        //cats
        IAnimal catPip = new Cat("Pip", 25, "russet", 110);
        IAnimal catDrug = new Cat("Drug", 3, "brown", 25);
        IAnimal catStray1 = new Cat(21, "white", 132);
        IAnimal catStray2 = new Cat(16, "dirty", 85);

        IAnimal[] dogs = {dogSonja, dogKesha, dogPip, dogDrug, dogStray1, dogStray2,
                catPip, catDrug, catStray1, catStray2};

        for (IAnimal oneAnimal : dogs) {
            System.out.println(oneAnimal.getClass());
            System.out.print(oneAnimal);
            System.out.print(oneAnimal.run(100));
            System.out.println(oneAnimal.swim(11));
        }

        System.out.println("Had created " + Animal.getCounter() + " objects superclass \"Animal\" ");
        System.out.println("Had created " + Dog.getCounter() + " objects class \"Dog\" ");
        System.out.println("Had created " + Cat.getCounter() + " objects class \"Cat\" ");


    }

}

/**
 * interface
 */
interface IAnimal {
    String run(int distance);

    String swim(int distance);
}

/**
 * abstract class
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

    @Override
    public String toString() {
        return String.format(
                "Name: %s \nWeight: %d \nColor: %s\n",
                name, weight, color
        );
    }

    static public int getCount() {
        return counter;
    }

    public boolean setMaxDistanceRun(int maxDistanceRun) {
        if (maxDistanceRun > 0) {
            this.maxDistanceRun = maxDistanceRun;
            return true;
        }
        return false;
    }

    public void setMaxDistanceSwim(int maxDistanceSwim) {
        if (maxDistanceSwim > 0)
            this.maxDistanceSwim = maxDistanceSwim;
    }

    public void setWeight(int weight) {
        if (weight > 0)
            this.weight = weight;
    }

    public static int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getMaxDistanceRun() {
        return maxDistanceRun;
    }

    public int getMaxDistanceSwim() {
        return maxDistanceSwim;
    }
}

/**
 * child class 1
 */
class Dog extends Animal {
    static protected int counter = 0;

    Dog(String name, int weight, String color, int maxDistanceSwim, int maxDistanceRun) {
        super(name, weight, color, maxDistanceSwim, maxDistanceRun);
        counter++;
    }

    Dog(int weight, String color, int maxDistanceSwim, int maxDistanceRun) {
        this("noname", weight, color, maxDistanceSwim, maxDistanceRun);
    }

    //    @Override
//    protected void finalize() throws Throwable { //вызов деструктора. но он depricated oO
//        counter--; //уменьшениия счетчика после удаления
//        super.finalize();
//    }
    static public int getCounter() {
        return counter;
    }

    @Override
    public String run(int distance) {
        if (distance <= maxDistanceRun)
            return "The dog has run " + distance + " steps\n";
        return "The dog cann't run " + distance + " steps. Maximum " + maxDistanceRun + "\n";
    }

    @Override
    public String swim(int distance) {
        if (distance <= maxDistanceSwim)
            return "The dog has swum " + distance + " meters\n";
        return "The dog cann't swim " + distance + " meters. Maximum " + maxDistanceSwim + "\n";
    }
}

/**
 * child class 2
 */
class Cat extends Animal {
    static protected int counter = 0;

    Cat(String name, int weight, String color, int maxDistanceRun) {
        super(name, weight, color, 0, maxDistanceRun);
        counter++;
    }

    Cat(int weight, String color, int maxDistanceRun) {
        this("noname", weight, color, maxDistanceRun);
    }

    static public int getCounter() {
        return counter;
    }

    @Override
    public String run(int distance) {
        if (distance <= maxDistanceRun)
            return "The cat has run " + distance + " steps\n";
        return "The cat cann't run " + distance + " steps. Maximum " + maxDistanceRun + "\n";
    }

    @Override
    public String swim(int distance) {
        return "Cats cann't swim\n";
    }
}