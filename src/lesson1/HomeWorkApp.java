package lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {            // first exercise
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void printThreeWords() {             // second exercise

        System.out.println("Orange" + "\n" + "Banana" + '\n' + "Apple");
    }

    private static void checkSumSign() {                // third exercise
        int a = 12;
        int b = -57;
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor() {                  // fourth exercise
        int value = 145;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {              //fifth exercise
        int a = 48;
        int b = 48;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
