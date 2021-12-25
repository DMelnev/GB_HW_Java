/**
 * @author Dmitriy Melnev
 * @version 2021-12-25
 */
package lesson7;

public class HomeWorkApp {
    public static void main(String[] args) {
        Cat[] pets = new Cat[7];
        pets[0] = new Cat("Barsick", 15);
        pets[1] = new Cat("Mursick", 14);
        pets[2] = new Cat("Applesick", 13);
        pets[3] = new Cat("Bulbsick", 12);
        pets[4] = new Cat("Starsick", 11);
        pets[5] = new Cat("Moonsick", 10);
        pets[6] = new Cat("Tablesick", 16);
//        System.out.println(pets[0]);
        Plate plate = new Plate(70);

        System.out.println("plate: " + plate.info());

        for (Cat pet : pets)
            System.out.printf(answer(pet.eat(plate), pet.getIsFull()), pet.getName());

        System.out.println("plate: " + plate.info());
        plate.addFood(20);
        System.out.println("plate: " + plate.info());

        for (Cat pet : pets)
            System.out.printf(answer(pet.eat(plate), pet.getIsFull()), pet.getName());

        System.out.println("plate: " + plate.info());
    }

    private static String answer(boolean hasEaten, boolean isFull) {
        return (hasEaten) ? "The kitten %s has eaten.\n" :
                (isFull) ? "%s is full.\n" : "There's not enough food for %s.\n";
    }
}

/**
 * class Cat
 */
class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public boolean eat(Plate plate) {
        if ((appetite <= plate.info()) && !isFull) {
            plate.decreaseFood(appetite);
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
                "Name :%s \nAppetite :%d \n%s\n",
                name, appetite, (isFull) ? "Full" : "Hungry"
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

    public void decreaseFood(int n) {
        food -= n;
    }

    public int info() {
        return food;
    }

    public void addFood(int add) {
        if (add > 0)
            food += add;
    }
}
