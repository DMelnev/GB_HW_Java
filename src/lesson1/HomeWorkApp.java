package lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {            // first exercise
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    static void printThreeWords() {             // second exercise

        System.out.println("Orange" + "\n" + "Banana" + '\n' + "Apple");
    }

    static void checkSumSign() {                // third exercise
        int a = 12;
        int b = -57;
        System.out.println(((a + b) >= 0) ? "Сумма положительная" : "Сумма отрицательная");
    }

    static void printColor() {                  // fourth exercise
        int value = 145;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {              //fifth exercise
        int a = 47;
        int b = 48;
        System.out.println((a >= b) ? "a >= b" : "a < b");

    }
}
