/**
 * Java 1. Lesson 7
 *
 * @author Dmitriy Melnev
 * @version 2021-12-25
 */
package lesson7;

public class HomeWorkApp {
    public static void main(String[] args) {
        Cat[] pets = new Cat[7];
        pets[0] = new Cat("Barsick", 15);
        pets[1] = new Cat("Murzick", 14);
        pets[2] = new Cat("Baker", 13);
        pets[3] = new Cat("Bulb", 12);
        pets[4] = new Cat("Conan", 11);
        pets[5] = new Cat("Monster", 10);
        pets[6] = new Cat("Tablet", 16);

        Plate plate = new Plate(70);

        System.out.println("Start plate: " + plate.info() + "\n");

        for (Cat pet : pets) {
            System.out.print(pet);
            System.out.printf(eating(pet, plate), pet.getName());
            System.out.println("Food left: " + plate + "\n");
        }
        System.out.print("Added to plate: " + plate);
        plate.addFood(21);
        System.out.println(" + 21 = " + plate + "\n");

        for (Cat pet : pets) {
            System.out.print(pet);
            System.out.printf(eating(pet, plate), pet.getName());
            System.out.println("Food left: " + plate + "\n");
        }
    }

    private static String eating(Cat pet, Plate plate) {
        return (pet.eat(plate)) ? "%s has eaten.\n" :
                (pet.getIsFull()) ? "%s is full.\n" : "There's not enough food for %s.\n";
    }
}

/**
 * class Cat
 */
class Cat {
    private String name;
    private int appetite;
    private boolean isFull = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean eat(Plate plate) {
        if (!isFull && plate.decreaseFood(appetite)) { //если левая часть == false, правая не будет выполняться.
            isFull = true;
            return true;
        }
        return false;
    }

    public boolean getIsFull() {
        return isFull;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
                "%s, appetite - %d, is %s\n",
                name, appetite, (isFull) ? "full" : "hungry"
        );
    }
}
/**
 * class Plate
 */
class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return Integer.toString(food);
    }

    public int info() {
        return food;
    }

    public void addFood(int add) {
        food += (add > 0) ? add : 0;
    }
}
