/**
 * @author Melnev Dmitry
 * @version 2021-12-25
 */
package lesson6;

public class HomeWorkApp {
    public static void main(String[] args) {

    }

}

interface IAnimal {
    String run(int distance);

    String swim(int distance);
}

abstract class Animal implements IAnimal {
    protected int maxDistanceRun, maxDistanceSwim;

    Animal(int maxDistanceSwim, int maxDistanceRun) {
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = maxDistanceSwim;
    }

    public boolean setMaxDistanceRun(int maxDistanceRun) {
        if (maxDistanceRun > 0) {
            this.maxDistanceRun = maxDistanceRun;
            return true;
        }
        return false;
    }

    public boolean setMaxDistanceSwim(int maxDistanceSwim) {
        if (maxDistanceSwim > 0) {
            this.maxDistanceSwim = maxDistanceSwim;
            return true;
        }
        return false;
    }

    public int getMaxDistanceRun() {
        return maxDistanceRun;
    }

    public int getMaxDistanceSwim() {
        return maxDistanceSwim;
    }
}
