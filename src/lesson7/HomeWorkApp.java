/**
 * @author Dmitriy Melnev
 * @version 2021-12-25
 */
package lesson7;

public class HomeWorkApp {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 15);
        Plate plate = new Plate(100);

        System.out.println("plate: " + plate.info());

        if (cat.eat(plate)) {
            System.out.println("The kitten has eaten.");
        } else {
            System.out.println("Is not enough food.");
        }

        System.out.println("plate: " + plate.info());
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

    public boolean eat(Plate p) {
        if (appetite <= p.info()) {
            p.decreaseFood(appetite);
            isFull = true;
            return true;
        }
        return false;
    }

    public boolean getIsFull() {
        return isFull;
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
}
